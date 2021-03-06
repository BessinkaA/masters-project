package com.cit.masters.fireservice;

import lombok.extern.slf4j.*;
import org.springframework.http.*;
import org.springframework.stereotype.*;
import org.springframework.web.client.*;

import javax.annotation.*;

@Service
@Slf4j
public class FireService {

    @Resource
    private RestTemplate restTemplate;

    public Boolean process(EnrichedTemperatureData data) {

        log.info("Fire service: Fire alert received, temperature is {}", data.getTemperatureData().getTemperature());

        // Check if room is empty or not
        OccupancyResponse peopleNumber;
        try {
            peopleNumber = restTemplate.getForObject("http://localhost:8082/" + data.getAsset()
                                                                                    .getRoomId(), OccupancyResponse.class);
        } catch (RestClientException e) {
            log.error("Couldn't receive room's occupancy", e);
            return false;
        }

        // Request contact from contact service
        ContactResponse contact;
        try {
            contact = restTemplate.getForObject("http://localhost:8087/" + data.getAsset()
                                                                               .getRoomId(), ContactResponse.class);
        } catch (RestClientException e) {
            log.error("Couldn't receive contacts", e);
            return false;
        }

        // Create new payload
        EnrichedAssetClimateData enrichedData = new EnrichedAssetClimateData(contact, data, peopleNumber);

        // Contact alert Service
        HttpEntity<EnrichedAssetClimateData> request = new HttpEntity<>(enrichedData);
        try {
            ResponseEntity<String> entity = restTemplate.postForEntity("http://localhost:8086", request, String.class);
            log.info("Response status: {}", entity.getStatusCodeValue());
            return true;
        } catch (RestClientException e) {
            log.error("Couldn't contact Alert Service", e);
            return false;

        }
    }
}
