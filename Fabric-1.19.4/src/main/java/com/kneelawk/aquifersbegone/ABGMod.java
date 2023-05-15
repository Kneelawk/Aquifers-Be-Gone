package com.kneelawk.aquifersbegone;

import net.fabricmc.api.ModInitializer;

public class ABGMod implements ModInitializer {

    @Override
    public void onInitialize() {
        FabricCommon.init();

        FabricCommon.loaded();
    }
}
