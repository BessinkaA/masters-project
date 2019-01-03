package com.cit.masters.contactservice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Random;

/**
 *
 */
@Service
@Slf4j
public class ContactService {


    public Object retrieveContacts() {
        Map<String, String> contactsMap = ContactUtils.getContactsMap();
        Random random = new Random();

        //Get random name
        Object randomName = contactsMap.keySet().toArray()[new Random().nextInt(contactsMap.keySet().toArray().length)];
        log.info("Got contact name: {}", randomName);

        return randomName;
    }
}

