package com.mekanismadditionsoverhaul.spider.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mekanismadditionsoverhaul.BabyScales;
import dev.chybx.spideroverhaul.client.render.OceanSpiderRenderer;
import dev.chybx.spideroverhaul.entity.OceanSpiderEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

public class BabyOceanSpiderRenderer extends OceanSpiderRenderer {
    public BabyOceanSpiderRenderer(EntityRendererProvider.Context context) {
        super(context);
        this.shadowRadius *= BabyScales.SPIDER;
    }

    @Override
    protected void scale(OceanSpiderEntity entity, PoseStack poseStack, float partialTick) {
        poseStack.scale(BabyScales.SPIDER, BabyScales.SPIDER, BabyScales.SPIDER);
    }
}
