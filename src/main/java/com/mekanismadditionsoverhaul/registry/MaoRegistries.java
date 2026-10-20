package com.mekanismadditionsoverhaul.registry;

import com.mojang.serialization.Codec;
import com.mekanismadditionsoverhaul.MaoConstants;
import com.mekanismadditionsoverhaul.spawn.BabySpawnBiomeModifier;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public final class MaoRegistries {
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, MaoConstants.MOD_ID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MaoConstants.MOD_ID);
    public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MaoConstants.MOD_ID);
    public static final DeferredRegister<Codec<? extends BiomeModifier>> BIOME_MODIFIERS =
            DeferredRegister.create(ForgeRegistries.Keys.BIOME_MODIFIER_SERIALIZERS, MaoConstants.MOD_ID);

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
