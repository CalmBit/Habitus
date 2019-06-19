package com.tridevmc.habitus.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.RotatedPillarBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.common.ToolType;

import javax.annotation.Nullable;

public class DeadLogBlock extends RotatedPillarBlock {

    private static final VoxelShape SHAPE_Y = VoxelShapes.combineAndSimplify(
            VoxelShapes.combineAndSimplify(
                Block.makeCuboidShape(0,0, 0, 16, 16, 2),
                Block.makeCuboidShape(14,0, 2, 16, 16, 14),
                IBooleanFunction.OR
            ),
            VoxelShapes.combineAndSimplify(
                    Block.makeCuboidShape(0,0, 14, 16, 16, 16),
                    Block.makeCuboidShape(0,0, 2, 2, 16, 14),
                    IBooleanFunction.OR
            ),
            IBooleanFunction.OR
    );

    private static final VoxelShape SHAPE_Z = VoxelShapes.combineAndSimplify(
            VoxelShapes.combineAndSimplify(
                    Block.makeCuboidShape(0,0, 0, 16, 2, 16),
                    Block.makeCuboidShape(14,2, 0, 16, 14, 16),
                    IBooleanFunction.OR
            ),
            VoxelShapes.combineAndSimplify(
                    Block.makeCuboidShape(0,14, 0, 16, 16, 16),
                    Block.makeCuboidShape(0,2, 0, 2, 14, 16),
                    IBooleanFunction.OR
            ),
            IBooleanFunction.OR
    );

    private static final VoxelShape SHAPE_X = VoxelShapes.combineAndSimplify(
            VoxelShapes.combineAndSimplify(
                    Block.makeCuboidShape(0,0, 0, 16, 2, 16),
                    Block.makeCuboidShape(0,2, 14, 16, 14, 16),
                    IBooleanFunction.OR
            ),
            VoxelShapes.combineAndSimplify(
                    Block.makeCuboidShape(0,14, 0, 16, 16, 16),
                    Block.makeCuboidShape(0,2, 0, 16, 14, 2),
                    IBooleanFunction.OR
            ),
            IBooleanFunction.OR
    );

    public DeadLogBlock() {
        super(Properties.create(Material.WOOD).hardnessAndResistance(2.0F).sound(SoundType.WOOD));
    }

    @Nullable
    @Override
    public ToolType getHarvestTool(BlockState state) {
        return ToolType.AXE;
    }

    @Override
    public BlockRenderLayer getRenderLayer() {
        return BlockRenderLayer.CUTOUT;
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return getVoxelShape(state);
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return getVoxelShape(state);
    }

    @Override
    public VoxelShape getRaytraceShape(BlockState state, IBlockReader worldIn, BlockPos pos) {
        return getVoxelShape(state);
    }


    private VoxelShape getVoxelShape(BlockState state) {
        switch(state.get(AXIS)) {
            case X:
                return SHAPE_X;
            case Y:
                return SHAPE_Y;
            case Z:
                return SHAPE_Z;
        }
        return null;
    }

    @Override
    public float func_220080_a(BlockState state, IBlockReader worldIn, BlockPos pos) {
        return 1.0f;
    }
}
