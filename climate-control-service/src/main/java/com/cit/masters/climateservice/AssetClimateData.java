package com.cit.masters.climateservice;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.validation.constraints.NotNull;

/**
 *
 */

@Setter
@Getter
public class AssetClimateData {

    @NonNull
    private int temperature;

    @NotNull
    private String sensorId;
}
