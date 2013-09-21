package ictrobot.gems.colourgems.world;

import java.util.Random;

import ictrobot.gems.module.ColourGemsModule;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import cpw.mods.fml.common.IWorldGenerator;

public class WorldGreenSapphire implements IWorldGenerator {

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

  public void generateSurface(World world, Random rand, int chunkX, int chunkZ) {
    for (int i = 0; i < 7; i++) { // how many block will spawn in one chunk.
      Random randgs = new Random();
      int randPosX = chunkX + randgs.nextInt(16);
      int randPosY = randgs.nextInt(40); // height
      int randPosZ = chunkZ + randgs.nextInt(16);

      (new WorldGenMinable(ColourGemsModule.oreGreenSapphireID, 8)).generate(world, randgs, randPosX, randPosY, randPosZ);
    }
  }

  public void generateNether() {
  }

  public void generateEnd() {
  }

}
