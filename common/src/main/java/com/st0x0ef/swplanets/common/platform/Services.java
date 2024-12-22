package com.st0x0ef.swplanets.common.platform;

import com.st0x0ef.swplanets.SWPlanets;
import com.st0x0ef.swplanets.common.platform.services.IPlatformHelper;

import java.util.ServiceLoader;

public class Services {

    public static final IPlatformHelper PLATFORM = load(IPlatformHelper.class);
    public static <T> T load(Class<T> clazz) {

        final T loadedService = ServiceLoader.load(clazz)
                .findFirst()
                .orElseThrow(() -> new NullPointerException("Failed to load service for " + clazz.getName()));
        SWPlanets.LOG.debug("Loaded {} for service {}", loadedService, clazz);
        return loadedService;


    }


}
