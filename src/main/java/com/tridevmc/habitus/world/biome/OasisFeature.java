package com.tridevmc.habitus.world.biome;

import com.mojang.datafixers.Dynamic;
import net.minecraft.block.BlockState;
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
        pos = worldIn.getHeight(Heightmap.Type.WORLD_SURFACE_WG, pos);

        int radius = 16;
        int r2 = radius*radius;
        int waterRadius = radius-4;
        int wr2 = waterRadius*waterRadius;
        for(int x = -radius;x <= radius;x++) {
            for(int z = -radius;z <= radius;z++) {
                BlockPos ppos = worldIn.getHeight(Heightmap.Type.WORLD_SURFACE_WG, new BlockPos(pos.getX()+x,0,pos.getZ()+z)).down();
                if((x*x)+(z*z) > r2) continue;
                for(int y = ppos.getY()-6;y <= ppos.getY();y++) {
                    BlockPos replacePos = new BlockPos(ppos.getX(), y, ppos.getZ());
                    if(worldIn.getBlockState(replacePos).getBlock() == Blocks.WATER) continue;
                    BlockState replaceState = (y == ppos.getY()) ?
                            ((x*x)+(z*z)<=wr2?Blocks.WATER.getDefaultState():Blocks.GRASS_BLOCK.getDefaultState())
                            : Blocks.DIRT.getDefaultState();
                    this.setBlockState(worldIn, replacePos, replaceState);
                }

            }
        }
        return true;
    }
}
