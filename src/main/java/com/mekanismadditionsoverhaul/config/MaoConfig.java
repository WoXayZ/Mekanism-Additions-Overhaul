package com.mekanismadditionsoverhaul.config;

import net.minecraftforge.common.ForgeConfigSpec;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public final class MaoConfig {
    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    private static final Map<String, Variant> VARIANTS = new LinkedHashMap<>();
    private static ForgeConfigSpec SPEC;

    private MaoConfig() {
    }

    public static void define(String id) {
        BUILDER.push(id);
        ForgeConfigSpec.BooleanValue enabled = BUILDER
                .comment("Spawn this baby in biomes where the adult already spawns.")
                .define("enabled", true);
        ForgeConfigSpec.DoubleValue weight = BUILDER
                .comment("Fraction of the adult spawn weight. 0.05 is the Mekanism baby default.")
                .defineInRange("weight", 0.05D, 0.0D, 100.0D);
        BUILDER.pop();
        VARIANTS.put(id, new Variant(enabled, weight));
    }

    public static ForgeConfigSpec finish() {
        if (SPEC == null) {
            SPEC = BUILDER.build();
        }
        return SPEC;
    }

    public static Variant variant(String id) {
        return VARIANTS.get(id);
    }

    public static Map<String, Variant> variants() {
        return Collections.unmodifiableMap(VARIANTS);
    }

    public record Variant(ForgeConfigSpec.BooleanValue enabled, ForgeConfigSpec.DoubleValue weight) {
    }
}
