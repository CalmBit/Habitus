package com.tridevmc.habitus.entity.render.model;

import com.mojang.blaze3d.platform.GlStateManager;
import com.tridevmc.habitus.entity.WastedEntity;
import net.minecraft.client.renderer.entity.IEntityRenderer;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.client.renderer.entity.model.ZombieModel;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class WastedOuterLayer extends LayerRenderer<WastedEntity, ZombieModel<WastedEntity>> {
    private static final ResourceLocation WASTED_OUTER_LAYER_TEXTURES = new ResourceLocation("habitus", "textures/entity/wasted_outer_layer.png");
    private final ZombieModel WASTED_OUTER_MODEL = new ZombieModel(0.25F, false);

    public WastedOuterLayer(IEntityRenderer<WastedEntity, ZombieModel<WastedEntity>> renderer) {
        super(renderer);
    }

    public void render(WastedEntity entityIn, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scaleIn) {
        if (!entityIn.isInvisible()) {
            this.getEntityModel().func_217148_a(this.WASTED_OUTER_MODEL);
            this.WASTED_OUTER_MODEL.setLivingAnimations(entityIn, limbSwing, limbSwingAmount, partialTicks);
            GlStateManager.color4f(1.0F, 1.0F, 1.0F, 1.0F);
            this.bindTexture(WASTED_OUTER_LAYER_TEXTURES);
            this.WASTED_OUTER_MODEL.render(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleIn);
        }
    }


    public boolean shouldCombineTextures() {
        return true;
    }
}