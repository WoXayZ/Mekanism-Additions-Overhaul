package com.mekanismadditionsoverhaul.spider.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mekanismadditionsoverhaul.BabyScales;
import dev.chybx.spideroverhaul.client.render.SavannaSpiderRenderer;
import dev.chybx.spideroverhaul.entity.SavannaSpiderEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

public class BabySavannaSpiderRenderer extends SavannaSpiderRenderer {
    public BabySavannaSpiderRenderer(EntityRendererProvider.Context context) {
        super(context);
        this.shadowRadius *= BabyScales.SPIDER;
    }

    @Override
    protected void scale(SavannaSpiderEntity entity, PoseStack poseStack, float partialTick) {
        poseStack.scale(BabyScales.SPIDER, BabyScales.SPIDER, BabyScales.SPIDER);
    }
}
