package com.tridevmc.habitus.world.biome;

import com.mojang.serialization.Codec;
import net.minecraft.world.gen.feature.BaseTreeFeatureConfig;
import net.minecraft.world.gen.feature.TreeFeature;

public class DeadTreeFeature extends TreeFeature {
    public DeadTreeFeature(Codec<BaseTreeFeatureConfig> codec) {
        super(codec);
    }



    /*// TODO: Did I hook into the right function here? Original was `place()`
    @Override
    public boolean place(IWorldGenerationReader worldIn, Random rand, BlockPos position, Set<BlockPos> blockset1, Set<BlockPos> blockset2, MutableBoundingBox p_225557_6_, TreeFeatureConfig p_225557_7_) {
        boolean res = super.func_225557_a_(worldIn, rand, position, blockset1, blockset1, p_225557_6_, p_225557_7_);
        if(res && rand.nextInt(10) <= 1) {
            World w = ((WorldGenRegion)worldIn).getWorld();
            WoodbugEntity ent = new WoodbugEntity(w);
            ent.setPosition(position.getX() + 0.5, position.getY(), position.getZ() + 0.5);
            ent.setNest(position);
            worldIn.addEntity(ent);
        }
        return res;
    }*/

}
