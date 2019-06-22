package com.tridevmc.habitus.entity;

import com.tridevmc.habitus.entity.render.CorpseRendererCache;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.registries.ForgeRegistryEntry;

public class Corpse extends ForgeRegistryEntry<Corpse> {
    public final Class<? extends LivingEntity> wrappedEntityClass;
    public final VisceraType visceraType;

    @OnlyIn(Dist.CLIENT)
    public Class<? extends EntityRenderer> rendererClass;

    public Corpse(Class<? extends LivingEntity> wrappedEntityClass,
                  VisceraType visceraType) {
        this.wrappedEntityClass = wrappedEntityClass;
        this.visceraType = visceraType;
    }

    @OnlyIn(Dist.CLIENT)
    public void setupRenderer(Class<? extends EntityRenderer> rendererClass, EntityRendererManager manager) {
        this.rendererClass = rendererClass;
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
