package com.example.streams.generation.consumers;

import static org.apache.spark.sql.functions.col;
import static org.apache.spark.sql.functions.from_json;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeoutException;

import org.apache.spark.SparkConf;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.streaming.OutputMode;
import org.apache.spark.sql.streaming.StreamingQueryException;
import org.apache.spark.sql.types.DataTypes;
import org.apache.spark.sql.types.StructField;
import org.apache.spark.sql.types.StructType;

public class SparkStructuredStreamingWithTripInfo {
	public static void main(String[] args) throws TimeoutException, StreamingQueryException {

		SparkConf conf = new SparkConf().setMaster("local").setAppName("SparkStructuredStreamingWithKafka");
		SparkSession spark = SparkSession.builder().config(conf).getOrCreate();
		spark.sparkContext().setLogLevel("ERROR");
		
		List<StructField> coordFields = new ArrayList<StructField>();
		coordFields.add(DataTypes.createStructField("lat", DataTypes.DoubleType, true));
		coordFields.add(DataTypes.createStructField("lon", DataTypes.DoubleType, true));

		List<StructField> fields = new ArrayList<StructField>();
		
		fields.add(DataTypes.createStructField("searchId", DataTypes.StringType, true));

		fields.add(DataTypes.createStructField("typeOfVehicle", DataTypes.StringType, true));
		fields.add(DataTypes.createStructField("paymentMethod", DataTypes.StringType, true));
		fields.add(DataTypes.createStructField("primaryPassangerName", DataTypes.StringType, true));
		fields.add(DataTypes.createStructField("primaryPassangerContact", DataTypes.StringType, true));
		fields.add(DataTypes.createStructField("estimatedPrice", DataTypes.DoubleType, true));
		fields.add(DataTypes.createStructField("pickupPoint", DataTypes.createStructType(coordFields), true));
		fields.add(DataTypes.createStructField("dropPoint", DataTypes.createStructType(coordFields), true));
		StructType structType = DataTypes.createStructType(fields);


		Dataset<Row> df = spark
				.readStream()
				.format("kafka")
				.option("kafka.bootstrap.servers", "localhost:9092")
				.option("subscribe", "bigstream2k22")
				.load();
		Dataset<Row> res = df.selectExpr("CAST(key AS STRING)", "CAST(value AS STRING)")
		.withColumn("value", from_json(col("value"), structType))
		.select(col("value.*"));
		
		res.createOrReplaceTempView("trip_stream");
		
		spark.sql("select typeOfVehicle,max(estimatedPrice) as max_price from trip_stream group by typeOfVehicle")
		.writeStream()
		.format("console")
		.outputMode(OutputMode.Complete())
		.start()
		.awaitTermination();

	}
}
