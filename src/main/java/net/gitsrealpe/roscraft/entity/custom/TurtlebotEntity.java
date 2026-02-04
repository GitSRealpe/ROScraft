package net.gitsrealpe.roscraft.entity.custom;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.level.Level;

public class TurtlebotEntity extends Mob {

    public TurtlebotEntity(EntityType<? extends TurtlebotEntity> entityType, Level level) {
        super(entityType, level);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 6.0D) // 3 hearts
                .add(Attributes.MOVEMENT_SPEED, 0.25D)
                .add(Attributes.ARMOR, 0.0D); // each point half chestplate
    }

    // @Override
    // protected void registerGoals() {
    // this.goalSelector.addGoal(0, new FloatGoal(this));
    // }

    @Override
    public void tick() {
        super.tick();

        this.addDeltaMovement(stuckSpeedMultiplier);
    }

}
