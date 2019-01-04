package com.cit.masters.alertservice;

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
