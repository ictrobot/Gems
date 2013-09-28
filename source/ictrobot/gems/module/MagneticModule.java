package ictrobot.gems.module;

import ictrobot.core.block.BasicBlock;
import ictrobot.core.block.Ore;
import ictrobot.core.helper.register.Register;
import ictrobot.core.helper.tool.ToolMaterials;
import ictrobot.core.helper.config.ConfigHelper;
import ictrobot.core.item.*;
import ictrobot.core.world.Dim0WorldGenerator;
import ictrobot.gems.magnetic.item.*;
import ictrobot.gems.magnetic.block.*;
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
   public static int magneticBlockID;
   public static int magnetID;

   //Define Blocks - Colour Gems
   public static Block orePositive;
   public static Block oreNegative;
   public static Block blockPositive;
   public static Block blockNegative;
   public static Block magneticBlock;
   
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
   public static Item magnet;

   public static Dim0WorldGenerator worldPositive;
   public static Dim0WorldGenerator worldNegative;
   
   public static void Config() {
      ConfigHelper.file("MagneticModule");
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
      magnetID = ConfigHelper.item("magnetID");
      
      blockPositiveID = ConfigHelper.block("blockPositiveID");
      blockNegativeID = ConfigHelper.block("blockNegativeID");
      orePositiveID = ConfigHelper.block("orePositiveID");
      oreNegativeID = ConfigHelper.block("oreNegativeID");
      magneticBlockID = ConfigHelper.block("magneticBlockID");
      
      ConfigHelper.save();
      
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
      repelPlayerLvl1 = (new RepelPlayer(repelPlayerLvl1ID, ToolMaterials.RepelPlayer, 1));
      repelPlayerLvl2 = (new RepelPlayer(repelPlayerLvl2ID, ToolMaterials.RepelPlayer, 2));
      repelPlayerLvl3 = (new RepelPlayer(repelPlayerLvl3ID, ToolMaterials.RepelPlayer, 3));
      repelPlayerLvl4 = (new RepelPlayer(repelPlayerLvl4ID, ToolMaterials.RepelPlayer, 4));
      repelPlayerLvl5 = (new RepelPlayer(repelPlayerLvl5ID, ToolMaterials.RepelPlayer, 5));
      magneticIngot = (new Ingot(magneticIngotID, "Magnetic"));
      magnet = (new BasicItem(magnetID, "Magnet"));
      //Function Blocks
      magneticBlock = (new MagneticBlock(magneticBlockID, "MagneticBlock", Material.iron));   
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
      GameRegistry.addRecipe(new ItemStack(magnet), "p n", "d d", "d d", 'd', new ItemStack(negative), 'p', new ItemStack(positive), 'n', new ItemStack(negative));
      GameRegistry.addRecipe(new ItemStack(magnet), "n p", "d d", "d d", 'd', new ItemStack(negative), 'p', new ItemStack(positive), 'n', new ItemStack(negative));
      GameRegistry.addRecipe(new ItemStack(magneticBlock), "ddd", "ddd", "ddd", 'd', new ItemStack(magneticIngot));
      GameRegistry.addShapelessRecipe(new ItemStack(positive, 9), new ItemStack(blockPositive));
      GameRegistry.addShapelessRecipe(new ItemStack(negative, 9), new ItemStack(blockNegative));
      GameRegistry.addShapelessRecipe(new ItemStack(magneticPowder), new ItemStack(positive), new ItemStack(negative));
      GameRegistry.addSmelting(magneticPowderID + 256, new ItemStack(magneticIngot), 1);
  
      
      //Blocks - Coloured Gems
      Register.Block(orePositive, "Positive Ore", "pickaxe", 3);
      Register.Block(oreNegative, "Negative Ore", "pickaxe", 3);
      Register.Block(blockPositive, "Positive Block", "pickaxe" , 3);
      Register.Block(blockNegative, "Negative Block", "pickaxe", 3);
      Register.Block(magneticBlock, "Magnetic Block", "pickaxe", 3);
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
      Register.Item(magnet, "Magnet");
    }
}
