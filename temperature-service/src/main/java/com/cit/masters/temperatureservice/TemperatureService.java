package com.cit.masters.temperatureservice;

import org.springframework.stereotype.Service;

/**
 *
 */

public interface TemperatureService {

    Boolean receive(TemperatureData data);
}
