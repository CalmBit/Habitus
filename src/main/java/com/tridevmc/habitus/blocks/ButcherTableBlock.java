package com.tridevmc.habitus.blocks;

import com.tridevmc.habitus.init.HSBlocks;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.block.material.PushReaction;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.stats.Stats;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraft.world.storage.loot.LootContext;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ButcherTableBlock extends HorizontalBlock {

    public static final EnumProperty<ButcherTableSide> SIDE = EnumProperty.create("side", ButcherTableSide.class);

    @Override
    public BlockRenderLayer getRenderLayer() {
        return BlockRenderLayer.CUTOUT;
    }

    public ButcherTableBlock() {
        super(Block.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD));
    }

    public void harvestBlock(World worldIn, PlayerEntity player, BlockPos pos, BlockState state, @Nullable TileEntity te, ItemStack stack) {
        super.harvestBlock(worldIn, player, pos, Blocks.AIR.getDefaultState(), te, stack);
    }

    public void onBlockHarvested(World worldIn, BlockPos pos, BlockState state, PlayerEntity player) {
        ButcherTableSide side = state.get(SIDE);
        BlockPos blockpos = pos.offset(getDirectionToOther(side, (Direction)state.get(HORIZONTAL_FACING).rotateYCCW()));
        BlockState blockstate = worldIn.getBlockState(blockpos);
        if (blockstate.getBlock() == this && blockstate.get(SIDE) != side) {
            worldIn.setBlockState(blockpos, Blocks.AIR.getDefaultState(), 35);
            worldIn.playEvent(player, 2001, blockpos, Block.getStateId(blockstate));
            if (!worldIn.isRemote && !player.isCreative()) {
                ItemStack itemstack = player.getHeldItemMainhand();
                spawnDrops(state, worldIn, pos, (TileEntity)null, player, itemstack);
                spawnDrops(blockstate, worldIn, blockpos, (TileEntity)null, player, itemstack);
            }

            player.addStat(Stats.BLOCK_MINED.get(this));
        }

        super.onBlockHarvested(worldIn, pos, state, player);
    }

    public PushReaction getPushReaction(BlockState state) {
        return PushReaction.DESTROY;
    }

    public BlockState updatePostPlacement(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos currentPos, BlockPos facingPos) {
        if (facing != getDirectionToOther(stateIn.get(SIDE), stateIn.get(HORIZONTAL_FACING).rotateYCCW())) {
            return super.updatePostPlacement(stateIn, facing, facingState, worldIn, currentPos, facingPos);
        } else {
            return facingState.getBlock() == this && facingState.get(SIDE) != stateIn.get(SIDE) ? stateIn : Blocks.AIR.getDefaultState();
        }
    }

    private static Direction getDirectionToOther(ButcherTableSide side, Direction dir) {
        return side == ButcherTableSide.RIGHT ? dir : dir.getOpposite();
    }


    @Nullable
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        Direction enumfacing = context.getPlacementHorizontalFacing();
        BlockPos blockpos = context.getPos();
        BlockPos blockpos1 = blockpos.offset(enumfacing.rotateY());
        return context.getWorld().getBlockState(blockpos1).isReplaceable(context) ? this.getDefaultState().with(HORIZONTAL_FACING, enumfacing) : null;
    }

    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(HORIZONTAL_FACING, SIDE);
    }

    public void onBlockPlacedBy(World worldIn, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack stack) {
        super.onBlockPlacedBy(worldIn, pos, state, placer, stack);
        if (!worldIn.isRemote) {
            BlockPos blockpos = pos.offset(state.get(HORIZONTAL_FACING).rotateY());
            worldIn.setBlockState(blockpos, state.with(SIDE, ButcherTableSide.RIGHT), 3);
            worldIn.notifyNeighbors(pos, Blocks.AIR);
            state.updateNeighbors(worldIn, pos, 3);
        }

    }

    /*@Override
    public ItemStack getItem(IBlockReader worldIn, BlockPos pos, BlockState state) {
        return HSBlocks.ITEM_BUTCHER_TABLE.getDefaultInstance();
    }

    @Override
    public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
        return Collections.singletonList(state.get(SIDE) == ButcherTableSide.LEFT ?
                HSBlocks.ITEM_BUTCHER_TABLE.getDefaultInstance()
                : Items.AIR.getDefaultInstance());
    }*/
}
