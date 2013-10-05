package ictrobot.gems.magnetic.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import ictrobot.core.Core;

public class TeleportRing extends Item {

  int Level;
  int Power;
  
  public TeleportRing(int id, int par2) {
    super(id);
    Power = par2;
    setTextureName(Core.ModID + ":" + "TeleportRing");
    setUnlocalizedName("TeleportRing");
    setCreativeTab(CreativeTabs.tabTools);
    setMaxStackSize(1);
  }

  @Override
  public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player) {
    if (Core.isServer()) {
      if (!player.isSneaking()) {
        double x = player.posX;
        int intX = (int)Math.floor(x);
        int y = (int)Math.floor(player.posY);
        double z = player.posZ;
        int intZ = (int)Math.floor(z);
        int airB = 0;
        int airT = 0;
        for(int i=1; i<Power; i++){
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
       for(int i=1; i<Power; i++){
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
    }
    return itemStack;
  }
}
