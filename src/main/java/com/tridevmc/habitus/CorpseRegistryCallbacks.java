package com.tridevmc.habitus;

import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.IForgeRegistryInternal;
import net.minecraftforge.registries.RegistryManager;

import javax.annotation.Nullable;

public class CorpseRegistryCallbacks implements IForgeRegistry.AddCallback<Corpse> {
    @Override
    public void onAdd(IForgeRegistryInternal<Corpse> owner, RegistryManager stage, int id, Corpse obj, @Nullable Corpse oldObj) {
        Habitus.LOGGER.info("Registering a corpse - " + obj.wrappedEntityClass.getSimpleName());
    }
}
