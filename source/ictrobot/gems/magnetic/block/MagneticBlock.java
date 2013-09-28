package ictrobot.gems.magnetic.block;

import ictrobot.core.Core;
import ictrobot.gems.module.MagneticModule;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class MagneticBlock extends Block {

  public MagneticBlock(int id, String texture, Material Material) {
    super(id, Material);
    setTextureName(Core.ModID + ":" + texture);
    setHardness(3.0F);
    setResistance(5.0F);
    setStepSound(Block.soundMetalFootstep);
    setUnlocalizedName(texture);
    setCreativeTab(CreativeTabs.tabBlock);
  }
  
  @Override
  public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float par7, float par8, float par9)
  {
    ItemStack held = player.getHeldItem();
    if (held != null) {
      if (held.getItem() == MagneticModule.magnet) {
        int targetX = x;
        int targetY = y;
        int targetZ = z;
          switch(side){
            case 0:
              targetY++;
              break;
            case 1:
              targetY--;
              break;
            case 2:
              targetZ++;
              break;
            case 3:
              targetZ--;
              break;
            case 4:
              targetX++;
              break;
            case 5:
              targetX--;
              break;
        }
        if (world.getBlockId(targetX, targetY, targetZ) == 0) {
          world.setBlock(targetX, targetY, targetZ, this.blockID);
          world.setBlock(x, y, z, 0);
          return true;
        }
      }
    }
    return false;
  }
}
