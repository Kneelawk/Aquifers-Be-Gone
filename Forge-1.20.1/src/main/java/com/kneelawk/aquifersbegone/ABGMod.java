package com.kneelawk.aquifersbegone;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Constants.MOD_ID)
public class ABGMod {
    public ABGMod() {
        FMLJavaModLoadingContext.get().getModEventBus().register(new ForgeCommon());
    }
}
