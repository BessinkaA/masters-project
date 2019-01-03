package com.cit.masters.occupancyservice;

import org.springframework.stereotype.Service;

import static java.util.UUID.fromString;

/**
 *
 */
@Service
public class OccupancyService {

    public Boolean receive(OccupancyData data) {

        try {
            fromString(data.getSensorId());
            return true;
        } catch (IllegalArgumentException exception) {
            return false;
        }
    }
}
