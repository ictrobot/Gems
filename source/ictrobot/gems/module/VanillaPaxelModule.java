package ictrobot.gems.module;

import ictrobot.core.helper.tool.ToolMaterials;
import ictrobot.core.tool.Paxel;

import java.io.File;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.Configuration;

public class VanillaPaxelModule {
  
  //Define IDs - Vanilla Paxel
  public static int woodPaxelID;
  public static int stonePaxelID;
  public static int ironPaxelID;
  public static int goldPaxelID;
  public static int diamondPaxelID;
  //Define Items - Vanilla Paxel
  public static Item woodPaxel;
  public static Item stonePaxel;
  public static Item ironPaxel;
  public static Item goldPaxel;
  public static Item diamondPaxel;
    
    public static void Config(File file) {
      Configuration config = new Configuration(file);
      config.load();
      woodPaxelID = config.get(Configuration.CATEGORY_ITEM, "woodPaxel", 5031).getInt();
      stonePaxelID = config.get(Configuration.CATEGORY_ITEM, "stonePaxel", 5032).getInt();
      ironPaxelID = config.get(Configuration.CATEGORY_ITEM, "ironPaxel", 5033).getInt();
      goldPaxelID = config.get(Configuration.CATEGORY_ITEM, "goldPaxel", 5034).getInt();
      diamondPaxelID = config.get(Configuration.CATEGORY_ITEM, "diamondPaxel", 5035).getInt();
      config.save();
    }

    public static void Settings() {
      //Tools - Vanilla Paxel
      woodPaxel = (new Paxel(woodPaxelID, ToolMaterials.Wood));
      stonePaxel = (new Paxel(stonePaxelID, ToolMaterials.Stone));
      ironPaxel = (new Paxel(ironPaxelID, ToolMaterials.Iron));
      goldPaxel = (new Paxel(goldPaxelID, ToolMaterials.Gold));
      diamondPaxel = (new Paxel(diamondPaxelID, ToolMaterials.Diamond));
      //Register Recipes - Vanilla Paxel
      GameRegistry.addRecipe(new ItemStack(woodPaxel), "spa", " t ", " t ", 's', new ItemStack(Item.shovelWood, 1, 0), 'p', new ItemStack(Item.pickaxeWood, 1, 0), 'a', new ItemStack(Item.axeWood, 1, 0), 't', new ItemStack(Item.stick));
      GameRegistry.addRecipe(new ItemStack(stonePaxel), "spa", " t ", " t ", 's', new ItemStack(Item.shovelStone, 1, 0), 'p', new ItemStack(Item.pickaxeStone, 1, 0), 'a', new ItemStack(Item.axeStone, 1, 0), 't', new ItemStack(Item.stick));
      GameRegistry.addRecipe(new ItemStack(ironPaxel), "spa", " t ", " t ", 's', new ItemStack(Item.shovelIron, 1, 0), 'p', new ItemStack(Item.pickaxeIron, 1, 0), 'a', new ItemStack(Item.axeIron, 1, 0), 't', new ItemStack(Item.stick));
      GameRegistry.addRecipe(new ItemStack(goldPaxel), "spa", " t ", " t ", 's', new ItemStack(Item.shovelGold, 1, 0), 'p', new ItemStack(Item.pickaxeGold, 1, 0), 'a', new ItemStack(Item.axeGold, 1, 0), 't', new ItemStack(Item.stick));
      GameRegistry.addRecipe(new ItemStack(diamondPaxel), "spa", " t ", " t ", 's', new ItemStack(Item.shovelDiamond, 1, 0), 'p', new ItemStack(Item.pickaxeDiamond, 1, 0), 'a', new ItemStack(Item.axeDiamond, 1, 0), 't', new ItemStack(Item.stick));
    }
    
    public static void Register(){
      //Items - Vanilla Paxel
      LanguageRegistry.addName(woodPaxel, "Wooden Paxel");
      GameRegistry.registerItem(woodPaxel, "woodPaxel");
      LanguageRegistry.addName(stonePaxel, "Stone paxel");
      GameRegistry.registerItem(stonePaxel, "stonePaxel");
      LanguageRegistry.addName(ironPaxel, "Iron Paxel");
      GameRegistry.registerItem(ironPaxel, "ironPaxel");
      LanguageRegistry.addName(goldPaxel, "Gold Paxel");
      GameRegistry.registerItem(goldPaxel, "goldPaxel");
      LanguageRegistry.addName(diamondPaxel, "Diamond Paxel");
      GameRegistry.registerItem(diamondPaxel, "diamondPaxel");
    }
}
