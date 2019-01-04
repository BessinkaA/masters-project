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

    public Boolean process(EnrichedTemperatureData data) {

        // TODO: add proper validation for UUID and such
        log.info("Fire service: Fire alert received, temperature is {}", data.getTemperatureData().getTemperature());
        RestTemplate restTemplate = new RestTemplate();

        // Check if room is empty or not
        OccupancyResponse peopleNumber = restTemplate.getForObject("http://localhost:8082/" + data.getAsset()
                                                                                                       .getRoomId(), OccupancyResponse.class);

        // Request contact from contact service
        ContactResponse contact = restTemplate.getForObject("http://localhost:8087/" + data.getTemperatureData()
                                                                                           .getSensorId(), ContactResponse.class);

        // Create new payload
        EnrichedAssetClimateData enrichedData = new EnrichedAssetClimateData(contact, data, peopleNumber);

        // Contact alert Service
        HttpEntity<EnrichedAssetClimateData> request = new HttpEntity<>(enrichedData);
        try {
            ResponseEntity<String> entity = restTemplate.postForEntity("http://localhost:8086", request, String.class);
            log.info("Response status: {}", entity.getStatusCodeValue());
            return true;
        } catch (Exception ex) {
            return false;

        }
    }
}
