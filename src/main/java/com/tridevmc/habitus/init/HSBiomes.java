package com.tridevmc.habitus.init;

import com.tridevmc.habitus.world.biome.DeadForestBiome;
import com.tridevmc.habitus.world.biome.FallenTreeFeature;
import net.minecraft.block.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.TreeFeature;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.event.RegistryEvent;

public class HSBiomes {

    public static final Feature<NoFeatureConfig> DEAD_TREES = (Feature<NoFeatureConfig>) new TreeFeature(NoFeatureConfig::deserialize, false, 6, HSBlocks.DEAD_LOG.getDefaultState(), Blocks.AIR.getDefaultState(), false)
            .setRegistryName("dead_trees");
    public static final Feature<NoFeatureConfig> FALLEN_TREES = (Feature<NoFeatureConfig>) new FallenTreeFeature(NoFeatureConfig::deserialize, 5);

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
                DEAD_TREES
        );
    }
}
