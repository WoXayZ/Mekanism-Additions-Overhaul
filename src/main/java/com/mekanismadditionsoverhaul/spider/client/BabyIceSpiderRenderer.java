package com.mekanismadditionsoverhaul.spider.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mekanismadditionsoverhaul.BabyScales;
import dev.chybx.spideroverhaul.client.render.IceSpiderRenderer;
import dev.chybx.spideroverhaul.entity.IceSpiderEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

public class BabyIceSpiderRenderer extends IceSpiderRenderer {
    public BabyIceSpiderRenderer(EntityRendererProvider.Context context) {
        super(context);
        this.shadowRadius *= BabyScales.SPIDER;
    }

    @Override
    protected void scale(IceSpiderEntity entity, PoseStack poseStack, float partialTick) {
        poseStack.scale(BabyScales.SPIDER, BabyScales.SPIDER, BabyScales.SPIDER);
    }
}
