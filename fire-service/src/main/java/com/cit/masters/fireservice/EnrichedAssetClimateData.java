package com.cit.masters.fireservice;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@ToString
public class EnrichedAssetClimateData {

    private ContactResponse contact;
    private EnrichedTemperatureData climateData;
    private OccupancyResponse peopleNumber;
}
