package com.tridevmc.habitus;

import com.tridevmc.habitus.client.ElixirColorer;
import com.tridevmc.habitus.client.TinctureColorer;
import com.tridevmc.habitus.entity.Corpse;
import com.tridevmc.habitus.entity.CorpseEntity;
import com.tridevmc.habitus.entity.ai.AvoidCorpseGoal;
import com.tridevmc.habitus.init.*;
import com.tridevmc.habitus.util.CorpseRegistryCallbacks;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.FireBlock;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.player.ClientPlayerEntity;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.potion.Potion;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.Feature;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.entity.living.LivingKnockBackEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DistExecutor;
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
    public static final ItemGroup HABITUS = new HabitusItemGroup();

    public static final CorpseRegistryCallbacks CORPSE_CALLBACK_INSTANCE = new CorpseRegistryCallbacks();
    private static IForgeRegistry<Corpse> corpseRegistry = null;

    private static final ResourceLocation CORPSE_REGISTRY_NAME = new ResourceLocation(MODID, "corpses");
    private static final ResourceLocation TINCTURE_REGISTRY_NAME = new ResourceLocation(MODID, "tinctures");

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
        HSBiomes.setupBiomes();
        ((FireBlock)Blocks.FIRE).setFireInfo(HSBlocks.DEAD_LOG, 80, 100);
        ((FireBlock)Blocks.FIRE).setFireInfo(HSBlocks.DEAD_PLANKS, 10, 30);
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
                    CorpseEntity corpse = c.createEntity(ent, ent.world);
                    ent.remove();
                }
            }
        }
    }

    @SubscribeEvent
    public void onMobDamage(final LivingDamageEvent evt) {
        if(evt.getSource().getImmediateSource() instanceof LivingEntity) {
            LivingEntity attacker = (LivingEntity)evt.getSource().getImmediateSource();
            ItemStack mainHand = attacker.getHeldItemMainhand();

            EffectInstance e = attacker.getActivePotionEffect(HSEffects.FIRE_ASPECT);
            if (e != null && mainHand.canApplyAtEnchantingTable(Enchantments.FIRE_ASPECT)) {
                evt.getEntityLiving().setFire(4 * (e.getAmplifier() + 1));

            }

            EffectInstance sharp = attacker.getActivePotionEffect(HSEffects.SHARPNESS);
            if(sharp != null && mainHand.canApplyAtEnchantingTable(Enchantments.SHARPNESS)) {
                evt.setAmount(evt.getAmount() + (1 + ((0.5f) * sharp.getAmplifier())));
                DistExecutor.runWhenOn(Dist.CLIENT, () -> () -> Minecraft.getInstance().particles.addParticleEmitter(evt.getEntity(), ParticleTypes.ENCHANTED_HIT));
            }
        }

        if(evt.getEntityLiving().getHealth() < evt.getEntityLiving().getMaxHealth() * 0.45) {
            evt.getEntityLiving().addPotionEffect(new EffectInstance(Effects.SLOWNESS, 300, 1));
        }
    }

    @SubscribeEvent
    public void onKnockback(LivingKnockBackEvent evt) {
        if(evt.getAttacker() instanceof LivingEntity) {
            LivingEntity attacker = (LivingEntity) evt.getAttacker();
            ItemStack mainHand = attacker.getHeldItemMainhand();

            EffectInstance knockback = attacker.getActivePotionEffect(HSEffects.KNOCKBACK);
            if (knockback != null && mainHand.canApplyAtEnchantingTable(Enchantments.KNOCKBACK)) {
                float s = evt.getStrength();
                s += 0.5f + (knockback.getAmplifier() * 0.5f);
                evt.setStrength(s);
            }
        }
    }


    @SubscribeEvent
    public void onMobDrop(final LivingDropsEvent evt) {
        if(!evt.getEntity().world.isRemote) {
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

    @SubscribeEvent
    public void onBlockHarvest(BlockEvent.HarvestDropsEvent evt) {
        /*if(!evt.isSilkTouching()) {
            EffectInstance e = evt.getHarvester().getActivePotionEffect(HSEffects.SILK_TOUCH);
            if(e != null && evt.getState().) {
                evt.getDrops().clear();
            }
        }*/
    }

    @SubscribeEvent
    public void onEntityJoin(final EntityJoinWorldEvent evt) {
        try {
            if (corpseRegistry == null)
                corpseRegistry = GameRegistry.findRegistry(Corpse.class);
            if(evt.getEntity() instanceof CreatureEntity && corpseRegistry.containsKey(evt.getEntity().getType().getRegistryName())) {
                CreatureEntity mob = (CreatureEntity)evt.getEntity();
            mob.goalSelector.addGoal(3, new AvoidCorpseGoal(mob, 6.0f, 1.0D, 1.2D));
        }}
        catch(Exception e) {
            LOGGER.error(e);
        }
    }

    // venting my FRUSTRATION
    @Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.FORGE)
    public static class ForgeVents {
        @SubscribeEvent
        public static void onColorRegistry(final ColorHandlerEvent.Item evt) {
            evt.getItemColors().register(new ElixirColorer(), HSItems.ELIXIR);
            evt.getItemColors().register(new TinctureColorer(), HSItems.TINCTURE);
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
            BiomeManager.addBiome(BiomeManager.BiomeType.WARM, new BiomeManager.BiomeEntry(HSBiomes.DEAD_FOREST, 10));
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
        public static void onEffectRegistry(final RegistryEvent.Register<Effect> evt) {
            HSEffects.registerEffects(evt);
        }

        @SubscribeEvent
        public static void onRegistryCreation(final RegistryEvent.NewRegistry evt) {
            new RegistryBuilder()
                    .setName(CORPSE_REGISTRY_NAME)
                    .setType(Corpse.class)
                    .add(CORPSE_CALLBACK_INSTANCE)
                    .create();

            new RegistryBuilder()
                    .setName(TINCTURE_REGISTRY_NAME)
                    .setType(Tincture.class)
                    .create();
        }

        @SubscribeEvent
        public static void onCorpseRegistry(final RegistryEvent.Register<Corpse> evt) {
            HSCorpses.registerCorpses(evt);
        }

        @SubscribeEvent
        public static void onTinctureRegistry(final RegistryEvent.Register<Tincture> evt) {
            HSTinctures.registerTinctures(evt);
        }
    }
}
