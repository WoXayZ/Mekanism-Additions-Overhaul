package com.mekanismadditionsoverhaul.creeper.client;

import com.mekanismadditionsoverhaul.client.MaoClient;
import com.mekanismadditionsoverhaul.client.RendererReplacements;
import com.mekanismadditionsoverhaul.creeper.CreeperModule;
import mekanism.additions.common.registries.AdditionsEntityTypes;
import tech.thatgravyboat.creeperoverhaul.common.entity.CreeperTypes;
import tech.thatgravyboat.creeperoverhaul.common.entity.base.BaseCreeper;
import tech.thatgravyboat.creeperoverhaul.common.entity.base.CreeperType;

public final class CreeperClient {
    private CreeperClient() {
    }

    public static void init() {
        MaoClient.addEarly(event -> RendererReplacements.put(AdditionsEntityTypes.BABY_CREEPER.get(), PlainsBabyCreeperRenderer::new));
        MaoClient.add(event -> {
            register(event, CreeperModule.JUNGLE.get(), CreeperTypes.JUNGLE);
            register(event, CreeperModule.BAMBOO.get(), CreeperTypes.BAMBOO);
            register(event, CreeperModule.DESERT.get(), CreeperTypes.DESERT);
            register(event, CreeperModule.BADLANDS.get(), CreeperTypes.BADLANDS);
            register(event, CreeperModule.HILLS.get(), CreeperTypes.HILLS);
            register(event, CreeperModule.SAVANNAH.get(), CreeperTypes.SAVANNAH);
            register(event, CreeperModule.MUSHROOM.get(), CreeperTypes.MUSHROOM);
            register(event, CreeperModule.SWAMP.get(), CreeperTypes.SWAMP);
            register(event, CreeperModule.DRIPSTONE.get(), CreeperTypes.DRIPSTONE);
            register(event, CreeperModule.CAVE.get(), CreeperTypes.CAVE);
            register(event, CreeperModule.DARK_OAK.get(), CreeperTypes.DARK_OAK);
            register(event, CreeperModule.SPRUCE.get(), CreeperTypes.SPRUCE);
            register(event, CreeperModule.BEACH.get(), CreeperTypes.BEACH);
            register(event, CreeperModule.SNOWY.get(), CreeperTypes.SNOWY);
            register(event, CreeperModule.OCEAN.get(), CreeperTypes.OCEAN);
        });
    }

    private static <E extends BaseCreeper> void register(net.minecraftforge.client.event.EntityRenderersEvent.RegisterRenderers event, net.minecraft.world.entity.EntityType<E> type, CreeperType creeperType) {
        event.registerEntityRenderer(type, context -> new BabyCreeperRenderer<>(context, creeperType));
    }
}
