package ictrobot.gems.tools.lapisgem;

import ictrobot.gems.Gems;
import net.minecraft.block.Block;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;

public class LapisGemPaxel extends ItemTool {
  
  public LapisGemPaxel(int id, float speed, EnumToolMaterial ToolMaterial) {
    super(id, speed, ToolMaterial, Block.blocksList);
    func_111206_d("Gems:LapisGemPaxel");
  }
  
  public boolean canHarvestBlock(Block par1Block, ItemStack itemStack)
  {
  return this.canHarvestBlock(par1Block);
  }

  public boolean canHarvestBlock(Block par1Block)
  {
  return true;
  }
  
  @Override
  public boolean getIsRepairable(ItemStack par1ItemStack, ItemStack par2ItemStack)
  {
    if (par2ItemStack.getItem()==Gems.chargedLapisGem)
      return true;
    else
      return false;
  }
  
}

/* if (par1ItemStack==(new ItemStack(Gems.lapisGemPaxel)) && par2ItemStack==(new ItemStack(Gems.chargedLapisGem)))
return true;
else
return false; */




