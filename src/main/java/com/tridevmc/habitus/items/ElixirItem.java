package com.tridevmc.habitus.items;

import com.tridevmc.habitus.init.HSItems;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PotionItem;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.PotionUtils;
import net.minecraft.stats.Stats;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class ElixirItem extends PotionItem {

    @OnlyIn(Dist.CLIENT)
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        super.addInformation(stack, worldIn, tooltip, flagIn);
        tooltip.add(new TranslationTextComponent("habitus.elixir.uses_left")
                .appendText(String.format("%d", (stack.getMaxDamage() - stack.getDamage())))
                .applyTextStyle(TextFormatting.YELLOW));
    }

    public ElixirItem(Properties properties) {
        super(properties);
    }


    @Override
    public ItemStack onItemUseFinish(ItemStack stack, World worldIn, LivingEntity entityLiving) {
        PlayerEntity playerentity = entityLiving instanceof PlayerEntity ? (PlayerEntity)entityLiving : null;

        AtomicBoolean broken = new AtomicBoolean(false);
        if (playerentity == null || !playerentity.abilities.isCreativeMode) {
            stack.damageItem(1, entityLiving, (e)->{
                broken.set(true);
            });
        }

        if (playerentity instanceof ServerPlayerEntity) {
            CriteriaTriggers.CONSUME_ITEM.trigger((ServerPlayerEntity)playerentity, stack);
        }

        if (!worldIn.isRemote) {
            for(EffectInstance effectinstance : PotionUtils.getEffectsFromStack(stack)) {
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
            if(broken.get()) {
                if (stack.isEmpty()) {
                    return new ItemStack(HSItems.ELIXIR_BOTTLE);
                }

                if (playerentity != null) {
                    playerentity.inventory.addItemStackToInventory(new ItemStack(HSItems.ELIXIR_BOTTLE));
                }
            }
        }

        return stack;
    }
}
