package com.mekanismadditionsoverhaul.creeper.entity;

import com.mekanismadditionsoverhaul.BabyBodies;
import com.mekanismadditionsoverhaul.BabyScales;
import com.mekanismadditionsoverhaul.creeper.BabyCreeperExplosion;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.level.Level;
import tech.thatgravyboat.creeperoverhaul.common.entity.base.CreeperType;
import tech.thatgravyboat.creeperoverhaul.common.entity.custom.PufferfishCreeper;

public class BabyOceanCreeper extends PufferfishCreeper {
    public BabyOceanCreeper(EntityType<? extends PufferfishCreeper> type, Level level, CreeperType creeperType) {
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
        return super.getDefaultDimensions(pose).scale(BabyScales.CREEPER);
    }

    @Override
    public void explode() {
        this.dead = true;
        BabyCreeperExplosion.explode(this);
    }

    @Override
    public boolean doHurtTarget(Entity entity) {
        byte state = this.getPuffState();
        float damage = (6.0F + state) * (this.isPowered() ? 2.0F : 1.0F) * BabyScales.ATTACK_TOTAL;
        if (entity.hurt(this.level().damageSources().mobAttack(this), damage)) {
            this.playSound(SoundEvents.PUFFER_FISH_STING, 1.0F, 1.0F);
            if (entity instanceof LivingEntity living && state > 0) {
                living.addEffect(new MobEffectInstance(MobEffects.POISON, 60 * state, 0));
            }
            return true;
        }
        return false;
    }
}
