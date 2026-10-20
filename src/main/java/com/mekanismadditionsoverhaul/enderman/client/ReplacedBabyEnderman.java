package com.mekanismadditionsoverhaul.enderman.client;

import mekanism.additions.common.entity.baby.EntityBabyEnderman;
import mekanism.additions.common.registries.AdditionsEntityTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import software.bernie.geckolib.animatable.GeoReplacedEntity;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;
import tech.alexnijjar.endermanoverhaul.common.constants.ConstantAnimations;

public class ReplacedBabyEnderman implements GeoReplacedEntity {
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

    @Override
    public EntityType<?> getReplacingEntityType() {
        return AdditionsEntityTypes.BABY_ENDERMAN.get();
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(new AnimationController<>(this, 0, this::move));
        controllers.add(new AnimationController<>(this, "creepy_controller", 5, this::creepy));
        controllers.add(new AnimationController<>(this, "hold_controller", 5, this::hold));
        controllers.add(new AnimationController<>(this, "attack_controller", 5, this::attack));
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.cache;
    }

    private EntityBabyEnderman enderman(AnimationState<ReplacedBabyEnderman> state) {
        Entity entity = state.getData(DataTickets.ENTITY);
        return entity instanceof EntityBabyEnderman baby ? baby : null;
    }

    private PlayState move(AnimationState<ReplacedBabyEnderman> state) {
        EntityBabyEnderman enderman = this.enderman(state);
        if (enderman == null) {
            return PlayState.STOP;
        }
        double swing = state.getLimbSwingAmount();
        boolean stepping = swing > 0.01D || swing < -0.01D;
        if (state.isMoving() || stepping) {
            state.getController().setAnimation(enderman.isCreepy() ? ConstantAnimations.RUN : ConstantAnimations.WALK);
            state.setControllerSpeed(enderman.isCreepy() ? 3.0F : 2.0F);
        } else {
            state.getController().setAnimation(ConstantAnimations.IDLE);
            state.setControllerSpeed(1.0F);
        }
        return PlayState.CONTINUE;
    }

    private PlayState creepy(AnimationState<ReplacedBabyEnderman> state) {
        EntityBabyEnderman enderman = this.enderman(state);
        if (enderman == null || !enderman.isCreepy()) {
            return PlayState.STOP;
        }
        state.getController().setAnimation(ConstantAnimations.ANGRY);
        return PlayState.CONTINUE;
    }

    private PlayState hold(AnimationState<ReplacedBabyEnderman> state) {
        EntityBabyEnderman enderman = this.enderman(state);
        if (enderman == null || enderman.getCarriedBlock() == null) {
            return PlayState.STOP;
        }
        state.getController().setAnimation(ConstantAnimations.HOLDING);
        return PlayState.CONTINUE;
    }

    private PlayState attack(AnimationState<ReplacedBabyEnderman> state) {
        EntityBabyEnderman enderman = this.enderman(state);
        if (enderman == null || enderman.getAttackAnim(state.getPartialTick()) == 0.0F) {
            return PlayState.STOP;
        }
        state.getController().setAnimation(ConstantAnimations.ATTACK);
        return PlayState.CONTINUE;
    }
}
