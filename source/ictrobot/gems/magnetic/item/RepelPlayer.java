package ictrobot.gems.magnetic.item;

import ictrobot.core.Core;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.world.World;

public class RepelPlayer extends ItemTool{

  public RepelPlayer(int par1, EnumToolMaterial par2EnumToolMaterial) {
    super(par1, 0, par2EnumToolMaterial, Block.blocksList);
    setMaxDamage(11);
    setUnlocalizedName("RepelPlayer");
    setCreativeTab(CreativeTabs.tabTools);
    setTextureName(Core.ModID + ":RepelPlayer");
    setMaxStackSize(1);
  }
  
  @Override
  public boolean canHarvestBlock(Block block) {
    return false;
  }

  @Override
  public float getStrVsBlock(ItemStack is, Block block, int meta) {
    return 0F;
  }

  @Override
  public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player) {
    player.motionY = 0.7; 
    //itemStack.setItemDamage(itemStack.getItemDamage() - 1);
    itemStack.damageItem(1, player);
    return itemStack;
  }
}
