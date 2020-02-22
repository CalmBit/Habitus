package com.tridevmc.habitus.init;

import com.tridevmc.habitus.Tincture;
import net.minecraft.potion.EffectInstance;
import net.minecraftforge.event.RegistryEvent;

public class HSTinctures {
    public static final Tincture EMPTY = new Tincture("empty")
            .setRegistryName("habitus", "empty");
    public static final Tincture WATER = new Tincture("water")
            .setRegistryName("habitus", "water");
    public static final Tincture FIRE_ASPECT = new Tincture("fire_aspect", new EffectInstance(HSEffects.FIRE_ASPECT, 2400))
            .setRegistryName("habitus", "fire_aspect");
    public static final Tincture SHARPNESS = new Tincture("sharpness", new EffectInstance(HSEffects.SHARPNESS, 2400))
            .setRegistryName("habitus", "sharpness");
    public static final Tincture SHARPNESS_2 = new Tincture("sharpness", new EffectInstance(HSEffects.SHARPNESS, 2400, 1))
            .setRegistryName("habitus", "sharpness_two");
    public static final Tincture SHARPNESS_3 = new Tincture("sharpness", new EffectInstance(HSEffects.SHARPNESS, 2400, 2))
            .setRegistryName("habitus", "sharpness_three");
    public static final Tincture SHARPNESS_4 = new Tincture("sharpness", new EffectInstance(HSEffects.SHARPNESS, 2400, 3))
            .setRegistryName("habitus", "sharpness_four");
    public static final Tincture SHARPNESS_5 = new Tincture("sharpness", new EffectInstance(HSEffects.SHARPNESS, 2400, 4))
            .setRegistryName("habitus", "sharpness_five");
    public static final Tincture KNOCKBACK = new Tincture("knockback", new EffectInstance(HSEffects.KNOCKBACK, 2400))
            .setRegistryName("habitus", "knockback");
    public static final Tincture KNOCKBACK_2 = new Tincture("knockback", new EffectInstance(HSEffects.KNOCKBACK, 2400, 1))
            .setRegistryName("habitus", "knockback_two");
    public static final Tincture SILK_TOUCH = new Tincture("silk_touch", new EffectInstance(HSEffects.SILK_TOUCH, 2400))
            .setRejections(new EffectInstance(HSEffects.FORTUNE))
            .setRegistryName("habitus", "silk_touch");
    public static final Tincture FORTUNE = new Tincture("fortune", new EffectInstance(HSEffects.FORTUNE, 2400))
            .setRejections(new EffectInstance(HSEffects.SILK_TOUCH))
            .setRegistryName("habitus", "fortune");
    public static final Tincture FORTUNE_2 = new Tincture("fortune", new EffectInstance(HSEffects.FORTUNE, 2400, 1))
            .setRejections(new EffectInstance(HSEffects.SILK_TOUCH))
            .setRegistryName("habitus", "fortune_two");
    public static final Tincture FORTUNE_3 = new Tincture("fortune", new EffectInstance(HSEffects.FORTUNE, 2400, 2))
            .setRejections(new EffectInstance(HSEffects.SILK_TOUCH))
            .setRegistryName("habitus", "fortune_three");


    public static void registerTinctures(RegistryEvent.Register<Tincture> evt) {
        evt.getRegistry().registerAll(
                EMPTY,
                WATER,
                FIRE_ASPECT,
                SHARPNESS,
                SHARPNESS_2,
                SHARPNESS_3,
                SHARPNESS_4,
                SHARPNESS_5,
                KNOCKBACK,
                KNOCKBACK_2,
                SILK_TOUCH,
                FORTUNE,
                FORTUNE_2,
                FORTUNE_3
        );
    }
}
