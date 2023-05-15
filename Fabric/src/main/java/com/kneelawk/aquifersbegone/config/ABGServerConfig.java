package com.kneelawk.aquifersbegone.config;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import com.google.gson.Gson;

import net.fabricmc.loader.api.FabricLoader;

import com.kneelawk.aquifersbegone.Constants;

public class ABGServerConfig {
    public static final ABGServerConfig CONFIG;

    static {
        Constants.LOG.info("[Aquifers Be Gone] Loading config...");

        Gson gson = new Gson();
        Path configDir = FabricLoader.getInstance().getConfigDir();
        Path configFile = configDir.resolve("aquifersbegone-server.json");

        ABGServerConfig config;
        try (BufferedReader reader = Files.newBufferedReader(configFile)) {
            config = gson.fromJson(reader, ABGServerConfig.class);
        } catch (IOException e) {
            Constants.LOG.warn("[Aquifers Be Gone] Error loading aquifersbegone.json config", e);
            config = new ABGServerConfig();
        }

        CONFIG = config;

        try (BufferedWriter writer = Files.newBufferedWriter(configFile)) {
            gson.toJson(config, writer);
        } catch (IOException e) {
            Constants.LOG.warn("[Aquifers Be Gone] Error writing aquifersbegone.json config", e);
        }

        Constants.LOG.info("[Aquifers Be Gone] Config loaded.");
    }

    public boolean lavaInCaves = true;
}
