package ictrobot.gems.module;

import ictrobot.core.helper.tool.*;
import ictrobot.core.item.*;
import ictrobot.core.tool.*;
import ictrobot.core.block.*;
import ictrobot.core.helper.register.Register;
import ictrobot.core.world.*;

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

   //Define Blocks - Colour Gems
   public static Block orePositive;
   public static Block oreNegative;
   
   //Define Items - Colour Gems
   public static Item positive;
   public static Item negative;

   public static Dim0WorldGenerator worldPositive;
   public static Dim0WorldGenerator worldNegative;
   
   public static void Config(File file) {
      Configuration config = new Configuration(file);
      config.load();
      //Items
      positiveID = config.get(Configuration.CATEGORY_ITEM, "positiveID", 5041).getInt();
      negativeID = config.get(Configuration.CATEGORY_ITEM, "negativeID", 5042).getInt();
      orePositiveID = config.get(Configuration.CATEGORY_ITEM, "orePositiveID", 801).getInt();
      oreNegativeID = config.get(Configuration.CATEGORY_ITEM, "oreNegativeID", 802).getInt();
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
   }
    
    public static void WorldGen() {
      GameRegistry.registerWorldGenerator(worldPositive);
      GameRegistry.registerWorldGenerator(worldNegative);
    }
    
    public static void Register(){
      //Blocks - Coloured Gems
      Register.Block(orePositive, "Positive Ore", "pickaxe", 4);
      Register.Block(oreNegative, "Negative Ore", "pickaxe", 4);
      //Items - Coloured Gems
      Register.Item(positive, "Positive Powder");
      Register.Item(negative, "Negative Powder");
    }
}
