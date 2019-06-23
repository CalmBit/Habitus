package com.tridevmc.habitus.items;

import com.tridevmc.habitus.Habitus;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class PeatBriquetteItem extends Item {
    public PeatBriquetteItem() {
        super(new Item.Properties().group(Habitus.HABITUS));
    }

    @Override
    public int getBurnTime(ItemStack itemStack) {
        return 1600;
    }
}
