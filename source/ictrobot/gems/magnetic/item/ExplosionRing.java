package ictrobot.gems.magnetic.item;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.util.List;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraft.world.World;

public class ExplosionRing extends BaseRing {

  public ExplosionRing(int id, int par2) {
    super(id, par2, "Explosion");
  }

  public void tickServer(ItemStack itemStack, World world, Entity entity, int par4, boolean par5) {
    if( itemStack.getTagCompound() == null ) {
      itemStack.setTagCompound( new NBTTagCompound( ) );
      itemStack.getTagCompound().setInteger("Power", 1);
      itemStack.getTagCompound().setInteger("MaxPower", DefaultPower);
    }
  }
  
  public ItemStack rightClick(ItemStack itemStack, World world, EntityPlayer player) {
    if( itemStack.getTagCompound() == null ) {
      itemStack.setTagCompound( new NBTTagCompound( ) );
      itemStack.getTagCompound().setInteger("Power", 1); 
      itemStack.getTagCompound().setInteger("MaxPower", DefaultPower);
    }
    return itemStack;
  }
  
  public ItemStack rightClickClient(ItemStack itemStack, World world, EntityPlayer player) {
    if (!player.isSneaking()) {
      if(Minecraft.getMinecraft().objectMouseOver!=null) {
        int x=Minecraft.getMinecraft().objectMouseOver.blockX;
        int y=Minecraft.getMinecraft().objectMouseOver.blockY;
        int z=Minecraft.getMinecraft().objectMouseOver.blockZ;
        packet(x, y, z, player);
      }
    }
    return itemStack;
  }
  
  public ItemStack rightClickServer(ItemStack itemStack, World world, EntityPlayer player) {
    NBTTagCompound tag = itemStack.getTagCompound();
    if (player.isSneaking()) {
      int level = tag.getInteger("Power");
      level++;
      if (level>tag.getInteger("MaxPower")) {
        level=1;
      }
      tag.setInteger("Power", level);
      player.addChatMessage("\u00A73\u00A7lExplosion Ring:\u00A7r\u00A77 Explosion Power " + level);
    }
    return itemStack;
  }
  
  static protected void packet(int x, int y, int z, EntityPlayer tmpplayer) {
    ByteArrayOutputStream bos = new ByteArrayOutputStream(8);
    DataOutputStream outputStream = new DataOutputStream(bos);
    try {
            outputStream.writeInt(2);
            outputStream.writeInt(x);
            outputStream.writeInt(y);
            outputStream.writeInt(z);
    } catch (Exception ex) {
            ex.printStackTrace();
    }
    
    Packet250CustomPayload packet = new Packet250CustomPayload();
    packet.channel = "Gems";
    packet.data = bos.toByteArray();
    packet.length = bos.size();
    EntityClientPlayerMP player = (EntityClientPlayerMP)tmpplayer;
    player.sendQueue.addToSendQueue(packet);
  }
  
  @SuppressWarnings({ "unchecked", "rawtypes" })
  public void addInformation(ItemStack itemStack, EntityPlayer player, List par3List, boolean par4) {
    if( itemStack.getTagCompound() != null ) {
      NBTTagCompound tag = itemStack.getTagCompound();
      par3List.add("\u00A77Explosion Power " + tag.getInteger("Power"));
      if(tag.getBoolean("Modified")) {
        par3List.add("\u00A77Modified");
      }
    }
  }
}
