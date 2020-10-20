package com.tridevmc.habitus.world.biome;

import com.mojang.serialization.Codec;
import com.tridevmc.habitus.blocks.DeadLogBlock;
import com.tridevmc.habitus.init.HSBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;

import java.util.Random;

public class FallenTreeFeature extends Feature<NoFeatureConfig> {
    private final int minimumLength;

    public FallenTreeFeature(Codec<NoFeatureConfig> p_i231953_1_,  int minimumLength) {
        super(p_i231953_1_);
        this.minimumLength = minimumLength;
    }

    @Override
    public boolean func_241855_a(ISeedReader worldIn, ChunkGenerator gen, Random rand, BlockPos pos, NoFeatureConfig config) {
        int length = minimumLength + rand.nextInt(3);

        Direction d = rand.nextBoolean() ?
                (rand.nextBoolean() ? Direction.NORTH : Direction.SOUTH)
                : (rand.nextBoolean() ? Direction.WEST : Direction.EAST);

        BlockState LOG_STATE = HSBlocks.DEAD_LOG.getDefaultState().with(DeadLogBlock.AXIS, d.getAxis());

        int actual = 0;

        if(d.getAxis() == Direction.Axis.Z) {
            for(int i = pos.getZ();i < pos.getZ() + (d.getZOffset() * length);i++) {
                BlockPos blockPos = new BlockPos(pos.getX(), pos.getY(), i);
                if(isReplaceable(worldIn.getBlockState(blockPos)) && isSubstrate(worldIn.getBlockState(blockPos.down()))) {
                    actual++;
                } else {
                    return false;
                }
            }
            if(actual >= minimumLength) {
                for(int i =pos.getZ();i < pos.getZ() + (d.getZOffset() * actual);i++) {
                    BlockPos blockPos = new BlockPos(pos.getX(), pos.getY(), i);
                    worldIn.setBlockState(blockPos, LOG_STATE, 19);
                }
            }
        } else if(d.getAxis() == Direction.Axis.X) {
            for(int i = pos.getX();i < pos.getX() + (d.getXOffset() * length);i++) {
                BlockPos blockPos = new BlockPos(i, pos.getY(), pos.getZ());
                if(isReplaceable(worldIn.getBlockState(blockPos)) && isSubstrate(worldIn.getBlockState(blockPos.down()))) {
                    actual++;
                } else {
                    return false;
                }
            }
            if(actual >= minimumLength) {
                for(int i =pos.getX();i < pos.getX() + (d.getXOffset() * actual);i++) {
                    BlockPos blockPos = new BlockPos(i, pos.getY(), pos.getZ());
                    worldIn.setBlockState(blockPos, LOG_STATE, 19);
                }
            }
        }
        return actual >= minimumLength;
    }

    private static boolean isReplaceable(BlockState state) {
        return state.getBlock() == Blocks.AIR || state.getBlock() == Blocks.DIRT || state.getBlock() == Blocks.GRASS_BLOCK || state.getBlock() == Blocks.GRASS;
    }

    private static boolean isSubstrate(BlockState state) {
        return state.getBlock() == Blocks.PODZOL;
    }
}
