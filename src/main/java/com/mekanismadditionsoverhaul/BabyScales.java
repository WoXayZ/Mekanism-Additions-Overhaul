package com.mekanismadditionsoverhaul;

public final class BabyScales {
    /**
     * Under the vanilla cave spider, which renders the spider model at 0.7.
     * Mekanism's generic baby factor of 0.5625 stays close enough to be mistaken for one.
     */
    public static final float SPIDER = 0.42F;
    /** {@code AdditionsEntityTypes} baby creeper factor. */
    public static final float CREEPER = 0.625F;
    /** {@code AdditionsEntityTypes} baby enderman factor. */
    public static final float ENDERMAN = 0.525F;
    /** Mekanism baby attack modifier is -0.75 added to the total, so melee that bypasses the attribute uses this. */
    public static final float ATTACK_TOTAL = 0.25F;

    private BabyScales() {
    }
}
