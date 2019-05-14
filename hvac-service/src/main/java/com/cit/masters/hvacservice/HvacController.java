package com.cit.masters.hvacservice;

import lombok.extern.slf4j.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import javax.annotation.*;
import javax.validation.*;

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
