package k4unl.minecraft.doubleJump.events;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.InputEvent.KeyInputEvent;
import k4unl.minecraft.doubleJump.lib.config.DJConfig;
import k4unl.minecraft.doubleJump.network.DJNetworkHandler;
import k4unl.minecraft.doubleJump.network.MessageKeyPressed;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiChat;

public class KeyHandler {
	public static void init(){
        if(!DJConfig.INSTANCE.getBool("disable")) {
            FMLCommonHandler.instance().bus().register(new KeyHandler());
        }
	}
	
	@SubscribeEvent
	public void onKeyInput(KeyInputEvent event) {

		if (!FMLClientHandler.instance().isGUIOpen(GuiChat.class)) {
			if (FMLClientHandler.instance().getClient().gameSettings.keyBindJump.getIsKeyPressed()) {
				if(!DJConfig.INSTANCE.getBool("disabled")) {
					if (Minecraft.getMinecraft().thePlayer.motionY < 0.04 && Minecraft.getMinecraft().thePlayer.isAirBorne) {
						DJNetworkHandler.sendToServer(new MessageKeyPressed(0));
					}
				}
			}
		}
	}
}
