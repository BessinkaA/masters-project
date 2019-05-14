package com.cit.masters.temperatureservice;

import lombok.extern.slf4j.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import javax.annotation.*;
import javax.validation.*;

@RestController
@Slf4j
public class TemperatureController {
    @Resource
    private TemperatureService temperatureService;

    @PostMapping
    public ResponseEntity<Object> receiveTemperatureData(@RequestBody @Valid TemperatureData data, @RequestHeader HttpHeaders headers) {
        log.info("Headers received: {}", headers);
        log.info("Incoming Temperature request to Climate Control: {}", data);
        log.info("SpanID: {}", headers.get("x-b3-spanid"));
        log.info("ParentSpanID: {}", headers.get("x-b3-parentspanid"));
        log.info("TraceID: {}", headers.get("x-b3-traceid"));
        log.info("Temperature request: {}", data);
        boolean processed = temperatureService.process(data);
        if (!processed) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Something went wrong");
        }
        return ResponseEntity.status(HttpStatus.OK).body("Temperature request was processed");
    }
}
