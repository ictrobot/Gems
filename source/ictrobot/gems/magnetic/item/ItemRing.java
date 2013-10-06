package ictrobot.gems.magnetic.item;

import java.util.List;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import ictrobot.core.Core;

public class ItemRing extends BaseRing {
  
  public ItemRing(int id, int par2) {
    super(id, par2, "Item");
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
  
  @SuppressWarnings({ "unchecked", "rawtypes" })
  public void tickServer(ItemStack itemStack, World world, Entity entity, int par4, boolean par5) {
    if( itemStack.getTagCompound() == null ) {
      itemStack.setTagCompound( new NBTTagCompound( ));
      itemStack.getTagCompound().setInteger("MaxPower", DefaultPower);
      itemStack.getTagCompound().setInteger("Delay", 10); 
    }
    NBTTagCompound tag = itemStack.getTagCompound();
    EntityPlayer player;
    if (tag.getBoolean("Enabled") && ((entity instanceof EntityPlayer))) {
      float radius = tag.getInteger("MaxPower");
      player = (EntityPlayer)entity;
      final List<EntityItem> list = (List<EntityItem>)world.getEntitiesWithinAABB((Class)EntityItem.class, player.boundingBox.expand(radius, radius, radius));
      for (final EntityItem e : list) {
        if (e.age >= tag.getInteger("Delay")) {
          if (Core.isServer() && player.inventory.addItemStackToInventory(e.getEntityItem())) {
            world.removeEntity(e);
            tag.setInteger("Pnum", tag.getInteger("Pnum")+1);
            tag.setDouble("P" + tag.getInteger("Pnum")+"x", e.posX);
            tag.setDouble("P" + tag.getInteger("Pnum")+"y", e.posY);
            tag.setDouble("P" + tag.getInteger("Pnum")+"z", e.posZ);
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
          if (time>20) {
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

  public ItemStack rightClickServer(ItemStack itemStack, World world, EntityPlayer player) {
    if( itemStack.getTagCompound() == null ) {
      itemStack.setTagCompound( new NBTTagCompound( ) );
      itemStack.getTagCompound().setInteger("Delay", 10); 
    }
    NBTTagCompound tag = itemStack.getTagCompound();
    if (player.isSneaking()) {
      if (!tag.getBoolean("Enabled")) {
        tag.setBoolean("Enabled", true);
        player.addChatMessage("\u00A73\u00A7lFlight Ring:\u00A7r\u00A77 Enabled");
      } 
      double time = tag.getInteger("Delay");
      time = time / 20;
      time = time + 0.5;
      if (time>5) {
        time=0.5;
      }
      double ticks = time*20;
      int t = (int)ticks;
      tag.setInteger("Delay", t);
      player.addChatMessage("\u00A73\u00A7lItem Ring:\u00A7r\u00A77 Delay " + time);
    } else {
      if (tag.getBoolean("Enabled")) {
        tag.setBoolean("Enabled", false);
        player.addChatMessage("\u00A73\u00A7lItem Ring:\u00A7r\u00A77 Disabled");
      } else {
        tag.setBoolean("Enabled", true);
        player.addChatMessage("\u00A73\u00A7lItem Ring:\u00A7r\u00A77 Enabled");
      }
    }
    return itemStack;
  }
  
  @SuppressWarnings({ "rawtypes", "unchecked" })
  public void addInformation(ItemStack itemStack, EntityPlayer player, List par3List, boolean par4) {
    if( itemStack.getTagCompound() != null ) {
      NBTTagCompound tag = itemStack.getTagCompound();
      if (tag.getBoolean("Enabled")) {
        par3List.add("\u00A77Enabled");
        double time = tag.getInteger("Delay");
        double delay = time/20;
        par3List.add("\u00A77Range - " + tag.getInteger("MaxPower"));
        par3List.add("\u00A77Delay - " + delay + " seconds");
      } else {
        par3List.add("\u00A77Disabled");
      }
      if(tag.getBoolean("Modified")) {
        par3List.add("\u00A77Modified");
      }
    }
  }
}
