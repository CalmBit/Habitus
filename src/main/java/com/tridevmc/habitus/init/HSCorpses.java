package com.tridevmc.habitus.init;

import com.tridevmc.habitus.Corpse;
import com.tridevmc.habitus.entity.EntityPigCorpse;
import com.tridevmc.habitus.entity.EntitySheepCorpse;
import com.tridevmc.habitus.entity.EnumVisceraType;
import net.minecraft.entity.passive.PigEntity;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraftforge.event.RegistryEvent;

public class HSCorpses {
    public static final Corpse PIG_CORPSE = new Corpse(EntityPigCorpse.class, PigEntity.class, EnumVisceraType.VISCERA_QUADRAPED);
    public static final Corpse SHEEP_CORPSE = new Corpse(EntitySheepCorpse.class, SheepEntity.class,  EnumVisceraType.VISCERA_QUADRAPED);

    public static void registerCorpses(RegistryEvent.Register<Corpse> evt) {
        evt.getRegistry().registerAll(
                PIG_CORPSE.setRegistryName("minecraft", "pig"),
                SHEEP_CORPSE.setRegistryName("minecraft", "sheep")
        );
    }
}
