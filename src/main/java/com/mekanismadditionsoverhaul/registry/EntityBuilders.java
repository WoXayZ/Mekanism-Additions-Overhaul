package com.mekanismadditionsoverhaul.registry;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;

public final class EntityBuilders {
    private EntityBuilders() {
    }

    public static <T extends Entity> EntityType.Builder<T> baby(EntityType.EntityFactory<T> factory, EntityType<?> adult, float scale) {
        EntityType.Builder<T> builder = EntityType.Builder.of(factory, adult.getCategory());
        if (!adult.canSerialize()) {
            builder.noSave();
        }
        if (!adult.canSummon()) {
            builder.noSummon();
        }
        if (adult.fireImmune()) {
            builder.fireImmune();
        }
        if (adult.canSpawnFarFromPlayer()) {
            builder.canSpawnFarFromPlayer();
        }
        EntityDimensions dimensions = adult.getDimensions();
        return builder
                .sized(dimensions.width * scale, dimensions.height * scale)
                .clientTrackingRange(adult.clientTrackingRange())
                .updateInterval(adult.updateInterval());
    }
}
