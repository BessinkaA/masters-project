package com.cit.masters.contactservice;

import lombok.extern.slf4j.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import javax.annotation.*;

@RestController
@Slf4j
public class ContactController {

    @Resource
    private ContactService contactService;

    @GetMapping(value = "/{roomId}")
    public ResponseEntity<Object> getEmergencyContacts(@PathVariable("roomId") String roomId) {
        log.info("Got request for contacts for room: {}", roomId);
        Contact contact = contactService.retrieveContacts();
        if (contact == null) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }

        return ResponseEntity.status(HttpStatus.OK).body(contact);
    }
}
