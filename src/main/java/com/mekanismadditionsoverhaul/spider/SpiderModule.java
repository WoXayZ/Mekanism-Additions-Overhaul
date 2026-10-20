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
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.monster.CaveSpider;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Spider;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.entity.SpawnPlacementRegisterEvent;
import net.minecraftforge.registries.RegistryObject;

public final class SpiderModule {
    public static final RegistryObject<EntityType<BabySpider>> BABY_SPIDER = MaoRegistries.ENTITIES.register("baby_spider", () -> EntityBuilders.baby(BabySpider::new, EntityType.SPIDER, BabyScales.SPIDER).build("baby_spider"));
    public static final RegistryObject<EntityType<BabyCaveSpider>> BABY_CAVE_SPIDER = MaoRegistries.ENTITIES.register("baby_cave_spider", () -> EntityBuilders.baby(BabyCaveSpider::new, EntityType.CAVE_SPIDER, BabyScales.SPIDER).build("baby_cave_spider"));
    public static final RegistryObject<ForgeSpawnEggItem> BABY_SPIDER_SPAWN_EGG = MaoRegistries.ITEMS.register("baby_spider_spawn_egg", () -> new ForgeSpawnEggItem(BABY_SPIDER::get, 3419431, 11013646, new Item.Properties()));
    public static final RegistryObject<ForgeSpawnEggItem> BABY_CAVE_SPIDER_SPAWN_EGG = MaoRegistries.ITEMS.register("baby_cave_spider_spawn_egg", () -> new ForgeSpawnEggItem(BABY_CAVE_SPIDER::get, 803406, 11013646, new Item.Properties()));

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

    private static void spawns(SpawnPlacementRegisterEvent event) {
        event.register(BABY_SPIDER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, SpawnPlacementRegisterEvent.Operation.REPLACE);
        event.register(BABY_CAVE_SPIDER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, SpawnPlacementRegisterEvent.Operation.REPLACE);
    }
}
