package com.cit.masters.temperatureservice;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

/**
 *
 */

@Getter
@Setter
public class TemperatureData {

    @NonNull
    private int temperature;

    @NonNull
    private String sensorId;
}
