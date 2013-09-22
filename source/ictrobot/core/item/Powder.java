package ictrobot.core.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import ictrobot.core.Core;

public class Powder extends Item {
  
  public String MaterialID;
  public String ItemType = "powder";
  
  public Powder(int id, String Material) {
    super(id);
    MaterialID = Material;
    setTextureName(Core.ModID + ":" + MaterialID + ItemType);
    setUnlocalizedName(ItemType + MaterialID);
    setCreativeTab(CreativeTabs.tabMaterials);
  }
}
