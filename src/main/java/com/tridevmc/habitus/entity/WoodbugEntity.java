package com.tridevmc.habitus.entity;

import com.tridevmc.habitus.init.HSBlocks;
import com.tridevmc.habitus.init.HSEntities;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.RandomPositionGenerator;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomWalkingGoal;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.IPacket;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.pathfinding.ClimberPathNavigator;
import net.minecraft.pathfinding.PathNavigator;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.*;
import net.minecraftforge.fml.network.NetworkHooks;

import java.util.Random;

public class WoodbugEntity extends CreatureEntity {
    private static final DataParameter<Byte> CLIMBING = EntityDataManager.createKey(WoodbugEntity.class, DataSerializers.BYTE);
    private static final DataParameter<BlockPos> NEST_POS = EntityDataManager.createKey(WoodbugEntity.class, DataSerializers.BLOCK_POS);

    public WoodbugEntity(EntityType type, World worldIn) {
        super(type, worldIn);
    }

    public WoodbugEntity(World worldIn) {
        this(HSEntities.WOODBUG, worldIn);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(2, new HideDuringDayGoal(this, 1.25D));
        //this.goalSelector.addGoal(4, new PanicGoal(this, 3.0D));
        this.goalSelector.addGoal(6, new WanderAtNightGoal(this, 1.0D));
        //this.goalSelector.addGoal(7, new LookAtGoal(this, PlayerEntity.class, 6.0F));
        //this.goalSelector.addGoal(8, new LookRandomlyGoal(this));
    }

    @Override
    protected void registerData() {
        super.registerData();
        this.dataManager.register(CLIMBING, (byte)0);
        this.dataManager.register(NEST_POS, BlockPos.ZERO);
    }

