package com.tridevmc.habitus.entity.render;

import com.tridevmc.habitus.entity.EntityPigCorpse;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.model.PigModel;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class RenderPigCorpse extends MobRenderer<EntityPigCorpse, PigModel<EntityPigCorpse>> {

    // thanks mojang
    private static final ResourceLocation PIG_TEXTURES = new ResourceLocation("textures/entity/pig/pig.png");

    public RenderPigCorpse(EntityRendererManager p_i47198_1_) {
        super(p_i47198_1_, new PigModel(), 0.7F);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityPigCorpse entityPigCorpse) {
        return PIG_TEXTURES;
    }
}
