package com.kneelawk.aquifersbegone;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

public class ForgeCommon {
    public ForgeCommon() {
        CommonClass.init();
    }

    @SubscribeEvent
    public void postLoaded(FMLCommonSetupEvent event) {
        CommonClass.loaded();
    }
}
