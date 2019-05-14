package com.cit.masters.alertservice;

import lombok.extern.slf4j.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import javax.annotation.*;
import javax.validation.*;

@RestController
@Slf4j
public class AlertController {

    @Resource
    private AlertService alertService;

    @PostMapping
    public ResponseEntity<Object> recieveAlert(@RequestBody @Valid EnrichedAssetClimateData data) {
        log.info("Incoming Fire alert to Alert Controller: {}", data);
        boolean received = alertService.receive(data);
        if (!received) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }
}
