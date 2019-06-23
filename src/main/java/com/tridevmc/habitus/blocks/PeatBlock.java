package com.tridevmc.habitus.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

import javax.annotation.Nullable;

public class PeatBlock extends Block {
    public PeatBlock() {
        super(Properties.create(Material.EARTH).hardnessAndResistance(1.0f).sound(SoundType.GROUND));
    }

    @Nullable
    @Override
    public ToolType getHarvestTool(BlockState p_getHarvestTool_1_) {
        return ToolType.SHOVEL;
    }
}
