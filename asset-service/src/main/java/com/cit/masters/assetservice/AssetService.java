package com.cit.masters.assetservice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

/**
 *
 */

@Service
@Slf4j
public class AssetService {
    public Asset getAsset() {

        List<Asset> assets = AssetUtils.getAssets();

        //Get random asset
        Asset randomAsset = assets.get(new Random().nextInt(assets.size()));
        log.info("Got asset: {}", randomAsset);

        return randomAsset;

    }
}
