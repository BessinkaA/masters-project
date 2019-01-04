package com.cit.masters.occupancyservice;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

/**
 *
 */

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class OccupancyData {

    @NonNull
    private int peopleNumber;

}
