package com.mekanismadditionsoverhaul.client;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;

import java.util.HashMap;
import java.util.Map;

public final class RendererReplacements {
    private static final Map<EntityType<?>, EntityRendererProvider<?>> REPLACEMENTS = new HashMap<>();

    private RendererReplacements() {
    }

    public static <T extends Entity> void put(EntityType<T> type, EntityRendererProvider<T> provider) {
        REPLACEMENTS.put(type, provider);
    }

    public static EntityRendererProvider<?> get(EntityType<?> type) {
        return REPLACEMENTS.get(type);
    }
}
