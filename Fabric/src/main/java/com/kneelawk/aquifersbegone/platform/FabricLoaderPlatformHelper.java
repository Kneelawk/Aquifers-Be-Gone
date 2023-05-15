package com.kneelawk.aquifersbegone.platform;

import com.kneelawk.aquifersbegone.config.ABGServerConfig;
import com.kneelawk.aquifersbegone.platform.services.ILoaderPlatformHelper;

public class FabricLoaderPlatformHelper implements ILoaderPlatformHelper {
    @Override
    public boolean lavaInCaves() {
        return ABGServerConfig.CONFIG.lavaInCaves;
    }
}
