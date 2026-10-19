package com.mekanismadditionsoverhaul.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import mekanism.additions.client.AdditionsClientRegistration;
import mekanism.additions.common.entity.baby.EntityBabyCreeper;
import mekanism.additions.common.registries.AdditionsEntityTypes;
import com.mekanismadditionsoverhaul.creeper.client.PlainsBabyCreeperRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.world.entity.EntityType;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(AdditionsClientRegistration.class)
public class AdditionsClientRegistrationMixin {
    @WrapOperation(
            method = "registerRenderers",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/neoforged/neoforge/client/event/EntityRenderersEvent$RegisterRenderers;registerEntityRenderer(Lnet/minecraft/world/entity/EntityType;Lnet/minecraft/client/renderer/entity/EntityRendererProvider;)V"
            )
    )
    private static void mekanismadditionsoverhaul$plainsBabyCreeper(
            EntityRenderersEvent.RegisterRenderers event,
            EntityType<?> type,
            EntityRendererProvider<?> provider,
            Operation<Void> original
    ) {
        if (type == AdditionsEntityTypes.BABY_CREEPER.get()) {
            original.call(event, type, (EntityRendererProvider<EntityBabyCreeper>) PlainsBabyCreeperRenderer::new);
            return;
        }
        original.call(event, type, provider);
    }
}
