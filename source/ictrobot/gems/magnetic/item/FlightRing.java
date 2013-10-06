package ictrobot.gems.magnetic.item;

import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import ictrobot.gems.Gems;

public class FlightRing extends BaseRing {
  public FlightRing(int id, int par2) {
    super(id, par2, "Flight");
  }
  
  public void tick(ItemStack itemStack, World world, Entity entity, int par4, boolean par5) {
    if (entity instanceof EntityPlayer) {
      EntityPlayer player = (EntityPlayer)entity;
      Gems.proxy.resetPlayerInAirTime(player);
      player.fallDistance = 0.0F;
      player.distanceWalkedModified = 0.0F;
    }
  }
  
  public void tickServer(ItemStack itemStack, World world, Entity entity, int par4, boolean par5) {
    if( itemStack.getTagCompound() == null ) {
      itemStack.setTagCompound( new NBTTagCompound( ) );
      itemStack.getTagCompound().setInteger("Power", 1);
      itemStack.getTagCompound().setInteger("MaxPower", DefaultPower);
    }
  }

  public ItemStack rightClick(ItemStack itemStack, World world, EntityPlayer player) {
    return itemStack;
  }
  
  public ItemStack rightClickClient(ItemStack itemStack, World world, EntityPlayer player) {
    NBTTagCompound tag = itemStack.getTagCompound();
    if (!player.isSneaking()) {
      player.motionY = (0.75*(tag.getInteger("Power")*0.75)); 
      Gems.proxy.resetPlayerInAirTime(player);
    }
    return itemStack;
  }
  
  public ItemStack rightClickServer(ItemStack itemStack, World world, EntityPlayer player) {
    if( itemStack.getTagCompound() == null ) {
      itemStack.setTagCompound( new NBTTagCompound( ) );
      itemStack.getTagCompound().setInteger("Power", 1);
      itemStack.getTagCompound().setInteger("MaxPower", DefaultPower);
    }
    NBTTagCompound tag = itemStack.getTagCompound();
    
    if (player.isSneaking()) {
      int level = tag.getInteger("Power");
      level++;
      if (level>tag.getInteger("MaxPower")) {
        level=1;
      }
      tag.setInteger("Power", level);
      player.addChatMessage("\u00A73\u00A7lFlight Ring:\u00A7r\u00A77 Magnetic Jump Level " + level);
    }
    
    return itemStack;
  }
  
  
  @SuppressWarnings({ "unchecked", "rawtypes" })
  public void addInformation(ItemStack itemStack, EntityPlayer player, List par3List, boolean par4) {
    if( itemStack.getTagCompound() != null ) {
      NBTTagCompound tag = itemStack.getTagCompound();
      par3List.add("\u00A77Magnetic Jump Level " + tag.getInteger("Power"));
      if(tag.getBoolean("Modified")) {
        par3List.add("\u00A77Modified");
      }
    }
  }
}
