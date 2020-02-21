package com.tridevmc.habitus.entity.render;

import com.tridevmc.habitus.Habitus;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.entity.LivingEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.HashMap;
import java.util.Map;

@OnlyIn(Dist.CLIENT)
public class CorpseRendererCache {
    public static final Map<Class<? extends LivingEntity>, EntityRenderer> rendererMap = new HashMap<>();

    public static void cacheRenderer(Class<? extends LivingEntity> clazz, EntityRenderer renderer) {
        rendererMap.put(clazz, renderer);
        Habitus.LOGGER.info("Cached renderer for '" + clazz.getSimpleName() + '"');
    }

    public static EntityRenderer getRenderer(LivingEntity e) {
        if(!rendererMap.containsKey(e.getClass())) {
            rendererMap.put(e.getClass(), Minecraft.getInstance().getRenderManager().getRenderer(e));
        }
        return rendererMap.get(e.getClass());
    }
}
