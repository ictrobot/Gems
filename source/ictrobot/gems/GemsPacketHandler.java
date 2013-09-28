package ictrobot.gems;

import ictrobot.gems.magnetic.armor.Jetpack;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;

import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet250CustomPayload;
import cpw.mods.fml.common.network.IPacketHandler;
import cpw.mods.fml.common.network.Player;
public class GemsPacketHandler implements IPacketHandler {

  @Override
  public void onPacketData(INetworkManager manager, Packet250CustomPayload packet, Player playerEntity) {
    if (packet.channel.equals("GemsJetpack")) {
      updateJetpack(packet);
    }
  }
  
  protected void updateJetpack(Packet250CustomPayload packet) {
    DataInputStream inputStream = new DataInputStream(new ByteArrayInputStream(packet.data));
    
    int state;
    
    try {
            state = inputStream.readInt();
    } catch (IOException e) {
            e.printStackTrace();
            return;
    }
   if (state==1) {
     Jetpack.upPressed = true;
   } else if (state==0) {
     Jetpack.upPressed = false;
   }
  }
}