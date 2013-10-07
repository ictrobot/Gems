package ictrobot.gems.op.armor;

import ictrobot.gems.Gems;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class OPchestplate extends ItemArmor {

  public OPchestplate(int par1, EnumArmorMaterial par2EnumArmorMaterial, int par3, int par4) {
    super(par1, par2EnumArmorMaterial, par3, par4);
  }

  @SideOnly(Side.CLIENT)
  public void registerIcons(IconRegister par1RegisterIcon) {
    this.itemIcon = par1RegisterIcon.registerIcon("Gems:OP");
  }

  public String getArmorTexture(ItemStack stack, Entity entity, int slot, int layer) {
    return "Gems:textures/models/armor/OP.png";
  }  
  @Override
  public void onArmorTickUpdate (World world, EntityPlayer player, ItemStack itemStack)  {
    Gems.proxy.resetPlayerInAirTime(player);
}
}