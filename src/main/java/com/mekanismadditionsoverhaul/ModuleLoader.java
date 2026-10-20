package com.mekanismadditionsoverhaul;

import net.minecraftforge.fml.ModList;

import java.lang.reflect.Method;

public final class ModuleLoader {
    private ModuleLoader() {
    }

    public static void load(String modId, String className) {
        if (!ModList.get().isLoaded(modId)) {
            MekanismAdditionsOverhaul.LOGGER.info("Skipping {} babies, {} is not installed", className.substring(className.lastIndexOf('.') + 1), modId);
            return;
        }
        try {
            Class<?> type = Class.forName(className);
            Method init = type.getMethod("init");
            init.invoke(null);
        } catch (ReflectiveOperationException exception) {
            throw new IllegalStateException("Failed to load " + className, exception);
        }
    }

    public static void loadClient(String className) {
        if (!MekanismAdditionsOverhaul.isClient()) {
            return;
        }
        try {
            Class<?> type = Class.forName(className);
            Method init = type.getMethod("init");
            init.invoke(null);
        } catch (ReflectiveOperationException exception) {
            throw new IllegalStateException("Failed to load " + className, exception);
        }
    }
}
