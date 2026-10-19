package com.mekanismadditionsoverhaul.enderman.entity;

import com.mekanismadditionsoverhaul.BabyBodies;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.monster.EnderMan;
import net.minecraft.world.level.Level;
import tech.alexnijjar.endermanoverhaul.common.entities.DarkOakEnderman;

public class BabyDarkOakEnderman extends DarkOakEnderman {
    public BabyDarkOakEnderman(EntityType<? extends EnderMan> type, Level level) {
        super(type, level);
        this.xpReward = (int) (this.xpReward * 2.5D);
        BabyBodies.prepare(this);
    }

    @Override
    public boolean isBaby() {
        return true;
    }

    @Override
    public float getAgeScale() {
        return 1.0F;
    }

    @Override
    public EntityDimensions getDefaultDimensions(Pose pose) {
        return this.getType().getDimensions();
    }
}
