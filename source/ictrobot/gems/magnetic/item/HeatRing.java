package ictrobot.gems.magnetic.item;

import java.util.List;
import java.util.Random;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class HeatRing extends BaseRing {
  
  public HeatRing(int id, int par2) {
    super(id, par2, "Heat");
  }

  public void tickClient(ItemStack itemStack, World world, Entity entity, int par4, boolean par5) {
    NBTTagCompound tag = itemStack.getTagCompound();
    if (tag!=null) {
      if (tag.getInteger("Pnum")>0) {
        for(int i=1; i<=tag.getInteger("Pnum"); i++){
          world.spawnParticle("largesmoke", tag.getDouble("P" + i + "x"), tag.getDouble("P" + i + "y"), tag.getDouble("P" + i + "z"), 0, 0.1, 0);
        }
      }
    }
  }
  
  public void tickServer(ItemStack itemStack, World world, Entity entity, int par4, boolean par5) {
    if( itemStack.getTagCompound() == null ) {
      itemStack.setTagCompound( new NBTTagCompound( ));
      itemStack.getTagCompound().setBoolean("Enabled", false);
      itemStack.getTagCompound().setInteger("MaxPower", DefaultPower);
    }
    NBTTagCompound tag = itemStack.getTagCompound();
    EntityPlayer player;
    if (tag.getBoolean("Enabled") && ((entity instanceof EntityPlayer))) {
      int r = tag.getInteger("MaxPower");
      player = (EntityPlayer)entity;
      int x = (int)Math.floor(player.posX);
      int y = (int)Math.floor(player.posY);
      int z = (int)Math.floor(player.posZ);
      for(int iX=x-r; iX<=x+r; iX++){
        for(int iY=y-r; iY<=y+r; iY++){
          for(int iZ=z-r; iZ<=z+r; iZ++){
            boolean Changed = false;
            if (world.getBlockId(iX, iY, iZ)==8 || world.getBlockId(iX, iY, iZ)==9) {
              world.setBlockToAir(iX, iY, iZ);
              Changed = true;
            }
            Random rand = new Random();
            if (MathHelper.getRandomIntegerInRange(rand, 1, 400)==1) {
              if (world.getBlockMaterial(iX, iY, iZ).getCanBurn() && world.isAirBlock(iX, iY+1, iZ)) {
                world.setBlock(iX, iY+1, iZ, 51);
                Changed = true;
              }
            }
            if (Changed) {
              tag.setInteger("Pnum", tag.getInteger("Pnum")+1);
              tag.setDouble("P" + tag.getInteger("Pnum")+"x", iX);
              tag.setDouble("P" + tag.getInteger("Pnum")+"y", iY);
              tag.setDouble("P" + tag.getInteger("Pnum")+"z", iZ);
              tag.setInteger("P" + tag.getInteger("Pnum") + "t", 1);
              tag.setBoolean("P" + tag.getInteger("Pnum") + "e", true);
            }
          }
        }
      }
      if (tag.getInteger("Pnum")>0) {
        boolean shouldReset = true;
        for(int i=1; i<=tag.getInteger("Pnum"); i++){
          if (tag.getInteger("P" + i + "t")!=0) {
            int time = tag.getInteger("P" + i + "t");
            time++;
            if (time>5) {
              tag.removeTag("P" + i + "t");
              tag.removeTag("P" + i + "x");
              tag.removeTag("P" + i + "y");
              tag.removeTag("P" + i + "z");
              tag.setBoolean("P" + i + "e", false);
            } else {
              tag.setInteger("P" + i + "t", time);
            }
          }
          if (tag.getBoolean("P" + i + "e")) {
            shouldReset=false;
          }
        }
        if (shouldReset) {
          for(int i=1; i<=tag.getInteger("Pnum"); i++){
            tag.removeTag("P" + i + "e");
          }
          tag.setInteger("Pnum", 0);
        }
      }
    }
  }

  public ItemStack rightClickServer(ItemStack itemStack, World world, EntityPlayer player) {
    if( itemStack.getTagCompound() == null ) {
      itemStack.setTagCompound( new NBTTagCompound( ) );
      itemStack.getTagCompound().setBoolean("Enabled", false);
      itemStack.getTagCompound().setInteger("MaxPower", DefaultPower);
    }
    NBTTagCompound tag = itemStack.getTagCompound();
    if (tag.getBoolean("Enabled")) {
      tag.setBoolean("Enabled", false);
      player.addChatMessage("\u00A73\u00A7lHeat Ring:\u00A7r\u00A77 Disabled");
    } else {
      tag.setBoolean("Enabled", true);
      player.addChatMessage("\u00A73\u00A7lHeat Ring:\u00A7r\u00A77 Enabled");
    }
    return itemStack;
  }
  
  @SuppressWarnings({ "rawtypes", "unchecked" })
  public void addInformation(ItemStack itemStack, EntityPlayer player, List par3List, boolean par4) {
    if( itemStack.getTagCompound() != null ) {
      NBTTagCompound tag = itemStack.getTagCompound();
      if (tag.getBoolean("Enabled")) {
        par3List.add("\u00A77Enabled");
        par3List.add("\u00A77Range - " + tag.getInteger("MaxPower"));
      } else {
        par3List.add("\u00A77Disabled");
      }
      if(tag.getBoolean("Modified")) {
        par3List.add("\u00A77Modified");
      }
    }
  }
}
