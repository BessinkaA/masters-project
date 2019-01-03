package com.cit.masters.fireservice;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 *
 */

@Setter
@Getter
@AllArgsConstructor
public class EnrichedAssetClimateData {

    private ContactResponse contact;
    private AssetClimateData climateData;
}
