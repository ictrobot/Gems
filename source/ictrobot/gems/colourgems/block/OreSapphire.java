package ictrobot.gems.colourgems.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.util.MathHelper;
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
  
  public int quantityDropped(int meta, int fortune, Random random){
    Random randomGenerator = new Random();
    int randomInt = randomGenerator.nextInt(3);
    return randomInt + fortune;
  }
  
  @Override
  public void dropBlockAsItemWithChance(World world, int x, int y, int z, int id, float f, int meta) {
      super.dropBlockAsItemWithChance(world, x, y, z, id, f, meta);
      this.dropXpOnBlockBreak(world, x, y, z, MathHelper.getRandomIntegerInRange(world.rand, 3, 5));
  }
}
