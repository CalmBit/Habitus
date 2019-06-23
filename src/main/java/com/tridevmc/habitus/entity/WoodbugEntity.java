package com.tridevmc.habitus.entity;

import com.tridevmc.habitus.init.HSBiomes;
import com.tridevmc.habitus.init.HSBlocks;
import com.tridevmc.habitus.init.HSEntities;
import net.minecraft.block.SilverfishBlock;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.PanicGoal;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomWalkingGoal;
import net.minecraft.entity.passive.TurtleEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.IPacket;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

import javax.annotation.Nullable;

public class WoodbugEntity extends CreatureEntity {
    private static final DataParameter<BlockPos> NEST_POS = EntityDataManager.createKey(WoodbugEntity.class, DataSerializers.BLOCK_POS);

    public WoodbugEntity(EntityType type, World worldIn) {
        super(type, worldIn);
    }

    public WoodbugEntity(World worldIn) {
        this(HSEntities.WOODBUG, worldIn);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(1, new PanicGoal(this, 1.25D));
        this.goalSelector.addGoal(6, new WaterAvoidingRandomWalkingGoal(this, 1.0D));
        this.goalSelector.addGoal(7, new LookAtGoal(this, PlayerEntity.class, 6.0F));
        this.goalSelector.addGoal(8, new LookRandomlyGoal(this));
    }

    @Override
    protected void registerData() {
        super.registerData();
        this.dataManager.register(NEST_POS, BlockPos.ZERO);
    }

    protected void registerAttributes() {
        super.registerAttributes();
        this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(4.0D);
        this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue((double)0.35F);
    }

    @Override
    public void writeAdditional(CompoundNBT nbt) {
        super.writeAdditional(nbt);
        nbt.putInt("NestPosX", this.dataManager.get(NEST_POS).getX());
        nbt.putInt("NestPosY", this.dataManager.get(NEST_POS).getX());
        nbt.putInt("NestPosZ", this.dataManager.get(NEST_POS).getX());
    }

    @Override
    public void readAdditional(CompoundNBT nbt) {
        super.readAdditional(nbt);
        this.setNest(new BlockPos(nbt.getInt("NestPosX"),
                nbt.getInt("NestPosY"),
                nbt.getInt("NestPosZ")));
    }

    @Nullable
    @Override
    public ILivingEntityData onInitialSpawn(IWorld worldIn, DifficultyInstance difficulty, SpawnReason spawnReason, @Nullable ILivingEntityData entityData, @Nullable CompoundNBT nbt) {
        this.setNest(new BlockPos(this));
        return super.onInitialSpawn(worldIn, difficulty, spawnReason, entityData, nbt);
    }

    public void setNest(BlockPos pos) {
        this.dataManager.set(NEST_POS, pos);
    }

    public float getBlockPathWeight(BlockPos pos, IWorldReader worldIn) {
        return worldIn.getBlockState(pos).getBlock() == HSBlocks.DEAD_LOG ? 1000.0F : super.getBlockPathWeight(pos, worldIn);
    }

    private BlockPos getNest() {
        return (BlockPos)this.dataManager.get(NEST_POS);
    }

    public CreatureAttribute getCreatureAttribute() {
        return CreatureAttribute.ARTHROPOD;
    }

    @Override
    public boolean getAlwaysRenderNameTagForRender() {
        return super.getAlwaysRenderNameTagForRender();
    }

    @Override
    public IPacket<?> createSpawnPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }
}
