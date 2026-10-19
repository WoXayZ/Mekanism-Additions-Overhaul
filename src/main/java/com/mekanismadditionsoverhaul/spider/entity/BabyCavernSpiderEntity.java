package com.mekanismadditionsoverhaul.spider.entity;

import com.mekanismadditionsoverhaul.BabyBodies;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.monster.Spider;
import net.minecraft.world.level.Level;
import dev.chybx.spideroverhaul.entity.CavernSpiderEntity;

public class BabyCavernSpiderEntity extends CavernSpiderEntity {
    public BabyCavernSpiderEntity(EntityType<? extends Spider> type, Level level) {
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
