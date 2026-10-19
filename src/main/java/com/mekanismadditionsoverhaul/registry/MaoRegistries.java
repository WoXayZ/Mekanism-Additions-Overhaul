package com.mekanismadditionsoverhaul.registry;

import com.mojang.serialization.MapCodec;
import com.mekanismadditionsoverhaul.MaoConstants;
import com.mekanismadditionsoverhaul.spawn.BabySpawnBiomeModifier;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.CreativeModeTab;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.world.BiomeModifier;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

public final class MaoRegistries {
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(Registries.ENTITY_TYPE, MaoConstants.MOD_ID);
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MaoConstants.MOD_ID);
    public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MaoConstants.MOD_ID);
    public static final DeferredRegister<MapCodec<? extends BiomeModifier>> BIOME_MODIFIERS =
            DeferredRegister.create(NeoForgeRegistries.Keys.BIOME_MODIFIER_SERIALIZERS, MaoConstants.MOD_ID);

    static {
        BIOME_MODIFIERS.register("baby_spawns", BabySpawnBiomeModifier::makeCodec);
    }

    private MaoRegistries() {
    }

    public static void register(IEventBus modBus) {
        ENTITIES.register(modBus);
        ITEMS.register(modBus);
        TABS.register(modBus);
        BIOME_MODIFIERS.register(modBus);
        MaoCreativeTabs.register();
    }
}
