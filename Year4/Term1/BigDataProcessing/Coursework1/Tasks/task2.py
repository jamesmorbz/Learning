import sys, string
import os
import math
import socket
import logging
import boto3

from pyspark.sql import SparkSession
from datetime import datetime

from pyspark.sql.functions import from_unixtime, date_format, col, to_date, concat_ws, sum, month, to_timestamp, count, \
    year, countDistinct, expr, round, unix_timestamp, udf
from pyspark.sql.types import FloatType, IntegerType, DoubleType

import subprocess
import sys

try:
    import matplotlib
except ImportError:
    subprocess.check_call([sys.executable, "-m", "pip", "install", "matplotlib", "--user"])
    sys.path.insert(0, os.path.expanduser("~/.local/lib/python3.8/site-packages"))
    import matplotlib.pyplot as plt
    
if __name__ == "__main__":
    spark = SparkSession \
        .builder \
        .appName("Task2CW") \
        .getOrCreate()
    s3_data_repository_bucket = os.environ['DATA_REPOSITORY_BUCKET']
    s3_endpoint_url = os.environ['S3_ENDPOINT_URL'] + ':' + os.environ['BUCKET_PORT']
    s3_access_key_id = os.environ['AWS_ACCESS_KEY_ID']
    s3_secret_access_key = os.environ['AWS_SECRET_ACCESS_KEY']
    s3_bucket = os.environ['BUCKET_NAME']

    hadoopConf = spark.sparkContext._jsc.hadoopConfiguration()
    hadoopConf.set("fs.s3a.endpoint", s3_endpoint_url)
    hadoopConf.set("fs.s3a.access.key", s3_access_key_id)
    hadoopConf.set("fs.s3a.secret.key", s3_secret_access_key)
    hadoopConf.set("fs.s3a.path.style.access", "true")
    hadoopConf.set("fs.s3a.connection.ssl.enabled", "false")

    now = datetime.now()
    date_time = now.strftime("%d-%m-%Y_%H:%M:%S")

    Logger= spark._jvm.org.apache.log4j.Logger
    logger = Logger.getLogger(__name__)

    logger.info("PROGRAM STARTING")

    # START - PART 1
    logger.info(f"STARTED - PART 1")

    blocks_df = spark.read.csv(f"s3a://{s3_data_repository_bucket}/ECS765/ethereum/blocks.csv", header=True, inferSchema=True)
    transactions_df = spark.read.csv(f"s3a://{s3_data_repository_bucket}/ECS765/ethereum/transactions.csv", header=True, inferSchema=True)

    blocks_df.printSchema()
    transactions_df.printSchema()
    
    logger.info(f"ENDED - PART 1")
    
    # START - PART 2
    logger.info(f"STARTED - PART 2")

    top_miners_df = blocks_df.groupBy("miner").sum("size").withColumnRenamed("sum(size)", "total_size").orderBy(col("total_size").desc()).limit(10)
    top_miners_df.show(truncate=False)

    logger.info(f"ENDED - PART 2")
    
    # START - PART 3
    logger.info(f"STARTED - PART 3")
    
    blocks_df = blocks_df.withColumn("formatted_date", date_format(from_unixtime("timestamp"), "yyyy-MM-dd"))
    blocks_df.select("timestamp", "formatted_date").show(10, truncate=False)

    logger.info(f"ENDED - PART 3")
    
    # START - PART 4
    logger.info(f"STARTED - PART 4")
    transactions_df = transactions_df.withColumnRenamed("hash", "transaction_hash") # Renaming because column name collision on the line below
    joined_df = transactions_df.join(blocks_df, transactions_df["block_hash"] == blocks_df["hash"], "inner")
    print(f"Number of lines in the merged dataset: {joined_df.count()}")

    logger.info(f"ENDED - PART 4")
    joined_df.show()
    # START - PART 5
    logger.info(f"STARTED - PART 5")
    
    september_df = joined_df.filter((month(from_unixtime(col("timestamp"))) == 9) & (date_format(from_unixtime(col("timestamp")), "yyyy") == "2015"))
    daily_september_df = september_df.groupBy(date_format(from_unixtime(col("timestamp")), "yyyy-MM-dd").alias("formatted_date")) \
                                     .agg(count("block_hash").alias("block_count"),     
                                          countDistinct("from_address").alias("unique_senders_count_number")) \
                                     .orderBy("formatted_date")
    daily_september_df.show(truncate=False)
    
    daily_september_pd_df = daily_september_df.toPandas()
    plt.figure()
    daily_september_pd_df.plot(x='formatted_date', y='block_count', kind='bar', legend=False)
    plt.ylabel("Block Count")
    plt.title("Block Count per Day in September 2015")
    plt.xticks(rotation=45)
    plt.tight_layout()
    plt.savefig("/tmp/september_block_count_histogram.png")
    plt.clf()
    
    plt.figure()
    daily_september_pd_df.plot(x='formatted_date', y='unique_senders_count_number', kind='bar', legend=False)
    plt.ylabel("Unique Senders Count")
    plt.title("Unique Senders per Day in September 2015")
    plt.xticks(rotation=45)
    plt.tight_layout()
    plt.savefig("/tmp/september_unique_senders_histogram.png")
    plt.clf()

    logger.info(f"ENDED - PART 5")
    
    # START - PART 6
    logger.info(f"STARTED - PART 6")
    
    october_df = joined_df.filter((month(from_unixtime(col("timestamp"))) == 10) & (date_format(from_unixtime(col("timestamp")), "yyyy") == "2015") & (col("transaction_index") == 0))
    october_fee_df = october_df.withColumn("transaction_fee", col("gas") * col("gas_price")) \
                               .groupBy(date_format(from_unixtime(col("timestamp")), "yyyy-MM-dd").alias("formatted_date")) \
                               .agg(sum("transaction_fee").alias("total_transaction_fee")) \
                               .orderBy("formatted_date")
    october_fee_df.show(truncate=False)

    october_pd_df = october_fee_df.toPandas()
    
    plt.figure()
    october_pd_df.plot(x='formatted_date', y='total_transaction_fee', kind='bar', legend=False)
    plt.ylabel("Total Transaction Fee")
    plt.title("Total Transaction Fee per Day in October 2015")
    plt.xticks(rotation=45)
    plt.tight_layout()
    plt.savefig("/tmp/october_transaction_fee_histogram.png")
    plt.clf()
    
    logger.info(f"ENDED - PART 6")

    logger.info(f"STARTED - Uploading all plots to s3")
    s3_client = boto3.client('s3',
        endpoint_url=os.environ['S3_ENDPOINT_URL'] + ':' + os.environ['BUCKET_PORT'],
        aws_access_key_id=os.environ['AWS_ACCESS_KEY_ID'],
        aws_secret_access_key=os.environ['AWS_SECRET_ACCESS_KEY']
    )
    
    s3_bucket = os.environ['BUCKET_NAME']
    s3_client.upload_file("/tmp/september_block_count_histogram.png", s3_bucket, "september_block_count_histogram.png")
    s3_client.upload_file("/tmp/september_unique_senders_histogram.png", s3_bucket, "september_unique_senders_histogram.png")
    s3_client.upload_file("/tmp/october_transaction_fee_histogram.png", s3_bucket, "october_transaction_fee_histogram.png")
    logger.info(f"ENDED - Uploading all plots to s3://{s3_bucket}/...")

    spark.stop()