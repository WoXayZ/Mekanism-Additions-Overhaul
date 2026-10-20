package com.mekanismadditionsoverhaul.enderman;

import com.mekanismadditionsoverhaul.BabyScales;
import com.mekanismadditionsoverhaul.ModuleHooks;
import com.mekanismadditionsoverhaul.ModuleLoader;
import com.mekanismadditionsoverhaul.config.MaoConfig;
import com.mekanismadditionsoverhaul.registry.EntityBuilders;
import com.mekanismadditionsoverhaul.registry.MaoRegistries;
import com.mekanismadditionsoverhaul.spawn.BabySpawn;
import com.mekanismadditionsoverhaul.enderman.entity.BabyBadlandsEnderman;
import com.mekanismadditionsoverhaul.enderman.entity.BabyCaveEnderman;
import com.mekanismadditionsoverhaul.enderman.entity.BabyCrimsonForestEnderman;
import com.mekanismadditionsoverhaul.enderman.entity.BabyDarkOakEnderman;
import com.mekanismadditionsoverhaul.enderman.entity.BabyDesertEnderman;
import com.mekanismadditionsoverhaul.enderman.entity.BabyEndEnderman;
import com.mekanismadditionsoverhaul.enderman.entity.BabyEndIslandsEnderman;
import com.mekanismadditionsoverhaul.enderman.entity.BabyFlowerFieldsEnderman;
import com.mekanismadditionsoverhaul.enderman.entity.BabyIceSpikesEnderman;
import com.mekanismadditionsoverhaul.enderman.entity.BabyMushroomFieldsEnderman;
import com.mekanismadditionsoverhaul.enderman.entity.BabyNetherWastesEnderman;
import com.mekanismadditionsoverhaul.enderman.entity.BabyCoralEnderman;
import com.mekanismadditionsoverhaul.enderman.entity.BabySavannaEnderman;
import com.mekanismadditionsoverhaul.enderman.entity.BabySnowyEnderman;
import com.mekanismadditionsoverhaul.enderman.entity.BabySoulsandValleyEnderman;
import com.mekanismadditionsoverhaul.enderman.entity.BabySwampEnderman;
import com.mekanismadditionsoverhaul.enderman.entity.BabyWarpedForestEnderman;
import com.mekanismadditionsoverhaul.enderman.entity.BabyWindsweptHillsEnderman;
import tech.alexnijjar.endermanoverhaul.common.entities.BadlandsEnderman;
import tech.alexnijjar.endermanoverhaul.common.entities.CaveEnderman;
import tech.alexnijjar.endermanoverhaul.common.entities.CoralEnderman;
import tech.alexnijjar.endermanoverhaul.common.entities.CrimsonForestEnderman;
import tech.alexnijjar.endermanoverhaul.common.entities.DarkOakEnderman;
import tech.alexnijjar.endermanoverhaul.common.entities.DesertEnderman;
import tech.alexnijjar.endermanoverhaul.common.entities.EndEnderman;
import tech.alexnijjar.endermanoverhaul.common.entities.EndIslandsEnderman;
import tech.alexnijjar.endermanoverhaul.common.entities.FlowerFieldsEnderman;
import tech.alexnijjar.endermanoverhaul.common.entities.IceSpikesEnderman;
import tech.alexnijjar.endermanoverhaul.common.entities.MushroomFieldsEnderman;
import tech.alexnijjar.endermanoverhaul.common.entities.NetherWastesEnderman;
import tech.alexnijjar.endermanoverhaul.common.entities.SavannaEnderman;
import tech.alexnijjar.endermanoverhaul.common.entities.SnowyEnderman;
import tech.alexnijjar.endermanoverhaul.common.entities.SoulsandValleyEnderman;
import tech.alexnijjar.endermanoverhaul.common.entities.SwampEnderman;
import tech.alexnijjar.endermanoverhaul.common.entities.WarpedForestEnderman;
import tech.alexnijjar.endermanoverhaul.common.entities.WindsweptHillsEnderman;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.monster.EnderMan;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.entity.SpawnPlacementRegisterEvent;
import net.minecraftforge.registries.RegistryObject;
import com.teamresourceful.resourcefullib.common.registry.RegistryEntry;
import tech.alexnijjar.endermanoverhaul.common.registry.ModEntityTypes;

