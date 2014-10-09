package k4unl.minecraft.doubleJump.events;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import net.minecraft.nbt.NBTTagCompound;

public class TickHandler {
	
	public static void init(){
		FMLCommonHandler.instance().bus().register(new TickHandler());
	}

    @SubscribeEvent
    public void tickPlayer(TickEvent.PlayerTickEvent event){
        if(event.phase == TickEvent.Phase.END) {
        	if(event.side.isServer()){
                if(event.player.onGround) {
                    NBTTagCompound tCompound = event.player.getEntityData();
                    tCompound.removeTag("hasJumped");
                }
        	}
        }
    }
}
