package com.cit.masters.occupancyservice;

import lombok.extern.slf4j.*;
import org.springframework.stereotype.*;

import java.util.*;

@Service
@Slf4j
public class OccupancyService {

    private List<OccupancyData> occupancyDataList = OccupancyUtils.occupancyDataList();

    public void addOccupancyData(OccupancyData data) {
        log.info("Got currently available occupancies: {}", occupancyDataList);
        occupancyDataList.add(data);
    }

    public OccupancyData getOccupancy() {
        log.info("Got GET for occupancy, available occupancy: {}", occupancyDataList);

        //Get random occupancy
        OccupancyData randomOccupancy = occupancyDataList.get(new Random().nextInt(occupancyDataList.size()));
        log.info("Got occupancy: {}", randomOccupancy);

        return randomOccupancy;

    }
}
