package com.tridevmc.habitus.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.WallBlock;
import net.minecraftforge.common.ToolType;

import javax.annotation.Nullable;

public class DecoStoneWallBlock extends WallBlock {
    public DecoStoneWallBlock(Block b) {
        super(Block.Properties.from(b));
    }

    @Nullable
    @Override
    public ToolType getHarvestTool(BlockState stateIn) {
        return ToolType.PICKAXE;
    }
}
