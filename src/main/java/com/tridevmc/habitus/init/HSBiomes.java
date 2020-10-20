package com.tridevmc.habitus.init;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.tridevmc.habitus.Habitus;
import com.tridevmc.habitus.world.biome.DeadTreeFeature;
import com.tridevmc.habitus.world.biome.FallenTreeFeature;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.HugeMushroomBlock;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.Tuple;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.biome.*;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.foliageplacer.BlobFoliagePlacer;
import net.minecraft.world.gen.foliageplacer.FoliagePlacer;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.minecraft.world.gen.trunkplacer.StraightTrunkPlacer;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class HSBiomes {

    private static final BaseTreeFeatureConfig DEAD_TREE_CONFIG =
            new BaseTreeFeatureConfig.Builder(
                    new SimpleBlockStateProvider(HSBlocks.DEAD_LOG.getDefaultState()),
                    new SimpleBlockStateProvider(Blocks.AIR.getDefaultState()),
                    new BlobFoliagePlacer(FeatureSpread.func_242252_a(0), FeatureSpread.func_242252_a(0), 0),
                    new StraightTrunkPlacer(4, 2, 0),
                    new TwoLayerFeature(1, 0, 1))
                    .build();

    private static final SphereReplaceConfig PEAT_DISK_CONFIG =
            new SphereReplaceConfig(HSBlocks.PEAT.getDefaultState(),
                    FeatureSpread.func_242253_a(2, 4),
                    2,
                    Lists.newArrayList(Blocks.DIRT.getDefaultState(), Blocks.GRASS_BLOCK.getDefaultState()));

    private static final SurfaceBuilderConfig PODZOL_DIRT_PEAT =
            new SurfaceBuilderConfig(Blocks.PODZOL.getDefaultState(),
                    Blocks.DIRT.getDefaultState(),
                    HSBlocks.PEAT.getDefaultState());


    @SuppressWarnings("unchecked")
    private static final Feature<NoFeatureConfig> FALLEN_TREE =
            (Feature<NoFeatureConfig>) new FallenTreeFeature(NoFeatureConfig.field_236558_a_, 5)
                .setRegistryName(Habitus.MODID, "tree_fallen");

    private static final ConfiguredFeature<BaseTreeFeatureConfig, ?> DEAD_TREES =
            Feature.TREE.withConfiguration(DEAD_TREE_CONFIG);
    private static final ConfiguredFeature<NoFeatureConfig, ?> FALLEN_TREES =
            FALLEN_TREE.withConfiguration(NoFeatureConfig.field_236559_b_);

    private static final ConfiguredSurfaceBuilder<SurfaceBuilderConfig> DEAD_FOREST_SURFACE =
            WorldGenRegistries.register(WorldGenRegistries.CONFIGURED_SURFACE_BUILDER,
                    "dead_forest",
                    SurfaceBuilder.DEFAULT.func_242929_a(HSBiomes.PODZOL_DIRT_PEAT));

    private static final BiomeGenerationSettings.Builder DEAD_FOREST_BUILDER =
            new BiomeGenerationSettings.Builder()
                    .withSurfaceBuilder(DEAD_FOREST_SURFACE);

    private static final ConfiguredFeature<?, ?> PEAT_DISK =
            Feature.DISK.withConfiguration(PEAT_DISK_CONFIG)
                    .withPlacement(Features.Placements.SEAGRASS_DISK_PLACEMENT)
                    .func_242731_b(3);

    public static final ConfiguredFeature<?, ?> SLATE_ORE =
            Feature.ORE.withConfiguration(COMMON_STONE_CONFIG(HSBlocks.SLATE.getDefaultState()))
                    .func_242733_d(80)
                    .func_242728_a()
                    .func_242731_b(10);
    public static final ConfiguredFeature<?, ?> LIMESTONE_ORE =
            Feature.ORE.withConfiguration(COMMON_STONE_CONFIG(HSBlocks.LIMESTONE.getDefaultState()))
                    .func_242733_d(80)
                    .func_242728_a()
                    .func_242731_b(10);
    public static final ConfiguredFeature<?, ?> MARBLE_ORE =
            Feature.ORE.withConfiguration(COMMON_STONE_CONFIG(HSBlocks.MARBLE.getDefaultState()))
                    .func_242733_d(80)
                    .func_242728_a()
                    .func_242731_b(10);

    private static Biome DEAD_FOREST = null;

    public static void registerBiomes(RegistryEvent.Register<Biome> evt) {
        // Carvers
        DefaultBiomeFeatures.withCavesAndCanyons(DEAD_FOREST_BUILDER);
        // Structures
        DefaultBiomeFeatures.withStrongholdAndMineshaft(DEAD_FOREST_BUILDER);
        // Lakes
        DefaultBiomeFeatures.withLavaAndWaterLakes(DEAD_FOREST_BUILDER);
        // "Monster Rooms"
        DefaultBiomeFeatures.withMonsterRoom(DEAD_FOREST_BUILDER);
        // Stone Variants
        DefaultBiomeFeatures.withCommonOverworldBlocks(DEAD_FOREST_BUILDER);
        // Ores
        DefaultBiomeFeatures.withOverworldOres(DEAD_FOREST_BUILDER);
        // Springs
        DefaultBiomeFeatures.withLavaAndWaterSprings(DEAD_FOREST_BUILDER);
        // Scattered Oak Trees
        DefaultBiomeFeatures.withTreesInWater(DEAD_FOREST_BUILDER);
        // Dense Grass
        DefaultBiomeFeatures.withNormalGrassPatch(DEAD_FOREST_BUILDER);
        // Plains Tall Grass
        DefaultBiomeFeatures.withTallGrass(DEAD_FOREST_BUILDER);

        DefaultBiomeFeatures.withNormalMushroomGeneration(DEAD_FOREST_BUILDER);

        Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, "disk_peat", PEAT_DISK);
        Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, "ore_slate", SLATE_ORE);
        Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, "ore_limestone", LIMESTONE_ORE);
        Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, "ore_marble", MARBLE_ORE);
        Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, "tree_dead", DEAD_TREES);
        Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, "tree_fallen", FALLEN_TREES);

        DEAD_FOREST_BUILDER.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, PEAT_DISK);
        DEAD_FOREST_BUILDER.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, DEAD_TREES);
        DEAD_FOREST_BUILDER.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, FALLEN_TREES);
        DEAD_FOREST_BUILDER.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Features.MUSHROOM_FIELD_VEGETATION);

        DEAD_FOREST = new Biome.Builder()
                .precipitation(Biome.RainType.RAIN)
                .category(Biome.Category.FOREST)
                .depth(0.1F)
                .scale(0.2F)
                .temperature(0.9F)
                .downfall(0.2F)
                .setEffects(new BiomeAmbience.Builder()
                        // Fog
                        .setFogColor(0x749dad)
                        // Water
                        .setWaterColor(0x776758)
                        // Water Fog
                        .setWaterFogColor(0x3d352d)
                        // Sky
                        .withSkyColor(0x749dad)
                        // Foliage
                        .withFoliageColor(0x5b4223)
                        // Grass
                        .withGrassColor(0x5b4223)
                        .build())
                .withGenerationSettings(DEAD_FOREST_BUILDER.build())
                .withTemperatureModifier(Biome.TemperatureModifier.NONE)
                .withMobSpawnSettings(new MobSpawnInfo.Builder()
                        .withSpawner(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityType.SPIDER, 100, 4, 4))
                        .withSpawner(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityType.ZOMBIE, 15, 4, 4))
                        .withSpawner(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityType.ZOMBIE_VILLAGER, 5, 1, 1))
                        .withSpawner(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityType.SKELETON, 100, 4, 4))
                        .withSpawner(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityType.CREEPER, 100, 4, 4))
                        .withSpawner(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityType.SLIME, 100, 4, 4))
                        .withSpawner(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityType.ENDERMAN, 10, 1, 4))
                        .withSpawner(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(EntityType.WITCH, 5, 1, 1))
                        .withSpawner(EntityClassification.MONSTER, new MobSpawnInfo.Spawners(HSEntities.WASTED, 80, 4, 4))
                        .copy())
                .build()
                .setRegistryName(Habitus.MODID, "dead_forest");

        evt.getRegistry().registerAll(
                DEAD_FOREST
        );
    }

    public static void registerFeatures(RegistryEvent.Register<Feature<?>> evt) {
        evt.getRegistry().register(FALLEN_TREE);
    }

    private static OreFeatureConfig COMMON_STONE_CONFIG(BlockState stone) {
        return new OreFeatureConfig(OreFeatureConfig.FillerBlockType.field_241882_a,
                stone, 33);
    }
}
