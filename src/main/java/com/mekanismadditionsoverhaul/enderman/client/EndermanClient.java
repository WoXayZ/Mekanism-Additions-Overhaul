package com.mekanismadditionsoverhaul.enderman.client;

import com.mekanismadditionsoverhaul.client.MaoClient;
import com.mekanismadditionsoverhaul.client.RendererReplacements;
import com.mekanismadditionsoverhaul.enderman.EndermanModule;
import mekanism.additions.common.registries.AdditionsEntityTypes;
import tech.alexnijjar.endermanoverhaul.client.renderer.base.BaseEndermanEntityRenderer;
import tech.alexnijjar.endermanoverhaul.common.registry.ModEntityTypes;

public final class EndermanClient {
    private EndermanClient() {
    }

    public static void init() {
        MaoClient.addEarly(event -> RendererReplacements.put(AdditionsEntityTypes.BABY_ENDERMAN.get(), ReplacedBabyEndermanRenderer::new));
        MaoClient.add(event -> {
            event.registerEntityRenderer(EndermanModule.BABY_BADLANDS_ENDERMAN.get(), context -> new BabyEndermanRenderer<>(context, ModEntityTypes.BADLANDS_ENDERMAN.get()));
            event.registerEntityRenderer(EndermanModule.BABY_CAVE_ENDERMAN.get(), context -> new BabyEndermanRenderer<>(context, ModEntityTypes.CAVE_ENDERMAN.get()));
            event.registerEntityRenderer(EndermanModule.BABY_CRIMSON_FOREST_ENDERMAN.get(), context -> new BabyEndermanRenderer<>(context, ModEntityTypes.CRIMSON_FOREST_ENDERMAN.get()));
            event.registerEntityRenderer(EndermanModule.BABY_DARK_OAK_ENDERMAN.get(), context -> new BabyEndermanRenderer<>(context, ModEntityTypes.DARK_OAK_ENDERMAN.get(), BaseEndermanEntityRenderer.DARK_OAK_ANIMATION));
            event.registerEntityRenderer(EndermanModule.BABY_DESERT_ENDERMAN.get(), context -> new BabyEndermanRenderer<>(context, ModEntityTypes.DESERT_ENDERMAN.get(), BaseEndermanEntityRenderer.DESERT_ANIMATION));
            event.registerEntityRenderer(EndermanModule.BABY_END_ENDERMAN.get(), context -> new BabyEndermanRenderer<>(context, ModEntityTypes.END_ENDERMAN.get(), BaseEndermanEntityRenderer.END_ANIMATION, false));
            event.registerEntityRenderer(EndermanModule.BABY_END_ISLANDS_ENDERMAN.get(), BabyEndIslandsEndermanRenderer::new);
            event.registerEntityRenderer(EndermanModule.BABY_FLOWER_FIELDS_ENDERMAN.get(), context -> new BabyEndermanRenderer<>(context, ModEntityTypes.FLOWER_FIELDS_ENDERMAN.get(), BaseEndermanEntityRenderer.FLOWER_FIELDS_ANIMATION));
            event.registerEntityRenderer(EndermanModule.BABY_ICE_SPIKES_ENDERMAN.get(), context -> new BabyEndermanRenderer<>(context, ModEntityTypes.ICE_SPIKES_ENDERMAN.get(), BaseEndermanEntityRenderer.ICE_SPIKES_ANIMATION));
            event.registerEntityRenderer(EndermanModule.BABY_MUSHROOM_FIELDS_ENDERMAN.get(), BabyMushroomFieldsEndermanRenderer::new);
            event.registerEntityRenderer(EndermanModule.BABY_NETHER_WASTES_ENDERMAN.get(), context -> new BabyEndermanRenderer<>(context, ModEntityTypes.NETHER_WASTES_ENDERMAN.get()));
            event.registerEntityRenderer(EndermanModule.BABY_CORAL_ENDERMAN.get(), context -> new BabyEndermanRenderer<>(context, ModEntityTypes.CORAL_ENDERMAN.get(), BaseEndermanEntityRenderer.CORAL_ANIMATION));
            event.registerEntityRenderer(EndermanModule.BABY_SAVANNA_ENDERMAN.get(), context -> new BabyEndermanRenderer<>(context, ModEntityTypes.SAVANNA_ENDERMAN.get()));
            event.registerEntityRenderer(EndermanModule.BABY_SNOWY_ENDERMAN.get(), context -> new BabyEndermanRenderer<>(context, ModEntityTypes.SNOWY_ENDERMAN.get(), BaseEndermanEntityRenderer.SNOWY_ANIMATION));
            event.registerEntityRenderer(EndermanModule.BABY_SOULSAND_VALLEY_ENDERMAN.get(), context -> new BabyEndermanRenderer<>(context, ModEntityTypes.SOULSAND_VALLEY_ENDERMAN.get(), BaseEndermanEntityRenderer.SOULSAND_VALLEY_ANIMATION, false));
            event.registerEntityRenderer(EndermanModule.BABY_SWAMP_ENDERMAN.get(), context -> new BabyEndermanRenderer<>(context, ModEntityTypes.SWAMP_ENDERMAN.get()));
            event.registerEntityRenderer(EndermanModule.BABY_WARPED_FOREST_ENDERMAN.get(), context -> new BabyEndermanRenderer<>(context, ModEntityTypes.WARPED_FOREST_ENDERMAN.get(), BaseEndermanEntityRenderer.WARPED_FOREST_ANIMATION));
            event.registerEntityRenderer(EndermanModule.BABY_WINDSWEPT_HILLS_ENDERMAN.get(), context -> new BabyEndermanRenderer<>(context, ModEntityTypes.WINDSWEPT_HILLS_ENDERMAN.get(), BaseEndermanEntityRenderer.WINDSWEPT_HILLS_ANIMATION));
        });
    }
}
