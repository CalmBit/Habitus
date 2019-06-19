package com.tridevmc.habitus;

import com.tridevmc.habitus.entity.CorpseEntity;
import com.tridevmc.habitus.entity.VisceraType;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.world.World;
import net.minecraftforge.registries.ForgeRegistryEntry;

public class Corpse extends ForgeRegistryEntry<Corpse> {
    public final Class<? extends LivingEntity> wrappedEntityClass;
    public final Class<? extends EntityRenderer> rendererClass;
    public final VisceraType visceraType;

    public Corpse(Class<? extends LivingEntity> wrappedEntityClass,
                  Class<? extends EntityRenderer> rendererClass,
                  VisceraType visceraType) {
        this.wrappedEntityClass = wrappedEntityClass;
        this.rendererClass = rendererClass;
        this.visceraType = visceraType;
    }

    public void setupRenderer(EntityRendererManager manager) {
        CorpseRendererCache.cacheRenderer(wrappedEntityClass, manager.entityRenderMap.get(wrappedEntityClass));
    }

    public CorpseEntity createEntity(LivingEntity ent, World world) {
        CorpseEntity c = new CorpseEntity(world);
        c.copyEntityData(ent, ent.getType());
        c.setPositionAndRotation(ent.posX, ent.posY, ent.posZ, ent.rotationYaw, ent.rotationPitch);
        c.setMotion(ent.getMotion());
        world.addEntity(c);
        return c;
    }

    public NonNullList<ItemStack> getCorpseDrops() {
        return NonNullList.create();
    }
}
