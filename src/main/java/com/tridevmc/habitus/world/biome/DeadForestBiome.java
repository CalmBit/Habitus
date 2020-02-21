package com.tridevmc.habitus.world.biome;

import com.google.common.collect.Lists;
import com.tridevmc.habitus.init.HSBiomes;
import com.tridevmc.habitus.init.HSBlocks;
import com.tridevmc.habitus.init.HSEntities;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.SphereReplaceConfig;
import net.minecraft.world.gen.feature.structure.MineshaftConfig;
import net.minecraft.world.gen.feature.structure.MineshaftStructure;
import net.minecraft.world.gen.placement.AtSurfaceWithExtraConfig;
import net.minecraft.world.gen.placement.ChanceConfig;
import net.minecraft.world.gen.placement.FrequencyConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

public class DeadForestBiome extends Biome {
    public DeadForestBiome() {
        super((new Biome.Builder()).surfaceBuilder(SurfaceBuilder.DEFAULT, HSBiomes.GRASS_DIRT_PEAT).precipitation(RainType.RAIN).category(Category.FOREST).depth(0.1F).scale(0.2F).temperature(0.9F).downfall(0.2F).waterColor(0x776758).waterFogColor(0x3d352d).parent((String)null));
        this.func_226711_a_(Feature.MINESHAFT.func_225566_b_(new MineshaftConfig(0.004D, MineshaftStructure.Type.NORMAL)));
        this.func_226711_a_(Feature.STRONGHOLD.func_225566_b_(IFeatureConfig.NO_FEATURE_CONFIG));
        DefaultBiomeFeatures.addCarvers(this);
        DefaultBiomeFeatures.addStructures(this);
        DefaultBiomeFeatures.addLakes(this);
        DefaultBiomeFeatures.addMonsterRooms(this);
        DefaultBiomeFeatures.addStoneVariants(this);
        DefaultBiomeFeatures.addOres(this);
        DefaultBiomeFeatures.addSprings(this);
        DefaultBiomeFeatures.func_222299_R(this);
        DefaultBiomeFeatures.func_222314_K(this);
        DefaultBiomeFeatures.func_222283_Y(this);
        this.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.DISK.func_225566_b_(new SphereReplaceConfig(HSBlocks.PEAT.getDefaultState(), 6, 12, Lists.newArrayList(Blocks.DIRT.getDefaultState(),
                                                                                                                                                                                                          Blocks.GRASS_BLOCK.getDefaultState())))
                                                                                 .func_227228_a_(Placement.COUNT_TOP_SOLID
                                                                                                 .func_227446_a_(new FrequencyConfig(4))));
        this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, HSBiomes.DEAD_TREES.func_225566_b_(HSBiomes.DEAD_TREE_CONFIG)
                                                                                          .func_227228_a_(Placement.COUNT_EXTRA_HEIGHTMAP
                                                                                                          .func_227446_a_(new AtSurfaceWithExtraConfig(2, 0.1f, 1))));
        this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, HSBiomes.FALLEN_TREES.func_225566_b_(IFeatureConfig.NO_FEATURE_CONFIG)
                                                                                            .func_227228_a_(Placement.COUNT_EXTRA_HEIGHTMAP
                                                                                                            .func_227446_a_(new AtSurfaceWithExtraConfig(2, 0.1f, 1))));
        this.addFeature(GenerationStage.Decoration.UNDERGROUND_DECORATION, Feature.FOSSIL.func_225566_b_(IFeatureConfig.NO_FEATURE_CONFIG)
                                                                                         .func_227228_a_(Placement.CHANCE_PASSTHROUGH
                                                                                                         .func_227446_a_(new ChanceConfig(32))));
        this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.SPIDER, 100, 4, 4));
        this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.ZOMBIE, 15, 4, 4));
        this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.ZOMBIE_VILLAGER, 5, 1, 1));
        this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.SKELETON, 100, 4, 4));
        this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.CREEPER, 100, 4, 4));
        this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.SLIME, 100, 4, 4));
        this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.ENDERMAN, 10, 1, 4));
        this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.WITCH, 5, 1, 1));
        this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(HSEntities.WASTED, 80, 4, 4));
    }



    @Override
    public int func_225529_c_() {
        return 0x749dad;
    }

    @Override
    public int func_225528_a_(double p_225528_1_, double p_225528_3_) {
        return 0x5b4223;
    }

    @Override
    public int func_225527_a_() {
        return 0x5b4223;
    }


}
