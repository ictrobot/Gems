package ictrobot.gems.magnetic.armor;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.relauncher.Side;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.packet.Packet250CustomPayload;

public class SendPacket {

  static public void keydown(EntityPlayer player) {
    packet(1, player);
  }
  
  static public void keyup(EntityPlayer player) {
    packet(0, player);
  }
  
  static protected void packet(int state, EntityPlayer tmpplayer) {
    ByteArrayOutputStream bos = new ByteArrayOutputStream(8);
    DataOutputStream outputStream = new DataOutputStream(bos);
    try {
            outputStream.writeInt(state);
    } catch (Exception ex) {
            ex.printStackTrace();
    }
    
    Packet250CustomPayload packet = new Packet250CustomPayload();
    packet.channel = "GemsJetpack";
    packet.data = bos.toByteArray();
    packet.length = bos.size();
        
    Side side = FMLCommonHandler.instance().getEffectiveSide();
    if (side == Side.CLIENT) {
      EntityClientPlayerMP player = (EntityClientPlayerMP) tmpplayer;
      player.sendQueue.addToSendQueue(packet);
    }
  }
}
