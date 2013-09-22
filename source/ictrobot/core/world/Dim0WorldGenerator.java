package ictrobot.core.world;

import java.util.Random;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import cpw.mods.fml.common.IWorldGenerator;

public class Dim0WorldGenerator implements IWorldGenerator {
  
  public int OreID;
  public int MaxHeight;
  public int MinHeight;
  public int Veins;
  public int OreinVein;
  
  /* OreID
   * MaxHeight
   * MinHeight
   * Veins
   * OreinVein
   */
  public Dim0WorldGenerator(int par1, int par2, int par3, int par4, int par5) {
    OreID = par1;
    MaxHeight = par2;
    MinHeight = par3;
    Veins = par4;
    OreinVein = par5;
  }

  @Override
  public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
    if (world.provider.dimensionId == -1 || world.provider.dimensionId == 1) {
      switch (world.provider.dimensionId) {
        case -1:
          generateNether();
          break;
        case 1:
          generateEnd();
          break;
      }
    } else {
    generateSurface(world, random, chunkX * 16, chunkZ * 16); 
    }
  }

  public void generateSurface(World world, Random unused, int chunkX, int chunkZ) {
    for (int i = 0; i < Veins; i++) {
      Random rand = new Random();
      int randPosX = chunkX + rand.nextInt(16);
      int randPosY = MathHelper.getRandomIntegerInRange(rand, MinHeight, MaxHeight);
      int randPosZ = chunkZ + rand.nextInt(16);

      (new WorldGenMinable(OreID, OreinVein)).generate(world, rand, randPosX, randPosY, randPosZ);
    }
  }

  public void generateNether() {
  }

  public void generateEnd() {
  }

}
