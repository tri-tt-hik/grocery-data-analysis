package com.example.streams.generation;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

import java.util.List;

public class SparkExample {
	public static void main(String[] args) {
		SparkConf conf = new SparkConf().setMaster("local[*]").setAppName("Spark-Example");
		JavaSparkContext sc = new JavaSparkContext(conf);
		JavaRDD<String> file = sc.textFile("/home/tritthik/hpc/BigStream-2022/book.txt");
		System.out.println("No Of Lines: "+ file.count());
		//JavaRDD<List<String>> words
		
		sc.close();
	}
}
