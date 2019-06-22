package com.tridevmc.habitus.client;

import com.tridevmc.habitus.init.HSTinctures;
import com.tridevmc.habitus.util.TinctureUtils;
import net.minecraft.client.renderer.color.IItemColor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionUtils;
import net.minecraft.potion.Potions;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class TinctureColorer implements IItemColor {

    @Override
    public int getColor(ItemStack stack, int tintIndex) {
        if(tintIndex == 0) {
            return TinctureUtils.getTinctureFromItem(stack) == HSTinctures.EMPTY ? 16253176 : PotionUtils.getPotionColorFromEffectList(TinctureUtils.getEffectsFromStack(stack));
        } else {
            return -1;
        }
    }
}
