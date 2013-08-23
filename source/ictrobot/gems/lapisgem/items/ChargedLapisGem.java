package ictrobot.gems.lapisgem.items;

import java.util.List;

import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ChargedLapisGem extends Item {
  public ChargedLapisGem(int id) {
    super(id);
    func_111206_d("Gems:ChargedLapisGem");
  }

  public void onCreated(ItemStack itemstack, World world, EntityPlayer entity) {
    float var4 = 1.0F;
    int i = (int) (entity.prevPosX + (entity.posX - entity.prevPosX) * var4);
    int j = (int) (entity.prevPosY + (entity.posY - entity.prevPosY) * var4 + 1.62D - entity.yOffset);
    int k = (int) (entity.prevPosZ + (entity.posZ - entity.prevPosZ) * var4);
    world.spawnEntityInWorld(new EntityLightningBolt(world, i, j, k));
  }

  @SideOnly(Side.CLIENT)
  public boolean hasEffect(ItemStack par1ItemStack) {
    return true;
  }
  
  @SuppressWarnings({ "unchecked", "rawtypes" })
  public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
    par3List.add("\u00A7eCharged");
  }
}
