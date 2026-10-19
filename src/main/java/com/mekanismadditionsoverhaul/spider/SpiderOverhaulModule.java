package com.mekanismadditionsoverhaul.spider;

import com.mekanismadditionsoverhaul.BabyScales;
import com.mekanismadditionsoverhaul.ModuleHooks;
import com.mekanismadditionsoverhaul.ModuleLoader;
import com.mekanismadditionsoverhaul.config.MaoConfig;
import com.mekanismadditionsoverhaul.registry.EntityBuilders;
import com.mekanismadditionsoverhaul.registry.MaoRegistries;
import com.mekanismadditionsoverhaul.spawn.BabySpawn;
import com.mekanismadditionsoverhaul.spider.entity.BabyDesertSpiderEntity;
import com.mekanismadditionsoverhaul.spider.entity.BabyIceSpiderEntity;
import com.mekanismadditionsoverhaul.spider.entity.BabyJungleSpiderEntity;
import com.mekanismadditionsoverhaul.spider.entity.BabySculkSpiderEntity;
import com.mekanismadditionsoverhaul.spider.entity.BabyMushroomSpiderEntity;
import com.mekanismadditionsoverhaul.spider.entity.BabyCavernSpiderEntity;
import com.mekanismadditionsoverhaul.spider.entity.BabyOceanSpiderEntity;
import com.mekanismadditionsoverhaul.spider.entity.BabyTaigaSpiderEntity;
import com.mekanismadditionsoverhaul.spider.entity.BabyBirchSpiderEntity;
import com.mekanismadditionsoverhaul.spider.entity.BabySavannaSpiderEntity;
import com.mekanismadditionsoverhaul.spider.entity.BabySwampSpiderEntity;
import dev.chybx.spideroverhaul.entity.DesertSpiderEntity;
import dev.chybx.spideroverhaul.entity.IceSpiderEntity;
import dev.chybx.spideroverhaul.entity.JungleSpiderEntity;
import dev.chybx.spideroverhaul.entity.SculkSpiderEntity;
import dev.chybx.spideroverhaul.entity.MushroomSpiderEntity;
import dev.chybx.spideroverhaul.entity.CavernSpiderEntity;
import dev.chybx.spideroverhaul.entity.OceanSpiderEntity;
import dev.chybx.spideroverhaul.entity.TaigaSpiderEntity;
import dev.chybx.spideroverhaul.entity.BirchSpiderEntity;
import dev.chybx.spideroverhaul.entity.SavannaSpiderEntity;
import dev.chybx.spideroverhaul.entity.SwampSpiderEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.SpawnPlacementTypes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Spider;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraft.world.level.levelgen.Heightmap;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.neoforged.neoforge.event.entity.RegisterSpawnPlacementsEvent;
import net.neoforged.neoforge.registries.DeferredHolder;

import java.util.function.Supplier;

public final class SpiderOverhaulModule {
    public static final DeferredHolder<EntityType<?>, EntityType<BabyDesertSpiderEntity>> BABY_DESERT_SPIDER = register("desert", BabyDesertSpiderEntity::new, dev.chybx.spideroverhaul.registry.ModEntities.DESERT_SPIDER, 13808780, 9127187);
    public static final DeferredHolder<EntityType<?>, EntityType<BabyIceSpiderEntity>> BABY_ICE_SPIDER = register("ice", BabyIceSpiderEntity::new, dev.chybx.spideroverhaul.registry.ModEntities.ICE_SPIDER, 5591652, 11980794);
    public static final DeferredHolder<EntityType<?>, EntityType<BabyJungleSpiderEntity>> BABY_JUNGLE_SPIDER = register("jungle", BabyJungleSpiderEntity::new, dev.chybx.spideroverhaul.registry.ModEntities.JUNGLE_SPIDER, 2263842, 25600);
    public static final DeferredHolder<EntityType<?>, EntityType<BabySculkSpiderEntity>> BABY_SCULK_SPIDER = register("sculk", BabySculkSpiderEntity::new, dev.chybx.spideroverhaul.registry.ModEntities.SCULK_SPIDER, 1710618, 52945);
    public static final DeferredHolder<EntityType<?>, EntityType<BabyMushroomSpiderEntity>> BABY_MUSHROOM_SPIDER = register("mushroom", BabyMushroomSpiderEntity::new, dev.chybx.spideroverhaul.registry.ModEntities.MUSHROOM_SPIDER, 16737095, 9127187);
    public static final DeferredHolder<EntityType<?>, EntityType<BabyCavernSpiderEntity>> BABY_CAVERN_SPIDER = register("cavern", BabyCavernSpiderEntity::new, dev.chybx.spideroverhaul.registry.ModEntities.CAVERN_SPIDER, 10181046, 15259125);
    public static final DeferredHolder<EntityType<?>, EntityType<BabyOceanSpiderEntity>> BABY_OCEAN_SPIDER = register("ocean", BabyOceanSpiderEntity::new, dev.chybx.spideroverhaul.registry.ModEntities.OCEAN_SPIDER, 2003199, 139);
    public static final DeferredHolder<EntityType<?>, EntityType<BabyTaigaSpiderEntity>> BABY_TAIGA_SPIDER = register("taiga", BabyTaigaSpiderEntity::new, dev.chybx.spideroverhaul.registry.ModEntities.TAIGA_SPIDER, 2263842, 16777215);
    public static final DeferredHolder<EntityType<?>, EntityType<BabyBirchSpiderEntity>> BABY_BIRCH_SPIDER = register("birch", BabyBirchSpiderEntity::new, dev.chybx.spideroverhaul.registry.ModEntities.BIRCH_SPIDER, 16119260, 3100495);
    public static final DeferredHolder<EntityType<?>, EntityType<BabySavannaSpiderEntity>> BABY_SAVANNA_SPIDER = register("savanna", BabySavannaSpiderEntity::new, dev.chybx.spideroverhaul.registry.ModEntities.SAVANNA_SPIDER, 14329120, 9127187);
    public static final DeferredHolder<EntityType<?>, EntityType<BabySwampSpiderEntity>> BABY_SWAMP_SPIDER = register("swamp", BabySwampSpiderEntity::new, dev.chybx.spideroverhaul.registry.ModEntities.SWAMP_SPIDER, 5597999, 3100463);

