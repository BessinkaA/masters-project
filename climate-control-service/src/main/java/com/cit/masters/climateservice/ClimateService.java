package com.cit.masters.climateservice;

import lombok.extern.slf4j.*;
import org.springframework.http.*;
import org.springframework.stereotype.*;
import org.springframework.web.client.*;

import javax.annotation.*;

@Service
@Slf4j
public class ClimateService {

    @Resource
    private RestTemplate restTemplate;

    public Boolean receive(EnrichedTemperatureData data) {

        if (data.getTemperatureData().getTemperature() > 50) {
            log.info("Fire alert received, temperature is {}", data.getTemperatureData().getTemperature());
            HttpEntity<EnrichedTemperatureData> request = new HttpEntity<>(data);
            try {
                ResponseEntity<String> entity = restTemplate.postForEntity("http://localhost:8084", request, String.class);
                log.info("Response status: {}", entity.getStatusCodeValue());
                return true;
            } catch (Exception ex) {
                log.error("Error contacting Fire Service", ex);
                return false;
            }
        } else {
            log.info("Not a fire event, temperature is {}. Sending request to HVAC service.", data.getTemperatureData()
                                                                                                  .getTemperature());
            HttpEntity<EnrichedTemperatureData> request = new HttpEntity<>(data);
            try {
                ResponseEntity<String> entity = restTemplate.postForEntity("http://localhost:8085", request, String.class);
                log.info("Response status: {}", entity.getStatusCodeValue());
                return true;
            } catch (Exception ex) {
                log.error("Error contacting HVAC Service", ex);
                return false;
            }
        }
    }
}
