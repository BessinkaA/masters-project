package com.cit.masters.temperatureservice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 *
 */
@Service
@Slf4j
public class TemperatureService {

    public Boolean process(TemperatureData data) {

        // TODO: add UUID normal check
        if (data.getTemperature() < 15 || data.getTemperature() > 25) {
            log.info("Temperature for sensor {} is not in a normal range: {}", data.getSensorId(), data.getTemperature());

            RestTemplate restTemplate = new RestTemplate();
            HttpEntity<TemperatureData> request = new HttpEntity<>(data);
            TemperatureData temperatureData = restTemplate.postForObject("http://localhost:8083", request, TemperatureData.class);

            return true;
        } else {
            log.info("Temperature for sensor {} is in a normal range: {}", data.getSensorId(), data.getTemperature());
            return true;
        }
    }
}
