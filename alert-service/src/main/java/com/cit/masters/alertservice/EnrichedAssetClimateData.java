package com.cit.masters.alertservice;

import lombok.*;

import javax.validation.constraints.*;

@Getter
@Setter
@ToString
public class EnrichedAssetClimateData {

    @NotNull
    private EnrichedTemperatureData climateData;

    @NotNull
    private Contact contact;

    @NotNull
    private OccupancyResponse peopleNumber;
}
