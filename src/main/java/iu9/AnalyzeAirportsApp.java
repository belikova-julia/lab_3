package iu9;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

public class AnalyzeAirportsApp {
    public static void main(String[] args) throws Exception {
        SparkConf conf = new SparkConf().setAppName("lab3");
        JavaSparkContext sc = new JavaSparkContext(conf);

        JavaRDD<String> flightFile = sc.textFile("data/flights.csv");
        JavaRDD<String> airportFile = sc.textFile("data/airports.csv");

        Map<String, String> airportMap = 
    }
}