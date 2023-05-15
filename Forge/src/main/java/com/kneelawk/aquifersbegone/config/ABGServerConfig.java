package com.kneelawk.aquifersbegone.config;

import net.minecraftforge.common.ForgeConfigSpec;

import org.apache.commons.lang3.tuple.Pair;

public class ABGServerConfig {
    public static final ABGServerConfig CONFIG;
    public static final ForgeConfigSpec SPEC;

    static {
        Pair<ABGServerConfig, ForgeConfigSpec> pair = new ForgeConfigSpec.Builder().configure(ABGServerConfig::new);
        CONFIG = pair.getLeft();
        SPEC = pair.getRight();
    }

    public final ForgeConfigSpec.BooleanValue lavaInCaves;

    public ABGServerConfig(ForgeConfigSpec.Builder builder) {
        lavaInCaves = builder.comment("Whether ABG leaves lava in caves or remove it. false = remove lava.")
            .define("lava_in_caves", true);
    }
}
