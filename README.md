
# ROS2Craft: Advanced Robotics in Minecraft!

This dev branch uses [ihmcrobotics:jros2](https://github.com/ihmcrobotics/jros2) as Java-ROS2 interface.

Obtained from Maven repository using:
```
dependencies {
  implementation 'us.ihmc:jros2:1.1.6'
}
```
However requires extra configuration as Neoforge uses strict *log4j* version dependency, which collides with *jros2*, so it has to force version in build.gradle file.
