package com.mekanismadditionsoverhaul.spider.client;

import com.mekanismadditionsoverhaul.client.MaoClient;
import com.mekanismadditionsoverhaul.spider.SpiderModule;

public final class SpiderClient {
    private SpiderClient() {
    }

    public static void init() {
        MaoClient.add(event -> {
            event.registerEntityRenderer(SpiderModule.BABY_SPIDER.get(), BabySpiderRenderer::new);
            event.registerEntityRenderer(SpiderModule.BABY_CAVE_SPIDER.get(), BabyCaveSpiderRenderer::new);
        });
    }
}
