package com.tridevmc.habitus.init;

import com.tridevmc.habitus.Habitus;
import com.tridevmc.habitus.entity.CorpseEntity;
import com.tridevmc.habitus.entity.WastedEntity;
import com.tridevmc.habitus.entity.WoodbugEntity;
import com.tridevmc.habitus.entity.render.CorpseRenderer;
import com.tridevmc.habitus.entity.render.WastedRenderer;
import com.tridevmc.habitus.entity.render.WoodbugRenderer;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntitySpawnPlacementRegistry;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.world.gen.Heightmap;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.client.registry.IRenderFactory;
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

    public static final EntityType WASTED = EntityType.Builder
            .create(WastedEntity::new, EntityClassification.MONSTER)
            .size(0.6F, 1.95F)
            .setTrackingRange(80)
            .setUpdateInterval(3)
            .setShouldReceiveVelocityUpdates(true)
            .setCustomClientFactory(((spawnEntity, world) -> new WastedEntity(world)))
            .build("habitus:wasted")
            .setRegistryName(Habitus.MODID, "wasted");

    public static final EntityType WOODBUG = EntityType.Builder
            .create(WoodbugEntity::new, EntityClassification.CREATURE)
            .size(0.4f, 0.3f)
            .setTrackingRange(80)
            .setUpdateInterval(3)
            .setShouldReceiveVelocityUpdates(true)
            .setCustomClientFactory(((spawnEntity, world) -> new WoodbugEntity(world)))
            .build("habitus:woodbug")
            .setRegistryName(Habitus.MODID, "woodbug");


    public static void registerEntities(RegistryEvent.Register<EntityType<?>> evt) {
        evt.getRegistry().registerAll(
                CORPSE,
                WASTED,
                WOODBUG
        );
        EntitySpawnPlacementRegistry.register(WASTED, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MonsterEntity::func_223325_c);
        EntitySpawnPlacementRegistry.register(WOODBUG, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, AnimalEntity::func_223316_b);

    }

    public static void registerRenderers() {
        RenderingRegistry.registerEntityRenderingHandler(CORPSE, CorpseRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(WASTED, WastedRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(WOODBUG, WoodbugRenderer::new);

    }
}
