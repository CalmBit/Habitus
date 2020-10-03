package com.tridevmc.habitus.mixin;

import com.tridevmc.habitus.init.HSEffects;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.LivingEntity;
import net.minecraft.potion.EffectInstance;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(EnchantmentHelper.class)
public class MixinEnchantmentHelper {
    @Overwrite
    public static int getKnockbackModifier(LivingEntity player) {
        EffectInstance knockback = player.getActivePotionEffect(HSEffects.KNOCKBACK);
        if(knockback != null) {
            return knockback.getAmplifier();
        } else {
            return EnchantmentHelper.getMaxEnchantmentLevel(Enchantments.KNOCKBACK, player);
        }
    }
}
