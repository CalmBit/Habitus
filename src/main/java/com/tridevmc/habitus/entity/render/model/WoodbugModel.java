package com.tridevmc.habitus.entity.render.model;//Made with Blockbench
//Paste this code into your mod.

import com.tridevmc.habitus.entity.WoodbugEntity;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.client.renderer.model.ModelBox;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class WoodbugModel extends EntityModel<WoodbugEntity> {
    private final RendererModel legs;
    private final RendererModel left_leg_1;
    private final RendererModel left_leg_2;
    private final RendererModel left_leg_3;
    private final RendererModel right_leg_1;
    private final RendererModel right_leg_3;
    private final RendererModel right_leg_2;
    private final RendererModel body;
    private final RendererModel left_elytra;
    private final RendererModel right_elytra;
    private final RendererModel head;
    private final RendererModel right_antenna;
    private final RendererModel left_antenna;

    public WoodbugModel() {
        textureWidth = 64;
        textureHeight = 64;

        legs = new RendererModel(this);
        legs.setRotationPoint(0.0F, 24.0F, 0.0F);

        left_leg_1 = new RendererModel(this);
        left_leg_1.setRotationPoint(-2.5F, -0.5F, 2.0F);
        legs.addChild(left_leg_1);
        left_leg_1.cubeList.add(new ModelBox(left_leg_1, 0, 19, -0.5F, -0.5F, -1.0F, 1, 1, 2, 0.0F, false));

        left_leg_2 = new RendererModel(this);
        left_leg_2.setRotationPoint(-2.5F, -0.5F, -1.0F);
        legs.addChild(left_leg_2);
        left_leg_2.cubeList.add(new ModelBox(left_leg_2, 6, 19, -0.5F, -0.5F, -1.0F, 1, 1, 2, 0.0F, false));

        left_leg_3 = new RendererModel(this);
        left_leg_3.setRotationPoint(-2.5F, -0.5F, -4.0F);
        legs.addChild(left_leg_3);
        left_leg_3.cubeList.add(new ModelBox(left_leg_3, 12, 19, -0.5F, -0.5F, -1.0F, 1, 1, 2, 0.0F, false));

        right_leg_1 = new RendererModel(this);
        right_leg_1.setRotationPoint(2.5F, -0.5F, 2.0F);
        legs.addChild(right_leg_1);
        right_leg_1.cubeList.add(new ModelBox(right_leg_1, 0, 22, -0.5F, -0.5F, -1.0F, 1, 1, 2, 0.0F, false));

        right_leg_3 = new RendererModel(this);
        right_leg_3.setRotationPoint(2.5F, -0.5F, -4.0F);
        legs.addChild(right_leg_3);
        right_leg_3.cubeList.add(new ModelBox(right_leg_3, 18, 19, -0.5F, -0.5F, -1.0F, 1, 1, 2, 0.0F, false));

        right_leg_2 = new RendererModel(this);
        right_leg_2.setRotationPoint(2.5F, -0.5F, -1.0F);
        legs.addChild(right_leg_2);
        right_leg_2.cubeList.add(new ModelBox(right_leg_2, 24, 19, -0.5F, -0.5F, -1.0F, 1, 1, 2, 0.0F, false));

        body = new RendererModel(this);
        body.setRotationPoint(0.0F, 23.6667F, -0.3333F);
        body.cubeList.add(new ModelBox(body, 0, 0, -2.0F, -1.6667F, -4.6667F, 4, 2, 8, 0.0F, false));

        right_elytra = new RendererModel(this);
        right_elytra.setRotationPoint(-1.5F, -2.1667F, -0.6667F);
        body.addChild(right_elytra);
        right_elytra.cubeList.add(new ModelBox(right_elytra, 0, 10, -1.5F, -0.5F, -4.0F, 3, 1, 8, 0.0F, false));

        left_elytra = new RendererModel(this);
        left_elytra.setRotationPoint(1.5F, -2.1667F, -0.6667F);
        body.addChild(left_elytra);
        left_elytra.cubeList.add(new ModelBox(left_elytra, 24, 0, -1.5F, -0.5F, -4.0F, 3, 1, 8, 0.0F, false));

        head = new RendererModel(this);
        head.setRotationPoint(0.0F, 23.6667F, 1.3333F);
        head.cubeList.add(new ModelBox(head, 22, 10, -2.0F, -1.6667F, 1.6667F, 4, 2, 2, 0.0F, false));

        right_antenna = new RendererModel(this);
        right_antenna.setRotationPoint(1.5F, -2.1667F, 4.1667F);
        head.addChild(right_antenna);
        right_antenna.cubeList.add(new ModelBox(right_antenna, 6, 22, -0.5F, 0.5F, -0.5F, 1, 1, 1, 0.0F, false));

        left_antenna = new RendererModel(this);
        left_antenna.setRotationPoint(-1.5F, -2.1667F, 4.1667F);
        head.addChild(left_antenna);
        left_antenna.cubeList.add(new ModelBox(left_antenna, 10, 22, -0.5F, 0.5F, -0.5F, 1, 1, 1, 0.0F, false));
    }

    @Override
    public void render(WoodbugEntity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        legs.render(f5);
        body.render(f5);
        head.render(f5);
    }


    public void setRotationAngle(RendererModel RendererModel, float x, float y, float z) {
        RendererModel.rotateAngleX = x;
        RendererModel.rotateAngleY = y;
        RendererModel.rotateAngleZ = z;
    }

    @Override
    public void setRotationAngles(WoodbugEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor) {
        this.head.rotateAngleY = -(netHeadYaw * ((float)Math.PI / 180F));
        this.head.rotateAngleX = -(headPitch * ((float)Math.PI / 180F));
        float f = ((float)Math.PI / 4F);
        this.left_leg_1.rotateAngleZ = (-(float)Math.PI / 4F);
        this.right_leg_1.rotateAngleZ = ((float)Math.PI / 4F);
        this.left_leg_2.rotateAngleZ = -0.58119464F;
        this.right_leg_2.rotateAngleZ = 0.58119464F;
        this.left_leg_3.rotateAngleZ = (-(float)Math.PI / 4F);
        this.right_leg_3.rotateAngleZ = ((float)Math.PI / 4F);
        float f1 = -0.0F;
        float f2 = ((float)Math.PI / 8F);
        this.left_leg_1.rotateAngleY = ((float)Math.PI / 4F);
        this.right_leg_1.rotateAngleY = (-(float)Math.PI / 4F);
        this.left_leg_2.rotateAngleY = ((float)Math.PI / 8F);
        this.right_leg_2.rotateAngleY = (-(float)Math.PI / 8F);
        this.left_leg_3.rotateAngleY = (-(float)Math.PI / 4F);
        this.right_leg_3.rotateAngleY = ((float)Math.PI / 4F);
        float f3 = -(MathHelper.cos(limbSwing * 0.6662F * 2.0F + 0.0F) * 0.4F) * limbSwingAmount;
        float f4 = -(MathHelper.cos(limbSwing * 0.6662F * 2.0F + (float)Math.PI) * 0.4F) * limbSwingAmount;
        float f5 = -(MathHelper.cos(limbSwing * 0.6662F * 2.0F + ((float)Math.PI / 2F)) * 0.4F) * limbSwingAmount;
        float f6 = -(MathHelper.cos(limbSwing * 0.6662F * 2.0F + ((float)Math.PI * 1.5F)) * 0.4F) * limbSwingAmount;
        float f7 = Math.abs(MathHelper.sin(limbSwing * 0.6662F + 0.0F) * 0.4F) * limbSwingAmount;
        float f8 = Math.abs(MathHelper.sin(limbSwing * 0.6662F + (float)Math.PI) * 0.4F) * limbSwingAmount;
        float f9 = Math.abs(MathHelper.sin(limbSwing * 0.6662F + ((float)Math.PI / 2F)) * 0.4F) * limbSwingAmount;
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