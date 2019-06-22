package com.tridevmc.habitus.items;

import com.tridevmc.habitus.Tincture;
import com.tridevmc.habitus.init.HSItems;
import com.tridevmc.habitus.init.HSTinctures;
import com.tridevmc.habitus.util.TinctureUtils;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.UseAction;
import net.minecraft.potion.EffectInstance;
import net.minecraft.stats.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.NonNullList;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.registries.IForgeRegistry;

import javax.annotation.Nullable;
import java.util.List;

public class TinctureItem extends Item {

    @OnlyIn(Dist.CLIENT)
    public ItemStack getDefaultInstance() {
        return TinctureUtils.addTinctureToItemStack(new ItemStack(HSItems.TINCTURE), HSTinctures.WATER);
    }

    public TinctureItem(Properties builder) {
        super(builder);
    }

    @Override
    public void fillItemGroup(ItemGroup group, NonNullList<ItemStack> items) {
        if (this.isInGroup(group)) {
            IForgeRegistry<Tincture> tinctures = GameRegistry.findRegistry(Tincture.class);
            for(Tincture tincture : tinctures) {
                if (tincture != HSTinctures.EMPTY) {
                    items.add(TinctureUtils.addTinctureToItemStack(new ItemStack(HSItems.TINCTURE), tincture));
                }
            }
        }
    }

    @Override
    public ItemStack onItemUseFinish(ItemStack stack, World worldIn, LivingEntity entityLiving) {
        PlayerEntity playerentity = entityLiving instanceof PlayerEntity ? (PlayerEntity)entityLiving : null;

        if (playerentity == null || !playerentity.abilities.isCreativeMode) {
            stack.shrink(1);
        }

        if (playerentity instanceof ServerPlayerEntity) {
            CriteriaTriggers.CONSUME_ITEM.trigger((ServerPlayerEntity)playerentity, stack);
        }

        if (!worldIn.isRemote) {
            for(EffectInstance effectinstance : TinctureUtils.getEffectsFromStack(stack)) {
                if (effectinstance.getPotion().isInstant()) {
                    effectinstance.getPotion().affectEntity(playerentity, playerentity, entityLiving, effectinstance.getAmplifier(), 1.0D);
                } else {
                    entityLiving.addPotionEffect(new EffectInstance(effectinstance));
                }
            }
        }

        if (playerentity != null) {
            playerentity.addStat(Stats.ITEM_USED.get(this));
        }

        if (playerentity == null || !playerentity.abilities.isCreativeMode) {
            if (stack.isEmpty()) {
                return new ItemStack(HSItems.TINCTURE_BOTTLE);
            }

            if (playerentity != null) {
                playerentity.inventory.addItemStackToInventory(new ItemStack(HSItems.TINCTURE_BOTTLE));
            }
        }

        return stack;
    }

    public int getUseDuration(ItemStack stack) {
        return 32;
    }

    public UseAction getUseAction(ItemStack stack) {
        return UseAction.DRINK;
    }

    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        playerIn.setActiveHand(handIn);
        return new ActionResult<>(ActionResultType.SUCCESS, playerIn.getHeldItem(handIn));
    }

    @OnlyIn(Dist.CLIENT)
    public boolean hasEffect(ItemStack stack) {
        return super.hasEffect(stack) || !TinctureUtils.getEffectsFromStack(stack).isEmpty();
    }

    public String getTranslationKey(ItemStack stack) {
        return TinctureUtils.getTinctureFromItem(stack).getNamePrefixed(this.getTranslationKey() + ".effect.");
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        TinctureUtils.addTinctureTooltip(stack, tooltip, 1.0F);
    }
}
