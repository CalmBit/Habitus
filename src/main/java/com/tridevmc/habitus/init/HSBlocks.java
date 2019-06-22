package com.tridevmc.habitus.init;

import com.tridevmc.habitus.Habitus;
import com.tridevmc.habitus.blocks.ButcherTableBlock;
import com.tridevmc.habitus.blocks.DeadLogBlock;
import com.tridevmc.habitus.blocks.DeadPlanksBlock;
import com.tridevmc.habitus.blocks.PeatBlock;
import com.tridevmc.habitus.items.PeatBlockItem;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.BlockItem;
import net.minecraftforge.event.RegistryEvent;

public class HSBlocks {
    public static final Block BUTCHER_TABLE = new ButcherTableBlock().setRegistryName(Habitus.MODID, "butcher_table");
    public static final Block DEAD_LOG = new DeadLogBlock().setRegistryName(Habitus.MODID, "dead_log");
    public static final Block DEAD_PLANKS = new DeadPlanksBlock().setRegistryName(Habitus.MODID, "dead_planks");
    public static final Block PEAT = new PeatBlock().setRegistryName(Habitus.MODID, "peat");

    public static final Item ITEM_BUTCHER_TABLE = createBlockItem(BUTCHER_TABLE, new Item.Properties().maxStackSize(1));

    public static void registerBlock(RegistryEvent.Register<Block> evt) {
        evt.getRegistry().registerAll(
                BUTCHER_TABLE,
                DEAD_LOG,
                DEAD_PLANKS,
                PEAT);
    }
    public static void registerItemBlocks(RegistryEvent.Register<Item> evt) {
        evt.getRegistry().registerAll(
                ITEM_BUTCHER_TABLE,
                createBlockItem(DEAD_LOG),
                createBlockItem(DEAD_PLANKS),
                new PeatBlockItem().setRegistryName(PEAT.getRegistryName())
        );
    }

    public static BlockItem createBlockItem(Block block, Item.Properties properties) {
        return (BlockItem) new BlockItem(block, properties).setRegistryName(block.getRegistryName());
    }

    public static BlockItem createBlockItem(Block block) {
        return createBlockItem(block, new Item.Properties());
    }
}
