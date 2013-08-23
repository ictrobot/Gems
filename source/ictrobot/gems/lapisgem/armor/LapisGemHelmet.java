package ictrobot.gems.lapisgem.armor;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class LapisGemHelmet extends ItemArmor {

  public LapisGemHelmet(int par1, EnumArmorMaterial par2EnumArmorMaterial, int par3, int par4) {
    super(par1, par2EnumArmorMaterial, par3, par4);
  }

  @SideOnly(Side.CLIENT)
  public void registerIcons(IconRegister par1RegisterIcon) {
    this.itemIcon = par1RegisterIcon.registerIcon("Gems:LapisGem_Helmet");
  }

  public String getArmorTexture(ItemStack stack, Entity entity, int slot, int layer) {
    return "Gems:textures/models/armor/LapisGem_layer_1.png";
  }

  public void onCreated(ItemStack itemstack, World world, EntityPlayer entity) {
    float var4 = 1.0F;
    int i = (int) (entity.prevPosX + (entity.posX - entity.prevPosX) * var4);
    int j = (int) (entity.prevPosY + (entity.posY - entity.prevPosY) * var4 + 1.62D - entity.yOffset);
    int k = (int) (entity.prevPosZ + (entity.posZ - entity.prevPosZ) * var4);
    world.spawnEntityInWorld(new EntityLightningBolt(world, i, j, k));
  }

}
