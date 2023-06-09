package com.kneelawk.aquifersbegone.platform;

import net.fabricmc.loader.api.FabricLoader;

import com.kneelawk.aquifersbegone.platform.services.IVersionPlatformHelper;

public class FabricVersionPlatformHelper implements IVersionPlatformHelper {

    @Override
    public String getPlatformName() {
        return "Fabric";
    }

    @Override
    public boolean isModLoaded(String modId) {

        return FabricLoader.getInstance().isModLoaded(modId);
    }

    @Override
    public boolean isDevelopmentEnvironment() {

        return FabricLoader.getInstance().isDevelopmentEnvironment();
    }
}
