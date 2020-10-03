package com.tridevmc.habitus.util;

import com.tridevmc.habitus.Tincture;
import com.tridevmc.habitus.init.HSTinctures;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.EffectUtils;
import net.minecraft.potion.Potion;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.*;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.registries.IForgeRegistry;

import java.util.List;

public class TinctureUtils {
    private static IForgeRegistry<Tincture> TINCTURE_REGISTRY = null;

    public static ItemStack addTinctureToItemStack(ItemStack itemIn, Tincture tincture) {
        ResourceLocation resourcelocation = getTinctureRegistry().getKey(tincture);
        if (tincture == HSTinctures.EMPTY) {
            itemIn.removeChildTag("Tincture");
        } else {
            itemIn.getOrCreateTag().putString("Tincture", resourcelocation.toString());
        }

        return itemIn;
    }

    private static IForgeRegistry<Tincture> getTinctureRegistry() {
        if (TINCTURE_REGISTRY == null) {
            TINCTURE_REGISTRY = GameRegistry.findRegistry(Tincture.class);
        }
        return TINCTURE_REGISTRY;
    }

    public static List<EffectInstance> getEffectsFromStack(ItemStack stack) {
        return getEffectsFromTag(stack.getTag());
    }

    public static List<EffectInstance> getEffectsFromTag(CompoundNBT tag) {
        Tincture t = getTinctureFromNBT(tag);

        if(t == null) {
            return HSTinctures.EMPTY.getEffects();
        }

        return t.getEffects();
    }

    public static List<EffectInstance> getRejectionsFromStack(ItemStack stack) {
        return getRejectionsFromTag(stack.getTag());
    }

    public static List<EffectInstance> getRejectionsFromTag(CompoundNBT tag) {
        Tincture t = getTinctureFromNBT(tag);

        if(t == null) {
            return HSTinctures.EMPTY.getRejections();
        }

        return t.getRejections();
    }

    public static Tincture getTinctureFromNBT(CompoundNBT tag) {
        if(tag == null) {
            return HSTinctures.EMPTY;
        }
        String tinctureType = tag.getString("Tincture");
        if(tinctureType.isEmpty()) {
            return HSTinctures.EMPTY;
        }
        return getTinctureRegistry().getValue(new ResourceLocation(tinctureType));
    }

    public static void addTinctureTooltip(ItemStack stack, List<ITextComponent> tooltip, float durationFactor) {
        List<EffectInstance> list = getEffectsFromStack(stack);
        if (list.isEmpty()) {
            tooltip.add((new TranslationTextComponent("effect.none")).mergeStyle(TextFormatting.GRAY));
        } else {
            for(EffectInstance effectinstance : list) {
                Effect effect = effectinstance.getPotion();
                TextComponent itextcomponent = new TranslationTextComponent(effectinstance.getEffectName());


                if (effectinstance.getAmplifier() > 0) {
                    itextcomponent = (TextComponent) itextcomponent.append(new StringTextComponent(" "))
                                                   .append(new TranslationTextComponent("habitus.tincture.potency." + effectinstance.getAmplifier()));
                }

                if (effectinstance.getDuration() > 20) {
                    itextcomponent = (TextComponent) itextcomponent.append(new StringTextComponent(" ("))
                                  .append(new StringTextComponent(EffectUtils.getPotionDurationString(effectinstance, durationFactor)))
                                  .append(new StringTextComponent(")"));
                }

                tooltip.add(itextcomponent.mergeStyle(effect.getEffectType().getColor()));
            }
        }
    }

    public static Tincture getTinctureFromItem(ItemStack stack) {
        return getTinctureFromNBT(stack.getTag());
    }
}