public final class EndermanModule {
    public static final RegistryObject<EntityType<BabyBadlandsEnderman>> BABY_BADLANDS_ENDERMAN = register("badlands", BabyBadlandsEnderman::new, ModEntityTypes.BADLANDS_ENDERMAN, 12874042, 4860954);
    public static final RegistryObject<EntityType<BabyCaveEnderman>> BABY_CAVE_ENDERMAN = register("cave", BabyCaveEnderman::new, ModEntityTypes.CAVE_ENDERMAN, 3947594, 1710626);
    public static final RegistryObject<EntityType<BabyCrimsonForestEnderman>> BABY_CRIMSON_FOREST_ENDERMAN = register("crimson_forest", BabyCrimsonForestEnderman::new, ModEntityTypes.CRIMSON_FOREST_ENDERMAN, 9117247, 3803668);
    public static final RegistryObject<EntityType<BabyDarkOakEnderman>> BABY_DARK_OAK_ENDERMAN = register("dark_oak", BabyDarkOakEnderman::new, ModEntityTypes.DARK_OAK_ENDERMAN, 4139546, 1971212);
    public static final RegistryObject<EntityType<BabyDesertEnderman>> BABY_DESERT_ENDERMAN = register("desert", BabyDesertEnderman::new, ModEntityTypes.DESERT_ENDERMAN, 14730378, 9071154);
    public static final RegistryObject<EntityType<BabyEndEnderman>> BABY_END_ENDERMAN = register("end", BabyEndEnderman::new, ModEntityTypes.END_ENDERMAN, 1447446, 13369594);
    public static final RegistryObject<EntityType<BabyEndIslandsEnderman>> BABY_END_ISLANDS_ENDERMAN = register("end_islands", BabyEndIslandsEnderman::new, ModEntityTypes.END_ISLANDS_ENDERMAN, 15198183, 9133302);
    public static final RegistryObject<EntityType<BabyFlowerFieldsEnderman>> BABY_FLOWER_FIELDS_ENDERMAN = register("flower_fields", BabyFlowerFieldsEnderman::new, ModEntityTypes.FLOWER_FIELDS_ENDERMAN, 15902659, 7061337);
    public static final RegistryObject<EntityType<BabyIceSpikesEnderman>> BABY_ICE_SPIKES_ENDERMAN = register("ice_spikes", BabyIceSpikesEnderman::new, ModEntityTypes.ICE_SPIKES_ENDERMAN, 14153471, 7244698);
    public static final RegistryObject<EntityType<BabyMushroomFieldsEnderman>> BABY_MUSHROOM_FIELDS_ENDERMAN = register("mushroom_fields", BabyMushroomFieldsEnderman::new, ModEntityTypes.MUSHROOM_FIELDS_ENDERMAN, 13088675, 9058874);
    public static final RegistryObject<EntityType<BabyNetherWastesEnderman>> BABY_NETHER_WASTES_ENDERMAN = register("nether_wastes", BabyNetherWastesEnderman::new, ModEntityTypes.NETHER_WASTES_ENDERMAN, 7019805, 14833698);
    public static final RegistryObject<EntityType<BabyCoralEnderman>> BABY_CORAL_ENDERMAN = register("coral", BabyCoralEnderman::new, ModEntityTypes.CORAL_ENDERMAN, 3050379, 15764122);
    public static final RegistryObject<EntityType<BabySavannaEnderman>> BABY_SAVANNA_ENDERMAN = register("savanna", BabySavannaEnderman::new, ModEntityTypes.SAVANNA_ENDERMAN, 12034394, 7032366);
    public static final RegistryObject<EntityType<BabySnowyEnderman>> BABY_SNOWY_ENDERMAN = register("snowy", BabySnowyEnderman::new, ModEntityTypes.SNOWY_ENDERMAN, 16054267, 10205129);
    public static final RegistryObject<EntityType<BabySoulsandValleyEnderman>> BABY_SOULSAND_VALLEY_ENDERMAN = register("soulsand_valley", BabySoulsandValleyEnderman::new, ModEntityTypes.SOULSAND_VALLEY_ENDERMAN, 5981750, 5030873);
    public static final RegistryObject<EntityType<BabySwampEnderman>> BABY_SWAMP_ENDERMAN = register("swamp", BabySwampEnderman::new, ModEntityTypes.SWAMP_ENDERMAN, 5204794, 2892822);
    public static final RegistryObject<EntityType<BabyWarpedForestEnderman>> BABY_WARPED_FOREST_ENDERMAN = register("warped_forest", BabyWarpedForestEnderman::new, ModEntityTypes.WARPED_FOREST_ENDERMAN, 1739398, 932408);
    public static final RegistryObject<EntityType<BabyWindsweptHillsEnderman>> BABY_WINDSWEPT_HILLS_ENDERMAN = register("windswept_hills", BabyWindsweptHillsEnderman::new, ModEntityTypes.WINDSWEPT_HILLS_ENDERMAN, 8227704, 5134928);

