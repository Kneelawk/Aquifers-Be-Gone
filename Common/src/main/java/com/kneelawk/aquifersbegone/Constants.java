package com.kneelawk.aquifersbegone;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.minecraft.resources.ResourceLocation;

public class Constants {
    public static final String MOD_ID = "aquifersbegone";
    public static final String MOD_NAME = "Aquifers Be Gone";
    public static final Logger LOG = LoggerFactory.getLogger(MOD_NAME);

    public static ResourceLocation id(String path) {
        return new ResourceLocation(MOD_ID, path);
    }
}
