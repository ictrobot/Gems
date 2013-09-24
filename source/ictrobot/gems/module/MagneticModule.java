package ictrobot.gems.module;

import ictrobot.core.block.BasicBlock;
import ictrobot.core.block.Ore;
import ictrobot.core.helper.register.Register;
import ictrobot.core.helper.tool.ToolMaterials;
import ictrobot.core.helper.config.ConfigHelper;
import ictrobot.core.item.*;
import ictrobot.core.world.Dim0WorldGenerator;
import ictrobot.gems.magnetic.item.RepelPlayer;

import java.io.File;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;


public class MagneticModule {
    
   //Define IDs - Colour Gems
   public static int positiveID;
   public static int negativeID;
   public static int magneticPowderID;
   public static int magneticIngotID;
   public static int orePositiveID;
   public static int oreNegativeID;
   public static int repelPlayerLvl1ID;
   public static int repelPlayerLvl2ID;
   public static int repelPlayerLvl3ID;
   public static int repelPlayerLvl4ID;
   public static int repelPlayerLvl5ID;
   public static int blockPositiveID;
   public static int blockNegativeID;

   //Define Blocks - Colour Gems
   public static Block orePositive;
   public static Block oreNegative;
   public static Block blockPositive;
   public static Block blockNegative;
   
   //Define Items - Colour Gems
   public static Item positive;
   public static Item negative;
   public static Item repelPlayerLvl1;
   public static Item repelPlayerLvl2;
   public static Item repelPlayerLvl3;
   public static Item repelPlayerLvl4;
   public static Item repelPlayerLvl5;
   public static Item magneticPowder;
   public static Item magneticIngot;

   public static Dim0WorldGenerator worldPositive;
   public static Dim0WorldGenerator worldNegative;
   
   public static void Config(File file) {
      ConfigHelper.file(file, "MagneticModule");
      //Items
      positiveID = ConfigHelper.item("positiveID");
      negativeID = ConfigHelper.item("negativeID");
      repelPlayerLvl1ID = ConfigHelper.item("repelPlayerLvl1ID");
      repelPlayerLvl2ID = ConfigHelper.item("repelPlayerLvl2ID");
      repelPlayerLvl3ID = ConfigHelper.item("repelPlayerLvl3ID");
      repelPlayerLvl4ID = ConfigHelper.item("repelPlayerLvl4ID");
      repelPlayerLvl5ID = ConfigHelper.item("repelPlayerLvl5ID");
      magneticPowderID = ConfigHelper.item("magneticPowderID");
      magneticIngotID = ConfigHelper.item("magneticIngotID");
      
      blockPositiveID = ConfigHelper.block("blockPositiveID");
      blockNegativeID = ConfigHelper.block("blockNegativeID");
      orePositiveID = ConfigHelper.block("orePositiveID");
      oreNegativeID = ConfigHelper.block("oreNegativeID");
      
      //Define World Gen
      worldPositive = new Dim0WorldGenerator(orePositiveID, 40, 5, 4, 8);
      worldNegative = new Dim0WorldGenerator(oreNegativeID, 40, 5, 4, 8);
    }

    public static void Settings() {
      //Ore
      orePositive = (new Ore(orePositiveID, "Positive", positiveID));
      oreNegative = (new Ore(oreNegativeID, "Negative", negativeID));
      //Items
      positive = (new Powder(positiveID, "Positive"));
      negative = (new Powder(negativeID, "Negative"));
      magneticPowder = (new Powder(magneticPowderID, "Magnetic"));
      repelPlayerLvl1 = (new RepelPlayer(repelPlayerLvl1ID, ToolMaterials.Magnetic, 1));
      repelPlayerLvl2 = (new RepelPlayer(repelPlayerLvl2ID, ToolMaterials.Magnetic, 2));
      repelPlayerLvl3 = (new RepelPlayer(repelPlayerLvl3ID, ToolMaterials.Magnetic, 3));
      repelPlayerLvl4 = (new RepelPlayer(repelPlayerLvl4ID, ToolMaterials.Magnetic, 4));
      repelPlayerLvl5 = (new RepelPlayer(repelPlayerLvl5ID, ToolMaterials.Magnetic, 5));
      magneticIngot = (new Ingot(magneticIngotID, "Magnetic"));
      //StorageBlocks
      blockPositive = (new BasicBlock(blockPositiveID, "Positiveblock", Material.rock)).setHardness(4.0F).setResistance(7.5F).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("BlockPositive").setCreativeTab(CreativeTabs.tabBlock);
      blockNegative = (new BasicBlock(blockNegativeID, "Negativeblock", Material.rock)).setHardness(4.0F).setResistance(7.5F).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("BlockNegative").setCreativeTab(CreativeTabs.tabBlock);
   }
    
