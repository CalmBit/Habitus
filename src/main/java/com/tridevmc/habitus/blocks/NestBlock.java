package com.tridevmc.habitus.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Explosion;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

public class NestBlock extends Block {
    public NestBlock() {
        super(Properties.create(Material.ROCK));
    }

    @Override
    public void onPlayerDestroy(IWorld worldIn, BlockPos pos, BlockState state) {
        super.onPlayerDestroy(worldIn, pos, state);
        this.explode(worldIn, pos);
    }

    @Override
    public void onExplosionDestroy(World worldIn, BlockPos pos, Explosion explosionIn) {
        super.onExplosionDestroy(worldIn, pos, explosionIn);
        this.explode(worldIn, pos);
    }

    @Override
    public void onFallenUpon(World worldIn, BlockPos pos, Entity entityIn, float fallDistance) {
        super.onFallenUpon(worldIn, pos, entityIn, fallDistance);
        if(fallDistance > 8.0f) {
            this.explode(worldIn, pos);
        }
    }

    protected void explode(IWorld worldIn, BlockPos pos) {
        if(worldIn instanceof World) {
            World world = (World)worldIn;
            world.createExplosion(null, pos.getX(), pos.getY(), pos.getZ(), 2.0f, Explosion.Mode.DESTROY);
        }
    }
}
