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
        builder.setShouldReceiveVelocityUpdates(adult.trackDeltas());
        EntityDimensions dimensions = adult.getDimensions().scale(scale);
        return builder
                .sized(dimensions.width(), dimensions.height())
                .eyeHeight(dimensions.height() * 0.83F)
                .clientTrackingRange(adult.clientTrackingRange())
                .updateInterval(adult.updateInterval());
    }
}
