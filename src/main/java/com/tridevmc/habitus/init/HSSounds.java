package com.tridevmc.habitus.init;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.event.RegistryEvent;

public class HSSounds {
    public static final SoundEvent ENTITY_WASTED_AMBIENT = createSoundEvent(new ResourceLocation("habitus", "entity.wasted.ambient"));
    public static final SoundEvent ENTITY_WASTED_DEATH = createSoundEvent(new ResourceLocation("habitus", "entity.wasted.death"));
    public static final SoundEvent ENTITY_WASTED_HURT = createSoundEvent(new ResourceLocation("habitus", "entity.wasted.hurt"));

    public static final SoundEvent MUSIC_DISC_CALM1 = createSoundEvent(new ResourceLocation("habitus", "music_disc.calm1"));
    public static final SoundEvent MUSIC_DISC_CALM2 = createSoundEvent(new ResourceLocation("habitus", "music_disc.calm2"));
    public static final SoundEvent MUSIC_DISC_CALM3 = createSoundEvent(new ResourceLocation("habitus", "music_disc.calm3"));
    public static final SoundEvent MUSIC_DISC_HAL1 = createSoundEvent(new ResourceLocation("habitus", "music_disc.hal1"));
    public static final SoundEvent MUSIC_DISC_HAL2 = createSoundEvent(new ResourceLocation("habitus", "music_disc.hal2"));
    public static final SoundEvent MUSIC_DISC_HAL3 = createSoundEvent(new ResourceLocation("habitus", "music_disc.hal3"));
    public static final SoundEvent MUSIC_DISC_HAL4 = createSoundEvent(new ResourceLocation("habitus", "music_disc.hal4"));
    public static final SoundEvent MUSIC_DISC_NUANCE1 = createSoundEvent(new ResourceLocation("habitus", "music_disc.nuance1"));
    public static final SoundEvent MUSIC_DISC_NUANCE2 = createSoundEvent(new ResourceLocation("habitus", "music_disc.nuance2"));
    public static final SoundEvent MUSIC_DISC_PIANO1 = createSoundEvent(new ResourceLocation("habitus", "music_disc.piano1"));
    public static final SoundEvent MUSIC_DISC_PIANO2 = createSoundEvent(new ResourceLocation("habitus", "music_disc.piano2"));
    public static final SoundEvent MUSIC_DISC_PIANO3 = createSoundEvent(new ResourceLocation("habitus", "music_disc.piano3"));

    public static final SoundEvent MUSIC_DISC_MENU1 = createSoundEvent(new ResourceLocation("habitus", "music_disc.menu1"));
    public static final SoundEvent MUSIC_DISC_MENU2 = createSoundEvent(new ResourceLocation("habitus", "music_disc.menu2"));
    public static final SoundEvent MUSIC_DISC_MENU3 = createSoundEvent(new ResourceLocation("habitus", "music_disc.menu3"));
    public static final SoundEvent MUSIC_DISC_MENU4 = createSoundEvent(new ResourceLocation("habitus", "music_disc.menu4"));

    public static final SoundEvent MUSIC_DISC_NETHER1 = createSoundEvent(new ResourceLocation("habitus", "music_disc.nether1"));
    public static final SoundEvent MUSIC_DISC_NETHER2 = createSoundEvent(new ResourceLocation("habitus", "music_disc.nether2"));
    public static final SoundEvent MUSIC_DISC_NETHER3 = createSoundEvent(new ResourceLocation("habitus", "music_disc.nether3"));
    public static final SoundEvent MUSIC_DISC_NETHER4 = createSoundEvent(new ResourceLocation("habitus", "music_disc.nether4"));

    public static final SoundEvent MUSIC_DISC_CREATIVE1 = createSoundEvent(new ResourceLocation("habitus", "music_disc.creative1"));
    public static final SoundEvent MUSIC_DISC_CREATIVE2 = createSoundEvent(new ResourceLocation("habitus", "music_disc.creative2"));
    public static final SoundEvent MUSIC_DISC_CREATIVE3 = createSoundEvent(new ResourceLocation("habitus", "music_disc.creative3"));
    public static final SoundEvent MUSIC_DISC_CREATIVE4 = createSoundEvent(new ResourceLocation("habitus", "music_disc.creative4"));
    public static final SoundEvent MUSIC_DISC_CREATIVE5 = createSoundEvent(new ResourceLocation("habitus", "music_disc.creative5"));
    public static final SoundEvent MUSIC_DISC_CREATIVE6 = createSoundEvent(new ResourceLocation("habitus", "music_disc.creative6"));



    public static void registerSoundEvents(RegistryEvent.Register<SoundEvent> evt) {
        evt.getRegistry().registerAll(
                ENTITY_WASTED_AMBIENT,
                ENTITY_WASTED_DEATH,
                ENTITY_WASTED_HURT,

                MUSIC_DISC_CALM1,
                MUSIC_DISC_CALM2,
                MUSIC_DISC_CALM3,
                MUSIC_DISC_HAL1,
                MUSIC_DISC_HAL2,
                MUSIC_DISC_HAL3,
                MUSIC_DISC_HAL4,
                MUSIC_DISC_NUANCE1,
                MUSIC_DISC_NUANCE2,
                MUSIC_DISC_PIANO1,
                MUSIC_DISC_PIANO2,
                MUSIC_DISC_PIANO3,

                MUSIC_DISC_MENU1,
                MUSIC_DISC_MENU2,
                MUSIC_DISC_MENU3,
                MUSIC_DISC_MENU4,

                MUSIC_DISC_NETHER1,
                MUSIC_DISC_NETHER2,
                MUSIC_DISC_NETHER3,
                MUSIC_DISC_NETHER4,

                MUSIC_DISC_CREATIVE1,
                MUSIC_DISC_CREATIVE2,
                MUSIC_DISC_CREATIVE3,
                MUSIC_DISC_CREATIVE4,
                MUSIC_DISC_CREATIVE5,
                MUSIC_DISC_CREATIVE6
        );
    }

    public static SoundEvent createSoundEvent(ResourceLocation location) {
        return new SoundEvent(location).setRegistryName(location);
    }
}
