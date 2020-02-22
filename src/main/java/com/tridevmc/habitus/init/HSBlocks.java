package com.tridevmc.habitus.init;

import com.tridevmc.habitus.Habitus;
import com.tridevmc.habitus.blocks.*;
import com.tridevmc.habitus.items.PeatBlockItem;
import net.minecraft.block.Block;
import net.minecraft.block.SlabBlock;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.item.Item;
import net.minecraft.item.BlockItem;
import net.minecraftforge.event.RegistryEvent;

public class HSBlocks {
    public static final Block BUTCHER_TABLE = new ButcherTableBlock()
            .setRegistryName(Habitus.MODID, "butcher_table");
    public static final Block DEAD_LOG = new DeadLogBlock()
            .setRegistryName(Habitus.MODID, "dead_log");
    public static final Block DEAD_PLANKS = new DeadPlanksBlock()
            .setRegistryName(Habitus.MODID, "dead_planks");
    public static final Block PEAT = new PeatBlock()
            .setRegistryName(Habitus.MODID, "peat");
    public static final Block SLATE = new DecoStoneBlock()
            .setRegistryName(Habitus.MODID, "slate");
    public static final Block LIMESTONE = new DecoStoneBlock()
            .setRegistryName(Habitus.MODID, "limestone");
    public static final Block MARBLE = new DecoStoneBlock()
            .setRegistryName(Habitus.MODID, "marble");
    public static final Block POLISHED_SLATE = new DecoStoneBlock()
            .setRegistryName(Habitus.MODID, "polished_slate");
    public static final Block POLISHED_LIMESTONE = new DecoStoneBlock()
            .setRegistryName(Habitus.MODID, "polished_limestone");
    public static final Block POLISHED_MARBLE = new DecoStoneBlock()
            .setRegistryName(Habitus.MODID, "polished_marble");
    public static final Block SLATE_BRICK = new DecoStoneBlock()
            .setRegistryName(Habitus.MODID, "slate_brick");
    public static final Block LIMESTONE_BRICK = new DecoStoneBlock()
            .setRegistryName(Habitus.MODID, "limestone_brick");
    public static final Block MARBLE_BRICK = new DecoStoneBlock()
            .setRegistryName(Habitus.MODID, "marble_brick");
    public static final Block CRACKED_SLATE_BRICK = new DecoStoneBlock()
            .setRegistryName(Habitus.MODID, "cracked_slate_brick");
    public static final Block CRACKED_LIMESTONE_BRICK = new DecoStoneBlock()
            .setRegistryName(Habitus.MODID, "cracked_limestone_brick");
    public static final Block CRACKED_MARBLE_BRICK = new DecoStoneBlock()
            .setRegistryName(Habitus.MODID, "cracked_marble_brick");
    public static final Block CHISELED_SLATE_BRICK = new DecoStoneBlock()
            .setRegistryName(Habitus.MODID, "chiseled_slate_brick");
    public static final Block CHISELED_LIMESTONE_BRICK = new DecoStoneBlock()
            .setRegistryName(Habitus.MODID, "chiseled_limestone_brick");
    public static final Block CHISELED_MARBLE_BRICK = new DecoStoneBlock()
            .setRegistryName(Habitus.MODID, "chiseled_marble_brick");
    public static final Block SLATE_SLAB = new DecoStoneSlabBlock(SLATE)
            .setRegistryName(Habitus.MODID, "slate_slab");
    public static final Block LIMESTONE_SLAB = new DecoStoneSlabBlock(LIMESTONE)
            .setRegistryName(Habitus.MODID, "limestone_slab");
    public static final Block MARBLE_SLAB = new DecoStoneSlabBlock(MARBLE)
            .setRegistryName(Habitus.MODID, "marble_slab");
    public static final Block SLATE_BRICK_SLAB = new DecoStoneSlabBlock(SLATE_BRICK)
            .setRegistryName(Habitus.MODID, "slate_brick_slab");
    public static final Block LIMESTONE_BRICK_SLAB = new DecoStoneSlabBlock(LIMESTONE_BRICK)
            .setRegistryName(Habitus.MODID, "limestone_brick_slab");
    public static final Block MARBLE_BRICK_SLAB = new DecoStoneSlabBlock(MARBLE_BRICK)
            .setRegistryName(Habitus.MODID, "marble_brick_slab");
    public static final Block SLATE_WALL = new DecoStoneWallBlock(SLATE)
            .setRegistryName(Habitus.MODID, "slate_wall");
    public static final Block LIMESTONE_WALL = new DecoStoneWallBlock(LIMESTONE)
            .setRegistryName(Habitus.MODID, "limestone_wall");
    public static final Block MARBLE_WALL = new DecoStoneWallBlock(MARBLE)
            .setRegistryName(Habitus.MODID, "marble_wall");
    public static final Block SLATE_BRICK_WALL = new DecoStoneWallBlock(SLATE_BRICK)
            .setRegistryName(Habitus.MODID, "slate_brick_wall");
    public static final Block LIMESTONE_BRICK_WALL = new DecoStoneWallBlock(LIMESTONE_BRICK)
            .setRegistryName(Habitus.MODID, "limestone_brick_wall");
    public static final Block MARBLE_BRICK_WALL = new DecoStoneWallBlock(MARBLE_BRICK)
            .setRegistryName(Habitus.MODID, "marble_brick_wall");
    public static final Block DEAD_SLAB = new WoodSlabBlock(DEAD_PLANKS)
            .setRegistryName(Habitus.MODID, "dead_slab");
    public static final Block TINCTURE_STAND = new TinctureStandBlock()
            .setRegistryName(Habitus.MODID, "tincture_stand");


