package com.tridevmc.habitus.init;

import com.tridevmc.habitus.Habitus;
import com.tridevmc.habitus.blocks.BlockButcherTable;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.BlockItem;
import net.minecraftforge.event.RegistryEvent;

public class HSBlocks {
    public static final Block BUTCHER_TABLE = new BlockButcherTable().setRegistryName(Habitus.MODID, "butcher_table");
    public static final Item ITEM_BUTCHER_TABLE = new BlockItem(BUTCHER_TABLE, new Item.Properties().maxStackSize(1)).setRegistryName(BUTCHER_TABLE.getRegistryName());
    public static void registerBlock(RegistryEvent.Register<Block> evt) {
        evt.getRegistry().registerAll(BUTCHER_TABLE);
    }
    public static void registerItemBlocks(RegistryEvent.Register<Item> evt) {
        evt.getRegistry().registerAll(ITEM_BUTCHER_TABLE);
    }
}
