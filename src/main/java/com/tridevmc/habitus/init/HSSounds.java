package com.tridevmc.habitus.init;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.event.RegistryEvent;

public class HSSounds {
    public static final SoundEvent ENTITY_WASTED_AMBIENT = new SoundEvent(new ResourceLocation("habitus", "entity.wasted.ambient"))
            .setRegistryName(new ResourceLocation("habitus", "entity.wasted.ambient"));
    public static final SoundEvent ENTITY_WASTED_DEATH = new SoundEvent(new ResourceLocation("habitus", "entity.wasted.death"))
            .setRegistryName(new ResourceLocation("habitus", "entity.wasted.death"));
    public static final SoundEvent ENTITY_WASTED_HURT = new SoundEvent(new ResourceLocation("habitus", "entity.wasted.hurt"))
            .setRegistryName(new ResourceLocation("habitus", "entity.wasted.hurt"));

    public static void registerSoundEvents(RegistryEvent.Register<SoundEvent> evt) {
        evt.getRegistry().registerAll(
                ENTITY_WASTED_AMBIENT,
                ENTITY_WASTED_DEATH,
                ENTITY_WASTED_HURT
        );
    }
}