    private SpiderOverhaulModule() {
    }

    public static void init() {
        ModuleHooks.ATTRIBUTES.add(SpiderOverhaulModule::attributes);
        ModuleHooks.SPAWNS.add(SpiderOverhaulModule::spawns);
        ModuleLoader.loadClient("com.mekanismadditionsoverhaul.spider.client.SpiderOverhaulClient");
    }

    private static void attributes(EntityAttributeCreationEvent event) {
        event.put(BABY_DESERT_SPIDER.get(), DesertSpiderEntity.createDesertSpiderAttributes().build());
        event.put(BABY_ICE_SPIDER.get(), IceSpiderEntity.createIceSpiderAttributes().build());
        event.put(BABY_JUNGLE_SPIDER.get(), JungleSpiderEntity.createJungleSpiderAttributes().build());
        event.put(BABY_SCULK_SPIDER.get(), SculkSpiderEntity.createSculkSpiderAttributes().build());
        event.put(BABY_MUSHROOM_SPIDER.get(), MushroomSpiderEntity.createMushroomSpiderAttributes().build());
        event.put(BABY_CAVERN_SPIDER.get(), CavernSpiderEntity.createCavernSpiderAttributes().build());
        event.put(BABY_OCEAN_SPIDER.get(), OceanSpiderEntity.createOceanSpiderAttributes().build());
        event.put(BABY_TAIGA_SPIDER.get(), TaigaSpiderEntity.createTaigaSpiderAttributes().build());
        event.put(BABY_BIRCH_SPIDER.get(), BirchSpiderEntity.createBirchSpiderAttributes().build());
        event.put(BABY_SAVANNA_SPIDER.get(), SavannaSpiderEntity.createSavannaSpiderAttributes().build());
        event.put(BABY_SWAMP_SPIDER.get(), SwampSpiderEntity.createSwampSpiderAttributes().build());
    }

    private static void spawns(RegisterSpawnPlacementsEvent event) {
        event.register(BABY_DESERT_SPIDER.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);
        event.register(BABY_ICE_SPIDER.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);
        event.register(BABY_JUNGLE_SPIDER.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);
        event.register(BABY_SCULK_SPIDER.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);
        event.register(BABY_MUSHROOM_SPIDER.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);
        event.register(BABY_CAVERN_SPIDER.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (type, level, reason, pos, random) -> CavernSpiderEntity.canSpawn((EntityType) type, level, reason, pos, random), RegisterSpawnPlacementsEvent.Operation.REPLACE);
        event.register(BABY_OCEAN_SPIDER.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);
        event.register(BABY_TAIGA_SPIDER.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);
        event.register(BABY_BIRCH_SPIDER.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);
        event.register(BABY_SAVANNA_SPIDER.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);
        event.register(BABY_SWAMP_SPIDER.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);
    }

    private static <T extends Spider> DeferredHolder<EntityType<?>, EntityType<T>> register(
            String name,
            EntityType.EntityFactory<T> factory,
            Supplier<? extends EntityType<?>> adult,
            int primary,
            int secondary
    ) {
        String id = "baby_" + name + "_spider";
        DeferredHolder<EntityType<?>, EntityType<T>> holder = MaoRegistries.ENTITIES.register(id, () -> EntityBuilders.baby(factory, adult.get(), BabyScales.SPIDER).build(id));
        MaoConfig.define(id);
        BabySpawn.register(id, holder, adult);
        MaoRegistries.ITEMS.register(id + "_spawn_egg", () -> new SpawnEggItem(holder.get(), primary, secondary, new Item.Properties()));
        return holder;
    }
}
