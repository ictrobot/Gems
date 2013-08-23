package ictrobot.gems.colourgems.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import ictrobot.gems.colourgems.ColourGemsModule;

public class OreGreenSapphire extends Block {

  public OreGreenSapphire(int id, Material par2Material) {
    super(id, par2Material);
    func_111022_d("Gems:OreGreenSapphire");
  }
  
  public int idDropped(int par1, Random random, int par3) {
    return (ColourGemsModule.greenSapphireID + 256);
  }
  
  public int quantityDropped(Random rand){
    Random randomGenerator = new Random();
    int randomInt = randomGenerator.nextInt(4);
    return randomInt;
  }
}
