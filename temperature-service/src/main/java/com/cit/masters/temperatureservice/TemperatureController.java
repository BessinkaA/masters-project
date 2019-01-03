package com.cit.masters.temperatureservice;

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
public class TemperatureController {
    @Resource
    private TemperatureService temperatureService;

    @PostMapping
    public ResponseEntity<Object> create(@RequestBody @Valid TemperatureData data) {
        log.info("Temperature request: {}", data);
        boolean processed = temperatureService.process(data);
        if (!processed) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Nope");
        }
        return ResponseEntity.status(HttpStatus.OK).body("Temperature request was processed");
    }
}
