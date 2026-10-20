package com.mekanismadditionsoverhaul;

import com.mekanismadditionsoverhaul.config.MaoConfig;
import com.mekanismadditionsoverhaul.registry.MaoRegistries;
import com.mekanismadditionsoverhaul.spider.SpiderModule;
import com.mojang.logging.LogUtils;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.entity.SpawnPlacementRegisterEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLEnvironment;
import org.slf4j.Logger;

@Mod(MaoConstants.MOD_ID)
public final class MekanismAdditionsOverhaul {
    public static final Logger LOGGER = LogUtils.getLogger();

    public MekanismAdditionsOverhaul() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        SpiderModule.init();
        ModuleLoader.load("creeperoverhaul", "com.mekanismadditionsoverhaul.creeper.CreeperModule");
        ModuleLoader.load("endermanoverhaul", "com.mekanismadditionsoverhaul.enderman.EndermanModule");

        MaoRegistries.register(modEventBus);
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, MaoConfig.finish());
        modEventBus.addListener(MekanismAdditionsOverhaul::onAttributes);
        modEventBus.addListener(MekanismAdditionsOverhaul::onSpawnPlacements);
    }

    private static void onAttributes(EntityAttributeCreationEvent event) {
        ModuleHooks.ATTRIBUTES.forEach(hook -> hook.accept(event));
    }

    private static void onSpawnPlacements(SpawnPlacementRegisterEvent event) {
        ModuleHooks.SPAWNS.forEach(hook -> hook.accept(event));
    }

    public static boolean isClient() {
        return FMLEnvironment.dist.isClient();
    }
}
