package ictrobot.gems.colourgems.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class Ore extends Block {

  public Ore(int id, Material par2Material, String texture) {
    super(id, par2Material);
    func_111022_d("Gems:" + texture);
  }
  
}
