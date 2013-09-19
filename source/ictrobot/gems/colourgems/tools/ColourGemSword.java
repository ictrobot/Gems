package ictrobot.gems.colourgems.tools;

import net.minecraft.block.Block;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemSword;

public class ColourGemSword extends ItemSword {
      
  public static final Block[] swordBlock = {Block.web};
  
  public ColourGemSword(int id, EnumToolMaterial ToolMaterial, String TextureName) {
    super(id, ToolMaterial);
    func_111206_d("Gems:" + TextureName + "Sword");
  }
}
