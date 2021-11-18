package iu9;

import scala.Tuple2;

import java.util.Map;

public class AnalyticsSerializable {
    private static final long serialVersionUID = 2L;

    private float maxDalay;
    private int amountOfDelays;
    private int amountOfCancells;
    private int amountOfFlights;

    public AnalyticsSerializable(float maxDalay,
                                 int amountOfDelays,
                                 int amountOfCancells,
                                 int amountOfFlights) {
        this.maxDalay = maxDalay;
        this.amountOfDelays = amountOfDelays;
        this.amountOfCancells = amountOfCancells;
        this.amountOfFlights = amountOfFlights;
    }

    public float getMaxDalay() {
        return maxDalay;
    }

    public int getAmountOfDelays() {
        return amountOfDelays;
    }

    public int getAmountOfCancells() {
        return amountOfCancells;
    }

    public int getAmountOfFlights() {
        return amountOfFlights;
    }

    public void addDelay() {
        amountOfDelays++;
    }

    public void addCancellation() {
        amountOfCancells++;
    }

    public void addFlight() {
        amountOfFlights++;
    }

    public void setMaxDelay(float delay) {
        maxDalay = Math.max(maxDalay, delay);
    }

    public static String getAnalytics(
            Tuple2<Tuple2<String, String>, AnalyticsSerializable> airportsInfo,
            Map<String, String> dictionary) {
        String fromAirport = dictionary.get(airportsInfo._1()._1());
        String toAirport = dictionary.get(airportsInfo._1()._2());
        AnalyticsSerializable analytics = airportsInfo._2();

        return fromAirport + "->" + toAirport + "\n" +
            " Max delay = " + analytics.getMaxDalay() +
            " " + "% Delayed = " + ((float) analytics.getAmountOfDelays()/analytics.getAmountOfFlights())*100 + "%" +
            " " + "% Cancelled = " + ((float) analytics.amountOfCancells()/analytics.getAmountOfFlights())*100 + "%" +
            " " + "Total = " + analytics.getAmountOfFlights();


    }
}
