package com.mekanismadditionsoverhaul.spider.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mekanismadditionsoverhaul.BabyScales;
import dev.chybx.spideroverhaul.client.render.CavernSpiderRenderer;
import dev.chybx.spideroverhaul.entity.CavernSpiderEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

public class BabyCavernSpiderRenderer extends CavernSpiderRenderer {
    public BabyCavernSpiderRenderer(EntityRendererProvider.Context context) {
        super(context);
        this.shadowRadius *= BabyScales.SPIDER;
    }

    @Override
    protected void scale(CavernSpiderEntity entity, PoseStack poseStack, float partialTick) {
        poseStack.scale(BabyScales.SPIDER, BabyScales.SPIDER, BabyScales.SPIDER);
    }
}
