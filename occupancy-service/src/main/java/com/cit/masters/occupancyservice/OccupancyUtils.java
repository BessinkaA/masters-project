package com.cit.masters.occupancyservice;

import java.util.Arrays;
import java.util.List;

/**
 *
 */
public class OccupancyUtils {

    public static List<OccupancyData> occupancyDataList() {
        return Arrays.asList(
                new OccupancyData(0),
                new OccupancyData(5),
                new OccupancyData(15)
        );
    }
}
