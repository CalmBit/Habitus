package com.tridevmc.habitus.entity;

import com.tridevmc.habitus.init.HSEntities;
import net.minecraft.entity.EntitySize;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.Pose;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.monster.SkeletonEntity;
import net.minecraft.world.World;

import java.util.UUID;

public class BabySkeletonEntity extends SkeletonEntity {
    private static final UUID BABY_SPEED_BOOST_ID = UUID.fromString("B9766B59-9566-4402-BC1F-2EE2A276D836");
    private static final AttributeModifier BABY_SPEED_BOOST = new AttributeModifier(BABY_SPEED_BOOST_ID, "Baby speed boost", 0.5D, AttributeModifier.Operation.MULTIPLY_BASE);
    public BabySkeletonEntity(EntityType type, World worldIn) {
        super(type, worldIn);
        this.experienceValue *= 2.5;
    }

    public BabySkeletonEntity(World worldIn) {
        this(HSEntities.BABY_SKELETON, worldIn);
    }

    @Override
    public boolean isChild() {
        return true;
    }

    @Override
    protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
        return 0.93F;
    }

    /**
     * Returns the Y Offset of this entity.
     */
    public double getYOffset() {
        return 0.0D;
    }

    public static AttributeModifierMap.MutableAttribute registerAttributes() {
        return MonsterEntity.func_234295_eP_().createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.5D);
    }
}
