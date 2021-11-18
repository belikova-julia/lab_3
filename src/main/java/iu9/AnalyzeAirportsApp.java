package iu9;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.broadcast.Broadcast;

public class AnalyzeAirportsApp {
    public static void main(String[] args) throws Exception {
        SparkConf conf = new SparkConf().setAppName("lab3");
        JavaSparkContext sc = new JavaSparkContext(conf);

        JavaRDD<String> flightFile = sc.textFile("data/flights.csv");
        JavaRDD<String> airportFile = sc.textFile("data/airports.csv");

        Map<String, String> airportMap = airportFile
                .filter(s -> !s.contains("Code"))
                .map(s -> )
                .mapToPair(s -> new Tuple1<>())
                .collectAsMap();
        final Broadcast<Map<String, String>> airportBrodcasted =
                sc.broadcast(airportMap)
    }
}