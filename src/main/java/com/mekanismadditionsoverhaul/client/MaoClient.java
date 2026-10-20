package com.mekanismadditionsoverhaul.client;

import com.mekanismadditionsoverhaul.MaoConstants;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

@Mod.EventBusSubscriber(modid = MaoConstants.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public final class MaoClient {
    public static final List<Consumer<EntityRenderersEvent.RegisterRenderers>> EARLY = new ArrayList<>();
    public static final List<Consumer<EntityRenderersEvent.RegisterRenderers>> RENDERERS = new ArrayList<>();

    private MaoClient() {
    }

    public static void addEarly(Consumer<EntityRenderersEvent.RegisterRenderers> renderer) {
        EARLY.add(renderer);
    }

    public static void add(Consumer<EntityRenderersEvent.RegisterRenderers> renderer) {
        RENDERERS.add(renderer);
    }

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public static void registerEarly(EntityRenderersEvent.RegisterRenderers event) {
        EARLY.forEach(renderer -> renderer.accept(event));
    }

    @SubscribeEvent
    public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
        RENDERERS.forEach(renderer -> renderer.accept(event));
    }
}
