package com.tridevmc.habitus.init;

import com.google.common.collect.Lists;
import com.tridevmc.habitus.Habitus;
import com.tridevmc.habitus.world.biome.DeadTreeFeature;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.HugeMushroomBlock;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
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
import net.minecraftforge.registries.ForgeRegistries;

public class HSBiomes {

    public static final BaseTreeFeatureConfig DEAD_TREE_CONFIG = new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(HSBlocks.DEAD_LOG.getDefaultState()),
            new SimpleBlockStateProvider(Blocks.AIR.getDefaultState()),
            new BlobFoliagePlacer(FeatureSpread.func_242252_a(0), FeatureSpread.func_242252_a(0), 0),
            new StraightTrunkPlacer(4, 2, 0),
            new TwoLayerFeature(1, 0, 1))
            .build();
    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> DEAD_TREES =  Feature.TREE.withConfiguration(DEAD_TREE_CONFIG);
    /*public static final Feature<NoFeatureConfig> FALLEN_TREES = (Feature<NoFeatureConfig>) new FallenTreeFeature(NoFeatureConfig::deserialize, 5)
            .setRegistryName("fallen_trees");
    public static final Feature<NoFeatureConfig> OASIS = (Feature<NoFeatureConfig>) new OasisFeature(NoFeatureConfig::deserialize)
            .setRegistryName("oasis");*/

    private static final BlockState RED_MUSHROOM_BLOCK = Blocks.RED_MUSHROOM_BLOCK.getDefaultState().with(HugeMushroomBlock.DOWN, Boolean.FALSE);
    private static final BlockState BROWN_MUSHROOM_BLOCK = Blocks.BROWN_MUSHROOM_BLOCK.getDefaultState().with(HugeMushroomBlock.UP, Boolean.TRUE).with(HugeMushroomBlock.DOWN, Boolean.FALSE);
    private static final BlockState MUSHROOM_STEM = Blocks.MUSHROOM_STEM.getDefaultState().with(HugeMushroomBlock.UP, Boolean.FALSE).with(HugeMushroomBlock.DOWN, Boolean.FALSE);
    private static final BigMushroomFeatureConfig BIG_RED_MUSHROOM = new BigMushroomFeatureConfig(new SimpleBlockStateProvider(RED_MUSHROOM_BLOCK), new SimpleBlockStateProvider(MUSHROOM_STEM), 2);
    private static final BigMushroomFeatureConfig BIG_BROWN_MUSHROOM = new BigMushroomFeatureConfig(new SimpleBlockStateProvider(BROWN_MUSHROOM_BLOCK), new SimpleBlockStateProvider(MUSHROOM_STEM), 3);
    public static final SurfaceBuilderConfig PODZOL_DIRT_PEAT = new SurfaceBuilderConfig(Blocks.PODZOL.getDefaultState(), Blocks.DIRT.getDefaultState(), HSBlocks.PEAT.getDefaultState());
    private static final ConfiguredSurfaceBuilder<SurfaceBuilderConfig> DEAD_FOREST_SURFACE = WorldGenRegistries.register(WorldGenRegistries.CONFIGURED_SURFACE_BUILDER, "dead_forest", SurfaceBuilder.DEFAULT.func_242929_a(HSBiomes.PODZOL_DIRT_PEAT));
    private static final BiomeGenerationSettings.Builder DEAD_FOREST_BUILDER = new BiomeGenerationSettings.Builder().withSurfaceBuilder(DEAD_FOREST_SURFACE);
    private static final ConfiguredFeature<?, ?> PEAT_DISK =
            Feature.DISK.withConfiguration(new SphereReplaceConfig(HSBlocks.PEAT.getDefaultState(),  FeatureSpread.func_242253_a(2, 4),2,
            Lists.newArrayList(Blocks.DIRT.getDefaultState(), Blocks.GRASS_BLOCK.getDefaultState()))).withPlacement(Features.Placements.SEAGRASS_DISK_PLACEMENT)
                                  .func_242731_b(3);
    public static final ConfiguredFeature<?, ?> SLATE_ORE = Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.field_241882_a,
           HSBlocks.SLATE.getDefaultState(), 33))
            .func_242733_d(80)
            .func_242728_a()
            .func_242731_b(10);
    public static final ConfiguredFeature<?, ?> LIMESTONE_ORE = Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.field_241882_a,
            HSBlocks.LIMESTONE.getDefaultState(), 33))
            .func_242733_d(80)
            .func_242728_a()
            .func_242731_b(10);
    public static final ConfiguredFeature<?, ?> MARBLE_ORE = Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.field_241882_a,
            HSBlocks.MARBLE.getDefaultState(), 33))
            .func_242733_d(80)
            .func_242728_a()
            .func_242731_b(10);
    static {

        /**
         *         this.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
         *                 Feature.DISK.withConfiguration(
         *                         new SphereReplaceConfig(HSBlocks.PEAT.getDefaultState(),6,12,
         *                                 Lists.newArrayList(
         *                                         Blocks.DIRT.getDefaultState(),
         *                                         Blocks.GRASS_BLOCK.getDefaultState())
         *                         ))
         *                         .withPlacement(Placement.COUNT_TOP_SOLID
         *                                 .configure(new FrequencyConfig(4))
         *                         ));
         *         this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
         *                 HSBiomes.DEAD_TREES.withConfiguration(HSBiomes.DEAD_TREE_CONFIG)
         *                         .withPlacement(Placement.COUNT_EXTRA_HEIGHTMAP
         *                                 .configure(new AtSurfaceWithExtraConfig(2,0.1f,1))
         *                         ));
         *         this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
         *                 HSBiomes.FALLEN_TREES.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG)
         *                         .withPlacement(Placement.COUNT_EXTRA_HEIGHTMAP
         *                                 .configure(new AtSurfaceWithExtraConfig(2,0.1f,1))
         *                         ));
         *         this.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION,
         *                 Feature.FOSSIL.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG)
         *                         .withPlacement(Placement.CHANCE_PASSTHROUGH
         *                                 .configure(new ChanceConfig(32))
         *                         ));
         *         this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
         *                 Feature.RANDOM_BOOLEAN_SELECTOR
         *                         .withConfiguration(new TwoFeatureChoiceConfig(
         *                                 Feature.HUGE_RED_MUSHROOM
         *                                         .withConfiguration(BIG_RED_MUSHROOM),
         *                                 Feature.HUGE_BROWN_MUSHROOM
         *                                         .withConfiguration(BIG_BROWN_MUSHROOM)
         *                         ))
         *                         .withPlacement(Placement.COUNT_CHANCE_HEIGHTMAP
         *                                 .configure(new HeightWithChanceConfig(1, 0.125f))
         *                         ));
         *         this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
         *                 Feature.RANDOM_PATCH
         *                         .withConfiguration(DefaultBiomeFeatures.RED_MUSHROOM_CONFIG)
         *                         .withPlacement(Placement.COUNT_CHANCE_HEIGHTMAP
         *                                 .configure(new HeightWithChanceConfig(1, 0.25F))));
         *         this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
         *                 Feature.RANDOM_PATCH
         *                         .withConfiguration(DefaultBiomeFeatures.BROWN_MUSHROOM_CONFIG)
         *                         .withPlacement(Placement.COUNT_CHANCE_HEIGHTMAP
         *                                 .configure(new HeightWithChanceConfig(1, 0.25F))));
         *         this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.SPIDER, 100, 4, 4));
         *         this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.ZOMBIE, 15, 4, 4));
         *         this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.ZOMBIE_VILLAGER, 5, 1, 1));
         *         this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.SKELETON, 100, 4, 4));
         *         this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.CREEPER, 100, 4, 4));
         *         this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.SLIME, 100, 4, 4));
         *         this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.ENDERMAN, 10, 1, 4));
         *         this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.WITCH, 5, 1, 1));
         *         this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(HSEntities.WASTED, 80, 4, 4));
         */
    }

    public static Biome DEAD_FOREST = null;

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
        DefaultBiomeFeatures.withDebrisOre(DEAD_FOREST_BUILDER);
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

        Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, "disk_peat", PEAT_DISK);
        Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, "ore_slate", SLATE_ORE);
        Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, "ore_limestone", LIMESTONE_ORE);
        Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, "ore_marble", MARBLE_ORE);
        Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, "tree_dead", DEAD_TREES);

        DEAD_FOREST_BUILDER.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, PEAT_DISK);
        DEAD_FOREST_BUILDER.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, SLATE_ORE);
        DEAD_FOREST_BUILDER.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, LIMESTONE_ORE);
        DEAD_FOREST_BUILDER.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, MARBLE_ORE);
        DEAD_FOREST_BUILDER.withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, DEAD_TREES);

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

    public static void setupBiomes() {

    }

    public static void registerFeatures(RegistryEvent.Register<Feature<?>> evt) {
        /*evt.getRegistry().registerAll(
                DEAD_TREES,
                FALLEN_TREES,
                OASIS
        );*/

        //Biomes.DESERT.addFeature(GenerationStage.Decoration.LOCAL_MODIFICATIONS, OASIS.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withPlacement(Placement.CHANCE_HEIGHTMAP.configure(new ChanceConfig(100))));
    }
}
