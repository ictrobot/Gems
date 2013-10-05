package ictrobot.core.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import ictrobot.core.Core;

public class BasicItem extends Item {
  
  public String MaterialID;
  public String ItemType = "item";
  
  public BasicItem(int id, String Material) {
    super(id);
    MaterialID = Material;
    setTextureName(Core.ModID + ":" + MaterialID);
    setUnlocalizedName(ItemType + MaterialID);
    setCreativeTab(CreativeTabs.tabMaterials);
  }
}
