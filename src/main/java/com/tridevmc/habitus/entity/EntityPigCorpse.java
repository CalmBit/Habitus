package com.tridevmc.habitus.entity;

import com.tridevmc.habitus.init.HSEntities;
import net.minecraft.entity.EntityType;
import net.minecraft.network.IPacket;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

public class EntityPigCorpse extends EntityCorpse {
    public EntityPigCorpse(EntityType type, World world) {
        super(type, world);
    }

    public EntityPigCorpse(World world) {
        this(HSEntities.PIG_CORPSE, world);
    }

    @Override
    public IPacket<?> createSpawnPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }
}
