package com.cit.masters.occupancyservice;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

/**
 *
 */

@Getter
@Setter
public class OccupancyData {

    @NonNull
    private int peopleNumber;

    @NonNull
    private String sensorId;
}
