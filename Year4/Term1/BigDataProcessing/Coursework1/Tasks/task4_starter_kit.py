import sys, string
import os
import socket
import time
import operator
import boto3
import json
from pyspark.sql import Row, SparkSession
from pyspark.sql.streaming import DataStreamWriter, DataStreamReader
from pyspark.sql.functions import explode, split, window, col, count
from pyspark.sql.types import IntegerType, DateType, StringType, StructType
from pyspark.sql.functions import sum, avg, max, when
from datetime import datetime

if __name__ == "__main__":
    spark = SparkSession \
        .builder \
        .appName("NasaLogSparkStreaming") \
        .getOrCreate()

    spark.sparkContext.setLogLevel("ERROR")

    # Question 1 (2 points) TODO: load data by specifying the host value and port value
    logsDF =

    logsDF = logsDF.select(explode(split(logsDF.value, " ")).alias("logs"), logsDF.timestamp)

    # Question 2 (2 points) TODO: define a watermark on the timestamp column with a delay of 3 seconds.
    logsDF =

    logsDF = logsDF.withColumn('idx', split(logsDF['logs'], ',').getItem(0)) \
        .withColumn('hostname', split(logsDF['logs'], ',').getItem(1)) \
        .withColumn('time', split(logsDF['logs'], ',').getItem(2)) \
        .withColumn('method', split(logsDF['logs'], ',').getItem(3)) \
        .withColumn('url', split(logsDF['logs'], ',').getItem(4)) \
        .withColumn('responsecode', split(logsDF['logs'], ',').getItem(5)) \
        .withColumn('bytes', split(logsDF['logs'], ',').getItem(6))

    # For other quesions, please start from this line.




    time.sleep(60)

    query.stop()

    spark.stop()

