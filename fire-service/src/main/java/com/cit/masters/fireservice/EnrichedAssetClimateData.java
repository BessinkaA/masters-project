package com.cit.masters.fireservice;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 *
 */

@Setter
@Getter
@AllArgsConstructor
@ToString
public class EnrichedAssetClimateData {

    private ContactResponse contact;
    private EnrichedTemperatureData climateData;
    private OccupancyResponse peopleNumber;
}
