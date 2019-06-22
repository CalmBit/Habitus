package com.tridevmc.habitus.entity.render;

import com.tridevmc.habitus.Habitus;
import com.tridevmc.habitus.entity.WoodbugEntity;
import com.tridevmc.habitus.entity.render.model.WoodbugModel;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class WoodbugRenderer extends MobRenderer<WoodbugEntity, WoodbugModel> {
    public static final ResourceLocation WOODBUG_TEXTURES = new ResourceLocation(Habitus.MODID, "textures/entity/woodbug.png");

    public WoodbugRenderer(EntityRendererManager renderManager) {
        super(renderManager, new WoodbugModel(), 0.3f);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(WoodbugEntity entity) {
        return WOODBUG_TEXTURES;
    }
}
