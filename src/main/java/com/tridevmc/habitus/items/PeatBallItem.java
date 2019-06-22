package com.tridevmc.habitus.items;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class PeatBallItem extends Item {
    public PeatBallItem() {
        super(new Item.Properties());
    }

    @Override
    public int getBurnTime(ItemStack itemStack) {
        return 400;
    }
}
