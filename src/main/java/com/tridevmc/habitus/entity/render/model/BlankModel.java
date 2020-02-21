package com.tridevmc.habitus.entity.render.model;

import com.tridevmc.habitus.entity.CorpseEntity;
import net.minecraft.client.renderer.entity.model.QuadrupedModel;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class BlankModel extends QuadrupedModel<CorpseEntity> {
    public BlankModel() {
        super(0, 0.0f, true, 0.0f, 0.0f, 0.f, 0.0f, 0);
    }
}
