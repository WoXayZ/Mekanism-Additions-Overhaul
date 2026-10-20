package com.mekanismadditionsoverhaul.creeper;

import com.mekanismadditionsoverhaul.BabyScales;
import com.mekanismadditionsoverhaul.ModuleHooks;
import com.mekanismadditionsoverhaul.ModuleLoader;
import com.mekanismadditionsoverhaul.config.MaoConfig;
import com.mekanismadditionsoverhaul.creeper.entity.BabyNeutralOverhaulCreeper;
import com.mekanismadditionsoverhaul.creeper.entity.BabyOceanCreeper;
import com.mekanismadditionsoverhaul.creeper.entity.BabyOverhaulCreeper;
import com.mekanismadditionsoverhaul.creeper.entity.BabyPassiveOverhaulCreeper;
import com.mekanismadditionsoverhaul.registry.EntityBuilders;
import com.mekanismadditionsoverhaul.registry.MaoRegistries;
import com.mekanismadditionsoverhaul.spawn.BabySpawn;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.entity.SpawnPlacementRegisterEvent;
import net.minecraftforge.registries.RegistryObject;
import tech.thatgravyboat.creeperoverhaul.common.entity.CreeperTypes;
import tech.thatgravyboat.creeperoverhaul.common.entity.base.CreeperType;
import tech.thatgravyboat.creeperoverhaul.common.registry.ModEntities;
import tech.thatgravyboat.creeperoverhaul.common.registry.ModSpawns;

import java.util.function.Supplier;

public final class CreeperModule {
    public static final RegistryObject<EntityType<BabyOverhaulCreeper>> JUNGLE = base("jungle", () -> CreeperTypes.JUNGLE, ModEntities.JUNGLE_CREEPER, 5272897, 5850650);
    public static final RegistryObject<EntityType<BabyNeutralOverhaulCreeper>> BAMBOO = neutral("bamboo", () -> CreeperTypes.BAMBOO, ModEntities.BAMBOO_CREEPER, 5869571, 2044706);
    public static final RegistryObject<EntityType<BabyOverhaulCreeper>> DESERT = base("desert", () -> CreeperTypes.DESERT, ModEntities.DESERT_CREEPER, 13744778, 9858621);
    public static final RegistryObject<EntityType<BabyOverhaulCreeper>> BADLANDS = base("badlands", () -> CreeperTypes.BADLANDS, ModEntities.BADLANDS_CREEPER, 10710091, 15255875);
    public static final RegistryObject<EntityType<BabyNeutralOverhaulCreeper>> HILLS = neutral("hills", () -> CreeperTypes.HILLS, ModEntities.HILLS_CREEPER, 10132360, 5201491);
    public static final RegistryObject<EntityType<BabyNeutralOverhaulCreeper>> SAVANNAH = neutral("savannah", () -> CreeperTypes.SAVANNAH, ModEntities.SAVANNAH_CREEPER, 11361586, 7223849);
    public static final RegistryObject<EntityType<BabyPassiveOverhaulCreeper>> MUSHROOM = passive("mushroom", () -> CreeperTypes.MUSHROOM, ModEntities.MUSHROOM_CREEPER, 6312554, 13720139);
    public static final RegistryObject<EntityType<BabyOverhaulCreeper>> SWAMP = base("swamp", () -> CreeperTypes.SWAMP, ModEntities.SWAMP_CREEPER, 5199925, 1779748);
    public static final RegistryObject<EntityType<BabyOverhaulCreeper>> DRIPSTONE = base("dripstone", () -> CreeperTypes.DRIPSTONE, ModEntities.DRIPSTONE_CREEPER, 8610646, 10521969);
    public static final RegistryObject<EntityType<BabyOverhaulCreeper>> CAVE = base("cave", () -> CreeperTypes.CAVE, ModEntities.CAVE_CREEPER, 8291452, 3817278);
    public static final RegistryObject<EntityType<BabyOverhaulCreeper>> DARK_OAK = base("dark_oak", () -> CreeperTypes.DARK_OAK, ModEntities.DARK_OAK_CREEPER, 4141341, 1971481);
    public static final RegistryObject<EntityType<BabyOverhaulCreeper>> SPRUCE = base("spruce", () -> CreeperTypes.SPRUCE, ModEntities.SPRUCE_CREEPER, 0x888788, 7570770);
    public static final RegistryObject<EntityType<BabyOverhaulCreeper>> BEACH = base("beach", () -> CreeperTypes.BEACH, ModEntities.BEACH_CREEPER, 14338198, 7360058);
    public static final RegistryObject<EntityType<BabyNeutralOverhaulCreeper>> SNOWY = neutral("snowy", () -> CreeperTypes.SNOWY, ModEntities.SNOWY_CREEPER, 12504536, 15268089);
    public static final RegistryObject<EntityType<BabyOceanCreeper>> OCEAN = ocean("ocean", () -> CreeperTypes.OCEAN, ModEntities.OCEAN_CREEPER, 8706206, 15705698);

