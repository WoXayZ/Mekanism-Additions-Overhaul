package com.mekanismadditionsoverhaul;

import com.mekanismadditionsoverhaul.config.MaoConfig;
import com.mekanismadditionsoverhaul.registry.MaoRegistries;
import com.mekanismadditionsoverhaul.spider.SpiderModule;
import com.mojang.logging.LogUtils;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.loading.FMLEnvironment;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.neoforged.neoforge.event.entity.RegisterSpawnPlacementsEvent;
import org.slf4j.Logger;

@Mod(MaoConstants.MOD_ID)
public final class MekanismAdditionsOverhaul {
    public static final Logger LOGGER = LogUtils.getLogger();

    public MekanismAdditionsOverhaul(IEventBus modEventBus, ModContainer modContainer) {
        SpiderModule.init();
        ModuleLoader.load("creeperoverhaul", "com.mekanismadditionsoverhaul.creeper.CreeperModule");
        ModuleLoader.load("endermanoverhaul", "com.mekanismadditionsoverhaul.enderman.EndermanModule");
        ModuleLoader.load("spider_overhaul", "com.mekanismadditionsoverhaul.spider.SpiderOverhaulModule");

        MaoRegistries.register(modEventBus);
        modContainer.registerConfig(ModConfig.Type.COMMON, MaoConfig.finish());
        modEventBus.addListener(MekanismAdditionsOverhaul::onAttributes);
        modEventBus.addListener(MekanismAdditionsOverhaul::onSpawnPlacements);
    }

    private static void onAttributes(EntityAttributeCreationEvent event) {
        ModuleHooks.ATTRIBUTES.forEach(hook -> hook.accept(event));
    }

    private static void onSpawnPlacements(RegisterSpawnPlacementsEvent event) {
        ModuleHooks.SPAWNS.forEach(hook -> hook.accept(event));
    }

    public static boolean isClient() {
        return FMLEnvironment.dist.isClient();
    }
}
