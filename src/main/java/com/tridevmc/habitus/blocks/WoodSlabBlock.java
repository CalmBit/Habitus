package com.tridevmc.habitus.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SlabBlock;
import net.minecraftforge.common.ToolType;

import javax.annotation.Nullable;

public class WoodSlabBlock extends SlabBlock {
    public WoodSlabBlock(Block b) {
        super(Block.Properties.from(b));
    }

    @Nullable
    @Override
    public ToolType getHarvestTool(BlockState stateIn) {
        return ToolType.AXE;
    }
}
