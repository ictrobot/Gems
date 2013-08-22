package ictrobot.gems.items;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class CraftingIngredient extends Item {
  
  private String tooltip;
  
  public CraftingIngredient(int par1, String Texture, String tooltip) {
    super(par1);
    func_111206_d("Gems:" + Texture);
  }
  
  @SuppressWarnings({ "unchecked", "rawtypes" })
  public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
    if (tooltip=="")
      par3List.add(tooltip);
    else
      par3List.add("\u00A0eCrafting Ingredient");
  }

}
