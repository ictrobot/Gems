package ictrobot.core.helper.tool;

import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraft.block.Block;
import net.minecraft.item.Item;

public class ToolMaterialsHelper {  
  
  public static boolean isRepairable(EnumToolMaterial material, ItemStack repairIS) {
    if (material.name() == "Ruby") {
      return OreDictionary.getOreID("gemRuby") == OreDictionary.getOreID(repairIS);
    } else if (material.name() == "GreenSapphire") {
      return OreDictionary.getOreID("gemGreenSapphire") == OreDictionary.getOreID(repairIS);
    } else if (material.name() == "Sapphire") {
      return OreDictionary.getOreID("gemSapphire") == OreDictionary.getOreID(repairIS);
    } else if (material.name() == "ChargedLapisGem") {
      return OreDictionary.getOreID("gemChargedLapis") == OreDictionary.getOreID(repairIS);   
    } else if (material.name() == "Wood") {
      return OreDictionary.getOreID("plankWood") == OreDictionary.getOreID(repairIS);   
    } else if (material.name() == "Stone") {
      return repairIS.itemID == Block.cobblestone.blockID;
    } else if (material.name() == "Iron") {
      return repairIS.itemID == Item.ingotIron.itemID;
    } else if (material.name() == "Gold") {
      return repairIS.itemID == Item.ingotGold.itemID;
    } else if (material.name() == "Diamond") {
      return repairIS.itemID == Item.diamond.itemID;
    } else {
      return false;
    }
  }
  
}