    private CreeperModule() {
    }

    public static void init() {
        ModuleHooks.ATTRIBUTES.add(CreeperModule::attributes);
        ModuleHooks.SPAWNS.add(CreeperModule::spawns);
        ModuleLoader.loadClient("com.mekanismadditionsoverhaul.creeper.client.CreeperClient");
    }

    private static void attributes(EntityAttributeCreationEvent event) {
        put(event, JUNGLE.get(), CreeperTypes.JUNGLE);
        put(event, BAMBOO.get(), CreeperTypes.BAMBOO);
        put(event, DESERT.get(), CreeperTypes.DESERT);
        put(event, BADLANDS.get(), CreeperTypes.BADLANDS);
        put(event, HILLS.get(), CreeperTypes.HILLS);
        put(event, SAVANNAH.get(), CreeperTypes.SAVANNAH);
        put(event, MUSHROOM.get(), CreeperTypes.MUSHROOM);
        put(event, SWAMP.get(), CreeperTypes.SWAMP);
        put(event, DRIPSTONE.get(), CreeperTypes.DRIPSTONE);
        put(event, CAVE.get(), CreeperTypes.CAVE);
        put(event, DARK_OAK.get(), CreeperTypes.DARK_OAK);
        put(event, SPRUCE.get(), CreeperTypes.SPRUCE);
        put(event, BEACH.get(), CreeperTypes.BEACH);
        put(event, SNOWY.get(), CreeperTypes.SNOWY);
        put(event, OCEAN.get(), CreeperTypes.OCEAN);
    }

    private static void put(EntityAttributeCreationEvent event, EntityType<? extends LivingEntity> type, CreeperType creeperType) {
        event.put(type, creeperType.attributes().build());
    }

    private static void spawns(SpawnPlacementRegisterEvent event) {
        ground(event, JUNGLE.get(), CreeperTypes.JUNGLE, ModSpawns::checkMonsterSpawnRulesAbove, Heightmap.Types.MOTION_BLOCKING);
        ground(event, BAMBOO.get(), CreeperTypes.BAMBOO, ModSpawns::checkDayMonsterSpawnRulesAbove, Heightmap.Types.MOTION_BLOCKING);
        ground(event, DESERT.get(), CreeperTypes.DESERT, ModSpawns::checkMonsterSpawnRulesAbove);
        ground(event, BADLANDS.get(), CreeperTypes.BADLANDS, ModSpawns::checkMonsterSpawnRulesAbove);
        ground(event, HILLS.get(), CreeperTypes.HILLS, ModSpawns::checkMonsterSpawnRulesAbove);
        ground(event, SAVANNAH.get(), CreeperTypes.SAVANNAH, ModSpawns::checkMonsterSpawnRulesAbove);
        ground(event, MUSHROOM.get(), CreeperTypes.MUSHROOM, ModSpawns::checkDayMonsterSpawnRulesAbove);
        ground(event, SWAMP.get(), CreeperTypes.SWAMP, ModSpawns::checkMonsterSpawnRulesAbove);
        ground(event, DRIPSTONE.get(), CreeperTypes.DRIPSTONE, ModSpawns::checkMonsterSpawnRulesCave);
        ground(event, CAVE.get(), CreeperTypes.CAVE, ModSpawns::checkMonsterSpawnRulesCave);
        ground(event, DARK_OAK.get(), CreeperTypes.DARK_OAK, ModSpawns::checkMonsterSpawnRulesAbove);
        ground(event, SPRUCE.get(), CreeperTypes.SPRUCE, ModSpawns::checkMonsterSpawnRulesAbove);
        ground(event, BEACH.get(), CreeperTypes.BEACH, ModSpawns::checkMonsterSpawnRulesAbove);
        ground(event, SNOWY.get(), CreeperTypes.SNOWY, ModSpawns::checkDayMonsterSpawnRulesAbove);
        event.register(OCEAN.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, ModSpawns.getPredicate(CreeperTypes.OCEAN, ModSpawns::checkWaterSpawnRules), SpawnPlacementRegisterEvent.Operation.REPLACE);
    }

