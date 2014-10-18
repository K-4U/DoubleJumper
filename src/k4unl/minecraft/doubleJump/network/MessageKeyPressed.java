/*
 * This file is part of Blue Power. Blue Power is free software: you can redistribute it and/or modify it under the terms of the GNU General Public
 * License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version. Blue Power is
 * distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A
 * PARTICULAR PURPOSE. See the GNU General Public License for more details. You should have received a copy of the GNU General Public License along
 * with Blue Power. If not, see <http://www.gnu.org/licenses/>
 */
package k4unl.minecraft.doubleJump.network;

import io.netty.buffer.ByteBuf;
import k4unl.minecraft.doubleJump.lib.config.DJConfig;
import k4unl.minecraft.k4lib.network.messages.AbstractPacket;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.util.MathHelper;
import net.minecraftforge.common.ForgeHooks;

public class MessageKeyPressed extends AbstractPacket<MessageKeyPressed> {
    private int keyIndex;

    public MessageKeyPressed() {
    
    }
    
    public MessageKeyPressed(int keyPressedIndex){
        keyIndex = keyPressedIndex;
    }
    
    @Override
    public void fromBytes(ByteBuf buf) {
        keyIndex = buf.readInt();
    }
    
    @Override
    public void toBytes(ByteBuf buf) {
        buf.writeInt(keyIndex);
    }

    @Override
    public void handleClientSide(MessageKeyPressed message, EntityPlayer player) {

    }

    @Override
    public void handleServerSide(MessageKeyPressed message, EntityPlayer player) {
        switch(keyIndex){
            case 0:
                NBTTagCompound tCompound = player.getEntityData();
                if(tCompound.hasKey("hasJumped")) {
                    if (player.motionY < 0.4 && tCompound.getInteger("hasJumped") < DJConfig.INSTANCE.getInt("maxJumps")) {
                        if(DJConfig.INSTANCE.getBool("secondJumpUsesHunger")) {
                            player.jump();
                        }else{
                            player.motionY = 0.41999998688697815D;

                            if (player.isPotionActive(Potion.jump))
                            {
                                player.motionY += (double)((float)(player.getActivePotionEffect(Potion.jump).getAmplifier() + 1) * 0.1F);
                            }

                            if (player.isSprinting())
                            {
                                float f = player.rotationYaw * 0.017453292F;
                                player.motionX -= (double)(MathHelper.sin(f) * 0.2F);
                                player.motionZ += (double)(MathHelper.cos(f) * 0.2F);
                            }

                            player.isAirBorne = true;
                            ForgeHooks.onLivingJump(player);
                        }
                        player.motionY += DJConfig.INSTANCE.getDouble("jumpBoost");
                        player.velocityChanged = true;
                    }
                }
                break;
        }
    }
}
