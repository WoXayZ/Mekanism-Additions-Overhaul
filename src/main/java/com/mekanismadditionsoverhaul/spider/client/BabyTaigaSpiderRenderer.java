package com.mekanismadditionsoverhaul.spider.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mekanismadditionsoverhaul.BabyScales;
import dev.chybx.spideroverhaul.client.render.TaigaSpiderRenderer;
import dev.chybx.spideroverhaul.entity.TaigaSpiderEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

public class BabyTaigaSpiderRenderer extends TaigaSpiderRenderer {
    public BabyTaigaSpiderRenderer(EntityRendererProvider.Context context) {
        super(context);
        this.shadowRadius *= BabyScales.SPIDER;
    }

    @Override
    protected void scale(TaigaSpiderEntity entity, PoseStack poseStack, float partialTick) {
        poseStack.scale(BabyScales.SPIDER, BabyScales.SPIDER, BabyScales.SPIDER);
    }
}
