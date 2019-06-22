package com.tridevmc.habitus.items;

import com.tridevmc.habitus.Habitus;
import com.tridevmc.habitus.init.HSBlocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class PeatBlockItem extends BlockItem {
    public PeatBlockItem() {
        super(HSBlocks.PEAT, new Item.Properties().group(Habitus.HABITUS));
    }

    @Override
    public int getBurnTime(ItemStack itemStack) {
        return 800;
    }
}
