package com.tridevmc.habitus.entity.render;

import com.tridevmc.habitus.entity.EntitySheepCorpse;
import com.tridevmc.habitus.entity.render.model.ModelSheepCorpse;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class RenderSheepCorpse extends MobRenderer<EntitySheepCorpse, ModelSheepCorpse<EntitySheepCorpse>> {
    private static final ResourceLocation SHEARED_SHEEP_TEXTURES = new ResourceLocation("textures/entity/sheep/sheep.png");

    public RenderSheepCorpse(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new ModelSheepCorpse(), 0.7F);
        this.addLayer(new LayerSheepCorpseWool(this));
    }

    protected ResourceLocation getEntityTexture(EntitySheepCorpse entity) {
        return SHEARED_SHEEP_TEXTURES;
    }
}
