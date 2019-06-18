package com.tridevmc.habitus;

import com.tridevmc.habitus.entity.EntityCorpse;
import com.tridevmc.habitus.entity.EnumVisceraType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.world.World;
import net.minecraftforge.registries.ForgeRegistryEntry;

import java.lang.reflect.InvocationTargetException;

public class Corpse extends ForgeRegistryEntry<Corpse> {
    public final Class<? extends EntityCorpse> corpseClass;
    public final Class<? extends LivingEntity> wrappedEntityClass;
    public final EnumVisceraType visceraType;

    public Corpse(Class<? extends EntityCorpse> corpseClass, Class<? extends LivingEntity> wrappedEntityClass, EnumVisceraType visceraType) {
        this.corpseClass = corpseClass;
        this.wrappedEntityClass = wrappedEntityClass;
        this.visceraType = visceraType;
    }

    public EntityCorpse createEntity(LivingEntity ent, World world) {
        try {
            EntityCorpse c = corpseClass.getConstructor(World.class).newInstance(world);
            c.setPositionAndRotation(ent.posX, ent.posY, ent.posZ, ent.rotationYaw, ent.rotationPitch);
            c.setMotion(ent.getMotion());
            world.addEntity(c);
            return c;
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            Habitus.LOGGER.error("Unable to construct " + corpseClass.toString() + "!");
            Habitus.LOGGER.error(e.getMessage());
        }

        return null;
    }

    public NonNullList<ItemStack> getCorpseDrops() {
        return NonNullList.create();
    }
}
