package com.mekanismadditionsoverhaul;

import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.entity.SpawnPlacementRegisterEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public final class ModuleHooks {
    public static final List<Consumer<EntityAttributeCreationEvent>> ATTRIBUTES = new ArrayList<>();
    public static final List<Consumer<SpawnPlacementRegisterEvent>> SPAWNS = new ArrayList<>();

    private ModuleHooks() {
    }
}
