package com.cit.masters.fireservice;

import org.springframework.stereotype.Service;

import static java.util.UUID.fromString;

/**
 *
 */
@Service
public class FireService {

    public Boolean receive(AssetClimateData data) {

        try {
            fromString(data.getSensorId());
            return true;
        } catch (IllegalArgumentException exception) {
            return false;
        }
    }
}
