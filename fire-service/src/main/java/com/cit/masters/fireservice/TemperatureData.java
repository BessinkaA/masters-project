package com.cit.masters.fireservice;

import lombok.*;

import java.io.*;

@Getter
@Setter
@ToString
public class TemperatureData implements Serializable {

    @NonNull
    private int temperature;

    @NonNull
    private String sensorId;
}
