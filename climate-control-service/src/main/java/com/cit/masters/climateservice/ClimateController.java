package com.cit.masters.climateservice;

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
public class ClimateController {

    @Resource
    private ClimateService climateService;

    @PostMapping
    public ResponseEntity<Object> create(@RequestBody @Valid AssetClimateData data) {
        log.info("Incoming Temperature request to Climate Control: {}", data);
        boolean received = climateService.receive(data);
        if (!received) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Climate control - bad request");
        }
        return ResponseEntity.status(HttpStatus.OK).body("Climate control works ok");
    }
}
