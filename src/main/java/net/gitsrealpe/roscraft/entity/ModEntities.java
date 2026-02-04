package net.gitsrealpe.roscraft.entity;

import java.util.function.Supplier;

import net.gitsrealpe.roscraft.ROScraft;
import net.gitsrealpe.roscraft.entity.custom.CameraEntity;
import net.gitsrealpe.roscraft.entity.custom.TurtlebotEntity;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister
            .create(BuiltInRegistries.ENTITY_TYPE, ROScraft.MODID);

    public static final Supplier<EntityType<CameraEntity>> CAMERA_ENTITY = ENTITY_TYPES.register("camera",
            () -> EntityType.Builder.of(CameraEntity::new, MobCategory.MISC)
                    .sized(0.7f, 1.6f)
                    .build("camera"));

    public static final Supplier<EntityType<TurtlebotEntity>> TURTLEBOT = ENTITY_TYPES.register("turtlebot",
            () -> EntityType.Builder.of(TurtlebotEntity::new, MobCategory.MISC)
                    .sized(1.0f, 1.0f)
                    .build("turtlebot"));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }

}
