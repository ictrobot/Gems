package ictrobot.gems.tools.lapisgem;

import net.minecraft.block.Block;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemTool;

public class LapisGemSword extends ItemTool {
      
  public static final Block[] swordBlock = {Block.web};
  
  public LapisGemSword(int id, EnumToolMaterial ToolMaterial) {
    super(id, 2F, ToolMaterial, swordBlock);
    func_111206_d("Gems:LapisGemSword");
  }
  
  public boolean canHarvestBlock(Block par1Block)
  {
      return par1Block.blockID == Block.web.blockID;
  }
}



