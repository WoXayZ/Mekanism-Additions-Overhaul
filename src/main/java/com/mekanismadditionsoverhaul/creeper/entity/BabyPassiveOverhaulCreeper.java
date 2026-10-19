package com.mekanismadditionsoverhaul.creeper.entity;

import com.mekanismadditionsoverhaul.BabyBodies;
import com.mekanismadditionsoverhaul.creeper.BabyCreeperExplosion;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.level.Level;
import tech.thatgravyboat.creeperoverhaul.common.entity.base.CreeperType;
import tech.thatgravyboat.creeperoverhaul.common.entity.base.NeutralCreeper;
import tech.thatgravyboat.creeperoverhaul.common.entity.base.PassiveCreeper;

public class BabyPassiveOverhaulCreeper extends PassiveCreeper {
    public BabyPassiveOverhaulCreeper(EntityType<? extends NeutralCreeper> type, Level level, CreeperType creeperType) {
        super(type, level, creeperType);
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

    @Override
    public void explode() {
        this.dead = true;
        BabyCreeperExplosion.explode(this);
    }
}
