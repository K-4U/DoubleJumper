package k4unl.minecraft.doubleJump.events;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingEvent;

public class EventHelper {


	public static void init(){
		MinecraftForge.EVENT_BUS.register(new EventHelper());
		FMLCommonHandler.instance().bus().register(new EventHelper());
	}


    @SubscribeEvent
    public void JumpEvent(LivingEvent.LivingJumpEvent event){
        //TODO: Fix me for server only
        if (event.entityLiving instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) event.entityLiving;
            NBTTagCompound tCompound = player.getEntityData();
            if (!tCompound.hasKey("hasJumped")) {
                tCompound.setInteger("hasJumped", 0);
            }
            tCompound.setInteger("hasJumped", tCompound.getInteger("hasJumped") + 1);
        }
    }
}
