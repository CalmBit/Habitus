package com.tridevmc.habitus;

import com.tridevmc.habitus.client.ElixirColorer;
import com.tridevmc.habitus.init.*;
import com.tridevmc.habitus.tinctures.TinctureEffect;
import com.tridevmc.habitus.world.biome.BiomeFixer;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.Feature;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.*;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.RegistryBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file

@Mod(Habitus.MODID)
public class Habitus
{
    // Directly reference a log4j logger.
    public static final Logger LOGGER = LogManager.getLogger(Habitus.MODID);
    public static final String MODID = "habitus";
    public static final ItemGroup HABITUS = new HabitusItemGroup();

    private static final ResourceLocation TINCTURE_REGISTRY_NAME = new ResourceLocation(MODID, "tinctures");

    public Habitus() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::processIMC);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::loadComplete);
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) {
        BiomeFixer.registerFeatureHooks();
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
        HSEntities.registerRenderers();
    }

    private void enqueueIMC(final InterModEnqueueEvent event) {
    }

    private void processIMC(final InterModProcessEvent event) {
    }

    private void loadComplete(final FMLLoadCompleteEvent event) {
        BiomeFixer.insertFeatures();
    }

    @Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {

        @SubscribeEvent
        public static void onColorRegistry(final ColorHandlerEvent.Item evt) {
            evt.getItemColors().register(new ElixirColorer(), HSItems.ELIXIR);
        }

        @SubscribeEvent
        public static void onBlocksRegistry(final RegistryEvent.Register<Block> evt) {
            HSBlocks.registerBlock(evt);
        }

        @SubscribeEvent
        public static void onItemsRegistry(final RegistryEvent.Register<Item> evt) {
            HSItems.registerItems(evt);
            HSBlocks.registerItemBlocks(evt);
        }

        @SubscribeEvent
        public static void onEntityRegistry(final RegistryEvent.Register<EntityType<?>> evt) {
            HSEntities.registerEntities(evt);
        }

        @SubscribeEvent
        public static void onBiomeRegistry(final RegistryEvent.Register<Biome> evt) {
            HSBiomes.registerBiomes(evt);
        }

        @SubscribeEvent
        public static void onFeatureRegistry(final RegistryEvent.Register<Feature<?>> evt) {
            HSBiomes.registerFeatures(evt);
        }

        @SubscribeEvent
        public static void onSoundEventRegistry(final RegistryEvent.Register<SoundEvent> evt) {
            HSSounds.registerSoundEvents(evt);
        }

        @SubscribeEvent
        public static void onRegistryCreation(final RegistryEvent.NewRegistry evt) {
            new RegistryBuilder<TinctureEffect>()
                    .setName(new ResourceLocation(MODID, "tincture_effects"))
                    .setType(TinctureEffect.class)
                    .create();
        }

        public static void onTincturEffectRegistry(final RegistryEvent.Register<TinctureEffect> evt) {
            HSTinctureEffects.registerTinctureEffects(evt);
        }
    }
}
