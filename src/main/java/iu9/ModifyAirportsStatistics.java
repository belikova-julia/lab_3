package iu9;

import org.apache.spark.api.java.function.Function2;

public class ModifyAirportsStatistics implements
        Function2<AnalyticsSerializable,
        String,
        AnalyticsSerializable> {
    @Override
    public AnalyticsSerializable call(AnalyticsSerializable analytics, String delay) throws Exception {
        analytics.addFlight();
        if (delay.isEmpty()) {
            analytics.addCancellation();
            return analytics;
        }
        if (Float.parseFloat(delay) != 0F) {
            analytics.addDelay();
            analytics.setMaxDelay(Float.parseFloat(delay));
            return analytics;
        }
        return null;
    }
}
