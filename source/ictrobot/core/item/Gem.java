package ictrobot.core.item;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import ictrobot.core.Core;

public class Gem extends Item {
  
  public String MaterialID;
  public String ItemType = "gem";
  
  public Gem(int id, String Material) {
    super(id);
    MaterialID = Material;
    setTextureName(Core.ModID + ":" + MaterialID + ItemType);
    setUnlocalizedName(ItemType + MaterialID);
    setCreativeTab(CreativeTabs.tabMaterials);
  }
  
  @SideOnly(Side.CLIENT)
  public boolean hasEffect(ItemStack par1ItemStack) {
    if (MaterialID=="ChargedLapis") {
      return true;
    } else {
      return false;
    }
  }
  
  @SuppressWarnings({ "unchecked", "rawtypes" })
  public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
    if (MaterialID=="ChargedLapis") {
      par3List.add("\u00A7eCharged");
    }
  }
  
  @Override
  public void onCreated(ItemStack itemstack, World world, EntityPlayer entity) {
    float var4 = 1.0F;
    if (MaterialID=="ChargedLapis") {
      int i = (int) (entity.prevPosX + (entity.posX - entity.prevPosX) * var4);
      int j = (int) (entity.prevPosY + (entity.posY - entity.prevPosY) * var4 + 1.62D - entity.yOffset);
      int k = (int) (entity.prevPosZ + (entity.posZ - entity.prevPosZ) * var4);
      world.spawnEntityInWorld(new EntityLightningBolt(world, i, j, k));
    }
  }
}
