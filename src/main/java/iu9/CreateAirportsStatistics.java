package iu9;

import java.util.function.Function;

public class CreateAirportsStatistics implements Function<String, AnalyticsSerializable> {
    public AnalyticsSerializable call(String delay) throws Exception {
        if (delay.isEmpty()) {
            return new AnalyticsSerializable(0F, 0, 1, 1);
        }
        if (Float.parseFloat(delay) != 0F) {
            return new AnalyticsSerializable(Float.parseFloat(delay), 1, 0, 1);
        }
        return new AnalyticsSerializable(0F, 0, 0, 1);
    }

}
