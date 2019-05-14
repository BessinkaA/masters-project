package com.cit.masters.assetservice;

import lombok.extern.slf4j.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import javax.annotation.*;

@RestController
@Slf4j
public class AssetController {

    @Resource
    private AssetService assetService;

    @GetMapping(value = "/{sensorId}")
    public ResponseEntity<Object> getEmergencyContacts(@PathVariable("sensorId") String sensorId) {
        log.info("Got request for Asset for sensor: {}", sensorId);
        Asset asset = assetService.getAsset();
        if (asset == null) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }

        return ResponseEntity.status(HttpStatus.OK).body(asset);
    }


}