    private EndermanModule() {
    }

    public static void init() {
        ModuleHooks.ATTRIBUTES.add(EndermanModule::attributes);
        ModuleHooks.SPAWNS.add(EndermanModule::spawns);
        ModuleLoader.loadClient("com.mekanismadditionsoverhaul.enderman.client.EndermanClient");
    }

    private static void attributes(EntityAttributeCreationEvent event) {
        event.put(BABY_BADLANDS_ENDERMAN.get(), BadlandsEnderman.createAttributes().build());
        event.put(BABY_CAVE_ENDERMAN.get(), CaveEnderman.createAttributes().build());
        event.put(BABY_CRIMSON_FOREST_ENDERMAN.get(), CrimsonForestEnderman.createAttributes().build());
        event.put(BABY_DARK_OAK_ENDERMAN.get(), DarkOakEnderman.createAttributes().build());
        event.put(BABY_DESERT_ENDERMAN.get(), DesertEnderman.createAttributes().build());
        event.put(BABY_END_ENDERMAN.get(), EndEnderman.createAttributes().build());
        event.put(BABY_END_ISLANDS_ENDERMAN.get(), EndIslandsEnderman.createAttributes().build());
        event.put(BABY_FLOWER_FIELDS_ENDERMAN.get(), FlowerFieldsEnderman.createAttributes().build());
        event.put(BABY_ICE_SPIKES_ENDERMAN.get(), IceSpikesEnderman.createAttributes().build());
        event.put(BABY_MUSHROOM_FIELDS_ENDERMAN.get(), MushroomFieldsEnderman.createAttributes().build());
        event.put(BABY_NETHER_WASTES_ENDERMAN.get(), NetherWastesEnderman.createAttributes().build());
        event.put(BABY_CORAL_ENDERMAN.get(), CoralEnderman.createAttributes().build());
        event.put(BABY_SAVANNA_ENDERMAN.get(), SavannaEnderman.createAttributes().build());
        event.put(BABY_SNOWY_ENDERMAN.get(), SnowyEnderman.createAttributes().build());
        event.put(BABY_SOULSAND_VALLEY_ENDERMAN.get(), SoulsandValleyEnderman.createAttributes().build());
        event.put(BABY_SWAMP_ENDERMAN.get(), SwampEnderman.createAttributes().build());
        event.put(BABY_WARPED_FOREST_ENDERMAN.get(), WarpedForestEnderman.createAttributes().build());
        event.put(BABY_WINDSWEPT_HILLS_ENDERMAN.get(), WindsweptHillsEnderman.createAttributes().build());
    }

