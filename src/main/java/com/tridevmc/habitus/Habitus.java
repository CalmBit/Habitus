package com.tridevmc.habitus;

import com.tridevmc.habitus.entity.EntityCorpse;
import com.tridevmc.habitus.init.HSBlocks;
import com.tridevmc.habitus.init.HSCorpses;
import com.tridevmc.habitus.init.HSEntities;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.IForgeRegistry;
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
    public static final CorpseRegistryCallbacks CORPSE_CALLBACK_INSTANCE = new CorpseRegistryCallbacks();
    private static IForgeRegistry<Corpse> corpseRegistry = null;

    private static final ResourceLocation CORPSE_REGISTRY_NAME = new ResourceLocation(MODID, "corpses");

    public Habitus() {
        // Register the setup method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        // Register the enqueueIMC method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);
        // Register the processIMC method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::processIMC);
        // Register the doClientStuff method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);


    }

    private void setup(final FMLCommonSetupEvent event)
    {
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
        HSEntities.registerRenderers();
    }

    private void enqueueIMC(final InterModEnqueueEvent event)
    {

    }

    private void processIMC(final InterModProcessEvent event)
    {

    }

    @SubscribeEvent
    public void onMobDeath(final LivingDeathEvent evt) {
        if(!evt.getEntity().world.isRemote) {
            LivingEntity ent = evt.getEntityLiving();
            if(corpseRegistry == null)
                corpseRegistry = GameRegistry.findRegistry(Corpse.class);
            if(corpseRegistry != null) {
                Corpse c = corpseRegistry.getValue(evt.getEntity().getType().getRegistryName());
                if(c != null) {
                    EntityCorpse corpse = c.createEntity(ent, ent.world);
                    corpse.copyEntityData(ent);
                    ent.remove();
                }
            }
        }
    }

    @SubscribeEvent
    public void onMobDamage(final LivingDamageEvent evt) {
        if(evt.getEntityLiving().getHealth() < evt.getEntityLiving().getMaxHealth() * 0.45) {
            evt.getEntityLiving().addPotionEffect(new EffectInstance(Effects.SLOWNESS, 300, 1));
        }
    }

    @SubscribeEvent
    public void onMobDrop(final LivingDropsEvent evt) {
        if(!evt.getEntity().world.isRemote) {
            LivingEntity ent = evt.getEntityLiving();
            if (corpseRegistry == null)
                corpseRegistry = GameRegistry.findRegistry(Corpse.class);
            if (corpseRegistry != null) {
                Corpse c = corpseRegistry.getValue(evt.getEntity().getType().getRegistryName());
                if (c != null) {
                    evt.getDrops().clear();
                }
            }
        }
    }

    @Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {

        @SubscribeEvent
        public static void onBlocksRegistry(final RegistryEvent.Register<Block> evt) {
            HSBlocks.registerBlock(evt);
        }

        @SubscribeEvent
        public static void onItemsRegistry(final RegistryEvent.Register<Item> evt) {
            HSBlocks.registerItemBlocks(evt);
        }

        @SubscribeEvent
        public static void onEntityRegistry(final RegistryEvent.Register<EntityType<?>> evt) {
            HSEntities.registerEntities(evt);
        }

        @SubscribeEvent
        public static void onRegistryCreation(final RegistryEvent.NewRegistry evt) {
            new RegistryBuilder()
                    .setName(CORPSE_REGISTRY_NAME)
                    .setType(Corpse.class)
                    .add(CORPSE_CALLBACK_INSTANCE)
                    .create();
        }

        @SubscribeEvent
        public static void onCorpseRegistry(final RegistryEvent.Register<Corpse> evt) {
            HSCorpses.registerCorpses(evt);
        }
    }
}
