package com.cit.masters.temperatureservice;

import lombok.extern.slf4j.*;
import org.springframework.http.*;
import org.springframework.stereotype.*;
import org.springframework.web.client.*;

import javax.annotation.*;

@Service
@Slf4j
public class TemperatureService {

    @Resource
    private RestTemplate restTemplate;

    public Boolean process(TemperatureData data) {
        if (data.getTemperature() < 15 || data.getTemperature() > 25) {
            log.info("Temperature for sensor {} is not in a normal range: {}", data.getSensorId(), data.getTemperature());

            // Get room information -> query Asset service
            AssetResponse asset;
            try {
                asset = restTemplate.getForObject("http://localhost:8088/" + data.getSensorId(), AssetResponse.class);
            } catch (RestClientException ex) {
                log.error("Failed to get asset", ex);
                return false;
            }

            // Create new payload
            EnrichedTemperatureData enrichedData = new EnrichedTemperatureData(asset, data);

            HttpEntity<EnrichedTemperatureData> request = new HttpEntity<>(enrichedData);
            try {
                ResponseEntity<String> entity = restTemplate.postForEntity("http://localhost:8083", request, String.class);
                log.info("Response status: {}", entity.getStatusCodeValue());
                return true;
            } catch (Exception ex) {
                log.error("Failed to POST to climate control", ex);
                return false;
            }

        } else {
            log.info("Temperature for sensor {} is in a normal range: {}", data.getSensorId(), data.getTemperature());
            return true;
        }
    }
}
