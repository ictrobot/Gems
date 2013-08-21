package ictrobot.gems.items.lapisgem;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import cpw.mods.fml.common.ICraftingHandler;

public class ChargedLapisGemHandler
    implements
    ICraftingHandler {

  @Override
  public void onCrafting(EntityPlayer player, ItemStack item, IInventory craftMatrix) {
    for(int i = 0; i < craftMatrix.getSizeInventory(); i++){
      if(craftMatrix.getStackInSlot(i) != null){
        ItemStack j = craftMatrix.getStackInSlot(i);
        if(j.getItem() != null && j.getItem() == Item.flintAndSteel){
          ItemStack k = new ItemStack(Item.flintAndSteel, 2, (j.getItemDamage()+1));
          if (k.getItemDamage() >= k.getMaxDamage()){
            k.stackSize--;
          }
          craftMatrix.setInventorySlotContents(i, k);
        } 
      }
    }
  }


@Override
  public void onSmelting(
      EntityPlayer player,
      ItemStack item) {

  }

}
