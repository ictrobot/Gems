package ictrobot.gems.lapisgem.tools;

import ictrobot.gems.lapisgem.LapisGemModule;
import net.minecraft.block.Block;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.world.World;

public class LapisGemPaxel extends ItemTool {
  
  public LapisGemPaxel(int id, float speed, EnumToolMaterial ToolMaterial) {
    super(id, speed, ToolMaterial, Block.blocksList);
    func_111206_d("Gems:LapisGemPaxel");
  }
  
  public boolean canHarvestBlock(Block par1Block, ItemStack itemStack)
  {
  return this.canHarvestBlock(par1Block);
  }

  public boolean canHarvestBlock(Block par1Block)
  {
  return true;
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


