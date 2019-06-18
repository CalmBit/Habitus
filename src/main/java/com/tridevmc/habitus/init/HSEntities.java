package com.tridevmc.habitus.init;

import com.tridevmc.habitus.Habitus;
import com.tridevmc.habitus.entity.EntityPigCorpse;
import com.tridevmc.habitus.entity.EntitySheepCorpse;
import com.tridevmc.habitus.entity.render.RenderPigCorpse;
import com.tridevmc.habitus.entity.render.RenderSheepCorpse;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class HSEntities {
    public static final EntityType PIG_CORPSE = EntityType.Builder
            .create(EntityPigCorpse::new, EntityClassification.MISC)
            .size(0.9f, 0.9f)
            .setTrackingRange(80)
            .setUpdateInterval(3)
            .setShouldReceiveVelocityUpdates(true)
            .disableSummoning()
            .setCustomClientFactory(((spawnEntity, world) -> new EntityPigCorpse(world)))
            .build("habitus:pig_corpse")
            .setRegistryName(Habitus.MODID, "pig_corpse");

    public static final EntityType SHEEP_CORPSE = EntityType.Builder
            .create(EntitySheepCorpse::new, EntityClassification.MISC)
            .size(0.9F, 1.3F)
            .setTrackingRange(80)
            .setUpdateInterval(3)
            .setShouldReceiveVelocityUpdates(true)
            .disableSummoning()
            .setCustomClientFactory(((spawnEntity, world) -> new EntitySheepCorpse(world)))
            .build("habitus:sheep_corpse")
            .setRegistryName(Habitus.MODID, "sheep_corpse");

    public static void registerEntities(RegistryEvent.Register<EntityType<?>> evt) {
        evt.getRegistry().registerAll(PIG_CORPSE, SHEEP_CORPSE);
    }

    public static void registerRenderers() {
        RenderingRegistry.registerEntityRenderingHandler(EntityPigCorpse.class, RenderPigCorpse::new);
        RenderingRegistry.registerEntityRenderingHandler(EntitySheepCorpse.class, RenderSheepCorpse::new);

    }
}