    private static void spawns(SpawnPlacementRegisterEvent event) {
        event.register(BABY_BADLANDS_ENDERMAN.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, BadlandsEnderman::checkMonsterSpawnRules, SpawnPlacementRegisterEvent.Operation.REPLACE);
        event.register(BABY_CAVE_ENDERMAN.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (type, level, reason, pos, random) -> CaveEnderman.checkSpawnRules((EntityType) type, level, reason, pos, random), SpawnPlacementRegisterEvent.Operation.REPLACE);
        event.register(BABY_CRIMSON_FOREST_ENDERMAN.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, CrimsonForestEnderman::checkMonsterSpawnRules, SpawnPlacementRegisterEvent.Operation.REPLACE);
        event.register(BABY_DARK_OAK_ENDERMAN.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, DarkOakEnderman::checkMonsterSpawnRules, SpawnPlacementRegisterEvent.Operation.REPLACE);
        event.register(BABY_DESERT_ENDERMAN.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, DesertEnderman::checkMonsterSpawnRules, SpawnPlacementRegisterEvent.Operation.REPLACE);
        event.register(BABY_END_ENDERMAN.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, EndEnderman::checkMonsterSpawnRules, SpawnPlacementRegisterEvent.Operation.REPLACE);
        event.register(BABY_END_ISLANDS_ENDERMAN.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, EndIslandsEnderman::checkMonsterSpawnRules, SpawnPlacementRegisterEvent.Operation.REPLACE);
        event.register(BABY_FLOWER_FIELDS_ENDERMAN.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, FlowerFieldsEnderman::checkMobSpawnRules, SpawnPlacementRegisterEvent.Operation.REPLACE);
        event.register(BABY_ICE_SPIKES_ENDERMAN.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, IceSpikesEnderman::checkMonsterSpawnRules, SpawnPlacementRegisterEvent.Operation.REPLACE);
        event.register(BABY_MUSHROOM_FIELDS_ENDERMAN.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, MushroomFieldsEnderman::checkMobSpawnRules, SpawnPlacementRegisterEvent.Operation.REPLACE);
        event.register(BABY_NETHER_WASTES_ENDERMAN.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, NetherWastesEnderman::checkMonsterSpawnRules, SpawnPlacementRegisterEvent.Operation.REPLACE);
        event.register(BABY_CORAL_ENDERMAN.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, CoralEnderman::checkMonsterSpawnRules, SpawnPlacementRegisterEvent.Operation.REPLACE);
        event.register(BABY_SAVANNA_ENDERMAN.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, SavannaEnderman::checkMonsterSpawnRules, SpawnPlacementRegisterEvent.Operation.REPLACE);
        event.register(BABY_SNOWY_ENDERMAN.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, SnowyEnderman::checkMonsterSpawnRules, SpawnPlacementRegisterEvent.Operation.REPLACE);
        event.register(BABY_SOULSAND_VALLEY_ENDERMAN.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, SoulsandValleyEnderman::checkMonsterSpawnRules, SpawnPlacementRegisterEvent.Operation.REPLACE);
        event.register(BABY_SWAMP_ENDERMAN.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, SwampEnderman::checkMonsterSpawnRules, SpawnPlacementRegisterEvent.Operation.REPLACE);
        event.register(BABY_WARPED_FOREST_ENDERMAN.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, WarpedForestEnderman::checkMonsterSpawnRules, SpawnPlacementRegisterEvent.Operation.REPLACE);
        event.register(BABY_WINDSWEPT_HILLS_ENDERMAN.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, WindsweptHillsEnderman::checkMonsterSpawnRules, SpawnPlacementRegisterEvent.Operation.REPLACE);
    }

    private static <T extends EnderMan> RegistryObject<EntityType<T>> register(
            String name,
            EntityType.EntityFactory<T> factory,
            RegistryEntry<? extends EntityType<?>> adult,
            int primary,
            int secondary
    ) {
        String id = "baby_" + name + "_enderman";
        RegistryObject<EntityType<T>> holder = MaoRegistries.ENTITIES.register(id, () -> EntityBuilders.baby(factory, adult.get(), BabyScales.ENDERMAN).build(id));
        MaoConfig.define(id);
        BabySpawn.register(id, holder, adult);
        MaoRegistries.ITEMS.register(id + "_spawn_egg", () -> new ForgeSpawnEggItem(holder::get, primary, secondary, new Item.Properties()));
        return holder;
    }
}
