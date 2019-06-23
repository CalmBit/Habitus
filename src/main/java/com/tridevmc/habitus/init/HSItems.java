package com.tridevmc.habitus.init;

import com.tridevmc.habitus.Habitus;
import com.tridevmc.habitus.items.*;
import net.minecraft.item.Item;
import net.minecraft.item.ItemTier;
import net.minecraft.item.Rarity;
import net.minecraft.util.IItemProvider;
import net.minecraftforge.event.RegistryEvent;

public class HSItems {
    public static final Item STONE_CLEAVER = new CleaverItem(ItemTier.STONE, 3.0f, -2.0f, new Item.Properties().group(Habitus.HABITUS)).setRegistryName(Habitus.MODID, "stone_cleaver");
    public static final Item IRON_CLEAVER = new CleaverItem(ItemTier.IRON, 3.0f,-2.0f,  new Item.Properties().group(Habitus.HABITUS)).setRegistryName(Habitus.MODID, "iron_cleaver");
    public static final Item GOLD_CLEAVER = new CleaverItem(ItemTier.GOLD, 3.0f,-2.0f, new Item.Properties().group(Habitus.HABITUS)).setRegistryName(Habitus.MODID, "gold_cleaver");
    public static final Item DIAMOND_CLEAVER = new CleaverItem(ItemTier.DIAMOND, 3.0f,-2.0f, new Item.Properties().group(Habitus.HABITUS)).setRegistryName(Habitus.MODID, "diamond_cleaver");

    public static final Item MUSIC_DISC_CALM1 = new BackgroundDiscItem(1, HSSounds.MUSIC_DISC_CALM1, new Item.Properties().maxStackSize(1).rarity(Rarity.RARE).group(Habitus.HABITUS))
            .setRegistryName(Habitus.MODID, "music_disc_calm1");
    public static final Item MUSIC_DISC_CALM2 = new BackgroundDiscItem(2, HSSounds.MUSIC_DISC_CALM2, new Item.Properties().maxStackSize(1).rarity(Rarity.RARE).group(Habitus.HABITUS))
            .setRegistryName(Habitus.MODID, "music_disc_calm2");
    public static final Item MUSIC_DISC_CALM3 = new BackgroundDiscItem(3, HSSounds.MUSIC_DISC_CALM3, new Item.Properties().maxStackSize(1).rarity(Rarity.RARE).group(Habitus.HABITUS))
            .setRegistryName(Habitus.MODID, "music_disc_calm3");
    public static final Item MUSIC_DISC_HAL1 = new BackgroundDiscItem(4, HSSounds.MUSIC_DISC_HAL1, new Item.Properties().maxStackSize(1).rarity(Rarity.RARE).group(Habitus.HABITUS))
            .setRegistryName(Habitus.MODID, "music_disc_hal1");
    public static final Item MUSIC_DISC_HAL2 = new BackgroundDiscItem(5, HSSounds.MUSIC_DISC_HAL2, new Item.Properties().maxStackSize(1).rarity(Rarity.RARE).group(Habitus.HABITUS))
            .setRegistryName(Habitus.MODID, "music_disc_hal2");
    public static final Item MUSIC_DISC_HAL3 = new BackgroundDiscItem(6, HSSounds.MUSIC_DISC_HAL3, new Item.Properties().maxStackSize(1).rarity(Rarity.RARE).group(Habitus.HABITUS))
            .setRegistryName(Habitus.MODID, "music_disc_hal3");
    public static final Item MUSIC_DISC_HAL4 = new BackgroundDiscItem(7, HSSounds.MUSIC_DISC_HAL4, new Item.Properties().maxStackSize(1).rarity(Rarity.RARE).group(Habitus.HABITUS))
            .setRegistryName(Habitus.MODID, "music_disc_hal4");
    public static final Item MUSIC_DISC_NUANCE1 = new BackgroundDiscItem(8, HSSounds.MUSIC_DISC_NUANCE1, new Item.Properties().maxStackSize(1).rarity(Rarity.RARE).group(Habitus.HABITUS))
            .setRegistryName(Habitus.MODID, "music_disc_nuance1");
    public static final Item MUSIC_DISC_NUANCE2 = new BackgroundDiscItem(9, HSSounds.MUSIC_DISC_NUANCE2, new Item.Properties().maxStackSize(1).rarity(Rarity.RARE).group(Habitus.HABITUS))
            .setRegistryName(Habitus.MODID, "music_disc_nuance2");
    public static final Item MUSIC_DISC_PIANO1 = new BackgroundDiscItem(10, HSSounds.MUSIC_DISC_PIANO1, new Item.Properties().maxStackSize(1).rarity(Rarity.RARE).group(Habitus.HABITUS))
            .setRegistryName(Habitus.MODID, "music_disc_piano1");
    public static final Item MUSIC_DISC_PIANO2 = new BackgroundDiscItem(11, HSSounds.MUSIC_DISC_PIANO2, new Item.Properties().maxStackSize(1).rarity(Rarity.RARE).group(Habitus.HABITUS))
            .setRegistryName(Habitus.MODID, "music_disc_piano2");
    public static final Item MUSIC_DISC_PIANO3 = new BackgroundDiscItem(12, HSSounds.MUSIC_DISC_PIANO3, new Item.Properties().maxStackSize(1).rarity(Rarity.RARE).group(Habitus.HABITUS))
            .setRegistryName(Habitus.MODID, "music_disc_piano3");

