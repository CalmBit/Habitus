package com.tridevmc.habitus.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class PeatBlock extends Block {
    public PeatBlock() {
        super(Properties.create(Material.EARTH).hardnessAndResistance(1.0f).sound(SoundType.GROUND));
    }
}
