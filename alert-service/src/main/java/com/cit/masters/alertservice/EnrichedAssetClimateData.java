package com.cit.masters.alertservice;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;

/**
 *
 */

@Getter
@Setter
@ToString
public class EnrichedAssetClimateData {

    @NotNull
    private EnrichedTemperatureData climateData;

    @NotNull
    private Contact contact;
}
