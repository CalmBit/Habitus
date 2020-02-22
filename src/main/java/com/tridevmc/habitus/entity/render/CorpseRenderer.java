package com.tridevmc.habitus.entity.render;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.tridevmc.habitus.Habitus;
import com.tridevmc.habitus.entity.CorpseEntity;
import com.tridevmc.habitus.entity.render.model.BlankModel;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.LivingRenderer;
import net.minecraft.client.renderer.entity.model.QuadrupedModel;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;

@OnlyIn(Dist.CLIENT)
public class CorpseRenderer extends LivingRenderer<CorpseEntity, QuadrupedModel<CorpseEntity>> {
    public CorpseRenderer(EntityRendererManager p_i50965_1_) {
        super(p_i50965_1_, new BlankModel(), 0.0f);
    }

    @Override
    public void render(CorpseEntity entity, float p_225623_2_, float p_225623_3_, MatrixStack p_225623_4_, IRenderTypeBuffer p_225623_5_, int p_225623_6_) {
        try {
            CorpseRendererCache.getRenderer(entity.corpse).render(entity.corpse, p_225623_2_, p_225623_3_, p_225623_4_, p_225623_5_, p_225623_6_);
        } catch(NullPointerException e) {
            Habitus.LOGGER.error("Unable to render corpse! Couldn't find CorpseRenderer for " + entity + "!");
        }
    }


    @Nullable
    @Override
    public ResourceLocation getEntityTexture(CorpseEntity entity) {
        return null;
    }


}
