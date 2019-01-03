package com.cit.masters.temperatureservice;

import org.springframework.stereotype.Service;

import static java.util.UUID.fromString;

/**
 *
 */
@Service
public class TemperatureService {

    @SuppressWarnings("ResultOfMethodCallIgnored")
    public Boolean receive(TemperatureData data) {

        try {
            fromString(data.getSensorId());
            return true;
        } catch (IllegalArgumentException exception) {
            return false;
        }
    }
}