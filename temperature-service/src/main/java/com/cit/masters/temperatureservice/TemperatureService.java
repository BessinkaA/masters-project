package com.cit.masters.temperatureservice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
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
        // TODO: remove "service" from package names
        if (data.getTemperature() < 15 || data.getTemperature() > 25) {
            log.info("Temperature for sensor {} is not in a normal range: {}", data.getSensorId(), data.getTemperature());

            // Get room information -> query Asset service
            RestTemplate restTemplate = new RestTemplate();
            AssetResponse asset = restTemplate.getForObject("http://localhost:8088/" + data.getSensorId(), AssetResponse.class);

            // Create new payload
            EnrichedTemperatureData enrichedData = new EnrichedTemperatureData(asset, data);

            // TODO: is this request needed? Pass data straight to postForEntity?
            HttpEntity<EnrichedTemperatureData> request = new HttpEntity<>(enrichedData);
            try {
                // TODO all internal requests route via Gateway
                ResponseEntity<String> entity = restTemplate.postForEntity("http://localhost:8083", request, String.class);
                log.info("Response status: {}", entity.getStatusCodeValue());
                return true;
            } catch (Exception ex) {
                return false;
            }

        } else {
            log.info("Temperature for sensor {} is in a normal range: {}", data.getSensorId(), data.getTemperature());
            return true;
        }
    }
}
