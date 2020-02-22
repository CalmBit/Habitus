package com.tridevmc.habitus;

import com.google.common.collect.ImmutableList;
import net.minecraft.potion.EffectInstance;

import javax.annotation.Nonnull;
import java.util.List;

public class Tincture extends net.minecraftforge.registries.ForgeRegistryEntry<Tincture> {
    private final String baseName;
    private final ImmutableList<EffectInstance> effects;
    private ImmutableList<EffectInstance> rejections = ImmutableList.of();

    public Tincture(@Nonnull String baseNameIn, EffectInstance... effectsIn) {
        this.baseName = baseNameIn;
        this.effects = ImmutableList.copyOf(effectsIn);
    }

    public Tincture setRejections(EffectInstance... rejectionsIn) {
        this.rejections = ImmutableList.copyOf(rejectionsIn);
        return this;
    }

    public List<EffectInstance> getEffects() {
        return this.effects;
    }
    public List<EffectInstance> getRejections() {return this.rejections;}

    public String getNamePrefixed(String prefix) {
        return prefix + this.baseName;
    }
}
