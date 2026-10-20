package com.mekanismadditionsoverhaul.enderman.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import mekanism.additions.common.entity.baby.EntityBabyEnderman;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.monster.EnderMan;
import net.minecraft.world.phys.Vec3;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.renderer.GeoReplacedEntityRenderer;
import tech.alexnijjar.endermanoverhaul.client.renderer.ReplacedEndermanRenderer;
import tech.alexnijjar.endermanoverhaul.client.renderer.base.BaseEndermanEntityRenderer;
import tech.alexnijjar.endermanoverhaul.client.renderer.base.BaseEndermanModel;
import tech.alexnijjar.endermanoverhaul.client.renderer.base.CustomCarriedBlockLayer;
import tech.alexnijjar.endermanoverhaul.client.renderer.base.CustomEnderEyesLayer;

public class ReplacedBabyEndermanRenderer extends GeoReplacedEntityRenderer<EntityBabyEnderman, ReplacedBabyEnderman> {
    public ReplacedBabyEndermanRenderer(EntityRendererProvider.Context context) {
        super(context, new BaseEndermanModel<>(
                new ResourceLocation("endermanoverhaul", "default_enderman"),
                true,
                ReplacedEndermanRenderer.TEXTURE,
                BaseEndermanEntityRenderer.ANIMATION
        ), new ReplacedBabyEnderman());
        this.addRenderLayer(new CustomEnderEyesLayer<>(this, ReplacedEndermanRenderer.GLOW));
        this.addRenderLayer(new CustomCarriedBlockLayer<>(this, context.getBlockRenderDispatcher(), this::currentEnderman));
    }

    private EnderMan currentEnderman() {
        return this.getCurrentEntity();
    }

    @Override
    public void actuallyRender(PoseStack stack, ReplacedBabyEnderman animatable, BakedGeoModel model, RenderType renderType, MultiBufferSource bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        stack.pushPose();
        stack.scale(0.5F, 0.5F, 0.5F);
        super.actuallyRender(stack, animatable, model, renderType, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, red, green, blue, alpha);
        stack.popPose();
    }

    @Override
    public void renderRecursively(PoseStack stack, ReplacedBabyEnderman animatable, GeoBone bone, RenderType renderType, MultiBufferSource bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        boolean head = "head".equals(bone.getName());
        if (head) {
            stack.pushPose();
            stack.translate(0.0D, -1.25D, 0.0D);
            stack.scale(1.5F, 1.5F, 1.5F);
        }
        super.renderRecursively(stack, animatable, bone, renderType, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, red, green, blue, alpha);
        if (head) {
            stack.popPose();
        }
    }

    @Override
    public Vec3 getRenderOffset(EntityBabyEnderman enderman, float partialTick) {
        if (enderman.isCreepy()) {
            var level = enderman.level();
            return new Vec3(level.random.nextGaussian() * 0.02D, 0.0D, level.random.nextGaussian() * 0.02D);
        }
        return super.getRenderOffset(enderman, partialTick);
    }
}
