package ictrobot.gems.vanillapaxel.tools;

import net.minecraft.block.Block;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraftforge.common.MinecraftForge;

public class VanillaPaxel extends ItemTool {
  
  public static Block[] blocksEffectiveAgainst ={Block.cobblestone, Block.stoneDoubleSlab, Block.stoneSingleSlab, Block.stone, Block.sandStone, Block.cobblestoneMossy, Block.oreIron, Block.blockIron, Block.oreCoal, Block.blockGold, Block.oreGold, Block.oreDiamond, Block.blockDiamond, Block.ice, Block.netherrack, Block.oreLapis, Block.blockLapis, Block.oreRedstone, Block.oreRedstoneGlowing, Block.rail, Block.railDetector, Block.railPowered, Block.railActivator,Block.grass, Block.dirt, Block.sand, Block.gravel, Block.snow, Block.blockSnow, Block.blockClay, Block.tilledField, Block.slowSand, Block.mycelium, Block.planks, Block.bookShelf, Block.wood, Block.chest, Block.stoneDoubleSlab, Block.stoneSingleSlab, Block.pumpkin, Block.pumpkinLantern};
  public VanillaPaxel(int id, float speed, EnumToolMaterial ToolMaterial, String TextureName) {
    super(id, speed, ToolMaterial, Block.blocksList);
    func_111206_d("Gems:" + TextureName + "Paxel");
  }
  
  public boolean canHarvestBlock(Block par1Block)
  {
    Boolean harvest = false;
    int toolLevel = this.toolMaterial.getHarvestLevel();
    int pickaxeLevel = MinecraftForge.getBlockHarvestLevel(par1Block, new ItemStack(par1Block).getItemDamage(), "pickaxe");
    int shovelLevel = MinecraftForge.getBlockHarvestLevel(par1Block, new ItemStack(par1Block).getItemDamage(), "shovel");
    int axeLevel = MinecraftForge.getBlockHarvestLevel(par1Block, new ItemStack(par1Block).getItemDamage(), "axe");
    if (toolLevel >= pickaxeLevel && pickaxeLevel != -1){
      harvest = true;
    }
    if (shovelLevel >= pickaxeLevel && pickaxeLevel != -1){
      harvest = true;
    }
    if (axeLevel >= pickaxeLevel && pickaxeLevel != -1){
      harvest = true;
    }
    
    return harvest;
  }
}