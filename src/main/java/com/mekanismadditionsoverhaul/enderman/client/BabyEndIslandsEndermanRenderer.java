package com.mekanismadditionsoverhaul.enderman.client;

import com.mekanismadditionsoverhaul.BabyScales;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import tech.alexnijjar.endermanoverhaul.client.renderer.EndIslandsEndermanRenderer;

public class BabyEndIslandsEndermanRenderer extends EndIslandsEndermanRenderer {
    public BabyEndIslandsEndermanRenderer(EntityRendererProvider.Context context) {
        super(context);
        this.withScale(BabyScales.ENDERMAN);
        this.shadowRadius *= BabyScales.ENDERMAN;
    }
}
