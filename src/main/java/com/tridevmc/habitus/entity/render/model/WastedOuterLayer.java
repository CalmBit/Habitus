package com.tridevmc.habitus.entity.render.model;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.platform.GlStateManager;
import com.tridevmc.habitus.entity.WastedEntity;
import net.minecraft.client.renderer.IRenderTypeBuffer;
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

    @Override
    public void render(MatrixStack matrixStack, IRenderTypeBuffer iRenderTypeBuffer, int i, WastedEntity wastedEntity, float v, float v1, float v2, float v3, float v4, float v5) {
        renderCopyCutoutModel(this.getEntityModel(),
                       this.WASTED_OUTER_MODEL,
                       WASTED_OUTER_LAYER_TEXTURES,
                       matrixStack,
                       iRenderTypeBuffer,
                       i,
                       wastedEntity,
                       v,v1,v2,v3,v4,v5,
                       1.0f, 1.0f, 1.0f);
    }

}