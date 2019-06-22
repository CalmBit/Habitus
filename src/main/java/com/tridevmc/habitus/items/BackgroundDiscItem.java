package com.tridevmc.habitus.items;

import net.minecraft.item.MusicDiscItem;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;

public class BackgroundDiscItem extends MusicDiscItem {

    private static final Map<SoundEvent, MusicDiscItem> RECORDS = new HashMap<>();
    public BackgroundDiscItem(int comparatorValueIn, SoundEvent soundIn, Properties builder) {
        super(comparatorValueIn, soundIn, builder);
    }

    @Nullable
    @OnlyIn(Dist.CLIENT)
    public static MusicDiscItem getBySound(SoundEvent soundIn) {
        return RECORDS.get(soundIn);
    }

}
