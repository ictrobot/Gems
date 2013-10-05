package ictrobot.gems.magnetic.block;

import ictrobot.core.Core;
import net.minecraft.block.Block;
import net.minecraft.block.BlockTNT;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.World;

public class CompressedTNT extends BlockTNT {

  int lvl;
  
  public CompressedTNT(int id, int level) {
    super(id);
    lvl = level;
    setTextureName(Core.ModID + ":CompressedTNT");
    setHardness(3.0F);
    setResistance(5.0F);
    setStepSound(Block.soundMetalFootstep);
    setUnlocalizedName("CompressedTNT" + level);
    setCreativeTab(CreativeTabs.tabBlock);
  }
  
  public void primeTnt(World par1World, int par2, int par3, int par4, int par5, EntityLivingBase par6EntityLivingBase)
  {
      if (!par1World.isRemote)
      {
          if ((par5 & 1) == 1)
          {
              par1World.createExplosion(par6EntityLivingBase, par2, par3, par4, (4*9)^lvl, true);
          }
      }
  }
}
