package ictrobot.core.block;

import ictrobot.core.Core;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class Ore extends Block {
  
  public String MaterialID;
  public int ItemDroppedID;

  public Ore(int id, String MaterialID, int DroppedID) {
    super(id, Material.rock);
    func_111022_d(Core.ModID + ":" + MaterialID + "ore");
    ItemDroppedID = DroppedID + 256;
  }
  
  public int idDropped(int par1, Random random, int par3) {
    return ItemDroppedID;
  }
  
  public int quantityDropped(int meta, int fortune, Random random){
    Random randomGenerator = new Random();
    int quantity = 0;
    if (fortune==1 || fortune==2 || fortune==3) {
      if (MathHelper.getRandomIntegerInRange(randomGenerator, 1, (5-fortune))==1){
        quantity = 2;
      } else{
        quantity = 1;
      }
      if (MathHelper.getRandomIntegerInRange(randomGenerator, 1, (4-fortune))==1){
        quantity = quantity + 1;
      }
    } else if (fortune==0) {
      if (MathHelper.getRandomIntegerInRange(randomGenerator, 1, 5)==1){
        quantity = 2;
      } else{
        quantity = 1;
      }
    }
      
    return quantity;
  }
  
  @Override
  public void dropBlockAsItemWithChance(World world, int x, int y, int z, int id, float f, int meta) {
      Random randomGenerator = new Random();
      super.dropBlockAsItemWithChance(world, x, y, z, id, f, meta);
      this.dropXpOnBlockBreak(world, x, y, z, MathHelper.getRandomIntegerInRange(randomGenerator, 3, 5));
  }
}
