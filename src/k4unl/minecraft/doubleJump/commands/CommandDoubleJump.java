package k4unl.minecraft.doubleJump.commands;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.relauncher.Side;
import k4unl.minecraft.doubleJump.DoubleJump;
import k4unl.minecraft.doubleJump.lib.config.DJConfig;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.ChatComponentText;

import java.util.ArrayList;
import java.util.List;

public class CommandDoubleJump extends CommandBase {

    private List<String> aliases;
    public CommandDoubleJump(){
        aliases = new ArrayList<String>();
        aliases.add("dj");
    }




    public List getCommandAliases() {

        return aliases;
    }

    @Override public boolean canCommandSenderUseCommand(ICommandSender sender) {

        return true;
    }

    @Override public String getCommandName() {

        return "doublejump";
    }

    @Override public String getCommandUsage(ICommandSender sender) {

        return "doublejump - Toggles double jump";
    }

    @Override
    public void processCommand(ICommandSender sender, String[] args) {


        if(FMLCommonHandler.instance().getSide().equals(Side.CLIENT)) {
            if (DJConfig.INSTANCE.getBool("disable")) {
                sender.addChatMessage(new ChatComponentText("Doublejump is now enabled"));
                DJConfig.INSTANCE.setBool("disable", false);
            }else{
                sender.addChatMessage(new ChatComponentText("Doublejump is now disabled"));
                DJConfig.INSTANCE.setBool("disable", true);
            }
            DoubleJump.configHandler.config.save();
        }
    }
}
