package com.tridevmc.habitus.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

import javax.annotation.Nullable;

public class DecoStoneBlock extends Block {

    public DecoStoneBlock() {
        super(Block.Properties.create(Material.ROCK).sound(SoundType.STONE).hardnessAndResistance(1.5f, 6.0f));
    }

    @Nullable
    @Override
    public ToolType getHarvestTool(BlockState stateIn) {
        return ToolType.PICKAXE;
    }
}
