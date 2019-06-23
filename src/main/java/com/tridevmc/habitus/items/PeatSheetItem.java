package com.tridevmc.habitus.items;

import com.tridevmc.habitus.Habitus;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class PeatSheetItem extends Item {
    public PeatSheetItem() {
        super(new Item.Properties().group(Habitus.HABITUS));
    }

    @Override
    public int getBurnTime(ItemStack itemStack) {
        return 400;
    }
}
