package com.tridevmc.habitus.init;

import com.tridevmc.habitus.entity.Corpse;
import com.tridevmc.habitus.entity.VisceraType;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.entity.passive.CowEntity;
import net.minecraft.entity.passive.PigEntity;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.entity.passive.horse.HorseEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.event.RegistryEvent;

public class HSCorpses {
    public static final Corpse PIG_CORPSE = new Corpse(PigEntity.class, VisceraType.VISCERA_QUADRAPED);
    public static final Corpse SHEEP_CORPSE = new Corpse(SheepEntity.class, VisceraType.VISCERA_QUADRAPED);
    public static final Corpse COW_CORPSE = new Corpse(CowEntity.class, VisceraType.VISCERA_QUADRAPED);
    public static final Corpse HORSE_CORPSE = new Corpse(HorseEntity.class, VisceraType.VISCERA_QUADRAPED);


    public static void registerCorpses(RegistryEvent.Register<Corpse> evt) {
        evt.getRegistry().registerAll(
                PIG_CORPSE.setRegistryName("minecraft", "pig"),
                SHEEP_CORPSE.setRegistryName("minecraft", "sheep"),
                COW_CORPSE.setRegistryName("minecraft", "cow"),
                HORSE_CORPSE.setRegistryName("minecraft", "horse")
        );
    }

    @OnlyIn(Dist.CLIENT)
    public static void setupRenderers(EntityRendererManager manager) {
        PIG_CORPSE.setupRenderer(PigRenderer.class, manager);
        SHEEP_CORPSE.setupRenderer(SheepRenderer.class, manager);
        COW_CORPSE.setupRenderer(CowRenderer.class, manager);
        HORSE_CORPSE.setupRenderer(HorseRenderer.class, manager);
    }
}
