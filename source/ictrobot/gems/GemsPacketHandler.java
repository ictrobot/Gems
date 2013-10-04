package ictrobot.gems;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IPacketHandler;
import cpw.mods.fml.common.network.Player;
public class GemsPacketHandler implements IPacketHandler {
  
  @Override
  public void onPacketData(INetworkManager manager, Packet250CustomPayload packet, Player playerEntity) {
      DataInputStream inputStream = new DataInputStream(new ByteArrayInputStream(packet.data));
      int packetSender;
      
      try {
        packetSender = inputStream.readInt();
      } catch (IOException e) {
        e.printStackTrace();
        return;
      }
      
      if (playerEntity instanceof EntityPlayer) {
        EntityPlayer player = ((EntityPlayer)playerEntity);
        if (packetSender==1) { //Jetpack
            updateJetpack(packet, player);
        } else if (packetSender==2) { //ExplosionRing
            updateExplosionRing(packet, player);
        }
      }
  }
  
  @SuppressWarnings("unused")
  protected void updateJetpack(Packet250CustomPayload packet, EntityPlayer player) {
    DataInputStream inputStream = new DataInputStream(new ByteArrayInputStream(packet.data));
    
    int state;
    
    try {
      int packetSender = inputStream.readInt(); 
      state = inputStream.readInt();
    } catch (IOException e) {
            e.printStackTrace();
            return;
    }        
    NBTTagCompound tag = player.getEntityData();
    tag.setInteger("GemsJetpack", state);
  }
  
  @SuppressWarnings("unused")
  protected void updateExplosionRing(Packet250CustomPayload packet, EntityPlayer player) {
    DataInputStream inputStream = new DataInputStream(new ByteArrayInputStream(packet.data));
    int x;
    int y;
    int z;
    
    try {
      int packetSender = inputStream.readInt(); 
      x = inputStream.readInt();
      y = inputStream.readInt();
      z = inputStream.readInt();
    } catch (IOException e) {
            e.printStackTrace();
            return;
    }
    World world = player.worldObj;
    System.out.println(world.toString());
    EntityTNTPrimed tnt = new EntityTNTPrimed(world, x, y, z, player);
    tnt.fuse = 0;
    world.setBlockToAir(x, y, z);
    world.spawnEntityInWorld(tnt);
  }
}