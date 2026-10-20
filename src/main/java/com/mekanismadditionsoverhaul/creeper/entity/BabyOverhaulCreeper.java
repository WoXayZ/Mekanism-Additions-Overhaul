package com.mekanismadditionsoverhaul.creeper.entity;

import com.mekanismadditionsoverhaul.BabyBodies;
import com.mekanismadditionsoverhaul.creeper.BabyCreeperExplosion;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.level.Level;
import tech.thatgravyboat.creeperoverhaul.common.entity.base.BaseCreeper;
import tech.thatgravyboat.creeperoverhaul.common.entity.base.CreeperType;

public class BabyOverhaulCreeper extends BaseCreeper {
    public BabyOverhaulCreeper(EntityType<? extends Creeper> type, Level level, CreeperType creeperType) {
        super(type, level, creeperType);
        this.xpReward = (int) (this.xpReward * 2.5D);
        BabyBodies.prepare(this);
    }

    @Override
    public boolean isBaby() {
        return true;
    }



    @Override
    public void explode() {
        this.dead = true;
        BabyCreeperExplosion.explode(this);
    }
}
