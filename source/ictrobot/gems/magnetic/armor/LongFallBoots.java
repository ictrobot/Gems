package ictrobot.gems.magnetic.armor;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumHelper;

public class LongFallBoots extends ItemArmor {
  
  static EnumArmorMaterial armor = EnumHelper.addArmorMaterial("Jetpack", 0, new int[] { 3, 8, 6, 3 }, 10);
  public LongFallBoots(int par1, int par2) {
    super(par1, armor, par2, 3);
  }

  @SideOnly(Side.CLIENT)
  public void registerIcons(IconRegister par1RegisterIcon) {
    this.itemIcon = par1RegisterIcon.registerIcon("Gems:LongFallBoots");
  }

  public String getArmorTexture(ItemStack stack, Entity entity, int slot, int layer) {
    return "Gems:textures/models/armor/longfall_1.png";
  }
  
  @Override
  public void onArmorTickUpdate (World world, EntityPlayer player, ItemStack itemStack)  {
    player.fallDistance = 0.0F;
    player.distanceWalkedModified = 0.0F;
  }
}
