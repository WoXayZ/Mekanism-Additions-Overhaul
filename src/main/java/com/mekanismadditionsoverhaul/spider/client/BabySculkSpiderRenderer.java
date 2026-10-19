package com.mekanismadditionsoverhaul.spider.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mekanismadditionsoverhaul.BabyScales;
import dev.chybx.spideroverhaul.client.render.SculkSpiderRenderer;
import dev.chybx.spideroverhaul.entity.SculkSpiderEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

public class BabySculkSpiderRenderer extends SculkSpiderRenderer {
    public BabySculkSpiderRenderer(EntityRendererProvider.Context context) {
        super(context);
        this.shadowRadius *= BabyScales.SPIDER;
    }

    @Override
    protected void scale(SculkSpiderEntity entity, PoseStack poseStack, float partialTick) {
        poseStack.scale(BabyScales.SPIDER, BabyScales.SPIDER, BabyScales.SPIDER);
    }
}
