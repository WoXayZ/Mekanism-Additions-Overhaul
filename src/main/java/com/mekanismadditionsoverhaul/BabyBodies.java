package com.mekanismadditionsoverhaul;

import mekanism.additions.common.registries.AdditionsEntityTypes;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.Pose;

public final class BabyBodies {
    private BabyBodies() {
    }

    public static void prepare(Mob mob) {
        AdditionsEntityTypes.setupBabyModifiers(mob);
        mob.setHealth(mob.getMaxHealth());
    }

    public static EntityDimensions dimensions(LivingEntity entity, Pose pose) {
        return entity.getType().getDimensions();
    }
}
