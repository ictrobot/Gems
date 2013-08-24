package ictrobot.gems.colourgems.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockGem extends Block {

  public BlockGem(int par1, String texture) {
    super(par1, Material.rock);
    func_111022_d("Gems:" + texture);
  }

}
