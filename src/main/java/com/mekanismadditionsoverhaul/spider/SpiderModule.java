package com.mekanismadditionsoverhaul.spider;

import com.mekanismadditionsoverhaul.BabyScales;
import com.mekanismadditionsoverhaul.ModuleHooks;
import com.mekanismadditionsoverhaul.ModuleLoader;
import com.mekanismadditionsoverhaul.config.MaoConfig;
import com.mekanismadditionsoverhaul.registry.EntityBuilders;
import com.mekanismadditionsoverhaul.registry.MaoRegistries;
import com.mekanismadditionsoverhaul.spawn.BabySpawn;
import com.mekanismadditionsoverhaul.spider.entity.BabyCaveSpider;
import com.mekanismadditionsoverhaul.spider.entity.BabySpider;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.SpawnPlacementTypes;
import net.minecraft.world.entity.monster.CaveSpider;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Spider;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraft.world.level.levelgen.Heightmap;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.neoforged.neoforge.event.entity.RegisterSpawnPlacementsEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;

public final class SpiderModule {
    public static final DeferredHolder<EntityType<?>, EntityType<BabySpider>> BABY_SPIDER = MaoRegistries.ENTITIES.register("baby_spider", () -> EntityBuilders.baby(BabySpider::new, EntityType.SPIDER, BabyScales.SPIDER).build("baby_spider"));
    public static final DeferredHolder<EntityType<?>, EntityType<BabyCaveSpider>> BABY_CAVE_SPIDER = MaoRegistries.ENTITIES.register("baby_cave_spider", () -> EntityBuilders.baby(BabyCaveSpider::new, EntityType.CAVE_SPIDER, BabyScales.SPIDER).build("baby_cave_spider"));
    public static final DeferredItem<SpawnEggItem> BABY_SPIDER_SPAWN_EGG = MaoRegistries.ITEMS.register("baby_spider_spawn_egg", () -> new SpawnEggItem(BABY_SPIDER.get(), 3419431, 11013646, new Item.Properties()));
    public static final DeferredItem<SpawnEggItem> BABY_CAVE_SPIDER_SPAWN_EGG = MaoRegistries.ITEMS.register("baby_cave_spider_spawn_egg", () -> new SpawnEggItem(BABY_CAVE_SPIDER.get(), 803406, 11013646, new Item.Properties()));

    private SpiderModule() {
    }

    public static void init() {
        MaoConfig.define("baby_spider");
        MaoConfig.define("baby_cave_spider");
        BabySpawn.register("baby_spider", BABY_SPIDER, () -> EntityType.SPIDER);
        BabySpawn.register("baby_cave_spider", BABY_CAVE_SPIDER, () -> EntityType.CAVE_SPIDER);
        ModuleHooks.ATTRIBUTES.add(SpiderModule::attributes);
        ModuleHooks.SPAWNS.add(SpiderModule::spawns);
        ModuleLoader.loadClient("com.mekanismadditionsoverhaul.spider.client.SpiderClient");
    }

    private static void attributes(EntityAttributeCreationEvent event) {
        event.put(BABY_SPIDER.get(), Spider.createAttributes().build());
        event.put(BABY_CAVE_SPIDER.get(), CaveSpider.createAttributes().build());
    }

    private static void spawns(RegisterSpawnPlacementsEvent event) {
        event.register(BABY_SPIDER.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);
        event.register(BABY_CAVE_SPIDER.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);
    }
}
