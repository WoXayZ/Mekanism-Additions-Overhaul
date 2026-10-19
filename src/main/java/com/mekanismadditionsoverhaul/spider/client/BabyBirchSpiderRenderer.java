package com.mekanismadditionsoverhaul.spider.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mekanismadditionsoverhaul.BabyScales;
import dev.chybx.spideroverhaul.client.render.BirchSpiderRenderer;
import dev.chybx.spideroverhaul.entity.BirchSpiderEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

public class BabyBirchSpiderRenderer extends BirchSpiderRenderer {
    public BabyBirchSpiderRenderer(EntityRendererProvider.Context context) {
        super(context);
        this.shadowRadius *= BabyScales.SPIDER;
    }

    @Override
    protected void scale(BirchSpiderEntity entity, PoseStack poseStack, float partialTick) {
        poseStack.scale(BabyScales.SPIDER, BabyScales.SPIDER, BabyScales.SPIDER);
    }
}
