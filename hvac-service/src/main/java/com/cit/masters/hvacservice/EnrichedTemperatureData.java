package com.cit.masters.hvacservice;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 *
 */
@Getter
@Setter
@AllArgsConstructor
@ToString
public class EnrichedTemperatureData {

    private AssetResponse asset;
    private TemperatureData temperatureData;
}
