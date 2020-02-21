package com.tridevmc.habitus.entity.render.model;//Made with Blockbench
//Paste this code into your mod.

import com.google.common.collect.ImmutableList;
import com.tridevmc.habitus.entity.WoodbugEntity;
import net.minecraft.client.renderer.entity.model.SegmentedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

public class WoodbugModel extends SegmentedModel<WoodbugEntity> {
    private final ModelRenderer legs;
    private final ModelRenderer right_leg_3;
    private final ModelRenderer left_leg_3;
    private final ModelRenderer right_leg_1;
    private final ModelRenderer left_leg_1;
    private final ModelRenderer right_leg_2;
    private final ModelRenderer left_leg_2;
    private final ModelRenderer body;
    private final ModelRenderer left_elytra;
    private final ModelRenderer right_elytra;
    private final ModelRenderer head;
    private final ModelRenderer right_antenna;
    private final ModelRenderer left_antenna;


    public WoodbugModel() {
        textureWidth = 64;
        textureHeight = 64;

        legs = new ModelRenderer(this);
        legs.setRotationPoint(0.0F, 24.0F, 0.0F);

        right_leg_3 = new ModelRenderer(this);
        right_leg_3.setRotationPoint(-2.5F, -1.0F, 1.5F);
        legs.addChild(right_leg_3);
        right_leg_3.setTextureOffset(12, 20);
        right_leg_3.func_228303_a_(-0.5F, -1.0F, -0.5F, 1, 2, 1, 0.0F, false);

        left_leg_3 = new ModelRenderer(this);
        left_leg_3.setRotationPoint(2.5F, -1.0F, 1.5F);
        legs.addChild(left_leg_3);
        left_leg_3.setTextureOffset(8, 20);
        left_leg_3.func_228303_a_(-0.5F, -1.0F, -0.5F, 1, 2, 1, 0.0F, false);

        right_leg_1 = new ModelRenderer(this);
        right_leg_1.setRotationPoint(-2.5F, -1.0F, -4.5F);
        legs.addChild(right_leg_1);
        right_leg_1.setTextureOffset(20, 20);
        right_leg_1.func_228303_a_(-0.5F, -1.0F, -0.5F, 1, 2, 1, 0.0F, false);

        left_leg_1 = new ModelRenderer(this);
        left_leg_1.setRotationPoint(2.5F, -1.0F, -4.5F);
        legs.addChild(left_leg_1);
        left_leg_1.setTextureOffset(0, 20);
        left_leg_1.func_228303_a_(-0.5F, -1.0F, -0.5F, 1, 2, 1, 0.0F, false);

        right_leg_2 = new ModelRenderer(this);
        right_leg_2.setRotationPoint(-2.5F, -1.0F, -1.5F);
        legs.addChild(right_leg_2);
        right_leg_2.setTextureOffset(16, 20);
        right_leg_2.func_228303_a_(-0.5F, -1.0F, -0.5F, 1, 2, 1, 0.0F, false);

        left_leg_2 = new ModelRenderer(this);
        left_leg_2.setRotationPoint(2.5F, -1.0F, -1.5F);
        legs.addChild(left_leg_2);
        left_leg_2.setTextureOffset(4, 20);
        left_leg_2.func_228303_a_(-0.5F, -1.0F, -0.5F, 1, 2, 1, 0.0F, false);

        body = new ModelRenderer(this);
        body.setRotationPoint(0.0F, 24.0F, 0.0F);
        body.setTextureOffset(0, 10);
        body.func_228303_a_(-2.0F, -3.0F, -5.0F, 4, 2, 8, 0.0F, false);

        left_elytra = new ModelRenderer(this);
        left_elytra.setRotationPoint(-1.5F, -3.5F, 0.5F);
        body.addChild(left_elytra);
        left_elytra.setTextureOffset(24, 0);
        left_elytra.func_228303_a_(-1.5F, -0.5F, -6.5F, 3, 1, 9, 0.0F, false);

        right_elytra = new ModelRenderer(this);
        right_elytra.setRotationPoint(1.5F, -3.5F, 0.5F);
        body.addChild(right_elytra);
        right_elytra.setTextureOffset(0, 0);
        right_elytra.func_228303_a_(-1.5F, -0.5F, -6.5F, 3, 1, 9, 0.0F, false);

        head = new ModelRenderer(this);
        head.setRotationPoint(0.0F, 23.3333F, -2.0F);
        head.setTextureOffset(24, 10);
        head.func_228303_a_(-2.0F, -2.3333F, -5.0F, 4, 2, 2, 0.0F, false);

        right_antenna = new ModelRenderer(this);
        right_antenna.setRotationPoint(1.5F, -1.8333F, -5.5F);
        head.addChild(right_antenna);
        right_antenna.setTextureOffset(0, 23);
        right_antenna.func_228303_a_(-0.5F, -0.5F, -0.5F, 1, 1, 1, 0.0F, false);

        left_antenna = new ModelRenderer(this);
        left_antenna.setRotationPoint(-1.5F, -1.8333F, -5.5F);
        head.addChild(left_antenna);
        left_antenna.setTextureOffset(4, 23);
        left_antenna.func_228303_a_(-0.5F, -0.5F, -0.5F, 1, 1, 1, 0.0F, false);
    }


