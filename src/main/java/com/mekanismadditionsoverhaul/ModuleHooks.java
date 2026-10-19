package com.mekanismadditionsoverhaul;

import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.neoforged.neoforge.event.entity.RegisterSpawnPlacementsEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public final class ModuleHooks {
    public static final List<Consumer<EntityAttributeCreationEvent>> ATTRIBUTES = new ArrayList<>();
    public static final List<Consumer<RegisterSpawnPlacementsEvent>> SPAWNS = new ArrayList<>();

    private ModuleHooks() {
    }
}
