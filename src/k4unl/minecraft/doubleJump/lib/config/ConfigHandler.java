package k4unl.minecraft.doubleJump.lib.config;

import net.minecraftforge.common.config.Configuration;

import java.io.File;

public class ConfigHandler {
	private static Configuration config;

	public static void init(File configFile){
		config = new Configuration(configFile);
		
		DJConfig.loadConfigOptions(config);

		if(config.hasChanged()){
			config.save();
		}
	}
	
}
