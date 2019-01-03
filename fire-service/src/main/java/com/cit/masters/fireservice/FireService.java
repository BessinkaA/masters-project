package com.cit.masters.fireservice;

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
public class FireService {

    public Boolean receive(AssetClimateData data) {

        // TODO: add proper validation for UUID and such
        log.info("Fire service: Fire alert received, temperature is {}", data.getTemperature());
        RestTemplate restTemplate = new RestTemplate();

        HttpEntity<AssetClimateData> request = new HttpEntity<>(data);
        try {
            ResponseEntity<String> entity = restTemplate.postForEntity("http://localhost:8086", request, String.class);
            log.info("Response status: {}", entity.getStatusCodeValue());
            return true;
        } catch (Exception ex) {
            return false;

        }
    }
}