    public static AttributeModifierMap.MutableAttribute getAttributeMap() {
        return MobEntity.func_233666_p_().createMutableAttribute(Attributes.MAX_HEALTH, 4.0D).createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.35F);
    }

    @Override
    public void writeAdditional(CompoundNBT nbt) {
        super.writeAdditional(nbt);
        nbt.putInt("NestPosX", this.dataManager.get(NEST_POS).getX());
        nbt.putInt("NestPosY", this.dataManager.get(NEST_POS).getY());
        nbt.putInt("NestPosZ", this.dataManager.get(NEST_POS).getZ());
    }

    @Override
    protected void updateFallState(double p_184231_1_, boolean p_184231_3_, BlockState p_184231_4_, BlockPos p_184231_5_) {
        // stub out
    }

    @Override
    public int getMaxFallHeight() {
        return 256;
    }

    @Override
    public void readAdditional(CompoundNBT nbt) {
        super.readAdditional(nbt);
        this.setNest(new BlockPos(nbt.getInt("NestPosX"),
                nbt.getInt("NestPosY"),
                nbt.getInt("NestPosZ")));
    }

    @Override
    public ILivingEntityData onInitialSpawn(IServerWorld worldIn, DifficultyInstance difficultyIn, SpawnReason reason, ILivingEntityData spawnDataIn, CompoundNBT dataTag) {
        this.setNest(new BlockPos(this.getPositionVec()));
        return super.onInitialSpawn(worldIn, difficultyIn, reason, spawnDataIn, dataTag);
    }

    public void setNest(BlockPos pos) {
        this.dataManager.set(NEST_POS, pos);
    }

    public float getBlockPathWeight(BlockPos pos, IWorldReader worldIn) {
        return worldIn.getBlockState(pos).getBlock() == HSBlocks.DEAD_LOG ? 10.0F : -10.0f;
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

    protected PathNavigator createNavigator(World worldIn) {
        return new ClimberPathNavigator(this, worldIn);
    }

    protected void playStepSound(BlockPos pos, BlockState blockIn) {
        this.playSound(SoundEvents.ENTITY_SPIDER_STEP, 0.15F, 1.0F);
    }

    public void tick() {
        super.tick();
        if (!this.world.isRemote) {
            this.setBesideClimbableBlock(this.collidedHorizontally);
        }

    }

    public boolean isBesideClimbableBlock() {
        return (this.dataManager.get(CLIMBING) & 1) != 0;
    }

    public void setBesideClimbableBlock(boolean climbing) {
        byte b0 = this.dataManager.get(CLIMBING);
        if (climbing) {
            b0 = (byte)(b0 | 1);
        } else {
            b0 = (byte)(b0 & -2);
        }

        this.dataManager.set(CLIMBING, b0);
    }

    /*public boolean atNest() {
        return this.getNest().getX() == this.getPosition().getX() &&
                this.getNest().getZ() == this.getPosition().getZ();
    }*/


    public static boolean canWoodbugSpawn(EntityType<? extends WoodbugEntity> type, IWorld worldIn, SpawnReason reason, BlockPos posIn, Random randIn) {
        return  ((worldIn.getBlockState(posIn.down()).getBlock() == Blocks.GRASS_BLOCK) ||
                (worldIn.getBlockState(posIn.down()).getBlock() == Blocks.DIRT) ||
                (worldIn.getBlockState(posIn.down()).getBlock() == Blocks.PODZOL)) && worldIn.getLightSubtracted(posIn, 0) > 8;
    }

    public boolean isOnLadder() {
        return /*!atNest() &&*/ this.isBesideClimbableBlock();
    }

    private class WanderAtNightGoal extends WaterAvoidingRandomWalkingGoal {

        public WanderAtNightGoal(CreatureEntity creature, double speedIn) {
            super(creature, speedIn);
        }

        @Override
        public boolean shouldExecute() {
            return !this.creature.world.isDaytime() && super.shouldExecute();
        }

        @Override
        public boolean shouldContinueExecuting() {
            return !this.creature.world.isDaytime() && super.shouldContinueExecuting();
        }
    }

    private class HideDuringDayGoal extends Goal {
        private WoodbugEntity entity;
        private BlockPos nestPos;
        private Vector3d trueNest;
        private boolean pathingFailed = false;
        private double speed;

        private HideDuringDayGoal(WoodbugEntity entity, double speedIn) {
            this.entity = entity;
            this.speed = speedIn;
            this.updateNestPosition();
        }

        public boolean withinLateralDistance(double dist) {
            double current_dist =
                    Math.pow((this.trueNest.getX() - this.entity.getPositionVec().getX()), 2) +
                    Math.pow((this.trueNest.getZ() - this.entity.getPositionVec().getZ()), 2);
            current_dist = Math.sqrt(current_dist);
            return current_dist <= dist;
        }

        @Override
        public boolean shouldExecute() {
            if(!this.entity.getNest().equals(this.nestPos)) updateNestPosition();
            return !withinLateralDistance(0.25) && this.entity.world.isDaytime();
        }

        @Override
        public boolean shouldContinueExecuting() {
            boolean res = this.shouldExecute() && !pathingFailed;
            if(!res) {
                if(!pathingFailed) {
                    this.entity.getNavigator().clearPath();
                    this.entity.navigator.setSpeed(0.0);
                }
            }
            return res;
        }

        @Override
        public void resetTask() {
        }

        @Override
        public void tick() {
            if(this.entity.getNavigator().noPath()) {
                if(nestPos.withinDistance(this.entity.getPositionVec(), 16.0)) {
                    boolean res = this.entity.getNavigator().tryMoveToXYZ(trueNest.x, trueNest.y, trueNest.z, this.speed);
                    this.pathingFailed = res;
                } else {
                    Vector3d newPosition = RandomPositionGenerator.findRandomTargetBlockTowards(this.entity, 16, 3, this.trueNest);
                    if (newPosition == null) {
                        this.pathingFailed = true;
                        return;
                    }
                    this.entity.getNavigator().tryMoveToXYZ(newPosition.x, newPosition.y, newPosition.z, this.speed);
                }
            }
        }

        protected void updateNestPosition() {
            this.nestPos = this.entity.getNest();
            this.trueNest = new Vector3d(nestPos.getX() + 0.5, nestPos.getY() + 0.5, nestPos.getZ() + 0.5);
        }

        @Override
        public void startExecuting() {
            this.pathingFailed = false;
        }


    }
}
