package com.tridevmc.habitus;

import com.tridevmc.habitus.client.ElixirColorer;
import com.tridevmc.habitus.client.TinctureColorer;
import com.tridevmc.habitus.entity.Corpse;
import com.tridevmc.habitus.entity.CorpseEntity;
import com.tridevmc.habitus.entity.ai.AvoidCorpseGoal;
import com.tridevmc.habitus.init.*;
import com.tridevmc.habitus.util.CorpseRegistryCallbacks;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.CreatureAttribute;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.RegistryKey;
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
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.RegistryBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
        /*List<BiomeManager.BiomeEntry> warm = BiomeManager.getBiomes(BiomeManager.BiomeType.WARM);
        List<BiomeManager.BiomeEntry> cool = BiomeManager.getBiomes(BiomeManager.BiomeType.COOL);
        List<BiomeManager.BiomeEntry> desert = BiomeManager.getBiomes(BiomeManager.BiomeType.DESERT);
        List<BiomeManager.BiomeEntry> icy = BiomeManager.getBiomes(BiomeManager.BiomeType.ICY);

        List<BiomeManager.BiomeEntry> biomes = new ArrayList<>();
        if(warm != null)biomes.addAll(warm);
        if(cool != null)biomes.addAll(cool);
        if(desert != null)biomes.addAll(desert);
        if(icy != null)biomes.addAll(icy);*/

        /*for(Biome b : ForgeRegistries.BIOMES.getValues()) {
            b.func(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE,
                    HSBlocks.SLATE.getDefaultState(), 33))
                    .withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(10, 0, 0, 80))));
            b.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE,
                    HSBlocks.LIMESTONE.getDefaultState(), 33))
                    .withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(10, 0, 0, 80))));
            b.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE,
                    HSBlocks.MARBLE.getDefaultState(), 33))
                    .withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(10, 0, 0, 80))));
        }*/

        /**for(Map.Entry<RegistryKey<Biome>, Biome> b : ForgeRegistries.BIOMES.getEntries()) {
            if(b.getKey().getRegistryName().getNamespace().equals(Habitus.MODID)) continue;
            b.getValue().func_242440_e().func_242496_b().add(HSBiomes.SLATE_ORE);
            b.getValue().func_242440_e().func_242496_b().add(HSBiomes.LIMESTONE_ORE);
            b.getValue().func_242440_e().func_242496_b().add(HSBiomes.MARBLE_ORE);
        }*/
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
            LivingEntity target = evt.getEntityLiving();
            ItemStack mainHand = attacker.getHeldItemMainhand();

            EffectInstance e = attacker.getActivePotionEffect(HSEffects.FIRE_ASPECT);
            if (e != null && mainHand.canApplyAtEnchantingTable(Enchantments.FIRE_ASPECT)) {
                evt.getEntityLiving().setFire(4 * (e.getAmplifier() + 1));
            }

            EffectInstance sharp = attacker.getActivePotionEffect(HSEffects.SHARPNESS);
            if(sharp != null && EnchantmentHelper.getEnchantmentLevel(Enchantments.SHARPNESS, mainHand) == 0 && mainHand.canApplyAtEnchantingTable(Enchantments.SHARPNESS)) {
                evt.setAmount(evt.getAmount() + (1 + ((0.5f) * sharp.getAmplifier())));
                DistExecutor.runWhenOn(Dist.CLIENT, () -> () -> Minecraft.getInstance().particles.addParticleEmitter(evt.getEntity(), ParticleTypes.ENCHANTED_HIT));
            }

            EffectInstance bane = attacker.getActivePotionEffect(HSEffects.BANE_OF_ARTHROPODS);
            if(bane != null && EnchantmentHelper.getEnchantmentLevel(Enchantments.BANE_OF_ARTHROPODS, mainHand) == 0 && mainHand.canApplyAtEnchantingTable(Enchantments.BANE_OF_ARTHROPODS)) {
                if(target.getCreatureAttribute() == CreatureAttribute.ARTHROPOD) {
                    evt.setAmount(evt.getAmount() + ((1 + bane.getAmplifier()) * 2.5f));
                    DistExecutor.runWhenOn(Dist.CLIENT, () -> () -> Minecraft.getInstance().particles.addParticleEmitter(evt.getEntity(), ParticleTypes.ENCHANTED_HIT));
                }
            }

            EffectInstance smite = attacker.getActivePotionEffect(HSEffects.SMITE);
            if(smite != null && EnchantmentHelper.getEnchantmentLevel(Enchantments.SMITE, mainHand) == 0 && mainHand.canApplyAtEnchantingTable(Enchantments.SMITE)) {
                if(target.getCreatureAttribute() == CreatureAttribute.UNDEAD) {
                    evt.setAmount(evt.getAmount() + ((1 + smite.getAmplifier()) * 2.5f));
                    DistExecutor.runWhenOn(Dist.CLIENT, () -> () -> Minecraft.getInstance().particles.addParticleEmitter(evt.getEntity(), ParticleTypes.ENCHANTED_HIT));
                }
            }
        }

        if(evt.getEntityLiving().getHealth() < evt.getEntityLiving().getMaxHealth() * 0.45) {
            evt.getEntityLiving().addPotionEffect(new EffectInstance(Effects.SLOWNESS, 300, 1));
        }
    }

    /*@SubscribeEvent
    public void onKnockback(LivingKnockBackEvent evt) {
        if(evt.getEntity() instanceof LivingEntity) {
            LivingEntity attacker = (LivingEntity) evt.getEntity();
            ItemStack mainHand = attacker.getHeldItemMainhand();

            EffectInstance knockback = attacker.getActivePotionEffect(HSEffects.KNOCKBACK);
            if (knockback != null && mainHand.canApplyAtEnchantingTable(Enchantments.KNOCKBACK)) {
                float s = evt.getStrength();
                s += 0.5f + (knockback.getAmplifier() * 0.5f);
                evt.setStrength(s);
            }
        }
    }*/


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

    /*@SubscribeEvent
    public static void onGenerateLoot(final GenerateLootEvent evt) {
        Entity ent = evt.getContextBuilder().get(LootParameters.THIS_ENTITY);
        if(ent instanceof PlayerEntity) {
            PlayerEntity player = (PlayerEntity)ent;
            ItemStack tool = evt.getContextBuilder().get(LootParameters.TOOL);
            if(tool != null) {
                tool = tool.copy();
                if(player.getActivePotionEffect(HSEffects.SILK_TOUCH) != null) {
                    if(tool.canApplyAtEnchantingTable(Enchantments.SILK_TOUCH)) {
                        tool.addEnchantment(Enchantments.SILK_TOUCH, 1);
                    }
                } else if(player.getActivePotionEffect(HSEffects.FORTUNE) != null) {
                    if(tool.canApplyAtEnchantingTable(Enchantments.FORTUNE)) {
                        int level = 1 + player.getActivePotionEffect(HSEffects.FORTUNE).getAmplifier();
                        tool.addEnchantment(Enchantments.FORTUNE, level);
                    }
                }
                evt.getContextBuilder().withParameter(LootParameters.TOOL, tool);

            } else {
                LOGGER.error("Unable to get LootParameters.TOOL! Couldn't apply tincture effect.");
            }
        }
    }*/

    @SubscribeEvent
    public static void onGetBreakSpeed(final PlayerEvent.BreakSpeed evt) {
        PlayerEntity player = evt.getPlayer();
        if(player.getActivePotionEffect(HSEffects.AQUA_AFFINITY) != null) {
            if (evt.getPlayer().areEyesInFluid(FluidTags.WATER) && !EnchantmentHelper.hasAquaAffinity(evt.getPlayer())) {
                evt.setNewSpeed(evt.getNewSpeed()*5.0f);
            }
        }
    }

    @Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {

        @SubscribeEvent
        public static void onColorRegistry(final ColorHandlerEvent.Item evt) {
            evt.getItemColors().register(new ElixirColorer(), HSItems.ELIXIR);
            evt.getItemColors().register(new TinctureColorer(), HSItems.TINCTURE);
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
