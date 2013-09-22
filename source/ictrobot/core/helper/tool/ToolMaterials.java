package ictrobot.core.helper.tool;

import net.minecraft.item.EnumToolMaterial;
import net.minecraftforge.common.EnumHelper;

public class ToolMaterials {
  public static EnumToolMaterial Wood = EnumHelper.addToolMaterial("Wood", 0, 59, 2.0F, 0.0F, 15);
  public static EnumToolMaterial Stone = EnumHelper.addToolMaterial("Stone", 1, 131, 4.0F, 1.0F, 5);
  public static EnumToolMaterial Iron = EnumHelper.addToolMaterial("Iron", 2, 250, 6.0F, 2.0F, 14);
  public static EnumToolMaterial Gold = EnumHelper.addToolMaterial("Gold", 0, 32, 12.0F, 0.0F, 22);
  public static EnumToolMaterial Diamond = EnumHelper.addToolMaterial("Diamond", 3, 1561, 8.0F, 3.0F, 10);
  
  //CUSTOM TOOL MATERIALS
  
  public static EnumToolMaterial Sapphire = EnumHelper.addToolMaterial("Sapphire", 3, 512, 8.0F, 3.0F, 10);
  public static EnumToolMaterial GreenSapphire = EnumHelper.addToolMaterial("GreenSapphire", 3, 512, 8.0F, 3.0F, 10);
  public static EnumToolMaterial Ruby = EnumHelper.addToolMaterial("Ruby", 3, 512, 8.0F, 3.0F, 10);
  public static EnumToolMaterial ChargedLapisGem = EnumHelper.addToolMaterial("LapisGem", 4, 2048, 10F, 10F, 50);
  
  public static EnumToolMaterial Magnetic = EnumHelper.addToolMaterial("Magnetic", 0, 10, 0, 0, 0);
}