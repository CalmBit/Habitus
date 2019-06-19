package com.tridevmc.habitus.init;

import com.tridevmc.habitus.Habitus;
import com.tridevmc.habitus.entity.CorpseEntity;
import com.tridevmc.habitus.entity.render.CorpseRenderer;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class HSEntities {
    public static final EntityType CORPSE = EntityType.Builder
            .create(CorpseEntity::new, EntityClassification.MISC)
            .size(0.9f, 0.9f)
            .setTrackingRange(80)
            .setUpdateInterval(3)
            .setShouldReceiveVelocityUpdates(true)
            .disableSummoning()
            .setCustomClientFactory(((spawnEntity, world) -> new CorpseEntity(world)))
            .build("habitus:corpse")
            .setRegistryName(Habitus.MODID, "corpse");


    public static void registerEntities(RegistryEvent.Register<EntityType<?>> evt) {
        evt.getRegistry().registerAll(CORPSE);
    }

    public static void registerRenderers() {
        RenderingRegistry.registerEntityRenderingHandler(CorpseEntity.class, CorpseRenderer::new);
    }
}