    public static final Item MUSIC_DISC_MENU1 = new BackgroundDiscItem(3, HSSounds.MUSIC_DISC_MENU1, new Item.Properties().maxStackSize(1).rarity(Rarity.RARE).group(Habitus.HABITUS))
            .setRegistryName(Habitus.MODID, "music_disc_menu1");
    public static final Item MUSIC_DISC_MENU2 = new BackgroundDiscItem(7, HSSounds.MUSIC_DISC_MENU2, new Item.Properties().maxStackSize(1).rarity(Rarity.RARE).group(Habitus.HABITUS))
            .setRegistryName(Habitus.MODID, "music_disc_menu2");
    public static final Item MUSIC_DISC_MENU3 = new BackgroundDiscItem(11, HSSounds.MUSIC_DISC_MENU3, new Item.Properties().maxStackSize(1).rarity(Rarity.RARE).group(Habitus.HABITUS))
            .setRegistryName(Habitus.MODID, "music_disc_menu3");
    public static final Item MUSIC_DISC_MENU4 = new BackgroundDiscItem(15, HSSounds.MUSIC_DISC_MENU4, new Item.Properties().maxStackSize(1).rarity(Rarity.RARE).group(Habitus.HABITUS))
            .setRegistryName(Habitus.MODID, "music_disc_menu4");

    public static final Item MUSIC_DISC_NETHER1 = new BackgroundDiscItem(3, HSSounds.MUSIC_DISC_NETHER1, new Item.Properties().maxStackSize(1).rarity(Rarity.RARE).group(Habitus.HABITUS))
            .setRegistryName(Habitus.MODID, "music_disc_nether1");
    public static final Item MUSIC_DISC_NETHER2 = new BackgroundDiscItem(7, HSSounds.MUSIC_DISC_NETHER2, new Item.Properties().maxStackSize(1).rarity(Rarity.RARE).group(Habitus.HABITUS))
            .setRegistryName(Habitus.MODID, "music_disc_nether2");
    public static final Item MUSIC_DISC_NETHER3 = new BackgroundDiscItem(11, HSSounds.MUSIC_DISC_NETHER3, new Item.Properties().maxStackSize(1).rarity(Rarity.RARE).group(Habitus.HABITUS))
            .setRegistryName(Habitus.MODID, "music_disc_nether3");
    public static final Item MUSIC_DISC_NETHER4 = new BackgroundDiscItem(15, HSSounds.MUSIC_DISC_NETHER4, new Item.Properties().maxStackSize(1).rarity(Rarity.RARE).group(Habitus.HABITUS))
            .setRegistryName(Habitus.MODID, "music_disc_nether4");

