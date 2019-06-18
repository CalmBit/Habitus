package com.tridevmc.habitus.entity;

import net.minecraft.entity.MobEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

import javax.annotation.Nonnull;

public abstract class EntityCorpse extends MobEntity {

    public EntityCorpse(EntityType type, World world) {
        super(type, world);
        this.setHealth(0.0f);
    }

    public void copyEntityData(LivingEntity other) {

    }

    protected void registerAttributes() {
        super.registerAttributes();
        this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(0.0D);
    }

    @Override
    protected void damageEntity(@Nonnull DamageSource src, float amount) {
        // stub out
    }

    @Override
    protected void registerData() {
        super.registerData();
    }

    public void writeAdditional(CompoundNBT compound) {
        super.writeAdditional(compound);
    }

    public void readAdditional(CompoundNBT compound) {
        super.readAdditional(compound);
    }

    @Override
    public void tick() {
        super.tick();
        if(this.deathTime != 20) {
            ++this.deathTime;
        }
    }

    @Override
    protected void onDeathUpdate() {

    }
}
