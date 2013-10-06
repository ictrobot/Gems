package ictrobot.gems.magnetic.item;

import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class TeleportRing extends BaseRing {
  
  public TeleportRing(int id, int par2) {
    super(id, par2, "Teleport");
  }
  
  public void tickServer(ItemStack itemStack, World world, Entity entity, int par4, boolean par5) {
    if( itemStack.getTagCompound() == null ) {
      itemStack.setTagCompound( new NBTTagCompound( ));
      itemStack.getTagCompound().setInteger("MaxPower", DefaultPower);
    }
  }
  
  public ItemStack rightClickServer(ItemStack itemStack, World world, EntityPlayer player) {
    if( itemStack.getTagCompound() == null ) {
      itemStack.setTagCompound( new NBTTagCompound( ));
      itemStack.getTagCompound().setInteger("MaxPower", DefaultPower);
    }
    NBTTagCompound tag = itemStack.getTagCompound();
    if (!player.isSneaking()) {
      double x = player.posX;
      int intX = (int)Math.floor(x);
      int y = (int)Math.floor(player.posY);
      double z = player.posZ;
      int intZ = (int)Math.floor(z);
      int airB = 0;
      int airT = 0;
      for(int i=1; i<=tag.getInteger("MaxPower"); i++){
        if (world.isAirBlock(intX, y+i, intZ) && world.isAirBlock(intX, y+i+1, intZ) && !(world.isAirBlock(intX, y+i-1, intZ)) && airB==0 && airT==0) {
          airB = y+i;
          airT = y+i+1;
        }
      }
      if (!(airB==0 && airT==0)) {
        player.setPositionAndUpdate(x, airB, z);
      }
    }
   if (player.isSneaking()) {
     double x = player.posX;
     int intX = (int)Math.floor(x);
     int y = (int)Math.floor(player.posY);
     double z = player.posZ;
     int intZ = (int)Math.floor(z);
     int airB = 0;
     int airT = 0;
     boolean solidBlock;
     for(int i=1; i<=tag.getInteger("MaxPower"); i++){
       solidBlock = !world.isAirBlock(intX, y-i-1, intZ);
       if (world.isAirBlock(intX, y-i, intZ) && world.isAirBlock(intX, y-i+1, intZ) && solidBlock && airB==0 && airT==0) {
         airB = y-i;
         airT = y-i+1;
       }
     }
     if (!(airB==0 && airT==0)) {
       player.setPositionAndUpdate(x, airB, z);
     }
    }
    return itemStack;
  }
  
  @SuppressWarnings({ "rawtypes", "unchecked" })
  public void addInformation(ItemStack itemStack, EntityPlayer player, List par3List, boolean par4) {
    if( itemStack.getTagCompound() != null ) {
      NBTTagCompound tag = itemStack.getTagCompound();
      par3List.add("\u00A77Range - " + tag.getInteger("MaxPower"));
      if(tag.getBoolean("Modified")) {
        par3List.add("\u00A77Modified");
      }
    }
  }
}
