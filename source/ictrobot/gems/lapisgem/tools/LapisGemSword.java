package ictrobot.gems.lapisgem.tools;

import ictrobot.gems.lapisgem.LapisGemModule;
import net.minecraft.block.Block;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.world.World;

public class LapisGemSword extends ItemSword {
      
  public static final Block[] swordBlock = {Block.web};
  
  public LapisGemSword(int id, EnumToolMaterial ToolMaterial) {
    super(id, ToolMaterial);
    func_111206_d("Gems:LapisGemSword");
  }
  
  public boolean canHarvestBlock(Block par1Block)
  {
      return par1Block.blockID == Block.web.blockID;
  }
  @Override
  public boolean getIsRepairable(ItemStack par1ItemStack, ItemStack par2ItemStack)
  {
    if (par2ItemStack.getItem()==LapisGemModule.chargedLapisGem)
      return true;
    else
      return false;
  }
  
  public void onCreated(ItemStack itemstack, World world, EntityPlayer entity) {
    float var4 = 1.0F;
    int i = (int) (entity.prevPosX + (entity.posX - entity.prevPosX) * var4);
    int j = (int) (entity.prevPosY + (entity.posY - entity.prevPosY) * var4 + 1.62D - entity.yOffset);
    int k = (int) (entity.prevPosZ + (entity.posZ - entity.prevPosZ) * var4);
    world.spawnEntityInWorld(new EntityLightningBolt(world, i, j, k));
  }

  
}
