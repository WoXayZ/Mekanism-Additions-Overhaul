package com.mekanismadditionsoverhaul.enderman.client;

import com.mekanismadditionsoverhaul.BabyScales;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import tech.alexnijjar.endermanoverhaul.client.renderer.base.BaseEndermanEntityRenderer;
import tech.alexnijjar.endermanoverhaul.common.entities.base.BaseEnderman;

public class BabyEndermanRenderer<T extends BaseEnderman> extends BaseEndermanEntityRenderer<T> {
    public BabyEndermanRenderer(EntityRendererProvider.Context context, EntityType<?> adult) {
        super(context, adult);
        this.scaleDown();
    }

    public BabyEndermanRenderer(EntityRendererProvider.Context context, EntityType<?> adult, ResourceLocation animation) {
        super(context, adult, animation);
        this.scaleDown();
    }

    public BabyEndermanRenderer(EntityRendererProvider.Context context, EntityType<?> adult, ResourceLocation animation, boolean turnsHead) {
        super(context, adult, animation, turnsHead);
        this.scaleDown();
    }

    private void scaleDown() {
        this.withScale(BabyScales.ENDERMAN);
        this.shadowRadius *= BabyScales.ENDERMAN;
    }
}
