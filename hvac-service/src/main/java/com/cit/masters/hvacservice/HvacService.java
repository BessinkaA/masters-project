package com.cit.masters.hvacservice;

import org.springframework.stereotype.*;

import static java.util.UUID.*;

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
