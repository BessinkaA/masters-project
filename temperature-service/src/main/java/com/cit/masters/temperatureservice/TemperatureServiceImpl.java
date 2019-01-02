package com.cit.masters.temperatureservice;

import java.util.UUID;

import static java.util.UUID.fromString;

/**
 *
 */
public class TemperatureServiceImpl implements TemperatureService {

    @Override
    public Boolean receive(TemperatureData data) {

        try {
            fromString(data.getSensorId());
            return true;
        } catch (IllegalArgumentException exception) {
            return false;
        }
    }
}
