package ictrobot.gems.colourgems.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.world.World;
import ictrobot.gems.colourgems.ColourGemsModule;

public class OreSapphire extends Block {

  public OreSapphire(int id, Material par2Material) {
    super(id, par2Material);
    func_111022_d("Gems:OreSapphire");
  }
  
  public int idDropped(int par1, Random random, int par3) {
    return (ColourGemsModule.sapphireID + 256);
  }
  
  public int quantityDropped(Random rand){
    Random randomGenerator = new Random();
    int randomInt = randomGenerator.nextInt(4);
    return randomInt;
  }
  
  public void onBlockDestroyedByPlayer(World par1World, int par2, int par3, int par4, int par5) 
  {
   this.dropXpOnBlockBreak(par1World, par2, par3, par4, 20);
  }
}
