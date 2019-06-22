package com.tridevmc.habitus.entity.ai;

import com.tridevmc.habitus.entity.CorpseEntity;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.util.EntityPredicates;

public class AvoidCorpseGoal extends AvoidEntityGoal<CorpseEntity> {
    public AvoidCorpseGoal(CreatureEntity entityIn, float distanceIn, double farSpeedIn, double nearSpeedIn) {
        super(entityIn, CorpseEntity.class, (e) -> ((CorpseEntity) e).corpse.getClass() == entityIn.getClass(), distanceIn, farSpeedIn, nearSpeedIn, AvoidCorpseGoal::targeter);
    }

    private static boolean targeter(LivingEntity target) {
        return EntityPredicates.CAN_AI_TARGET.test(target);
    }
}
