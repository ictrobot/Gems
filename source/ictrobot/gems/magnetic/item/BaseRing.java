package ictrobot.gems.magnetic.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import ictrobot.core.Core;

public class BaseRing extends Item {

  int Level;
  int DefaultPower;
  String type;
  
  public BaseRing(int id, int MaxPower, String ringType) {
    super(id);
    DefaultPower = MaxPower;
    type = ringType;
    setTextureName(Core.ModID + ":" + type + "Ring");
    setUnlocalizedName(type + "Ring");
    setCreativeTab(CreativeTabs.tabTools);
    setMaxStackSize(1);
  }

  //Update Tick
  public void onUpdate(ItemStack itemStack, World world, Entity entity, int par4, boolean par5) {
    tick(itemStack, world, entity, par4, par5);
    if (Core.isClient()) {
      tickClient(itemStack, world, entity, par4, par5);
    } else if (Core.isServer()) {
      tickServer(itemStack, world, entity, par4, par5);
    }
  }
  
  public void tick(ItemStack itemStack, World world, Entity entity, int par4, boolean par5) {
    
  }
  
  public void tickClient(ItemStack itemStack, World world, Entity entity, int par4, boolean par5) {
    
  }
  
  public void tickServer(ItemStack itemStack, World world, Entity entity, int par4, boolean par5) {
    
  }
  
  public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player) {
    itemStack = rightClick(itemStack, world, player);
    if (Core.isClient()) {
      itemStack = rightClickClient(itemStack, world, player);
    } else if (Core.isServer()) {
      itemStack = rightClickServer(itemStack, world, player);
    }
    return itemStack;
  }
  
  public ItemStack rightClick(ItemStack itemStack, World world, EntityPlayer player) {
    return itemStack;
  }
  
  public ItemStack rightClickClient(ItemStack itemStack, World world, EntityPlayer player) {
    return itemStack;
  }
  
  public ItemStack rightClickServer(ItemStack itemStack, World world, EntityPlayer player) {
    return itemStack;
  }
}
