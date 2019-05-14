package com.cit.masters.temperatureservice;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
public class EnrichedTemperatureData {

    private AssetResponse asset;
    private TemperatureData temperatureData;
}
