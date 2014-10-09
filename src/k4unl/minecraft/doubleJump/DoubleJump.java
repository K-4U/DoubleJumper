package k4unl.minecraft.doubleJump;


import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import k4unl.minecraft.doubleJump.events.EventHelper;
import k4unl.minecraft.doubleJump.events.TickHandler;
import k4unl.minecraft.doubleJump.lib.Log;
import k4unl.minecraft.doubleJump.lib.config.ConfigHandler;
import k4unl.minecraft.doubleJump.lib.config.ModInfo;
import k4unl.minecraft.doubleJump.network.DJNetworkHandler;
import k4unl.minecraft.doubleJump.proxy.CommonProxy;


@Mod(
	modid = ModInfo.ID,
	name = ModInfo.NAME,
	version = ModInfo.VERSION,
    dependencies = "require-after:k4lib@[0.1.12,)"
)
public class DoubleJump {

    @Instance(value = ModInfo.ID)
    public static DoubleJump instance;

    @SidedProxy(
      clientSide = "k4unl.minecraft.doubleJump.proxy.ClientProxy",
      serverSide = "k4unl.minecraft.doubleJump.proxy.CommonProxy"
    )
    public static CommonProxy proxy;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {

        Log.init();
        ConfigHandler.init(event.getSuggestedConfigurationFile());
    }

    @EventHandler
    public void load(FMLInitializationEvent event) {

        TickHandler.init();
        EventHelper.init();
        DJNetworkHandler.init();
        proxy.init();
    }


    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {

    }
}
