package com.cit.masters.climateservice;

import lombok.extern.slf4j.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import javax.annotation.*;
import javax.validation.*;

@RestController
@Slf4j
public class ClimateController {

    @Resource
    private ClimateService climateService;

    @PostMapping
    public ResponseEntity<Object> create(@RequestBody @Valid EnrichedTemperatureData data, @RequestHeader HttpHeaders headers) {
        log.info("Headers received: {}", headers);
        log.info("Incoming Temperature request to Climate Control: {}", data);
        log.info("SpanID: {}", headers.get("x-b3-spanid"));
        log.info("ParentSpanID: {}", headers.get("x-b3-parentspanid"));
        log.info("TraceID: {}", headers.get("x-b3-traceid"));
        boolean received = climateService.receive(data);
        if (!received) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }
}
