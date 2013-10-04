package ictrobot.gems.magnetic.item;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraft.world.World;
import ictrobot.core.Core;

public class ExplosionRing extends Item {

  int Level;
  
  public ExplosionRing(int id) {
    super(id);
    setTextureName(Core.ModID + ":" + "ExplosionRing");
    setUnlocalizedName("ExplosionRing");
    setCreativeTab(CreativeTabs.tabTools);
    setMaxStackSize(1);
  }

  @Override
  public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player) {
    if (Core.isClient()) {
      if(Minecraft.getMinecraft().objectMouseOver!=null) {
        int x=Minecraft.getMinecraft().objectMouseOver.blockX;
        int y=Minecraft.getMinecraft().objectMouseOver.blockY;
        int z=Minecraft.getMinecraft().objectMouseOver.blockZ;
        packet(x, y, z, player);
      }
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
}
