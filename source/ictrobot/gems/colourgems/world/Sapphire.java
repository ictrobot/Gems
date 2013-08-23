package ictrobot.gems.colourgems.world;

import java.util.Random;
import ictrobot.gems.colourgems.ColourGemsModule;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import cpw.mods.fml.common.IWorldGenerator;

public class Sapphire implements IWorldGenerator {

@Override
public void generate(Random random, int chunkX, int chunkZ, World world,
IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
switch (world.provider.dimensionId) {
case -1:
generateNether();
break;
case 0:
generateSurface(world, random, chunkX * 16, chunkZ * 16);
break;
case 1:
generateEnd();
break;
}
}

public void generateSurface(World world, Random rand, int chunkX, int chunkZ) {
for (int i = 0; i < 20; i++) { //how many block will spawn in one chunk.
int randPosX = chunkX + rand.nextInt(16);
int randPosY = rand.nextInt(40); //height
int randPosZ = chunkZ + rand.nextInt(16);

(new WorldGenMinable(ColourGemsModule.oreSapphireID, 10)).generate(world, rand, randPosX, randPosY, randPosZ); //Change 10 to any number, this is how many block will spawn together.
}
}

public void generateNether() {
}

public void generateEnd() {
}

}