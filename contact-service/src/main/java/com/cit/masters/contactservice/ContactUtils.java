package com.cit.masters.contactservice;

import java.util.Arrays;
import java.util.List;

/**
 *
 */
public class ContactUtils {

    public static List<Contact> getContactsList() {
        return Arrays.asList(
                new Contact("Jane Doe", "123456789"),
                new Contact("John Doe", "987654321"),
                new Contact("Alison Donovan", "123456789"),
                new Contact("Jack Donovan", "987654321"),
                new Contact("John Murphy", "123456789"),
                new Contact("Jane Murphy", "987654321"),
                new Contact("John Sullivan", "123456789"),
                new Contact("Alison Sullivan", "987654321"),
                new Contact("Jane Sullivan", "123456789"),
                new Contact("John Donovan", "987654321")
        );
    }
}
