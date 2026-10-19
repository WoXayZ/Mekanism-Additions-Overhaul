package com.mekanismadditionsoverhaul.spider.client;

import com.mekanismadditionsoverhaul.client.MaoClient;
import com.mekanismadditionsoverhaul.spider.SpiderOverhaulModule;

public final class SpiderOverhaulClient {
    private SpiderOverhaulClient() {
    }

    public static void init() {
        MaoClient.add(event -> {
            event.registerEntityRenderer(SpiderOverhaulModule.BABY_DESERT_SPIDER.get(), BabyDesertSpiderRenderer::new);
            event.registerEntityRenderer(SpiderOverhaulModule.BABY_ICE_SPIDER.get(), BabyIceSpiderRenderer::new);
            event.registerEntityRenderer(SpiderOverhaulModule.BABY_JUNGLE_SPIDER.get(), BabyJungleSpiderRenderer::new);
            event.registerEntityRenderer(SpiderOverhaulModule.BABY_SCULK_SPIDER.get(), BabySculkSpiderRenderer::new);
            event.registerEntityRenderer(SpiderOverhaulModule.BABY_MUSHROOM_SPIDER.get(), BabyMushroomSpiderRenderer::new);
            event.registerEntityRenderer(SpiderOverhaulModule.BABY_CAVERN_SPIDER.get(), BabyCavernSpiderRenderer::new);
            event.registerEntityRenderer(SpiderOverhaulModule.BABY_OCEAN_SPIDER.get(), BabyOceanSpiderRenderer::new);
            event.registerEntityRenderer(SpiderOverhaulModule.BABY_TAIGA_SPIDER.get(), BabyTaigaSpiderRenderer::new);
            event.registerEntityRenderer(SpiderOverhaulModule.BABY_BIRCH_SPIDER.get(), BabyBirchSpiderRenderer::new);
            event.registerEntityRenderer(SpiderOverhaulModule.BABY_SAVANNA_SPIDER.get(), BabySavannaSpiderRenderer::new);
            event.registerEntityRenderer(SpiderOverhaulModule.BABY_SWAMP_SPIDER.get(), BabySwampSpiderRenderer::new);
        });
    }
}
