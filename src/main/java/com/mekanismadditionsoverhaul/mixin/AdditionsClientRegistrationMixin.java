package com.mekanismadditionsoverhaul.mixin;

import mekanism.additions.client.AdditionsClientRegistration;
import com.mekanismadditionsoverhaul.client.RendererReplacements;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.world.entity.EntityType;
import net.minecraftforge.client.event.EntityRenderersEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(AdditionsClientRegistration.class)
public class AdditionsClientRegistrationMixin {
    @Redirect(
            method = "registerRenderers",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraftforge/client/event/EntityRenderersEvent$RegisterRenderers;registerEntityRenderer(Lnet/minecraft/world/entity/EntityType;Lnet/minecraft/client/renderer/entity/EntityRendererProvider;)V"
            )
    )
    @SuppressWarnings({"unchecked", "rawtypes"})
    private static void mekanismadditionsoverhaul$replaceBaby(
            EntityRenderersEvent.RegisterRenderers event,
            EntityType<?> type,
            EntityRendererProvider<?> provider
    ) {
        EntityRendererProvider<?> replacement = RendererReplacements.get(type);
        event.registerEntityRenderer((EntityType) type, (EntityRendererProvider) (replacement != null ? replacement : provider));
    }
}
