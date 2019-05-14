package com.cit.masters.fireservice;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class EnrichedTemperatureData {

    private AssetResponse asset;
    private TemperatureData temperatureData;
}
