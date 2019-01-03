package com.cit.masters.assetservice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 *
 */
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
