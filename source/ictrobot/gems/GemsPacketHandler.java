package ictrobot.gems;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet250CustomPayload;
import cpw.mods.fml.common.network.IPacketHandler;
import cpw.mods.fml.common.network.Player;
public class GemsPacketHandler implements IPacketHandler {

//  static public String[] Flight = {""};
  
  @Override
  public void onPacketData(INetworkManager manager, Packet250CustomPayload packet, Player playerEntity) {
    if (packet.channel.equals("GemsJetpack")) {
      if (playerEntity instanceof EntityPlayer) {
        EntityPlayer player = ((EntityPlayer)playerEntity);
        updateJetpack(packet, player);
      }   
    }
  }
  
  protected void updateJetpack(Packet250CustomPayload packet, EntityPlayer player) {
    DataInputStream inputStream = new DataInputStream(new ByteArrayInputStream(packet.data));
    
    int state;
    
    try {
            state = inputStream.readInt();
    } catch (IOException e) {
            e.printStackTrace();
            return;
    }
/*   if (state==1) {
     Flight = true;
   } else if (state==0) {
     Flight = false;
   } 
   if (Flight.length>0) {
     int i=0;
     for(i=0; i==Flight.length; i++){
       System.out.println(i + " " + Flight[i] + " " + player.username + " " + (Flight[i]==player.username));
       if (Flight[i]==player.username) {
         if (state==1) {
           return;
         } else {
           Flight = removeElements(Flight, player.username);
           return;
         }
       }
     }
   }
   Flight = addElement(Flight, player.username); */
    
    NBTTagCompound tag = player.getEntityData();
    tag.setInteger("GemsJetpack", state);
  }
  
  @SuppressWarnings({ "unchecked", "rawtypes" })
  public static String[] removeElements(String[] input, String deleteMe) {
    List result = new LinkedList();

    for(String item : input)
        if(!deleteMe.equals(item))
            result.add(item);

    return (String[]) result.toArray(input);
  }
  
  public static String[] addElement(String[] org, String added) {
    String[] result = Arrays.copyOf(org, org.length +1);
    result[org.length] = added;
    return result;
  }
}