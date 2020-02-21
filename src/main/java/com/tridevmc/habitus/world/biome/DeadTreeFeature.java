package com.tridevmc.habitus.world.biome;

import com.mojang.datafixers.Dynamic;
import com.tridevmc.habitus.entity.WoodbugEntity;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.World;
import net.minecraft.world.gen.IWorldGenerationReader;
import net.minecraft.world.gen.WorldGenRegion;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.TreeFeature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;

import java.util.Random;
import java.util.Set;
import java.util.function.Function;

public class DeadTreeFeature extends TreeFeature {
    public DeadTreeFeature(Function<Dynamic<?>, ? extends TreeFeatureConfig> func) {
        super(func);
    }

    // TODO: Did I hook into the right function here? Original was `place()`
    @Override
    public boolean func_225557_a_(IWorldGenerationReader worldIn, Random rand, BlockPos position, Set<BlockPos> blockset1, Set<BlockPos> blockset2, MutableBoundingBox p_225557_6_, TreeFeatureConfig p_225557_7_) {
        boolean res = super.func_225557_a_(worldIn, rand, position, blockset1, blockset1, p_225557_6_, p_225557_7_);
        if(res && rand.nextInt(10) <= 1) {
            World w = ((WorldGenRegion)worldIn).getWorld();
            WoodbugEntity ent = new WoodbugEntity(w);
            ent.setPosition(position.getX() + 0.5, position.getY(), position.getZ() + 0.5);
            ent.setNest(position);
            worldIn.addEntity(ent);
        }
        return res;
    }

}
