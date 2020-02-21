package com.tridevmc.habitus.world.biome;

import com.mojang.datafixers.Dynamic;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationSettings;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;

import java.util.Random;
import java.util.function.Function;

public class OasisFeature extends Feature<NoFeatureConfig> {
    public OasisFeature(Function<Dynamic<?>, ? extends NoFeatureConfig> configFactoryIn) {
        super(configFactoryIn);
    }

    @Override
    public boolean place(IWorld worldIn, ChunkGenerator<? extends GenerationSettings> generator, Random rand, BlockPos pos, NoFeatureConfig config) {
        pos = worldIn.getHeight(Heightmap.Type.WORLD_SURFACE, pos);

        for(int x = pos.getX()-5;x <= pos.getX()+5;x++) {
            for(int z = pos.getZ()-5;z <= pos.getZ()+5;z++) {
                BlockPos ppos = new BlockPos(x, pos.getY(), z);
                if(worldIn.getBlockState(ppos.down()).getBlock() == Blocks.WATER) continue;
                this.setBlockState(worldIn, new BlockPos(x, pos.getY(), z), Blocks.GRASS_BLOCK.getDefaultState());
            }
        }
        return true;
    }
}
