package k4unl.minecraft.doubleJump.lib.config;

import k4unl.minecraft.k4lib.lib.config.Config;
import k4unl.minecraft.k4lib.lib.config.ConfigOption;

public class DJConfig extends Config{
    public static Config INSTANCE = new DJConfig();


    @Override
    public void init() {
        configOptions.add(new ConfigOption("disable", false).setComment("Set this to true to disable the mod (client side)"));
        configOptions.add(new ConfigOption("maxJumps", 2));
        configOptions.add(new ConfigOption("jumpBoost", 0.15D).setComment("0.2D is about a half block"));
        configOptions.add(new ConfigOption("secondJumpUsesHunger", true).setComment("Whether or not to use double the ammount of hunger when jumping the second time"));
    }
}
