package net.gitsrealpe.roscraft.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;

import net.gitsrealpe.roscraft.ROScraft;
import net.gitsrealpe.roscraft.entity.custom.TurtlebotEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class TurtlebotRenderer extends MobRenderer<TurtlebotEntity, TurtlebotModel<TurtlebotEntity>> {
    public TurtlebotRenderer(EntityRendererProvider.Context context) {
        super(context, new TurtlebotModel<>(context.bakeLayer(TurtlebotModel.LAYER_LOCATION)), 0.25f);
    }

    @Override
    public ResourceLocation getTextureLocation(TurtlebotEntity entity) {
        return ResourceLocation.fromNamespaceAndPath(ROScraft.MODID, "textures/entity/turtlebot/turtlebot.png");
    }

    @Override
    public void render(TurtlebotEntity entity, float entityYaw, float partialTicks, PoseStack poseStack,
            MultiBufferSource buffer, int packedLight) {
        super.render(entity, entityYaw, partialTicks, poseStack, buffer, packedLight);
    }
}
