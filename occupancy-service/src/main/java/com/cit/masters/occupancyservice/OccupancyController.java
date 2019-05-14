package com.cit.masters.occupancyservice;

import lombok.extern.slf4j.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import javax.annotation.*;
import javax.validation.*;

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
