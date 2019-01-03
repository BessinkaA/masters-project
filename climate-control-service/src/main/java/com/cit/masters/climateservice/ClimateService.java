package com.cit.masters.climateservice;

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
public class ClimateService {

    public Boolean receive(AssetClimateData data) {

        // TODO: add proper validation for UUID and such
        log.info("Fire alert received, temperature is {}", data.getTemperature());
        if (data.getTemperature() > 50) {
            RestTemplate restTemplate = new RestTemplate();
            HttpEntity<AssetClimateData> request = new HttpEntity<>(data);
            try {
                ResponseEntity<String> entity = restTemplate.postForEntity("http://localhost:8084", request, String.class);
                log.info("Response status: {}", entity.getStatusCodeValue());
                return true;
            } catch (Exception ex) {
                return false;
            }
        } else{
            log.info("Not a fire event, temperature is {}", data.getTemperature());
            return true;
        }
    }
}
