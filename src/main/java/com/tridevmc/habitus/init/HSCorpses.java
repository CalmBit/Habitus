package com.tridevmc.habitus.init;

import com.tridevmc.habitus.Corpse;
import com.tridevmc.habitus.entity.VisceraType;
import net.minecraft.client.renderer.entity.CowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.PigRenderer;
import net.minecraft.client.renderer.entity.SheepRenderer;
import net.minecraft.entity.passive.CowEntity;
import net.minecraft.entity.passive.PigEntity;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.event.RegistryEvent;

public class HSCorpses {
    public static final Corpse PIG_CORPSE = new Corpse(PigEntity.class, VisceraType.VISCERA_QUADRAPED);
    public static final Corpse SHEEP_CORPSE = new Corpse(SheepEntity.class, VisceraType.VISCERA_QUADRAPED);
    public static final Corpse COW_CORPSE = new Corpse(CowEntity.class, VisceraType.VISCERA_QUADRAPED);

    public static void registerCorpses(RegistryEvent.Register<Corpse> evt) {
        evt.getRegistry().registerAll(
                PIG_CORPSE.setRegistryName("minecraft", "pig"),
                SHEEP_CORPSE.setRegistryName("minecraft", "sheep"),
                COW_CORPSE.setRegistryName("minecraft", "cow")
        );
    }

    @OnlyIn(Dist.CLIENT)
    public static void setupRenderers(EntityRendererManager manager) {
        PIG_CORPSE.setupRenderer(manager);
        SHEEP_CORPSE.setupRenderer(manager);
        COW_CORPSE.setupRenderer(manager);
    }
}
