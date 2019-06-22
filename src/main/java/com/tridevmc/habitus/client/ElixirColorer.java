package com.tridevmc.habitus.client;

import net.minecraft.client.renderer.color.IItemColor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionUtils;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class ElixirColorer implements IItemColor {
    @Override
    public int getColor(ItemStack stack, int tintIndex) {
        if(tintIndex == 0) {
            return PotionUtils.getColor(stack);
        } else {
            return -1;
        }
    }
}
