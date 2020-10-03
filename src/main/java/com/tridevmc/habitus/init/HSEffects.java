package com.tridevmc.habitus.init;

import com.tridevmc.habitus.HabitusEffect;
import com.tridevmc.habitus.Tincture;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.EffectType;
import net.minecraft.potion.Potion;
import net.minecraftforge.event.RegistryEvent;

public class HSEffects {
    public static final Effect FIRE_ASPECT = new HabitusEffect(EffectType.BENEFICIAL, 0xE49A3A)
            .setRegistryName("habitus", "fire_aspect");
    public static final Effect SHARPNESS = new HabitusEffect(EffectType.BENEFICIAL, 0x932423)
            .setRegistryName("habitus", "sharpness");
    public static final Effect KNOCKBACK = new HabitusEffect(EffectType.BENEFICIAL, 0x0f27db)
            .setRegistryName("habitus", "knockback");
    public static final Effect SILK_TOUCH = new HabitusEffect(EffectType.BENEFICIAL, 0x9c44db)
            .setRegistryName("habitus", "silk_touch");
    public static final Effect FORTUNE = new HabitusEffect(EffectType.BENEFICIAL, 0x1ba62d)
            .setRegistryName("habitus", "fortune");
    public static final Effect AQUA_AFFINITY = new HabitusEffect(EffectType.BENEFICIAL, 0x3293a8)
            .setRegistryName("habitus", "aqua_affinity");
    public static final Effect BANE_OF_ARTHROPODS = new HabitusEffect(EffectType.BENEFICIAL, 0x6f26a3)
            .setRegistryName("habitus", "bane_of_arthropods");
    public static final Effect SMITE = new HabitusEffect(EffectType.BENEFICIAL, 0x26a39f)
            .setRegistryName("habitus", "smite");

    public static void registerEffects(RegistryEvent.Register<Effect> evt) {
        evt.getRegistry().registerAll(
            FIRE_ASPECT,
            SHARPNESS,
            KNOCKBACK,
            SILK_TOUCH,
            FORTUNE,
            AQUA_AFFINITY,
            BANE_OF_ARTHROPODS,
            SMITE
        );
    }
}
