package ictrobot.gems.module;

import ictrobot.core.helper.tool.*;
import ictrobot.core.item.*;
import ictrobot.core.tool.*;
import ictrobot.core.block.*;
import ictrobot.gems.colourgems.world.*;

import java.io.File;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.oredict.OreDictionary;

public class ColourGemsModule {
    
   //Define IDs - Colour Gems
   public static int oreSapphireID;
   public static int oreGreenSapphireID;
   public static int oreRubyID;
   public static int sapphireID;
   public static int greenSapphireID;
   public static int rubyID;
   public static int sapphirePaxelID;
   public static int greenSapphirePaxelID;
   public static int rubyPaxelID;
   public static int sapphireSwordID;
   public static int greenSapphireSwordID;
   public static int rubySwordID;
   public static int blockSapphireID;
   public static int blockGreenSapphireID;
   public static int blockRubyID;
   //Define Blocks - Colour Gems
   public static Block oreSapphire;
   public static Block oreGreenSapphire;
   public static Block oreRuby;
   public static Block blockSapphire;
   public static Block blockGreenSapphire;
   public static Block blockRuby;
   
   //Define Items - Colour Gems
   public static Item sapphire;
   public static Item greenSapphire;
   public static Item ruby;
   public static Item sapphirePaxel;
   public static Item greenSapphirePaxel;
   public static Item rubyPaxel;
   public static Item sapphireSword;
   public static Item greenSapphireSword;
   public static Item rubySword;
   
   //Define World Gen - Colour Gems
   public static WorldSapphire worldSapphire = new WorldSapphire();
   public static WorldGreenSapphire worldGreenSapphire = new WorldGreenSapphire();
   public static WorldRuby worldRuby = new WorldRuby();
  
    public static void Config(File file) {
      Configuration config = new Configuration(file);
      config.load();
      //Items
      sapphireID = config.get(Configuration.CATEGORY_ITEM, "Sapphire", 5041).getInt();
      greenSapphireID = config.get(Configuration.CATEGORY_ITEM, "GreenSapphire", 5042).getInt();
      rubyID = config.get(Configuration.CATEGORY_ITEM, "Ruby", 5043).getInt();
      sapphirePaxelID = config.get(Configuration.CATEGORY_ITEM, "SapphirePaxel", 5044).getInt();
      greenSapphirePaxelID = config.get(Configuration.CATEGORY_ITEM, "GreenSapphirePaxel", 5045).getInt();
      rubyPaxelID = config.get(Configuration.CATEGORY_ITEM, "RubyPaxel", 5046).getInt();
      sapphireSwordID = config.get(Configuration.CATEGORY_ITEM, "SapphireSword", 5047).getInt();
      greenSapphireSwordID = config.get(Configuration.CATEGORY_ITEM, "GreenSapphireSword", 5048).getInt();
      rubySwordID = config.get(Configuration.CATEGORY_ITEM, "RubySword", 5049).getInt();
      //Blocks
      oreSapphireID = config.get(Configuration.CATEGORY_BLOCK, "OreSapphire", 1011).getInt();
      oreGreenSapphireID = config.get(Configuration.CATEGORY_BLOCK, "OreGreenSapphire", 1012).getInt();
      oreRubyID = config.get(Configuration.CATEGORY_BLOCK, "OreRuby", 1013).getInt();
      blockSapphireID = config.get(Configuration.CATEGORY_BLOCK, "BlockSapphire", 1014).getInt();
      blockGreenSapphireID = config.get(Configuration.CATEGORY_BLOCK, "BlockGreenSapphire", 1015).getInt();
      blockRubyID = config.get(Configuration.CATEGORY_BLOCK, "BlockRuby", 1016).getInt();
      config.save();
    }

    public static void Settings() {
      //Blocks - Colour Gems
      oreSapphire = (new Ore(oreSapphireID, "Sapphire", sapphireID)).setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("oreSapphire").setCreativeTab(CreativeTabs.tabBlock);
      oreGreenSapphire = (new Ore(oreGreenSapphireID, "GreenSapphire", greenSapphireID)).setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("oreGreenSapphire").setCreativeTab(CreativeTabs.tabBlock);
      oreRuby = (new Ore(oreRubyID, "Ruby", rubyID)).setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("oreRuby").setCreativeTab(CreativeTabs.tabBlock);
      blockSapphire = (new BasicBlock(blockSapphireID, "Sapphireblock", Material.iron)).setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("blockSapphire").setCreativeTab(CreativeTabs.tabBlock);
      blockGreenSapphire = (new BasicBlock(blockGreenSapphireID, "GreenSapphireblock", Material.iron)).setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("blockGreenSapphire").setCreativeTab(CreativeTabs.tabBlock);
      blockRuby = (new BasicBlock(blockRubyID, "Rubyblock", Material.iron)).setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("blockRuby").setCreativeTab(CreativeTabs.tabBlock);
      //Items - Colour Gems
      sapphire = (new Gem(sapphireID, "Sapphire"));
      greenSapphire = (new Gem(greenSapphireID, "GreenSapphire"));
      ruby = (new Gem(rubyID, "Ruby"));
      //Tools - Colour Gems
      sapphirePaxel = (new Paxel(sapphirePaxelID, ToolMaterials.Sapphire));
      greenSapphirePaxel = (new Paxel(greenSapphirePaxelID,  ToolMaterials.GreenSapphire));
      rubyPaxel = (new Paxel(rubyPaxelID,  ToolMaterials.Ruby));
      sapphireSword = (new Sword(sapphireSwordID, ToolMaterials.Sapphire));
      greenSapphireSword = (new Sword(greenSapphireSwordID, ToolMaterials.GreenSapphire));
      rubySword = (new Sword(rubySwordID, ToolMaterials.Ruby));
   }
    
