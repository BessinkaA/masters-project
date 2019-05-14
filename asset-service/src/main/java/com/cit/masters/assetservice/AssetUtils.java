package com.cit.masters.assetservice;

import java.util.*;

public class AssetUtils {

    public static List<Asset> getAssets() {
        return Arrays.asList(
                new Asset("Western Gateway Building", "123"),
                new Asset("Western Gateway Building", "321"),
                new Asset("Western Gateway Building", "456"),
                new Asset("Western Gateway Building", "987"),
                new Asset("Main Building", "123"),
                new Asset("Main Building", "321"),
                new Asset("Main Building", "456"),
                new Asset("Main Building", "987"),
                new Asset("Library", "123"),
                new Asset("Library", "987")
        );
    }
}
