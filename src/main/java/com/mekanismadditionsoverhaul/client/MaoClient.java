package com.mekanismadditionsoverhaul.client;

import com.mekanismadditionsoverhaul.MaoConstants;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

@EventBusSubscriber(modid = MaoConstants.MOD_ID, value = Dist.CLIENT, bus = EventBusSubscriber.Bus.MOD)
public final class MaoClient {
    public static final List<Consumer<EntityRenderersEvent.RegisterRenderers>> RENDERERS = new ArrayList<>();

    private MaoClient() {
    }

    public static void add(Consumer<EntityRenderersEvent.RegisterRenderers> renderer) {
        RENDERERS.add(renderer);
    }

    @SubscribeEvent
    public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
        RENDERERS.forEach(renderer -> renderer.accept(event));
    }
}
