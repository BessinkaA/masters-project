package com.cit.masters.temperatureservice;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.io.Serializable;

/**
 *
 */

@Getter
@Setter
public class TemperatureData implements Serializable {

    @NonNull
    private int temperature;

    @NonNull
    private String sensorId;
}
