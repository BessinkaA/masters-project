package com.cit.masters.occupancyservice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

/**
 *
 */
@Service
@Slf4j
public class OccupancyService {

    public void receive(OccupancyData data) {
        List<OccupancyData> peopleNumber = OccupancyUtils.occupancyDataList();
        peopleNumber.add(data);
    }

    public OccupancyData getOccupancy() {
        List<OccupancyData> occupancyDataList = OccupancyUtils.occupancyDataList();

        //Get random asset
        OccupancyData randomOccupancy = occupancyDataList.get(new Random().nextInt(occupancyDataList.size()));
        log.info("Got occupancy: {}", randomOccupancy);

        return randomOccupancy;

    }
}
