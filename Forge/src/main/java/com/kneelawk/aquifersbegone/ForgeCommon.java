package com.kneelawk.aquifersbegone;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

import com.kneelawk.aquifersbegone.config.ABGServerConfig;

public class ForgeCommon {
    public ForgeCommon() {
        CommonClass.init();
        ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, ABGServerConfig.SPEC);
    }

    @SubscribeEvent
    public void postLoaded(FMLCommonSetupEvent event) {
        CommonClass.loaded();
    }
}
