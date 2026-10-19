package com.mekanismadditionsoverhaul.spider.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mekanismadditionsoverhaul.BabyScales;
import net.minecraft.client.renderer.entity.CaveSpiderRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.world.entity.monster.CaveSpider;

public class BabyCaveSpiderRenderer extends CaveSpiderRenderer {
    public BabyCaveSpiderRenderer(EntityRendererProvider.Context context) {
        super(context);
        this.shadowRadius *= BabyScales.SPIDER;
    }

    @Override
    protected void scale(CaveSpider entity, PoseStack poseStack, float partialTick) {
        super.scale(entity, poseStack, partialTick);
        poseStack.scale(BabyScales.SPIDER, BabyScales.SPIDER, BabyScales.SPIDER);
    }
}
