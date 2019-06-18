package com.tridevmc.habitus.entity.render.model;

import com.tridevmc.habitus.entity.EntitySheepCorpse;
import net.minecraft.client.renderer.entity.model.QuadrupedModel;
import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class ModelSheepCorpse<T extends EntitySheepCorpse> extends QuadrupedModel<T> {
    public ModelSheepCorpse() {
        super(12, 0.0F);
        this.field_78150_a = new RendererModel(this, 0, 0);
        this.field_78150_a.addBox(-3.0F, -4.0F, -6.0F, 6, 6, 8, 0.0F);
        this.field_78150_a.setRotationPoint(0.0F, 6.0F, -8.0F);
        this.field_78148_b = new RendererModel(this, 28, 8);
        this.field_78148_b.addBox(-4.0F, -10.0F, -7.0F, 8, 16, 6, 0.0F);
        this.field_78148_b.setRotationPoint(0.0F, 5.0F, 2.0F);
    }
}
