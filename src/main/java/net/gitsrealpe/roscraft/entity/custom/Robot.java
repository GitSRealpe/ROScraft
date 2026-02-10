package net.gitsrealpe.roscraft.entity.custom;

import edu.wpi.rail.jrosbridge.Ros;
import edu.wpi.rail.jrosbridge.Topic;
import edu.wpi.rail.jrosbridge.messages.Message;
import net.gitsrealpe.roscraft.ros.ROSManager;
import net.minecraft.core.NonNullList;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public abstract class Robot extends LivingEntity {

    public String robotName = "robot";
    public Topic twistSubscriber;
    // Track if this instance registered with ROS manager
    private boolean rosRegistered = false;

    protected Robot(EntityType<? extends LivingEntity> entityType, Level level) {
        super(entityType, level);

        this.setCustomName(Component.literal(this.robotName + this.getId()));

        if (level.isClientSide()) {
            // Get the shared ROS connection
            Ros ros = ROSManager.getInstance().getRosConnection();
            rosRegistered = true;

            // this.lidar = new Lidar(this, 10);

            // Each robot creates its own topic using the shared connection
            // Use entity ID to create unique topic name
            this.twistSubscriber = new Topic(ros, "/turtlebot" + this.getId() + "/cmd_vel", "geometry_msgs/Twist");
            this.twistSubscriber.subscribe(this::twistCallback);

        }

    }

    protected abstract void twistCallback(Message message);

    @Override
    public void remove(RemovalReason reason) {
        super.remove(reason);
        cleanup();
    }

    /**
     * Clean up ROS resources when entity is removed
     */
    protected void cleanup() {
        if (this.level().isClientSide() && rosRegistered) {
            if (this.twistSubscriber != null) {
                this.twistSubscriber.unsubscribe();
            }
            // Notify the manager that this robot is done
            ROSManager.getInstance().releaseRobot();
            rosRegistered = false;
        }
    }

    @Override
    public Iterable<ItemStack> getArmorSlots() {
        return NonNullList.withSize(4, ItemStack.EMPTY);
    }

    @Override
    public ItemStack getItemBySlot(EquipmentSlot slot) {
        return ItemStack.EMPTY;
    }

    @Override
    public void setItemSlot(EquipmentSlot slot, ItemStack stack) {
        return;
    }

    @Override
    public HumanoidArm getMainArm() {
        return HumanoidArm.RIGHT;
    }

}
