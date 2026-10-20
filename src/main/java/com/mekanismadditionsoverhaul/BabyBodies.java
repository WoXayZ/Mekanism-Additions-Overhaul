package com.mekanismadditionsoverhaul;

import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;

import java.util.UUID;

public final class BabyBodies {
    private static final UUID SPEED_ID = UUID.fromString("8c2c0c8e-6c3a-4d1e-9b1a-7c0e5a1b2d01");
    private static final UUID HEALTH_ID = UUID.fromString("2f6a9c10-1b44-4e7a-9d33-0a5c8e7b6f12");
    private static final UUID ATTACK_ID = UUID.fromString("b1e4d7a2-5c88-4f09-a6d1-3e9c0b7a4f55");

    private BabyBodies() {
    }

    public static void prepare(Mob mob) {
        if (mob.level().isClientSide()) {
            return;
        }
        add(mob, Attributes.MOVEMENT_SPEED, SPEED_ID, -0.5D, AttributeModifier.Operation.MULTIPLY_BASE);
        add(mob, Attributes.MAX_HEALTH, HEALTH_ID, -0.5D, AttributeModifier.Operation.MULTIPLY_TOTAL);
        add(mob, Attributes.ATTACK_DAMAGE, ATTACK_ID, -0.75D, AttributeModifier.Operation.MULTIPLY_TOTAL);
        mob.setHealth(mob.getMaxHealth());
    }

    private static void add(Mob mob, Attribute attribute, UUID id, double amount, AttributeModifier.Operation operation) {
        AttributeInstance instance = mob.getAttribute(attribute);
        if (instance == null || instance.getModifier(id) != null) {
            return;
        }
        instance.addTransientModifier(new AttributeModifier(id, "mekanismadditionsoverhaul:baby", amount, operation));
    }
}
