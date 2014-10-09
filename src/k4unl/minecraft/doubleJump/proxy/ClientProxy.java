package k4unl.minecraft.doubleJump.proxy;

import k4unl.minecraft.doubleJump.events.KeyHandler;

public class ClientProxy extends CommonProxy {
	
	public void init(){
		super.init();

		KeyHandler.init();
	}
	
}
