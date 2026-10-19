package com.mekanismadditionsoverhaul.spawn;

import com.mojang.serialization.MapCodec;
import com.mekanismadditionsoverhaul.config.MaoConfig;
import net.minecraft.core.Holder;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.neoforged.neoforge.common.world.BiomeModifier;
import net.neoforged.neoforge.common.world.MobSpawnSettingsBuilder;
import net.neoforged.neoforge.common.world.ModifiableBiomeInfo;
import java.util.ArrayList;
import java.util.List;

public final class BabySpawnBiomeModifier implements BiomeModifier {
    public static final BabySpawnBiomeModifier INSTANCE = new BabySpawnBiomeModifier();
    private static final MapCodec<BabySpawnBiomeModifier> CODEC = MapCodec.unit(INSTANCE);
    private static final double GROUP_FRACTION = 0.5D;

    private BabySpawnBiomeModifier() {
    }

    public static MapCodec<BabySpawnBiomeModifier> makeCodec() {
        return CODEC;
    }

    @Override
    public void modify(Holder<Biome> biome, Phase phase, ModifiableBiomeInfo.BiomeInfo.Builder builder) {
        if (phase != Phase.AFTER_EVERYTHING) {
            return;
        }
        MobSpawnSettingsBuilder settings = builder.getMobSpawnSettings();
        for (BabySpawn spawn : BabySpawn.ALL) {
            MaoConfig.Variant variant = MaoConfig.variant(spawn.id());
            if (variant == null || !variant.enabled().get()) {
                continue;
            }
            EntityType<?> adult = spawn.adult().get();
            EntityType<?> baby = spawn.baby().get();
            double weightFraction = variant.weight().get();
            for (MobCategory category : MobCategory.values()) {
                List<MobSpawnSettings.SpawnerData> existing = new ArrayList<>(settings.getSpawner(category));
                for (MobSpawnSettings.SpawnerData data : existing) {
                    if (data.type != adult) {
                        continue;
                    }
                    int weight = Mth.ceil(data.getWeight().asInt() * weightFraction);
                    if (weight <= 0) {
                        continue;
                    }
                    int min = Math.max(1, Mth.ceil(data.minCount * GROUP_FRACTION));
                    int max = Math.max(min, Mth.ceil(data.maxCount * GROUP_FRACTION));
                    settings.addSpawn(category, new MobSpawnSettings.SpawnerData(baby, weight, min, max));
                    MobSpawnSettings.MobSpawnCost cost = settings.getCost(adult);
                    if (cost != null) {
                        settings.addMobCharge(baby, cost.charge(), cost.energyBudget());
                    }
                }
            }
        }
    }

    @Override
    public MapCodec<? extends BiomeModifier> codec() {
        return CODEC;
    }
}
