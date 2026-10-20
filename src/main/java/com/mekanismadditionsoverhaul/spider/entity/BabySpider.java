package com.mekanismadditionsoverhaul.spider.entity;

import com.mekanismadditionsoverhaul.BabyBodies;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.monster.Spider;
import net.minecraft.world.level.Level;

public class BabySpider extends Spider {
    public BabySpider(EntityType<? extends Spider> type, Level level) {
        super(type, level);
        this.xpReward = (int) (this.xpReward * 2.5D);
        BabyBodies.prepare(this);
    }

    @Override
    public boolean isBaby() {
        return true;
    }


}
