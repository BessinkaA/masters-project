package com.cit.masters.climateservice;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 *
 */

@Getter
@Setter
@ToString
public class TemperatureData implements Serializable {

    @NonNull
    private int temperature;

    @NonNull
    private String sensorId;
}
