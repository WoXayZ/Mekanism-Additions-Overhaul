package com.mekanismadditionsoverhaul.registry;

import com.mekanismadditionsoverhaul.spider.SpiderModule;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.RegistryObject;

public final class MaoCreativeTabs {
    public static RegistryObject<CreativeModeTab> TAB;

    private MaoCreativeTabs() {
    }

    public static void register() {
        TAB = MaoRegistries.TABS.register("main", () -> CreativeModeTab.builder()
                .title(Component.translatable("itemGroup.mekanismadditionsoverhaul"))
                .icon(() -> new ItemStack(SpiderModule.BABY_SPIDER_SPAWN_EGG.get()))
                .displayItems((parameters, output) -> MaoRegistries.ITEMS.getEntries().forEach(entry -> output.accept(entry.get())))
                .build());
    }
}
