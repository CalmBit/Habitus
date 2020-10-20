package com.tridevmc.habitus.tinctures;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.tridevmc.habitus.util.ListUtil;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.ForgeRegistryEntry;

import java.util.List;

public class TinctureEffect extends ForgeRegistryEntry<TinctureEffect> {
    private final String baseName;
    private final int color;
    private final int maxLevel;
    private final List<ResourceLocation> rejections;
    private final List<TinctureTarget> targets;

    private TinctureEffect(String baseName, int color, List<ResourceLocation> rejections, List<TinctureTarget> targets, int maxLevel) {
        this.baseName = baseName;
        this.color = color;
        this.maxLevel = maxLevel;
        this.rejections = ImmutableList.copyOf(rejections);
        this.targets = ImmutableList.copyOf(targets);
    }

    /**
     * Checks if the registry key of another TinctureEffect type is listed as a
     * rejection in this effect.
     * @param other Other tincture effect to check against
     * @return Whether or not this effect has the other tincture listed as a rejection.
     */
    public boolean willReject(TinctureEffect other) {
        return this.rejections.contains(other.getRegistryName());
    }

    /**
     * TinctureEffects are considered 'compatible' if their target lists have at least
     * one intersection - this set is the 'compatible' subset for the pair (i.e. the
     * set of items which both TinctureEffects can be applied to)
     * @param other Other tincture effect to check against
     * @return The compatible subset for this pair of TinctureEffects
     */
    public List<TinctureTarget> getCompatibleSubset(TinctureEffect other) {
        return ListUtil.intersection(this.targets, other.targets);
    }

    /**
     * Determines whether or not this TinctureEffect and the one passed in are
     * 'compatible' (see {@link TinctureEffect#getCompatibleSubset(TinctureEffect)}).
     * @param other Other tincture effect to check against
     * @return Whether or not these effects are compatible
     */
    public boolean areCompatible(TinctureEffect other) {
        return getCompatibleSubset(other).size() != 0;
    }

    public static class Builder {
        private String baseName;
        private int color = -1;
        private int maxLevel = 1;
        private List<ResourceLocation> rejections = Lists.newArrayList();
        private List<TinctureTarget> targets = Lists.newArrayList();

        public Builder(String baseName) {
            this.baseName = baseName;
        }

        public Builder withColor(int color) {
            this.color = color;
            return this;
        }

        public Builder withRejection(ResourceLocation rejection) {
            this.rejections.add(rejection);
            return this;
        }

        public Builder withMaxLevel(int maxLevel) {
            this.maxLevel = maxLevel;
            return this;
        }

        public Builder withTarget(TinctureTarget target) {
            this.targets.add(target);
            return this;
        }

        public TinctureEffect build() {
            return new TinctureEffect(baseName, color, rejections, targets, maxLevel);
        }
    }
}
