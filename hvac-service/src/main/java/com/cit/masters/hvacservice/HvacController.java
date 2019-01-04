package com.cit.masters.hvacservice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 *
 */
@RestController
@Slf4j
public class HvacController {

    @Resource
    private HvacService hvacService;

    @PostMapping
    public ResponseEntity<Object> receiveTemperatureData(@RequestBody @Valid EnrichedTemperatureData data) {
        log.info("Incoming Temperature request to HVAC Controller: {}", data);
        boolean received = hvacService.receive(data);
        if (!received) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }
}
