package ictrobot.gems.module;

import ictrobot.core.helper.tool.*;
import ictrobot.core.item.*;
import ictrobot.core.tool.*;
import ictrobot.core.block.*;
import ictrobot.core.helper.register.Register;
import ictrobot.core.world.*;
import ictrobot.gems.magnetic.item.*;

import java.io.File;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.Configuration;

@SuppressWarnings("unused")
public class MagneticModule {
    
   //Define IDs - Colour Gems
   public static int positiveID;
   public static int negativeID;
   public static int orePositiveID;
   public static int oreNegativeID;
   public static int repelPlayerID;

   //Define Blocks - Colour Gems
   public static Block orePositive;
   public static Block oreNegative;
   
   //Define Items - Colour Gems
   public static Item positive;
   public static Item negative;
   public static Item repelPlayer;

   public static Dim0WorldGenerator worldPositive;
   public static Dim0WorldGenerator worldNegative;
   
   public static void Config(File file) {
      Configuration config = new Configuration(file);
      config.load();
      //Items
      positiveID = config.get(Configuration.CATEGORY_ITEM, "positiveID", 6041).getInt();
      negativeID = config.get(Configuration.CATEGORY_ITEM, "negativeID", 6042).getInt();
      orePositiveID = config.get(Configuration.CATEGORY_ITEM, "orePositiveID", 801).getInt();
      oreNegativeID = config.get(Configuration.CATEGORY_ITEM, "oreNegativeID", 802).getInt();
      repelPlayerID = config.get(Configuration.CATEGORY_ITEM, "repelPlayerID", 6043).getInt();
      config.save();
      
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
      repelPlayer = (new RepelPlayer(repelPlayerID, ToolMaterials.Magnetic));
   }
    
    public static void WorldGen() {
      GameRegistry.registerWorldGenerator(worldPositive);
      GameRegistry.registerWorldGenerator(worldNegative);
    }
    
    public static void Register(){
      GameRegistry.addRecipe(new ItemStack(repelPlayer), "n n", "p p", "m m", 'm', new ItemStack(Block.pistonBase), 'p', new ItemStack(positive), 'n', new ItemStack(negative));
      GameRegistry.addRecipe(new ItemStack(repelPlayer), "p p", "n n", "m m", 'm', new ItemStack(Block.pistonBase), 'p', new ItemStack(positive), 'n', new ItemStack(negative));
      
      
      //Blocks - Coloured Gems
      Register.Block(orePositive, "Positive Ore", "pickaxe", 3);
      Register.Block(oreNegative, "Negative Ore", "pickaxe", 3);
      //Items - Coloured Gems
      Register.Item(positive, "Positive Powder");
      Register.Item(negative, "Negative Powder");
      Register.Item(repelPlayer, "Repel Player");
    }
}
