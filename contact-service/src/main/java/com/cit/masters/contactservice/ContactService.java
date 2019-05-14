package com.cit.masters.contactservice;

import lombok.extern.slf4j.*;
import org.springframework.stereotype.*;

import java.util.*;

@Service
@Slf4j
public class ContactService {


    public Contact retrieveContacts() {
        List<Contact> contacts = ContactUtils.getContactsList();

        //Get random name
        Contact randomName = contacts.get(new Random().nextInt(contacts.size()));
        log.info("Got contact name: {}", randomName);

        return randomName;
    }
}

