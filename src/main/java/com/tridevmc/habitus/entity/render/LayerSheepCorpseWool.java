package com.tridevmc.habitus.entity.render;

import com.mojang.blaze3d.platform.GlStateManager;
import com.tridevmc.habitus.entity.EntitySheepCorpse;
import com.tridevmc.habitus.entity.render.model.ModelSheepCorpse;
import com.tridevmc.habitus.entity.render.model.ModelSheepWoolCorpse;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.item.DyeColor;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nonnull;

public class LayerSheepCorpseWool extends LayerRenderer<EntitySheepCorpse, ModelSheepCorpse<EntitySheepCorpse>> {
    // THANKS MOJANG
    private static final ResourceLocation TEXTURE = new ResourceLocation("textures/entity/sheep/sheep_fur.png");
    private final ModelSheepWoolCorpse sheepModel = new ModelSheepWoolCorpse();

    public LayerSheepCorpseWool(RenderSheepCorpse renderer) {
        super(renderer);
    }

    @Override
    public void render(@Nonnull EntitySheepCorpse corpse, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
        if (!corpse.getSheared() && !corpse.isInvisible()) {
            this.bindTexture(TEXTURE);
            if (corpse.hasCustomName() && "jeb_".equals(corpse.getName().getUnformattedComponentText())) {
                int currentLivingTick = corpse.ticksExisted / 25 + corpse.getEntityId();
                int colorCount = DyeColor.values().length;
                int currentColor = currentLivingTick % colorCount;
                int nextColor = (currentLivingTick + 1) % colorCount;
                float brightness = ((float)(corpse.ticksExisted % 25) + partialTicks) / 25.0F;
                float[] currentColorGL = SheepEntity.getDyeRgb(DyeColor.byId(currentColor));
                float[] nextColorGL = SheepEntity.getDyeRgb(DyeColor.byId(nextColor));
                GlStateManager.color3f(currentColorGL[0] * (1.0F - brightness) + nextColorGL[0] * brightness, currentColorGL[1] * (1.0F - brightness) + nextColorGL[1] * brightness, currentColorGL[2] * (1.0F - brightness) + nextColorGL[2] * brightness);
            } else {
                float[] color = SheepEntity.getDyeRgb(corpse.getFleeceColor());
                GlStateManager.color3f(color[0], color[1], color[2]);
            }

            this.getEntityModel().setModelAttributes(this.sheepModel);
            this.sheepModel.setLivingAnimations(corpse, limbSwing, limbSwingAmount, partialTicks);
            this.sheepModel.render(corpse, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
        }
    }

    @Override
    public boolean shouldCombineTextures() {
        return true;
    }
}
