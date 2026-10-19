package com.mekanismadditionsoverhaul.enderman.client;

import com.mekanismadditionsoverhaul.BabyScales;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import tech.alexnijjar.endermanoverhaul.client.renderer.MushroomFieldsEndermanRenderer;

public class BabyMushroomFieldsEndermanRenderer extends MushroomFieldsEndermanRenderer {
    public BabyMushroomFieldsEndermanRenderer(EntityRendererProvider.Context context) {
        super(context);
        this.withScale(BabyScales.ENDERMAN);
        this.shadowRadius *= BabyScales.ENDERMAN;
    }
}
