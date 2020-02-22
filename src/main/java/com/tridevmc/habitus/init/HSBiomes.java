package com.tridevmc.habitus.init;

import com.tridevmc.habitus.world.biome.DeadForestBiome;
import com.tridevmc.habitus.world.biome.DeadTreeFeature;
import com.tridevmc.habitus.world.biome.FallenTreeFeature;
import com.tridevmc.habitus.world.biome.OasisFeature;
import net.minecraft.block.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.foliageplacer.BlobFoliagePlacer;
import net.minecraft.world.gen.placement.ChanceConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.event.RegistryEvent;

public class HSBiomes {

    public static final TreeFeatureConfig DEAD_TREE_CONFIG = new TreeFeatureConfig.Builder(new SimpleBlockStateProvider(HSBlocks.DEAD_LOG.getDefaultState()),
            new SimpleBlockStateProvider(Blocks.AIR.getDefaultState()),
            new BlobFoliagePlacer(0, 0))
            .baseHeight(6).build();
    public static final Feature<TreeFeatureConfig> DEAD_TREES = (Feature<TreeFeatureConfig>) new DeadTreeFeature(TreeFeatureConfig::func_227338_a_)
            .setRegistryName("dead_trees");
    public static final Feature<NoFeatureConfig> FALLEN_TREES = (Feature<NoFeatureConfig>) new FallenTreeFeature(NoFeatureConfig::deserialize, 5)
            .setRegistryName("fallen_trees");
    public static final Feature<NoFeatureConfig> OASIS = (Feature<NoFeatureConfig>) new OasisFeature(NoFeatureConfig::deserialize)
            .setRegistryName("oasis");

    public static final SurfaceBuilderConfig GRASS_DIRT_PEAT = new SurfaceBuilderConfig(Blocks.GRASS_BLOCK.getDefaultState(), Blocks.DIRT.getDefaultState(), HSBlocks.PEAT.getDefaultState());

    public static final Biome DEAD_FOREST = new DeadForestBiome().setRegistryName("dead_forest");

    public static void registerBiomes(RegistryEvent.Register<Biome> evt) {
        evt.getRegistry().registerAll(
            DEAD_FOREST
        );
    }

    public static void setupBiomes() {
        BiomeDictionary.addTypes(DEAD_FOREST,
                BiomeDictionary.Type.FOREST,
                BiomeDictionary.Type.DEAD,
                BiomeDictionary.Type.SPOOKY);
    }

    public static void registerFeatures(RegistryEvent.Register<Feature<?>> evt) {
        evt.getRegistry().registerAll(
                DEAD_TREES,
                FALLEN_TREES,
                OASIS
        );

        Biomes.DESERT.addFeature(GenerationStage.Decoration.LOCAL_MODIFICATIONS, OASIS.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withPlacement(Placement.CHANCE_HEIGHTMAP.configure(new ChanceConfig(100))));
    }
}
