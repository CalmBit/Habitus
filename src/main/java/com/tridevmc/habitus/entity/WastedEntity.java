package com.tridevmc.habitus.entity;

import com.tridevmc.habitus.init.HSEntities;
import com.tridevmc.habitus.init.HSSounds;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.monster.ZombieEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.network.IPacket;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

public class WastedEntity extends ZombieEntity {
    public WastedEntity(EntityType type, World world) {
        super(type, world);
    }

    public WastedEntity(World world) {
        this(HSEntities.WASTED, world);
    }

    protected SoundEvent getAmbientSound() {
        return HSSounds.ENTITY_WASTED_AMBIENT;
    }

    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return HSSounds.ENTITY_WASTED_HURT;
    }

    protected SoundEvent getDeathSound() {
        return HSSounds.ENTITY_WASTED_DEATH;
    }

    public boolean attackEntityAsMob(Entity entityIn) {
        boolean flag = super.attackEntityAsMob(entityIn);
        if (flag && this.getHeldItemMainhand().isEmpty() && entityIn instanceof LivingEntity) {
            float f = this.world.getDifficultyForLocation(new BlockPos(this)).getAdditionalDifficulty();
            ((LivingEntity)entityIn).addPotionEffect(new EffectInstance(Effects.WEAKNESS, 140 * (int)f));
        }

        return flag;
    }

    protected boolean shouldDrown() {
        return false;
    }

    protected ItemStack getSkullDrop() {
        return ItemStack.EMPTY;
    }

    @Override
    public IPacket<?> createSpawnPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }
}
