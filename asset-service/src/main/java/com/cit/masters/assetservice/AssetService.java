package com.cit.masters.assetservice;

import lombok.extern.slf4j.*;
import org.springframework.stereotype.*;

import java.util.*;

@Service
@Slf4j
public class AssetService {
    public Asset getAsset() {
        log.info("Getting asset...");
        List<Asset> assets = AssetUtils.getAssets();

        //Get random asset
        Asset randomAsset = assets.get(new Random().nextInt(assets.size()));
        log.info("Got asset: {}", randomAsset);

        return randomAsset;

    }
}
