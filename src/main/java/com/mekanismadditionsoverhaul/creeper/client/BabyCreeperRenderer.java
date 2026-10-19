package com.mekanismadditionsoverhaul.creeper.client;

import com.mekanismadditionsoverhaul.BabyScales;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import tech.thatgravyboat.creeperoverhaul.client.renderer.normal.CreeperModel;
import tech.thatgravyboat.creeperoverhaul.client.renderer.normal.CreeperRenderer;
import tech.thatgravyboat.creeperoverhaul.common.entity.base.BaseCreeper;
import tech.thatgravyboat.creeperoverhaul.common.entity.base.CreeperType;

public class BabyCreeperRenderer<E extends BaseCreeper> extends CreeperRenderer<E> {
    public BabyCreeperRenderer(EntityRendererProvider.Context context, CreeperType type) {
        super(context, new CreeperModel<>(type));
        this.withScale(BabyScales.CREEPER);
        this.shadowRadius *= BabyScales.CREEPER;
    }
}