    public static void WorldGen() {
      GameRegistry.registerWorldGenerator(worldSapphire);
      GameRegistry.registerWorldGenerator(worldGreenSapphire);
      GameRegistry.registerWorldGenerator(worldRuby);
    }
    
    public static void Register(){
      GameRegistry.addRecipe(new ItemStack(sapphirePaxel), "lbl", " s ", " s ", 'b', new ItemStack(blockSapphire), 'l', new ItemStack(sapphire), 's', new ItemStack(Item.stick));
      GameRegistry.addRecipe(new ItemStack(greenSapphirePaxel), "lbl", " s ", " s ", 'b', new ItemStack(blockGreenSapphire), 'l', new ItemStack(greenSapphire), 's', new ItemStack(Item.stick));
      GameRegistry.addRecipe(new ItemStack(rubyPaxel), "lbl", " s ", " s ", 'b', new ItemStack(blockRuby), 'l', new ItemStack(ruby), 's', new ItemStack(Item.stick));
      GameRegistry.addRecipe(new ItemStack(sapphireSword), " g ", " g ", " s ", 'g', new ItemStack(sapphire), 's', new ItemStack(Item.stick));
      GameRegistry.addRecipe(new ItemStack(greenSapphireSword), " g ", " g ", " s ", 'g', new ItemStack(greenSapphire), 's', new ItemStack(Item.stick));
      GameRegistry.addRecipe(new ItemStack(rubySword), " g ", " g ", " s ", 'g', new ItemStack(ruby), 's', new ItemStack(Item.stick));
      GameRegistry.addRecipe(new ItemStack(blockSapphire), "ggg", "ggg", "ggg", 'g', new ItemStack(sapphire));
      GameRegistry.addRecipe(new ItemStack(blockGreenSapphire), "ggg", "ggg", "ggg", 'g', new ItemStack(greenSapphire));
      GameRegistry.addRecipe(new ItemStack(blockRuby), "ggg", "ggg", "ggg", 'g', new ItemStack(ruby));
      GameRegistry.addShapelessRecipe(new ItemStack(sapphire, 9), new ItemStack(blockSapphire));
      GameRegistry.addShapelessRecipe(new ItemStack(greenSapphire, 9), new ItemStack(blockGreenSapphire));
      GameRegistry.addShapelessRecipe(new ItemStack(ruby, 9), new ItemStack(blockRuby));
      //Blocks - Coloured Gems
      LanguageRegistry.addName(oreSapphire, "Sapphire Ore");
      GameRegistry.registerBlock(oreSapphire, "oreSapphire");
      MinecraftForge.setBlockHarvestLevel(oreSapphire, "pickaxe", 2);
      LanguageRegistry.addName(oreGreenSapphire, "Green Sapphire Ore");
      GameRegistry.registerBlock(oreGreenSapphire, "oreGreenSapphire");
      MinecraftForge.setBlockHarvestLevel(oreGreenSapphire, "pickaxe", 2);
      LanguageRegistry.addName(oreRuby, "Ruby Ore");
      GameRegistry.registerBlock(oreRuby, "oreRuby");
      MinecraftForge.setBlockHarvestLevel(oreRuby, "pickaxe", 2);
      LanguageRegistry.addName(blockSapphire, "Block of Sapphire");
      GameRegistry.registerBlock(blockSapphire, "blockSapphire");
      MinecraftForge.setBlockHarvestLevel(blockSapphire, "pickaxe", 2);
      LanguageRegistry.addName(blockGreenSapphire, "Block of Green Sapphire");
      GameRegistry.registerBlock(blockGreenSapphire, "blockGreenSapphire");
      MinecraftForge.setBlockHarvestLevel(blockGreenSapphire, "pickaxe", 2);
      LanguageRegistry.addName(blockRuby, "Block of Ruby");
      GameRegistry.registerBlock(blockRuby, "blockRuby");
      MinecraftForge.setBlockHarvestLevel(blockRuby, "pickaxe", 2);
      //Items - Coloured Gems
      LanguageRegistry.addName(sapphire, "Sapphire");
      GameRegistry.registerItem(sapphire, "sapphire");
      OreDictionary.registerOre("gemSapphire", sapphire);
      LanguageRegistry.addName(greenSapphire, "Green Sapphire");
      GameRegistry.registerItem(greenSapphire, "greenSapphire");
      OreDictionary.registerOre("gemGreenSapphire", greenSapphire);
      LanguageRegistry.addName(ruby, "Ruby");
      GameRegistry.registerItem(ruby, "ruby");
      OreDictionary.registerOre("gemRuby", ruby);
      LanguageRegistry.addName(sapphirePaxel, "Sapphire Paxel");
      GameRegistry.registerItem(sapphirePaxel, "sapphirePaxel");
      LanguageRegistry.addName(greenSapphirePaxel, "Green Sapphire Paxel");
      GameRegistry.registerItem(greenSapphirePaxel, "greenSapphirePaxel");
      LanguageRegistry.addName(rubyPaxel, "Ruby Paxel");
      GameRegistry.registerItem(rubyPaxel, "rubyPaxel");
      LanguageRegistry.addName(sapphireSword, "Sapphire Sword");
      GameRegistry.registerItem(sapphireSword, "sapphireSword");
      LanguageRegistry.addName(greenSapphireSword, "Green Sapphire Sword");
      GameRegistry.registerItem(greenSapphireSword, "greenSapphireSword");
      LanguageRegistry.addName(rubySword, "Ruby Sword");
      GameRegistry.registerItem(rubySword, "rubySword");
    }
}
