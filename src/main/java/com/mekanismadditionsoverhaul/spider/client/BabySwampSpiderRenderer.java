package com.mekanismadditionsoverhaul.spider.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mekanismadditionsoverhaul.BabyScales;
import dev.chybx.spideroverhaul.client.render.SwampSpiderRenderer;
import dev.chybx.spideroverhaul.entity.SwampSpiderEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

public class BabySwampSpiderRenderer extends SwampSpiderRenderer {
    public BabySwampSpiderRenderer(EntityRendererProvider.Context context) {
        super(context);
        this.shadowRadius *= BabyScales.SPIDER;
    }

    @Override
    protected void scale(SwampSpiderEntity entity, PoseStack poseStack, float partialTick) {
        poseStack.scale(BabyScales.SPIDER, BabyScales.SPIDER, BabyScales.SPIDER);
    }
}
