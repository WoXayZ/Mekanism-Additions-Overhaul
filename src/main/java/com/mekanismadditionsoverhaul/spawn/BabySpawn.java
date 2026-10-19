package com.mekanismadditionsoverhaul.spawn;

import net.minecraft.world.entity.EntityType;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public record BabySpawn(String id, Supplier<? extends EntityType<?>> baby, Supplier<? extends EntityType<?>> adult) {
    public static final List<BabySpawn> ALL = new ArrayList<>();

    public static void register(String id, Supplier<? extends EntityType<?>> baby, Supplier<? extends EntityType<?>> adult) {
        ALL.add(new BabySpawn(id, baby, adult));
    }
}
