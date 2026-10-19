package com.mekanismadditionsoverhaul.creeper.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import mekanism.additions.common.entity.baby.EntityBabyCreeper;
import com.mekanismadditionsoverhaul.BabyScales;
import com.mekanismadditionsoverhaul.creeper.PlainsBabyCreeper;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.monster.Creeper;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.GeoReplacedEntityRenderer;
import tech.thatgravyboat.creeperoverhaul.client.RenderTypes;
import tech.thatgravyboat.creeperoverhaul.common.utils.PlatformUtils;

public class PlainsBabyCreeperRenderer extends GeoReplacedEntityRenderer<EntityBabyCreeper, PlainsBabyCreeper> {
    private static final ResourceLocation GLOW = ResourceLocation.fromNamespaceAndPath("creeperoverhaul", "textures/entity/plains/plains_creeper_glow.png");
    private static final ResourceLocation CHARGED = ResourceLocation.fromNamespaceAndPath("creeperoverhaul", "textures/entity/armor/creeper_armor.png");

    public PlainsBabyCreeperRenderer(EntityRendererProvider.Context context) {
        super(context, new PlainsBabyCreeperModel(), new PlainsBabyCreeper());
        this.withScale(BabyScales.CREEPER);
        this.shadowRadius *= BabyScales.CREEPER;
        this.addRenderLayer(new Glow(this));
        this.addRenderLayer(new Power(this));
    }

    @Override
    public void preRender(PoseStack stack, PlainsBabyCreeper animatable, BakedGeoModel model, MultiBufferSource bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, int color) {
        super.preRender(stack, animatable, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, color);
        float swell = this.currentCreeper().getSwelling(partialTick);
        float pulse = 1.0F + Mth.sin(swell * 100.0F) * swell * 0.01F;
        swell = Mth.clamp(swell, 0.0F, 1.0F);
        swell = swell * swell * swell * swell;
        float horizontal = (1.0F + swell * 0.4F) * pulse;
        float vertical = (1.0F + swell * 0.1F) / pulse;
        stack.scale(horizontal, vertical, horizontal);
    }

    @Override
    public int getPackedOverlay(PlainsBabyCreeper animatable, float u, float partialTick) {
        return super.getPackedOverlay(animatable, swellOverlay(this.currentCreeper(), partialTick), partialTick);
    }

    private Creeper currentCreeper() {
        return this.getCurrentEntity();
    }

    private static float swellOverlay(Creeper creeper, float partialTick) {
        float swell = creeper.getSwelling(partialTick);
        return (int) (swell * 10.0F) % 2 == 0 ? 0.0F : Mth.clamp(swell, 0.5F, 1.0F);
    }

    private static final class Glow extends software.bernie.geckolib.renderer.layer.GeoRenderLayer<PlainsBabyCreeper> {
        private final PlainsBabyCreeperRenderer renderer;

        private Glow(PlainsBabyCreeperRenderer renderer) {
            super(renderer);
            this.renderer = renderer;
        }

        @Override
        public void render(PoseStack poseStack, PlainsBabyCreeper animatable, BakedGeoModel bakedModel, RenderType renderType, MultiBufferSource bufferSource, VertexConsumer buffer, float partialTick, int packedLight, int packedOverlay) {
            Creeper creeper = this.renderer.getCurrentEntity();
            float swell = creeper.getSwelling(partialTick);
            if (swell <= 0.0F && !creeper.isPowered()) {
                return;
            }
            if (creeper.isPowered()) {
                swell = 1.0F;
            }
            RenderType eyes = RenderTypes.getTransparentEyes(GLOW);
            VertexConsumer consumer = bufferSource.getBuffer(eyes);
            int color = 0xFFFFFF | (int) (swell * 240.0F) << 24;
            this.getRenderer().reRender(this.getDefaultBakedModel(animatable), poseStack, bufferSource, animatable, eyes, consumer, partialTick, packedLight, OverlayTexture.NO_OVERLAY, color);
        }
    }

    private static final class Power extends software.bernie.geckolib.renderer.layer.GeoRenderLayer<PlainsBabyCreeper> {
        private final PlainsBabyCreeperRenderer renderer;

        private Power(PlainsBabyCreeperRenderer renderer) {
            super(renderer);
            this.renderer = renderer;
        }

        @Override
        public void render(PoseStack poseStack, PlainsBabyCreeper animatable, BakedGeoModel bakedModel, RenderType renderType, MultiBufferSource bufferSource, VertexConsumer buffer, float partialTick, int packedLight, int packedOverlay) {
            if (PlatformUtils.shouldHidePowerLayer() || !this.renderer.getCurrentEntity().isPowered()) {
                return;
            }
            float age = this.renderer.getCurrentEntity().tickCount + partialTick;
            RenderType swirl = RenderTypes.getSwirl(CHARGED, age * 0.005F % 1.0F, age * 0.005F % 1.0F);
            VertexConsumer consumer = bufferSource.getBuffer(swirl);
            this.getRenderer().reRender(this.getDefaultBakedModel(animatable), poseStack, bufferSource, animatable, swirl, consumer, partialTick, packedLight, OverlayTexture.NO_OVERLAY, -1);
        }
    }
}
