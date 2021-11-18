package iu9;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.broadcast.Broadcast;
import scala.Tuple1;
import scala.Tuple2;

import java.util.Map;

public class AnalyzeAirportsApp {
    private static final String DELIMETER = ",";
    private static final int AIRPORT_ID_COL = 0;
    private static final int AIRPORT_NAME_COL = 1;


    public static void main(String[] args) throws Exception {
        SparkConf conf = new SparkConf().setAppName("lab3");
        JavaSparkContext sc = new JavaSparkContext(conf);

        JavaRDD<String> flightFile = sc.textFile("data/flights.csv");
        JavaRDD<String> airportFile = sc.textFile("data/airports.csv");

        Map<String, String> airportMap = airportFile
                .filter(s -> !s.contains("Code"))
                .map(s -> RowSerializable.parseRow(s, DELIMETER))
                .mapToPair(row -> new Tuple2<>(row.getValue(AIRPORT_ID_COL), row.getValue(AIRPORT_NAME_COL)))
                .collectAsMap();
        final Broadcast<Map<String, String>> airportBrodcasted =
                sc.broadcast(airportMap);
    }
}