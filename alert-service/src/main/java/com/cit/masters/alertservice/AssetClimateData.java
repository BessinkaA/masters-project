package com.cit.masters.alertservice;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.validation.constraints.NotNull;

/**
 *
 */

@Getter
@Setter
public class AssetClimateData {

    @NonNull
    private int temperature;

    @NotNull
    private String sensorId;
}
