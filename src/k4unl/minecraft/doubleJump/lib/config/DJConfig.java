package k4unl.minecraft.doubleJump.lib.config;

import k4unl.minecraft.k4lib.lib.config.Config;
import k4unl.minecraft.k4lib.lib.config.ConfigOption;

public class DJConfig extends Config{
    public static Config INSTANCE = new DJConfig();


    @Override
    public void init() {

        configOptions.add(new ConfigOption("maxJumps", 2));
    }
}
