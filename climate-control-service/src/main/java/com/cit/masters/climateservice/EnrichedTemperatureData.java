package com.cit.masters.climateservice;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class EnrichedTemperatureData {

    private AssetResponse asset;
    private TemperatureData temperatureData;
}
