package ictrobot.lapisgem;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class LapisGemItem extends Item {
  public LapisGemItem(int id) {
    super(id);
    setMaxStackSize(64);
    setCreativeTab(CreativeTabs.tabMaterials);
    setUnlocalizedName("LapisGem");
    func_111206_d("lapisgem:LapisGem");
  }

  public void onCreated(ItemStack itemstack, World world, EntityPlayer entity) {
    float var4 = 1.0F;
    int i = (int) (entity.prevPosX + (entity.posX - entity.prevPosX) * var4);
    int j = (int) (entity.prevPosY + (entity.posY - entity.prevPosY) * var4
        + 1.62D - entity.yOffset);
    int k = (int) (entity.prevPosZ + (entity.posZ - entity.prevPosZ) * var4);
    world.spawnEntityInWorld(new EntityLightningBolt(world, i, j, k));
  }
}