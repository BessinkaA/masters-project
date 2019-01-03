package com.cit.masters.hvacservice;

import org.springframework.stereotype.Service;

import static java.util.UUID.fromString;

/**
 *
 */

@Service
public class HvacService {

    public Boolean receive(EnrichedTemperatureData data) {

        try {
            fromString(data.getTemperatureData().getSensorId());
            return true;
        } catch (IllegalArgumentException exception) {
            return false;
        }
    }
}
