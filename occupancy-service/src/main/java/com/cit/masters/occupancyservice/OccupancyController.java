package com.cit.masters.occupancyservice;

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
public class OccupancyController {
    @Resource
    private OccupancyService occupancyService;

    @PostMapping
    public ResponseEntity<Object> create(@RequestBody @Valid OccupancyData data) {
        log.info("Occupancy request: {}", data);
        boolean received = occupancyService.receive(data);
        if (!received) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Occupancy service returned bad request");
        }
        return ResponseEntity.status(HttpStatus.OK).body("Occupancy service Works");
    }
}
