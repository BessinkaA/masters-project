package com.cit.masters.contactservice;

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
public class ContactController {

    @Resource
    private ContactService contactService;

    @GetMapping(value = "/{sensorId}")
    public ResponseEntity<Object> getEmergencyContacts(@PathVariable("sensorId") String sensorId) {
        log.info("Got request for contacts for sensor: {}", sensorId);
        Object contactName = contactService.retrieveContacts();
        if (contactName == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        //TODO else return contacts
        return ResponseEntity.status(HttpStatus.OK).body(contactName);
    }
}
