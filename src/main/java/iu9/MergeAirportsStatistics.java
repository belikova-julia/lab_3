package iu9;

import org.apache.spark.api.java.function.Function2;

import java.util.function.Function;

public class MergeAirportsStatistics implements
        Function2<AnalyticsSerializable, AnalyticsSerializable, AnalyticsSerializable> {
    @Override
    public AnalyticsSerializable call(AnalyticsSerializable analytics1,
                                      AnalyticsSerializable analytics2) throws Exception {
        return null;
    }
}
