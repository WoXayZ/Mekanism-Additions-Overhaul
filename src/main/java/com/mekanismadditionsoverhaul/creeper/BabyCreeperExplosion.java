package com.mekanismadditionsoverhaul.creeper;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.AreaEffectCloud;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import tech.thatgravyboat.creeperoverhaul.common.entity.base.BaseCreeper;
import tech.thatgravyboat.creeperoverhaul.common.utils.PlatformUtils;

import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;

public final class BabyCreeperExplosion {
    private BabyCreeperExplosion() {
    }

    public static void explode(BaseCreeper creeper) {
        Level level = creeper.level();
        if (level.isClientSide()) {
            return;
        }
        float radius = 1.5F * (creeper.isPowered() ? 2.0F : 1.0F);
        Level.ExplosionInteraction interaction = PlatformUtils.getInteractionForCreeper(creeper);
        Explosion explosion = level.explode(creeper, creeper.getX(), creeper.getY(), creeper.getZ(), radius, interaction);
        creeper.type.getExplosionSound(creeper).ifPresent(sound -> level.playSound(
                null,
                creeper,
                sound,
                SoundSource.BLOCKS,
                4.0F,
                (1.0F + (level.random.nextFloat() - level.random.nextFloat()) * 0.2F) * 0.7F));
        creeper.discard();
        explosion.getHitPlayers().keySet().forEach(player -> creeper.type.inflictingPotions().stream()
                .map(MobEffectInstance::new)
                .forEach(player::addEffect));
        replaceBlocks(creeper, level, explosion);
        summonCloud(creeper, level);
    }

    private static void replaceBlocks(BaseCreeper creeper, Level level, Explosion explosion) {
        if (creeper.type.replacer().isEmpty()) {
            return;
        }
        for (BlockPos pos : explosion.getToBlow()) {
            BlockPos below = pos.below();
            BlockState state = level.getBlockState(below);
            for (Map.Entry<Predicate<BlockState>, Function<net.minecraft.util.RandomSource, BlockState>> entry : creeper.type.replacer().entrySet()) {
                if (!entry.getKey().test(state)) {
                    continue;
                }
                BlockState next = entry.getValue().apply(creeper.getRandom());
                if (next != null) {
                    level.setBlock(below, next, 3);
                }
                break;
            }
        }
    }

    private static void summonCloud(BaseCreeper creeper, Level level) {
        if (!(level instanceof ServerLevel)) {
            return;
        }
        var effects = java.util.stream.Stream.concat(
                creeper.getActiveEffects().stream().map(MobEffectInstance::new),
                creeper.type.potionsWhenDead().stream().map(MobEffectInstance::new)
        ).toList();
        if (effects.isEmpty()) {
            return;
        }
        AreaEffectCloud cloud = new AreaEffectCloud(level, creeper.getX(), creeper.getY(), creeper.getZ());
        cloud.setRadius(2.5F);
        cloud.setRadiusOnUse(-0.5F);
        cloud.setWaitTime(10);
        cloud.setDuration(cloud.getDuration() / 2);
        cloud.setRadiusPerTick(-cloud.getRadius() / (float) cloud.getDuration());
        effects.forEach(cloud::addEffect);
        level.addFreshEntity(cloud);
    }
}
