package com.tridevmc.habitus.entity.render;

import com.tridevmc.habitus.CorpseRendererCache;
import com.tridevmc.habitus.entity.CorpseEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.LivingRenderer;
import net.minecraft.client.renderer.entity.model.QuadrupedModel;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class CorpseRenderer extends LivingRenderer<CorpseEntity, QuadrupedModel<CorpseEntity>> {
    public CorpseRenderer(EntityRendererManager p_i50965_1_) {
        super(p_i50965_1_, new BlankModel(), 0.0f);
    }

    @Override
    public void doRender(CorpseEntity entity, double x, double y, double z, float entityYaw, float partialTicks) {
        try {
            CorpseRendererCache.rendererMap.get(entity.corpse.getClass()).doRender(entity.corpse, x, y, z, entityYaw, partialTicks);
        } catch(NullPointerException e) {
            //
        }
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(CorpseEntity entity) {
        return null;
    }
}
