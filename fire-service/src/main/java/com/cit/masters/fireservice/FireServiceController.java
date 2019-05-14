package com.cit.masters.fireservice;

import lombok.extern.slf4j.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import javax.annotation.*;
import javax.validation.*;

@RestController
@Slf4j
public class FireServiceController {

    @Resource
    private FireService fireService;

    @PostMapping
    public ResponseEntity<Object> receiveFireEvent(@RequestBody @Valid EnrichedTemperatureData data) {
        log.info("Incoming Fire alert to Fire Service: {}", data);
        boolean received = fireService.process(data);
        if (!received) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }
}
