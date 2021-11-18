package iu9;

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

    


}
