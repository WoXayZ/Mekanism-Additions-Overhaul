package com.mekanismadditionsoverhaul.spider.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mekanismadditionsoverhaul.BabyScales;
import dev.chybx.spideroverhaul.client.render.DesertSpiderRenderer;
import dev.chybx.spideroverhaul.entity.DesertSpiderEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

public class BabyDesertSpiderRenderer extends DesertSpiderRenderer {
    public BabyDesertSpiderRenderer(EntityRendererProvider.Context context) {
        super(context);
        this.shadowRadius *= BabyScales.SPIDER;
    }

    @Override
    protected void scale(DesertSpiderEntity entity, PoseStack poseStack, float partialTick) {
        poseStack.scale(BabyScales.SPIDER, BabyScales.SPIDER, BabyScales.SPIDER);
    }
}
