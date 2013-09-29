package ictrobot.gems.magnetic.item;

import java.util.List;

import ictrobot.core.Core;
import ictrobot.gems.Gems;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.world.World;

public class RepelPlayer extends ItemTool{

  public int Level;
  public EnumToolMaterial ToolMaterial;
  
  public RepelPlayer(int par1, EnumToolMaterial par2EnumToolMaterial, int TmpLevel) {
    super(par1, 0, par2EnumToolMaterial, Block.blocksList);
    setMaxDamage((12*TmpLevel)-1);
    setUnlocalizedName("RepelPlayerLvl" + TmpLevel);
    setCreativeTab(CreativeTabs.tabTools);
    setTextureName(Core.ModID + ":RepelPlayer");
    setMaxStackSize(1);
    Level = TmpLevel;
    ToolMaterial = par2EnumToolMaterial;
  }
  
  @SuppressWarnings({ "unchecked", "rawtypes" })
  public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
    par3List.add("Level " + Level);
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
  public boolean getIsRepairable(ItemStack toolIS, ItemStack repairIS) {
      return false; //ToolMaterialsHelper.isRepairable(ToolMaterial, repairIS);
  }

  @Override
  public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player) {
    player.motionY = (0.75*(Level*0.75)); 
    Gems.proxy.resetPlayerInAirTime(player);
    itemStack.damageItem(1, player);
    return itemStack;
  }
}
