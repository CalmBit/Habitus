package com.tridevmc.habitus.entity;

import com.tridevmc.habitus.init.HSEntities;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.IPacket;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.IEntityAdditionalSpawnData;
import net.minecraftforge.fml.network.NetworkHooks;

import javax.annotation.Nonnull;
import java.util.Optional;

public class CorpseEntity extends MobEntity implements IEntityAdditionalSpawnData {
    public EntityType type;
    public LivingEntity corpse;

    public CorpseEntity(EntityType type, World world) {
        super(type, world);
        this.setHealth(0.0f);
    }

    public CorpseEntity(World world) {
        this(HSEntities.CORPSE, world);
    }

    public void copyEntityData(LivingEntity other, EntityType type) {
        this.corpse = other;
        this.type = type;
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
        compound.put("CorpseEntity", corpse.serializeNBT());
    }

    public void readAdditional(CompoundNBT compound) {
        super.readAdditional(compound);
        CompoundNBT entityTag = compound.getCompound("CorpseEntity");
        setupCorpseEntity(entityTag);
        corpse.deserializeNBT(entityTag);
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

    @Override
    public void writeSpawnData(PacketBuffer buffer) {
        buffer.writeCompoundTag(corpse.serializeNBT());
    }

    @Override
    public void readSpawnData(PacketBuffer buffer) {
        CompoundNBT entityTag = buffer.readCompoundTag();
        setupCorpseEntity(entityTag);
    }

    public void setupCorpseEntity(CompoundNBT entityTag) {
        Optional<EntityType<?>> t = EntityType.readEntityType(entityTag);
        if(t.isPresent()) {
            type = t.get();
            corpse = (LivingEntity) type.create(this.world);
            corpse.deserializeNBT(entityTag);
            corpse.prevRenderYawOffset = corpse.renderYawOffset;
            corpse.prevRotationYawHead = corpse.rotationYawHead;
        }
    }

    @Override
    public IPacket<?> createSpawnPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }
}
