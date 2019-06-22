package com.tridevmc.habitus;

import com.tridevmc.habitus.init.HSItems;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class HabitusItemGroup extends ItemGroup {

    public HabitusItemGroup() {
        super("habitus");
    }

    @Override
    public ItemStack createIcon() {
        return new ItemStack(HSItems.IRON_CLEAVER);
    }
}
