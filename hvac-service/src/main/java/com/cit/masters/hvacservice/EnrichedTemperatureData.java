package com.cit.masters.hvacservice;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class EnrichedTemperatureData {

    private AssetResponse asset;
    private TemperatureData temperatureData;
}