    private static <T extends net.minecraft.world.entity.Mob> void ground(
            SpawnPlacementRegisterEvent event,
            EntityType<T> type,
            CreeperType creeperType,
            net.minecraft.world.entity.SpawnPlacements.SpawnPredicate<T> predicate
    ) {
        ground(event, type, creeperType, predicate, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES);
    }

    private static <T extends net.minecraft.world.entity.Mob> void ground(
            SpawnPlacementRegisterEvent event,
            EntityType<T> type,
            CreeperType creeperType,
            net.minecraft.world.entity.SpawnPlacements.SpawnPredicate<T> predicate,
            Heightmap.Types heightmap
    ) {
        event.register(type, SpawnPlacements.Type.ON_GROUND, heightmap, ModSpawns.getPredicate(creeperType, predicate), SpawnPlacementRegisterEvent.Operation.REPLACE);
    }

    private static RegistryObject<EntityType<BabyOverhaulCreeper>> base(String name, Supplier<CreeperType> type, Supplier<? extends EntityType<?>> adult, int primary, int secondary) {
        String id = "baby_" + name + "_creeper";
        EntityType.EntityFactory<BabyOverhaulCreeper> factory = (entityType, level) -> new BabyOverhaulCreeper(entityType, level, type.get());
        RegistryObject<EntityType<BabyOverhaulCreeper>> holder = MaoRegistries.ENTITIES.register(id, () -> EntityBuilders.baby(
                factory,
                adult.get(),
                BabyScales.CREEPER
        ).build(id));
        finish(id, holder, adult, primary, secondary);
        return holder;
    }

    private static RegistryObject<EntityType<BabyNeutralOverhaulCreeper>> neutral(String name, Supplier<CreeperType> type, Supplier<? extends EntityType<?>> adult, int primary, int secondary) {
        String id = "baby_" + name + "_creeper";
        EntityType.EntityFactory<BabyNeutralOverhaulCreeper> factory = (entityType, level) -> new BabyNeutralOverhaulCreeper(entityType, level, type.get());
        RegistryObject<EntityType<BabyNeutralOverhaulCreeper>> holder = MaoRegistries.ENTITIES.register(id, () -> EntityBuilders.baby(
                factory,
                adult.get(),
                BabyScales.CREEPER
        ).build(id));
        finish(id, holder, adult, primary, secondary);
        return holder;
    }

    private static RegistryObject<EntityType<BabyPassiveOverhaulCreeper>> passive(String name, Supplier<CreeperType> type, Supplier<? extends EntityType<?>> adult, int primary, int secondary) {
        String id = "baby_" + name + "_creeper";
        EntityType.EntityFactory<BabyPassiveOverhaulCreeper> factory = (entityType, level) -> new BabyPassiveOverhaulCreeper(entityType, level, type.get());
        RegistryObject<EntityType<BabyPassiveOverhaulCreeper>> holder = MaoRegistries.ENTITIES.register(id, () -> EntityBuilders.baby(
                factory,
                adult.get(),
                BabyScales.CREEPER
        ).build(id));
        finish(id, holder, adult, primary, secondary);
        return holder;
    }

    private static RegistryObject<EntityType<BabyOceanCreeper>> ocean(String name, Supplier<CreeperType> type, Supplier<? extends EntityType<?>> adult, int primary, int secondary) {
        String id = "baby_" + name + "_creeper";
        EntityType.EntityFactory<BabyOceanCreeper> factory = (entityType, level) -> new BabyOceanCreeper(entityType, level, type.get());
        RegistryObject<EntityType<BabyOceanCreeper>> holder = MaoRegistries.ENTITIES.register(id, () -> EntityBuilders.baby(
                factory,
                adult.get(),
                BabyScales.CREEPER
        ).build(id));
        finish(id, holder, adult, primary, secondary);
        return holder;
    }

    @SuppressWarnings("unchecked")
    private static EntityType<? extends net.minecraft.world.entity.Mob> castMob(EntityType<?> type) {
        return (EntityType<? extends net.minecraft.world.entity.Mob>) type;
    }

    private static void finish(String id, Supplier<? extends EntityType<?>> baby, Supplier<? extends EntityType<?>> adult, int primary, int secondary) {
        MaoConfig.define(id);
        BabySpawn.register(id, baby, adult);
        MaoRegistries.ITEMS.register(id + "_spawn_egg", () -> new ForgeSpawnEggItem(() -> castMob(baby.get()), primary, secondary, new net.minecraft.world.item.Item.Properties()));
    }
}
