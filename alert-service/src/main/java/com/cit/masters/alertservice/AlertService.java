package com.cit.masters.alertservice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static java.util.UUID.fromString;

/**
 *
 */
@Service
@Slf4j
public class AlertService {

    public Boolean receive(EnrichedAssetClimateData data) {

        try {
            fromString(data.getClimateData().getTemperatureData().getSensorId());
            return true;
        } catch (IllegalArgumentException exception) {
            return false;
        }
    }
}