    public static final Item MUSIC_DISC_CREATIVE1 = new BackgroundDiscItem(3, HSSounds.MUSIC_DISC_CREATIVE1, new Item.Properties().maxStackSize(1).rarity(Rarity.RARE).group(Habitus.HABITUS))
            .setRegistryName(Habitus.MODID, "music_disc_creative1");
    public static final Item MUSIC_DISC_CREATIVE2 = new BackgroundDiscItem(7, HSSounds.MUSIC_DISC_CREATIVE2, new Item.Properties().maxStackSize(1).rarity(Rarity.RARE).group(Habitus.HABITUS))
            .setRegistryName(Habitus.MODID, "music_disc_creative2");
    public static final Item MUSIC_DISC_CREATIVE3 = new BackgroundDiscItem(11, HSSounds.MUSIC_DISC_CREATIVE3, new Item.Properties().maxStackSize(1).rarity(Rarity.RARE).group(Habitus.HABITUS))
            .setRegistryName(Habitus.MODID, "music_disc_creative3");
    public static final Item MUSIC_DISC_CREATIVE4 = new BackgroundDiscItem(15, HSSounds.MUSIC_DISC_CREATIVE4, new Item.Properties().maxStackSize(1).rarity(Rarity.RARE).group(Habitus.HABITUS))
            .setRegistryName(Habitus.MODID, "music_disc_creative4");
    public static final Item MUSIC_DISC_CREATIVE5 = new BackgroundDiscItem(11, HSSounds.MUSIC_DISC_CREATIVE5, new Item.Properties().maxStackSize(1).rarity(Rarity.RARE).group(Habitus.HABITUS))
            .setRegistryName(Habitus.MODID, "music_disc_creative5");
    public static final Item MUSIC_DISC_CREATIVE6 = new BackgroundDiscItem(15, HSSounds.MUSIC_DISC_CREATIVE6, new Item.Properties().maxStackSize(1).rarity(Rarity.RARE).group(Habitus.HABITUS))
            .setRegistryName(Habitus.MODID, "music_disc_creative6");

    public static final Item ELIXIR = new ElixirItem(new Item.Properties().maxStackSize(1).group(Habitus.HABITUS).maxDamage(3))
            .setRegistryName(Habitus.MODID, "elixir");
    public static final Item ELIXIR_BOTTLE = new ElixirBottleItem(new Item.Properties().maxStackSize(16).group(Habitus.HABITUS))
            .setRegistryName(Habitus.MODID, "elixir_bottle");
    public static final Item TINCTURE = new TinctureItem(new Item.Properties().maxStackSize(1).group(Habitus.HABITUS))
            .setRegistryName(Habitus.MODID, "tincture");
    public static final Item TINCTURE_BOTTLE = new TinctureBottleItem(new Item.Properties().maxStackSize(16).group(Habitus.HABITUS))
            .setRegistryName(Habitus.MODID, "tincture_bottle");

    public static final Item PEAT_BALL = new PeatBallItem()
            .setRegistryName(Habitus.MODID, "peat_ball");
    public static final Item PEAT_SHEET = new PeatSheetItem()
            .setRegistryName(Habitus.MODID, "peat_sheet");
    public static final Item UNFIRED_PEAT_BRIQUETTE = new UnfiredPeatBriquetteItem()
            .setRegistryName(Habitus.MODID, "unfired_peat_briquette");
    public static final Item PEAT_BRIQUETTE = new PeatBriquetteItem()
            .setRegistryName(Habitus.MODID, "peat_briquette");

    public static void registerItems(RegistryEvent.Register<Item> evt) {
        evt.getRegistry().registerAll(
                STONE_CLEAVER,
                IRON_CLEAVER,
                GOLD_CLEAVER,
                DIAMOND_CLEAVER,

                MUSIC_DISC_CALM1,
                MUSIC_DISC_CALM2,
                MUSIC_DISC_CALM3,
                MUSIC_DISC_HAL1,
                MUSIC_DISC_HAL2,
                MUSIC_DISC_HAL3,
                MUSIC_DISC_HAL4,
                MUSIC_DISC_NUANCE1,
                MUSIC_DISC_NUANCE2,
                MUSIC_DISC_PIANO1,
                MUSIC_DISC_PIANO2,
                MUSIC_DISC_PIANO3,

                MUSIC_DISC_MENU1,
                MUSIC_DISC_MENU2,
                MUSIC_DISC_MENU3,
                MUSIC_DISC_MENU4,

                MUSIC_DISC_NETHER1,
                MUSIC_DISC_NETHER2,
                MUSIC_DISC_NETHER3,
                MUSIC_DISC_NETHER4,

                MUSIC_DISC_CREATIVE1,
                MUSIC_DISC_CREATIVE2,
                MUSIC_DISC_CREATIVE3,
                MUSIC_DISC_CREATIVE4,
                MUSIC_DISC_CREATIVE5,
                MUSIC_DISC_CREATIVE6,

                ELIXIR,
                ELIXIR_BOTTLE,
                TINCTURE,
                TINCTURE_BOTTLE,

                PEAT_BALL,
                PEAT_SHEET,
                UNFIRED_PEAT_BRIQUETTE,
                PEAT_BRIQUETTE
        );
    }
}
