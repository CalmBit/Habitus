package com.tridevmc.habitus.entity.render.model;

import net.minecraft.client.renderer.entity.model.QuadrupedModel;
import net.minecraft.client.renderer.entity.model.RendererModel;

public class ModelSheepWoolCorpse extends QuadrupedModel {
    public ModelSheepWoolCorpse() {
        super(12, 0.0F);
        this.field_78150_a = new RendererModel(this, 0, 0);
        this.field_78150_a.addBox(-3.0F, -4.0F, -4.0F, 6, 6, 6, 0.6F);
        this.field_78150_a.setRotationPoint(0.0F, 6.0F, -8.0F);
        this.field_78148_b = new RendererModel(this, 28, 8);
        this.field_78148_b.addBox(-4.0F, -10.0F, -7.0F, 8, 16, 6, 1.75F);
        this.field_78148_b.setRotationPoint(0.0F, 5.0F, 2.0F);
        float lvt_1_1_ = 0.5F;
        this.field_78149_c = new RendererModel(this, 0, 16);
        this.field_78149_c.addBox(-2.0F, 0.0F, -2.0F, 4, 6, 4, 0.5F);
        this.field_78149_c.setRotationPoint(-3.0F, 12.0F, 7.0F);
        this.field_78146_d = new RendererModel(this, 0, 16);
        this.field_78146_d.addBox(-2.0F, 0.0F, -2.0F, 4, 6, 4, 0.5F);
        this.field_78146_d.setRotationPoint(3.0F, 12.0F, 7.0F);
        this.field_78147_e = new RendererModel(this, 0, 16);
        this.field_78147_e.addBox(-2.0F, 0.0F, -2.0F, 4, 6, 4, 0.5F);
        this.field_78147_e.setRotationPoint(-3.0F, 12.0F, -5.0F);
        this.field_78144_f = new RendererModel(this, 0, 16);
        this.field_78144_f.addBox(-2.0F, 0.0F, -2.0F, 4, 6, 4, 0.5F);
        this.field_78144_f.setRotationPoint(3.0F, 12.0F, -5.0F);
    }
}
