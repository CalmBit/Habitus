package com.tridevmc.habitus.client;

import com.tridevmc.habitus.entity.render.WastedRenderer;
import com.tridevmc.habitus.entity.render.WoodbugRenderer;
import com.tridevmc.habitus.init.HSBlocks;
import com.tridevmc.habitus.init.HSEntities;
import com.tridevmc.habitus.init.HSItems;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.client.renderer.entity.SkeletonRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;

@OnlyIn(Dist.CLIENT)
public class ClientProxy extends CommonProxy {

    @SubscribeEvent
    public void onColorRegistry(final ColorHandlerEvent.Item evt) {
        evt.getItemColors().register(new ElixirColorer(), HSItems.ELIXIR);
    }

    @Override
    public void registerEntityRenderers() {
        RenderingRegistry.registerEntityRenderingHandler(HSEntities.WASTED, WastedRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(HSEntities.WOODBUG, WoodbugRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(HSEntities.BABY_SKELETON, SkeletonRenderer::new);
    }

    @Override
    public void adjustBlockRenderTypes() {
        RenderTypeLookup.setRenderLayer(HSBlocks.TINCTURE_STAND, RenderType.getCutout());
    }
}
