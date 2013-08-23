package ictrobot.gems.colourgems.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import ictrobot.gems.colourgems.ColourGemsModule;

public class OreRuby extends Block {

  public OreRuby(int id, Material par2Material) {
    super(id, par2Material);
    func_111022_d("Gems:OreRuby");
  }
  
  public int idDropped(int par1, Random random, int par3) {
    return (ColourGemsModule.rubyID + 256);
  }
}