    public Iterable<ModelRenderer> func_225601_a_() {
        return ImmutableList.of(this.head, this.body, this.legs);
    }

    @Override
    public void func_225597_a_(WoodbugEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.head.rotateAngleY = (netHeadYaw * ((float)Math.PI / 270F));
        this.head.rotateAngleX = (headPitch * ((float)Math.PI / 270F));
        this.left_leg_1.rotateAngleZ = (-(float)Math.PI / 4F);
        this.right_leg_1.rotateAngleZ = ((float)Math.PI / 4F);
        this.left_leg_2.rotateAngleZ = -0.58119464F;
        this.right_leg_2.rotateAngleZ = 0.58119464F;
        this.left_leg_3.rotateAngleZ = (-(float)Math.PI / 4F);
        this.right_leg_3.rotateAngleZ = ((float)Math.PI / 4F);
        this.left_leg_1.rotateAngleY = ((float)Math.PI / 4F);
        this.right_leg_1.rotateAngleY = (-(float)Math.PI / 4F);
        this.left_leg_2.rotateAngleY = ((float)Math.PI / 8F);
        this.right_leg_2.rotateAngleY = (-(float)Math.PI / 8F);
        this.left_leg_3.rotateAngleY = (-(float)Math.PI / 4F);
        this.right_leg_3.rotateAngleY = ((float)Math.PI / 4F);
        float f3 = -(MathHelper.cos(limbSwing * 0.6662F * 2.0F + 0.0F) * 0.4F) * limbSwingAmount;
        float f4 = -(MathHelper.cos(limbSwing * 0.6662F * 2.0F + (float)Math.PI) * 0.4F) * limbSwingAmount;
        float f6 = -(MathHelper.cos(limbSwing * 0.6662F * 2.0F + ((float)Math.PI * 1.5F)) * 0.4F) * limbSwingAmount;
        float f7 = Math.abs(MathHelper.sin(limbSwing * 0.6662F + 0.0F) * 0.4F) * limbSwingAmount;
        float f8 = Math.abs(MathHelper.sin(limbSwing * 0.6662F + (float)Math.PI) * 0.4F) * limbSwingAmount;
        float f10 = Math.abs(MathHelper.sin(limbSwing * 0.6662F + ((float)Math.PI * 1.5F)) * 0.4F) * limbSwingAmount;
        this.left_leg_1.rotateAngleY += f3;
        this.right_leg_1.rotateAngleY += -f3;
        this.left_leg_2.rotateAngleY += f4;
        this.right_leg_2.rotateAngleY += -f4;
        this.left_leg_3.rotateAngleY += f6;
        this.right_leg_3.rotateAngleY += -f6;
        this.left_leg_1.rotateAngleZ += f7;
        this.right_leg_1.rotateAngleZ += -f7;
        this.left_leg_2.rotateAngleZ += f8;
        this.right_leg_2.rotateAngleZ += -f8;
        this.left_leg_3.rotateAngleZ += f10;
        this.right_leg_3.rotateAngleZ += -f10;
    }
}