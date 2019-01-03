package com.cit.masters.alertservice;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;

/**
 *
 */

@Getter
@Setter
@ToString
public class AssetClimateData {

    @NonNull
    private int temperature;

    @NotNull
    private String sensorId;
}
