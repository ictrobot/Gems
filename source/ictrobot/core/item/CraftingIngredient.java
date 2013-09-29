package ictrobot.core.item;

import java.util.List;

import ictrobot.core.Core;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class CraftingIngredient extends Item{
  
  public String MaterialID;
  public String ItemType = "item";
  
  public CraftingIngredient(int id, String Material) {
    super(id);
    MaterialID = Material;
    setTextureName(Core.ModID + ":" + MaterialID + ItemType);
    setUnlocalizedName(ItemType + MaterialID);
    setCreativeTab(CreativeTabs.tabMaterials);
  }
  
  @SuppressWarnings({ "unchecked", "rawtypes" })
  public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
      par3List.add("Crafting Ingredient");
  }
}
