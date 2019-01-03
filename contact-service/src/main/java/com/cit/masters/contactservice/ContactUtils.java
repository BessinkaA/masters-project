package com.cit.masters.contactservice;

import java.util.HashMap;
import java.util.Map;

/**
 *
 */
public class ContactUtils {

    public static Map<String, String> getContactsMap() {
        Map<String, String> contactsMap = new HashMap<>();
        contactsMap.put("Jane Doe", "123456789");
        contactsMap.put("John Doe", "987654321");
        contactsMap.put("Alison Donovan", "123456789");
        contactsMap.put("Jack Donovan", "987654321");
        contactsMap.put("John Murphy", "123456789");
        contactsMap.put("Jane Murphy", "987654321");
        contactsMap.put("John Sullivan", "123456789");
        contactsMap.put("Alison Sullivan", "987654321");
        contactsMap.put("Jane Sullivan", "123456789");
        contactsMap.put("John Donovan", "987654321");
        return contactsMap;

    }
}
