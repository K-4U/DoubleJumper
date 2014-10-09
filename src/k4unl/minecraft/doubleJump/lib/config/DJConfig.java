package k4unl.minecraft.doubleJump.lib.config;

import k4unl.minecraft.k4lib.lib.config.Config;
import k4unl.minecraft.k4lib.lib.config.ConfigOption;

public class DJConfig extends Config{

	static {
        configOptions.add(new ConfigOption("maxJumps", 2));
	}
}
