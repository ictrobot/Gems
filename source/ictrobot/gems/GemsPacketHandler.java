package ictrobot.gems;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;

import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet250CustomPayload;
import cpw.mods.fml.common.network.IPacketHandler;
import cpw.mods.fml.common.network.Player;
public class GemsPacketHandler implements IPacketHandler {

  static public boolean Flight = false;
  
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
     Flight = true;
   } else if (state==0) {
     Flight = false;
   }
  }
}