package com.cit.masters.occupancyservice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    public ResponseEntity<Object> receiveOccupancy(@RequestBody @Valid OccupancyData data) {
        log.info("Occupancy request: {}", data);
        occupancyService.addOccupancyData(data);
        return ResponseEntity.status(HttpStatus.OK).body("Received occupancy data: " + data);
    }

    @GetMapping(value = "/{roomId}")
    public ResponseEntity<Object> getEmergencyContacts(@PathVariable("roomId") String roomId) {
        log.info("Got request to report number of people for room: {}", roomId);
        OccupancyData numberOfPeople = occupancyService.getOccupancy();
        if (numberOfPeople == null) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }

        return ResponseEntity.status(HttpStatus.OK).body(numberOfPeople);
    }
}
