package com.mekanismadditionsoverhaul.spider.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mekanismadditionsoverhaul.BabyScales;
import dev.chybx.spideroverhaul.client.render.MushroomSpiderRenderer;
import dev.chybx.spideroverhaul.entity.MushroomSpiderEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

public class BabyMushroomSpiderRenderer extends MushroomSpiderRenderer {
    public BabyMushroomSpiderRenderer(EntityRendererProvider.Context context) {
        super(context);
        this.shadowRadius *= BabyScales.SPIDER;
    }

    @Override
    protected void scale(MushroomSpiderEntity entity, PoseStack poseStack, float partialTick) {
        poseStack.scale(BabyScales.SPIDER, BabyScales.SPIDER, BabyScales.SPIDER);
    }
}
