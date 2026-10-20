package com.mekanismadditionsoverhaul;

import net.minecraft.resources.ResourceLocation;

public final class MaoConstants {
    public static final String MOD_ID = "mekanismadditionsoverhaul";

    private MaoConstants() {
    }

    public static ResourceLocation id(String path) {
        return new ResourceLocation(MOD_ID, path);
    }
}