    public static void WorldGen() {
      GameRegistry.registerWorldGenerator(worldPositive);
      GameRegistry.registerWorldGenerator(worldNegative);
    }
    
    public static void Register(){
    	
      GameRegistry.addRecipe(new ItemStack(repelPlayerLvl1), "n n", "p p", "m m", 'm', new ItemStack(Block.pistonBase), 'p', new ItemStack(positive), 'n', new ItemStack(negative));
      GameRegistry.addRecipe(new ItemStack(repelPlayerLvl1), "p p", "n n", "m m", 'm', new ItemStack(Block.pistonBase), 'p', new ItemStack(positive), 'n', new ItemStack(negative));
      GameRegistry.addRecipe(new ItemStack(repelPlayerLvl2), "   ", "m m", "pip", 'p', new ItemStack(Block.pistonBase), 'm', new ItemStack(repelPlayerLvl1), 'i', new ItemStack(Block.blockIron));
      GameRegistry.addRecipe(new ItemStack(repelPlayerLvl3), "   ", "mdm", "pip", 'p', new ItemStack(Block.pistonBase), 'm', new ItemStack(repelPlayerLvl2), 'i', new ItemStack(Block.blockIron), 'd', new ItemStack(Item.diamond));
      GameRegistry.addRecipe(new ItemStack(repelPlayerLvl4), "   ", "mdm", "pip", 'p', new ItemStack(Block.pistonBase), 'm', new ItemStack(repelPlayerLvl3), 'i', new ItemStack(Block.blockIron), 'd', new ItemStack(Item.diamond));
      GameRegistry.addRecipe(new ItemStack(repelPlayerLvl5), "   ", "mdm", "pip", 'p', new ItemStack(Block.pistonBase), 'm', new ItemStack(repelPlayerLvl4), 'i', new ItemStack(Block.blockIron), 'd', new ItemStack(Block.blockDiamond));
      GameRegistry.addRecipe(new ItemStack(blockPositive), "ddd", "ddd", "ddd", 'd', new ItemStack(positive));
      GameRegistry.addRecipe(new ItemStack(blockNegative), "ddd", "ddd", "ddd", 'd', new ItemStack(negative));
      GameRegistry.addShapelessRecipe(new ItemStack(positive, 9), new ItemStack(blockPositive));
      GameRegistry.addShapelessRecipe(new ItemStack(negative, 9), new ItemStack(blockNegative));
      GameRegistry.addShapelessRecipe(new ItemStack(magneticPowder), new ItemStack(positive), new ItemStack(negative));
      GameRegistry.addSmelting(magneticPowderID + 256, new ItemStack(magneticIngot), 1);
  
      
      //Blocks - Coloured Gems
      Register.Block(orePositive, "Positive Ore", "pickaxe", 3);
      Register.Block(oreNegative, "Negative Ore", "pickaxe", 3);
      Register.Block(blockPositive, "Positive Block", "pickaxe" , 3);
      Register.Block(blockNegative, "Negative Block", "pickaxe", 3);
      //Items - Coloured Gems
      Register.Item(positive, "Positive Powder");
      Register.Item(negative, "Negative Powder");
      Register.Item(magneticPowder, "Magnetic Powder");
      Register.Item(magneticIngot, "Magnetic Ingot");
      Register.Item(repelPlayerLvl1, "Magnetic Jump");
      Register.Item(repelPlayerLvl2, "Magnetic Jump");
      Register.Item(repelPlayerLvl3, "Magnetic Jump");
      Register.Item(repelPlayerLvl4, "Magnetic Jump");
      Register.Item(repelPlayerLvl5, "Magnetic Jump");
    }
}
