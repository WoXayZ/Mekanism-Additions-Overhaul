package com.mekanismadditionsoverhaul.spider.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mekanismadditionsoverhaul.BabyScales;
import dev.chybx.spideroverhaul.client.render.JungleSpiderRenderer;
import dev.chybx.spideroverhaul.entity.JungleSpiderEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

public class BabyJungleSpiderRenderer extends JungleSpiderRenderer {
    public BabyJungleSpiderRenderer(EntityRendererProvider.Context context) {
        super(context);
        this.shadowRadius *= BabyScales.SPIDER;
    }

    @Override
    protected void scale(JungleSpiderEntity entity, PoseStack poseStack, float partialTick) {
        poseStack.scale(BabyScales.SPIDER, BabyScales.SPIDER, BabyScales.SPIDER);
    }
}
