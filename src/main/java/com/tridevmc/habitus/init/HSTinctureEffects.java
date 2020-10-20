package com.tridevmc.habitus.init;

import com.tridevmc.habitus.Habitus;
import com.tridevmc.habitus.tinctures.TinctureEffect;
import com.tridevmc.habitus.tinctures.TinctureTarget;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;

public class HSTinctureEffects {
    public static final TinctureEffect PROTECTION = new TinctureEffect.Builder("protection")
            .withColor(0xFFDEADBE)
            .withMaxLevel(4)
            .withTarget(TinctureTarget.HEAD)
            .withTarget(TinctureTarget.CHESTPLATE)
            .withTarget(TinctureTarget.LEGGINGS)
            .withTarget(TinctureTarget.BOOTS)
            .withRejection(new ResourceLocation(Habitus.MODID, "blast_protection"))
            .withRejection(new ResourceLocation(Habitus.MODID, "fire_protection"))
            .withRejection(new ResourceLocation(Habitus.MODID, "projectile_protection"))
            .build()
            .setRegistryName(Habitus.MODID, "protection");
    public static final TinctureEffect FIRE_PROTECTION = new TinctureEffect.Builder("fire_protection")
            .withColor(0xFFDEADBE)
            .withMaxLevel(4)
            .withTarget(TinctureTarget.HEAD)
            .withTarget(TinctureTarget.CHESTPLATE)
            .withTarget(TinctureTarget.LEGGINGS)
            .withTarget(TinctureTarget.BOOTS)
            .withRejection(new ResourceLocation(Habitus.MODID, "protection"))
            .withRejection(new ResourceLocation(Habitus.MODID, "blast_protection"))
            .withRejection(new ResourceLocation(Habitus.MODID, "projectile_protection"))
            .build()
            .setRegistryName(Habitus.MODID, "fire_protection");
    public static final TinctureEffect FEATHER_FALLING = new TinctureEffect.Builder("feather_falling")
            .withColor(0xFFDEADBE)
            .withMaxLevel(4)
            .withTarget(TinctureTarget.BOOTS)
            .build()
            .setRegistryName(Habitus.MODID, "feather_falling");
    public static final TinctureEffect BLAST_PROTECTION = new TinctureEffect.Builder("blast_protection")
            .withColor(0xFFDEADBE)
            .withMaxLevel(4)
            .withTarget(TinctureTarget.HEAD)
            .withTarget(TinctureTarget.CHESTPLATE)
            .withTarget(TinctureTarget.LEGGINGS)
            .withTarget(TinctureTarget.BOOTS)
            .withRejection(new ResourceLocation(Habitus.MODID, "protection"))
            .withRejection(new ResourceLocation(Habitus.MODID, "fire_protection"))
            .withRejection(new ResourceLocation(Habitus.MODID, "projectile_protection"))
            .build()
            .setRegistryName(Habitus.MODID, "blast_protection");
    public static final TinctureEffect PROJECTILE_PROTECTION = new TinctureEffect.Builder("projectile_projection")
            .withColor(0xFFDEADBE)
            .withMaxLevel(4)
            .withTarget(TinctureTarget.HEAD)
            .withTarget(TinctureTarget.CHESTPLATE)
            .withTarget(TinctureTarget.LEGGINGS)
            .withTarget(TinctureTarget.BOOTS)
            .withRejection(new ResourceLocation(Habitus.MODID, "protection"))
            .withRejection(new ResourceLocation(Habitus.MODID, "blast_protection"))
            .withRejection(new ResourceLocation(Habitus.MODID, "fire_protection"))
            .build()
            .setRegistryName(Habitus.MODID, "projectile_projection");
    public static final TinctureEffect RESPIRATION = new TinctureEffect.Builder("respiration")
            .withColor(0xFFDEADBE)
            .withMaxLevel(3)
            .withTarget(TinctureTarget.HEAD)
            .build()
            .setRegistryName(Habitus.MODID, "respiration");
    public static final TinctureEffect AQUA_AFFINITY = new TinctureEffect.Builder("aqua_affinity")
            .withColor(0xFFDEADBE)
            .withMaxLevel(1)
            .withTarget(TinctureTarget.HEAD)
            .build()
            .setRegistryName(Habitus.MODID, "aqua_affinity");
    public static final TinctureEffect THORNS = new TinctureEffect.Builder("thorns")
            .withColor(0xFFDEADBE)
            .withMaxLevel(3)
            .withTarget(TinctureTarget.HEAD)
            .withTarget(TinctureTarget.CHESTPLATE)
            .withTarget(TinctureTarget.LEGGINGS)
            .withTarget(TinctureTarget.BOOTS)
            .build()
            .setRegistryName(Habitus.MODID, "thorns");
    public static final TinctureEffect DEPTH_STRIDER = new TinctureEffect.Builder("depth_strider")
            .withColor(0xFFDEADBE)
            .withMaxLevel(3)
            .withTarget(TinctureTarget.BOOTS)
            .withRejection(new ResourceLocation(Habitus.MODID, "frost_walker"))
            .build()
            .setRegistryName(Habitus.MODID, "depth_strider");
    public static final TinctureEffect FROST_WALKER = new TinctureEffect.Builder("frost_walker")
            .withColor(0xFFDEADBE)
            .withMaxLevel(3)
            .withTarget(TinctureTarget.BOOTS)
            .withRejection(new ResourceLocation(Habitus.MODID, "depth_strider"))
            .build()
            .setRegistryName(Habitus.MODID, "frost_walker");
    public static final TinctureEffect SOUL_SPEED = new TinctureEffect.Builder("soul_speed")
            .withColor(0xFFDEADBE)
            .withMaxLevel(3)
            .withTarget(TinctureTarget.BOOTS)
            .build()
            .setRegistryName(Habitus.MODID, "soul_speed");
    public static final TinctureEffect SHARPNESS = new TinctureEffect.Builder("sharpness")
            .withColor(0xFFDEADBE)
            .withMaxLevel(5)
            .withTarget(TinctureTarget.SWORD)
            .withRejection(new ResourceLocation(Habitus.MODID, "bane_of_arthropods"))
            .withRejection(new ResourceLocation(Habitus.MODID, "smite"))
            .build()
            .setRegistryName(Habitus.MODID, "sharpness");
    public static final TinctureEffect SMITE = new TinctureEffect.Builder("smite")
            .withColor(0xFFDEADBE)
            .withMaxLevel(5)
            .withTarget(TinctureTarget.SWORD)
            .withRejection(new ResourceLocation(Habitus.MODID, "bane_of_arthropods"))
            .withRejection(new ResourceLocation(Habitus.MODID, "sharpness"))
            .build()
            .setRegistryName(Habitus.MODID, "smite");
    public static final TinctureEffect BANE_OF_ARTHROPODS = new TinctureEffect.Builder("bane_of_arthropods")
            .withColor(0xFFDEADBE)
            .withMaxLevel(5)
            .withTarget(TinctureTarget.SWORD)
            .withRejection(new ResourceLocation(Habitus.MODID, "sharpness"))
            .withRejection(new ResourceLocation(Habitus.MODID, "smite"))
            .build()
            .setRegistryName(Habitus.MODID, "bane_of_arthropods");
    public static final TinctureEffect KNOCKBACK = new TinctureEffect.Builder("knockback")
            .withColor(0xFFDEADBE)
            .withMaxLevel(2)
            .withTarget(TinctureTarget.SWORD)
            .build()
            .setRegistryName(Habitus.MODID, "knockback");

    public static void registerTinctureEffects(RegistryEvent.Register<TinctureEffect> evt) {

    }
}
