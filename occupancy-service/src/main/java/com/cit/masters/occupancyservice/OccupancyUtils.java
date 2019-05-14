package com.cit.masters.occupancyservice;

import java.util.*;

public class OccupancyUtils {

    public static List<OccupancyData> occupancyDataList() {
        return new ArrayList<>(Arrays.asList(
                new OccupancyData(0),
                new OccupancyData(5),
                new OccupancyData(15),
                new OccupancyData(12),
                new OccupancyData(45)
        ));
    }
}
