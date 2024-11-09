import sys, string
import os
import socket
from pyspark.sql import SparkSession
from datetime import datetime
from pyspark.sql.functions import from_unixtime, date_format, col, to_date, concat_ws, sum, month, to_timestamp, count, round
from pyspark.sql.types import FloatType, IntegerType
import logging

if __name__ == "__main__":

    spark = SparkSession\
        .builder\
        .appName("CourseworkIsFun1")\
        .getOrCreate()
    s3_data_repository_bucket = os.environ['DATA_REPOSITORY_BUCKET']
    s3_endpoint_url = os.environ['S3_ENDPOINT_URL']+':'+os.environ['BUCKET_PORT']
    s3_access_key_id = os.environ['AWS_ACCESS_KEY_ID']
    s3_secret_access_key = os.environ['AWS_SECRET_ACCESS_KEY']
    s3_bucket = os.environ['BUCKET_NAME']

    hadoopConf = spark.sparkContext._jsc.hadoopConfiguration()
    hadoopConf.set("fs.s3a.endpoint", s3_endpoint_url)
    hadoopConf.set("fs.s3a.access.key", s3_access_key_id)
    hadoopConf.set("fs.s3a.secret.key", s3_secret_access_key)
    hadoopConf.set("fs.s3a.path.style.access", "true")
    hadoopConf.set("fs.s3a.connection.ssl.enabled", "false")

    Logger= spark._jvm.org.apache.log4j.Logger
    logger = Logger.getLogger(__name__)

    logger.info("PROGRAM STARTING")

    ### START - PART 1 + 2
    logger.info(f"STARTED - PART 1 + 2")
    logger.info(f"STARTED - READING FILE - TRIP DATA")
    rides_df = spark.read.csv(f"s3a://{s3_data_repository_bucket}/ECS765/nyc_taxi/yellow_tripdata/2023/yellow_tripdata_2023-*.csv", header=True, inferSchema=True)
    logger.info(f"FINISHED - READING FILE - TRIP DATA")

    logger.info(f"TRIP DATA has: {rides_df.count()} ROWS")
    # logger.info(f"{filename} Content: {rides_df.collect()}")

    filtered_df = rides_df.filter((col("fare_amount") > 50) & (col("trip_distance") < 1))

    result_df = (rides_df
                 .filter((col("fare_amount") > 50) & (col("trip_distance") < 1))
                 .withColumn("trip_date", date_format(col("tpep_pickup_datetime"), "yyyy-MM-dd"))
                 .filter((col("trip_date") >= "2023-02-01") & (col("trip_date") <= "2023-02-07"))
                 .groupBy("trip_date")
                 .count()
                 .orderBy("trip_date"))
    
    result_df.show(truncate=False)
    logger.info(f"ENDED - PART 1 + 2")
    ### END - PART 1 + 2

    ### START - PART 3
    logger.info(f"STARTED - PART 3")
    lookup_df = spark.read.csv(f"s3a://{s3_data_repository_bucket}/ECS765/nyc_taxi/taxi_zone_lookup.csv", header=True, inferSchema=True)

    rides_with_pickup = rides_df.join(
        lookup_df,
        rides_df["PULocationID"] == lookup_df["LocationID"],
        "left"
    ).withColumnRenamed("Borough", "Pickup_Borough") \
     .withColumnRenamed("Zone", "Pickup_Zone") \
     .withColumnRenamed("service_zone", "Pickup_service_zone") \
     .drop("LocationID", "PULocationID")
    
    final_rides_df = rides_with_pickup.join(
        lookup_df,
        rides_with_pickup["DOLocationID"] == lookup_df["LocationID"],
        "left"
    ).withColumnRenamed("Borough", "Dropoff_Borough") \
     .withColumnRenamed("Zone", "Dropoff_Zone") \
     .withColumnRenamed("service_zone", "Dropoff_service_zone") \
     .drop("LocationID", "DOLocationID")
    
    final_rides_df.printSchema()
    logger.info(f"ENDED - PART 3")
    ### END - PART 3

    ### START - PART 4
    logger.info("STARTED - PART 4")

    final_rides_df = final_rides_df.withColumn("route", concat_ws(" to ", "Pickup_Borough", "Dropoff_Borough"))
    final_rides_df = final_rides_df.withColumn("Month", month("tpep_pickup_datetime"))
    final_rides_df.select("*").show(10, truncate=False)
    
    logger.info("ENDED - PART 4")
    ### END - PART 4

    ### START - PART 5
    logger.info("STARTED - PART 5")

    grouped_df = final_rides_df.groupBy("Month", "route") \
    .agg(
        sum("tip_amount").alias("total_tip_amount"),
        sum("passenger_count").alias("total_passenger_count")
    )
    result_tip_df = grouped_df.withColumn("average_tip_per_passenger", 
                                  round(col("total_tip_amount") / col("total_passenger_count"), 2))

    result_tip_df.show(10, truncate=False)
    
    logger.info("ENDED - PART 5")
    ### END - PART 5

    ### START - PART 6
    logger.info("STARTED - PART 6")

    zero_tip_df = result_tip_df.filter(col("average_tip_per_passenger") == 0)
    zero_tip_df.show(truncate=False)
    
    logger.info("ENDED - PART 6")
    ### END - PART 6

    ### START - PART 7
    logger.info("STARTED - PART 7")
    
    top_routes_df = result_tip_df.orderBy(col("average_tip_per_passenger").desc()).limit(10)
    top_routes_df.show(truncate=False)
    
    logger.info("ENDED - PART 7")
    ### END - PART 7
    
    spark.stop()