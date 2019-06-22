package com.tridevmc.habitus.entity.render;

import com.tridevmc.habitus.Habitus;
import com.tridevmc.habitus.entity.WastedEntity;
import com.tridevmc.habitus.entity.render.model.WastedOuterLayer;
import net.minecraft.client.renderer.entity.AbstractZombieRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.model.ZombieModel;
import net.minecraft.entity.monster.ZombieEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class WastedRenderer extends AbstractZombieRenderer<WastedEntity, ZombieModel<WastedEntity>> {
    private static final ResourceLocation WASTED_ZOMBIE_TEXTURES = new ResourceLocation(Habitus.MODID, "textures/entity/wasted.png");

    public WastedRenderer(EntityRendererManager rendererManager) {
        super(rendererManager, new ZombieModel<>(), new ZombieModel<>(0.5F, true), new ZombieModel<>(1.0F, true));
        this.addLayer(new WastedOuterLayer(this));
    }

    @Override
    protected ResourceLocation getEntityTexture(ZombieEntity entity) {
        return WASTED_ZOMBIE_TEXTURES;
    }
}