    public static final Item ITEM_BUTCHER_TABLE = createBlockItem(BUTCHER_TABLE, new Item.Properties()
            .maxStackSize(1)
            .group(Habitus.HABITUS));


    public static void registerBlock(RegistryEvent.Register<Block> evt) {
        evt.getRegistry().registerAll(
                BUTCHER_TABLE,
                DEAD_LOG,
                DEAD_PLANKS,
                PEAT,
                SLATE,
                POLISHED_SLATE,
                SLATE_BRICK,
                CRACKED_SLATE_BRICK,
                CHISELED_SLATE_BRICK,
                LIMESTONE,
                POLISHED_LIMESTONE,
                LIMESTONE_BRICK,
                CRACKED_LIMESTONE_BRICK,
                CHISELED_LIMESTONE_BRICK,
                MARBLE,
                POLISHED_MARBLE,
                MARBLE_BRICK,
                CRACKED_MARBLE_BRICK,
                CHISELED_MARBLE_BRICK,
                SLATE_SLAB,
                LIMESTONE_SLAB,
                MARBLE_SLAB,
                SLATE_BRICK_SLAB,
                LIMESTONE_BRICK_SLAB,
                MARBLE_BRICK_SLAB,
                SLATE_WALL,
                LIMESTONE_WALL,
                MARBLE_WALL,
                SLATE_BRICK_WALL,
                LIMESTONE_BRICK_WALL,
                MARBLE_BRICK_WALL,
                DEAD_SLAB,
                TINCTURE_STAND
        );

        RenderTypeLookup.setRenderLayer(TINCTURE_STAND, RenderType.getCutout());
    }
    public static void registerItemBlocks(RegistryEvent.Register<Item> evt) {
        evt.getRegistry().registerAll(
                ITEM_BUTCHER_TABLE,
                createBlockItem(DEAD_LOG),
                createBlockItem(DEAD_PLANKS),
                new PeatBlockItem()
                        .setRegistryName(PEAT.getRegistryName()),
                createBlockItem(SLATE),
                createBlockItem(POLISHED_SLATE),
                createBlockItem(SLATE_BRICK),
                createBlockItem(CRACKED_SLATE_BRICK),
                createBlockItem(CHISELED_SLATE_BRICK),
                createBlockItem(LIMESTONE),
                createBlockItem(POLISHED_LIMESTONE),
                createBlockItem(LIMESTONE_BRICK),
                createBlockItem(CRACKED_LIMESTONE_BRICK),
                createBlockItem(CHISELED_LIMESTONE_BRICK),
                createBlockItem(MARBLE),
                createBlockItem(POLISHED_MARBLE),
                createBlockItem(MARBLE_BRICK),
                createBlockItem(CRACKED_MARBLE_BRICK),
                createBlockItem(CHISELED_MARBLE_BRICK),
                createBlockItem(SLATE_SLAB),
                createBlockItem(LIMESTONE_SLAB),
                createBlockItem(MARBLE_SLAB),
                createBlockItem(SLATE_BRICK_SLAB),
                createBlockItem(LIMESTONE_BRICK_SLAB),
                createBlockItem(MARBLE_BRICK_SLAB),
                createBlockItem(SLATE_WALL),
                createBlockItem(LIMESTONE_WALL),
                createBlockItem(MARBLE_WALL),
                createBlockItem(SLATE_BRICK_WALL),
                createBlockItem(LIMESTONE_BRICK_WALL),
                createBlockItem(MARBLE_BRICK_WALL),
                createBlockItem(DEAD_SLAB),
                createBlockItem(TINCTURE_STAND)
        );
    }

    public static BlockItem createBlockItem(Block block, Item.Properties properties) {
        return (BlockItem) new BlockItem(block, properties)
            .setRegistryName(block.getRegistryName());
    }

    public static BlockItem createBlockItem(Block block) {
        return createBlockItem(block, new Item.Properties().group(Habitus.HABITUS));
    }
}
