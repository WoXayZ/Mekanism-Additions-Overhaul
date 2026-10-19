package com.mekanismadditionsoverhaul.config;

import net.neoforged.neoforge.common.ModConfigSpec;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public final class MaoConfig {
    private static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();
    private static final Map<String, Variant> VARIANTS = new LinkedHashMap<>();
    private static ModConfigSpec SPEC;

    private MaoConfig() {
    }

    public static void define(String id) {
        BUILDER.push(id);
        ModConfigSpec.BooleanValue enabled = BUILDER
                .comment("Spawn this baby in biomes where the adult already spawns.")
                .define("enabled", true);
        ModConfigSpec.DoubleValue weight = BUILDER
                .comment("Fraction of the adult spawn weight. 0.05 is the Mekanism baby default.")
                .defineInRange("weight", 0.05D, 0.0D, 100.0D);
        BUILDER.pop();
        VARIANTS.put(id, new Variant(enabled, weight));
    }

    public static ModConfigSpec finish() {
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

    public record Variant(ModConfigSpec.BooleanValue enabled, ModConfigSpec.DoubleValue weight) {
    }
}
