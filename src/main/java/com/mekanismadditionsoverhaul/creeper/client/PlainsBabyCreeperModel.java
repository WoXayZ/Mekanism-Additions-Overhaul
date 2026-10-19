package com.mekanismadditionsoverhaul.creeper.client;

import com.mekanismadditionsoverhaul.creeper.PlainsBabyCreeper;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class PlainsBabyCreeperModel extends GeoModel<PlainsBabyCreeper> {
    private static final ResourceLocation MODEL = ResourceLocation.fromNamespaceAndPath("creeperoverhaul", "geo/plains.geo.json");
    private static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath("creeperoverhaul", "textures/entity/plains/plains_creeper.png");
    private static final ResourceLocation ANIMATION = ResourceLocation.fromNamespaceAndPath("creeperoverhaul", "animations/creeper.animation.json");

    @Override
    public ResourceLocation getModelResource(PlainsBabyCreeper animatable) {
        return MODEL;
    }

    @Override
    public ResourceLocation getTextureResource(PlainsBabyCreeper animatable) {
        return TEXTURE;
    }

    @Override
    public ResourceLocation getAnimationResource(PlainsBabyCreeper animatable) {
        return ANIMATION;
    }
}
