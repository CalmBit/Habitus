package com.tridevmc.habitus.items;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class PeatBriquetteItem extends Item {
    public PeatBriquetteItem() {
        super(new Item.Properties());
    }

    @Override
    public int getBurnTime(ItemStack itemStack) {
        return 1600;
    }
}
