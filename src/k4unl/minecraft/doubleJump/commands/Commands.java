package k4unl.minecraft.doubleJump.commands;

import cpw.mods.fml.common.event.FMLServerStartingEvent;

/**
 * Created by K-4U on 14-1-2015.
 */
public class Commands {

    public static void init(FMLServerStartingEvent event) {

        event.registerServerCommand(new CommandDoubleJump());
    }
}
