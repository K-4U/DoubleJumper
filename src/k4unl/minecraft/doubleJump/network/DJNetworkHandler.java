package k4unl.minecraft.doubleJump.network;

import cpw.mods.fml.relauncher.Side;
import k4unl.minecraft.doubleJump.lib.config.ModInfo;
import k4unl.minecraft.k4lib.network.NetworkHandler;

public class DJNetworkHandler extends NetworkHandler {


    public static void init(){
        INSTANCE.registerMessage(MessageKeyPressed.class, MessageKeyPressed.class, discriminant++, Side.SERVER);
    }

    public static String getModId() {
        return ModInfo.ID;
    }

}
