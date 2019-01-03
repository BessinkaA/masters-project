package com.cit.masters.hvacservice;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;

/**
 *
 */

@Setter
@Getter
@ToString
public class AssetClimateData {

    @NonNull
    private int temperature;

    @NotNull
    private String sensorId;
}
