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
import k4unl.minecraft.doubleJump.lib.config.DJConfig;
import k4unl.minecraft.doubleJump.lib.config.ModInfo;
import k4unl.minecraft.doubleJump.network.DJNetworkHandler;
import k4unl.minecraft.doubleJump.proxy.CommonProxy;
import k4unl.minecraft.k4lib.lib.config.ConfigHandler;

@Mod(
	modid = ModInfo.ID,
	name = ModInfo.NAME,
	version = ModInfo.VERSION,
    dependencies = "required-after:k4lib"
)
public class DoubleJump {

    @Instance(value = ModInfo.ID)
    public static DoubleJump instance;

    @SidedProxy(
      clientSide = "k4unl.minecraft.doubleJump.proxy.ClientProxy",
      serverSide = "k4unl.minecraft.doubleJump.proxy.CommonProxy"
    )
    public static CommonProxy proxy;

    public static ConfigHandler configHandler = new ConfigHandler();

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {

        Log.init();
        DJConfig.INSTANCE.init();
        configHandler.init(DJConfig.INSTANCE, event.getSuggestedConfigurationFile());
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
