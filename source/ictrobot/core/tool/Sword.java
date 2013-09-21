package ictrobot.core.tool;

import ictrobot.core.Core;
import ictrobot.core.helper.tool.ToolMaterialsHelper;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemSword;
import net.minecraft.item.ItemStack;
public class Sword extends ItemSword {
  
  public String ToolType = "sword";

  private EnumToolMaterial ToolMaterial;
  public String ToolMaterialID;
    
  public Sword(int itemId, EnumToolMaterial Material) {
        super(itemId, Material);
        ToolMaterial = Material;
        ToolMaterialID = ToolMaterial.name();
        setUnlocalizedName(ToolMaterialID + ToolType);
        setCreativeTab(CreativeTabs.tabCombat);
        func_111206_d(Core.ModID + ":" + ToolMaterialID + ToolType);
    }

    @Override
    public boolean getIsRepairable(ItemStack toolIS, ItemStack repairIS) {
        return ToolMaterialsHelper.isRepairable(ToolMaterial, repairIS);
    }

}