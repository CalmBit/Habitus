package com.tridevmc.habitus.init;

import com.tridevmc.habitus.Habitus;
import com.tridevmc.habitus.entity.BabySkeletonEntity;
import com.tridevmc.habitus.entity.WastedEntity;
import com.tridevmc.habitus.entity.WoodbugEntity;
import com.tridevmc.habitus.entity.render.WastedRenderer;
import com.tridevmc.habitus.entity.render.WoodbugRenderer;
import net.minecraft.client.renderer.entity.SkeletonRenderer;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntitySpawnPlacementRegistry;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.monster.SkeletonEntity;
import net.minecraft.entity.monster.ZombieEntity;
import net.minecraft.world.gen.Heightmap;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class HSEntities {
    public static final EntityType WASTED = EntityType.Builder
            .create(WastedEntity::new, EntityClassification.MONSTER)
            .size(0.6F, 1.95F)
            .setTrackingRange(8)
            .setUpdateInterval(3)
            .setShouldReceiveVelocityUpdates(true)
            .setCustomClientFactory(((spawnEntity, world) -> new WastedEntity(world)))
            .build("habitus:wasted")
            .setRegistryName(Habitus.MODID, "wasted");

    public static final EntityType WOODBUG = EntityType.Builder
            .create(WoodbugEntity::new, EntityClassification.CREATURE)
            .size(0.4f, 0.3f)
            .setTrackingRange(16)
            .setUpdateInterval(3)
            .setShouldReceiveVelocityUpdates(true)
            .setCustomClientFactory(((spawnEntity, world) -> new WoodbugEntity(world)))
            .build("habitus:woodbug")
            .setRegistryName(Habitus.MODID, "woodbug");

    public static final EntityType BABY_SKELETON = EntityType.Builder
            .create(BabySkeletonEntity::new, EntityClassification.MONSTER)
            .size(0.6F, 1.99F)
            .setTrackingRange(8)
            .setUpdateInterval(3)
            .setShouldReceiveVelocityUpdates(true)
            .setCustomClientFactory((((spawnEntity, world) -> new BabySkeletonEntity(world))))
            .build("habitus:baby_skeleton")
            .setRegistryName(Habitus.MODID, "baby_skeleton");


    public static void registerEntities(RegistryEvent.Register<EntityType<?>> evt) {
        evt.getRegistry().registerAll(
                WASTED,
                WOODBUG,
                BABY_SKELETON
        );
        GlobalEntityTypeAttributes.put(WOODBUG, WoodbugEntity.registerAttributes().create());
        GlobalEntityTypeAttributes.put(WASTED, ZombieEntity.func_234342_eQ_().create());
        GlobalEntityTypeAttributes.put(BABY_SKELETON, BabySkeletonEntity.registerAttributes().create());
        EntitySpawnPlacementRegistry.register(WASTED, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MonsterEntity::canMonsterSpawn);
        EntitySpawnPlacementRegistry.register(WOODBUG, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, WoodbugEntity::canWoodbugSpawn);
        EntitySpawnPlacementRegistry.register(BABY_SKELETON, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MonsterEntity::canMonsterSpawn);
    }

    public static void registerRenderers() {
        RenderingRegistry.registerEntityRenderingHandler(WASTED, WastedRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(WOODBUG, WoodbugRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(BABY_SKELETON, SkeletonRenderer::new);
    }
}
