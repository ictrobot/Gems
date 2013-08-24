package ictrobot.gems.colourgems;

import ictrobot.gems.colourgems.block.*;
import ictrobot.gems.colourgems.world.*;
import ictrobot.gems.colourgems.items.*;
import ictrobot.gems.colourgems.tools.*;

import java.io.File;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.EnumHelper;
import net.minecraftforge.common.MinecraftForge;

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
      oreSapphire = (new OreSapphire(oreSapphireID, Material.rock)).setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("oreSapphire").setCreativeTab(CreativeTabs.tabBlock);
      oreGreenSapphire = (new OreGreenSapphire(oreGreenSapphireID, Material.rock)).setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("oreGreenSapphire").setCreativeTab(CreativeTabs.tabBlock);
      oreRuby = (new OreRuby(oreRubyID, Material.rock)).setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("oreRuby").setCreativeTab(CreativeTabs.tabBlock);
      blockSapphire = (new BlockGem(blockSapphireID, "BlockSapphire")).setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("blockSapphire").setCreativeTab(CreativeTabs.tabBlock);
      blockGreenSapphire = (new BlockGem(blockGreenSapphireID, "BlockGreenSapphire")).setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("blockGreenSapphire").setCreativeTab(CreativeTabs.tabBlock);
      blockRuby = (new BlockGem(blockRubyID, "BlockRuby")).setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("blockRuby").setCreativeTab(CreativeTabs.tabBlock);
      //Items - Colour Gems
      sapphire = (new Gem(sapphireID, "GemSapphire")).setUnlocalizedName("Sapphire").setCreativeTab(CreativeTabs.tabMaterials);
      greenSapphire = (new Gem(greenSapphireID, "GemGreenSapphire")).setUnlocalizedName("GreenSapphire").setCreativeTab(CreativeTabs.tabMaterials);
      ruby = (new Gem(rubyID, "GemRuby")).setUnlocalizedName("Ruby").setCreativeTab(CreativeTabs.tabMaterials);
      //Tools - Colour Gems
      EnumToolMaterial colourgemToolMaterial = EnumHelper.addToolMaterial("Gem Tool", 3, 512, 8.0F, -3.0F, 10);
      sapphirePaxel = (new ColourGemPaxel(sapphirePaxelID, 8F, colourgemToolMaterial, "Sapphire")).setUnlocalizedName("sapphirePaxel").setCreativeTab(CreativeTabs.tabTools);
      greenSapphirePaxel = (new ColourGemPaxel(greenSapphirePaxelID, 8F, colourgemToolMaterial, "GreenSapphire")).setUnlocalizedName("greenSapphirePaxel").setCreativeTab(CreativeTabs.tabTools);
      rubyPaxel = (new ColourGemPaxel(rubyPaxelID, 8F, colourgemToolMaterial, "Ruby")).setUnlocalizedName("rubyPaxel").setCreativeTab(CreativeTabs.tabTools);
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
      LanguageRegistry.addName(greenSapphire, "Green Sapphire");
      GameRegistry.registerItem(greenSapphire, "greenSapphire");
      LanguageRegistry.addName(ruby, "Ruby");
      GameRegistry.registerItem(ruby, "ruby");
      LanguageRegistry.addName(sapphirePaxel, "Sapphire Paxel");
      GameRegistry.registerItem(sapphirePaxel, "sapphirePaxel");
      LanguageRegistry.addName(greenSapphirePaxel, "Green Sapphire Paxel");
      GameRegistry.registerItem(greenSapphirePaxel, "greenSapphirePaxel");
      LanguageRegistry.addName(rubyPaxel, "Ruby Paxel");
      GameRegistry.registerItem(rubyPaxel, "rubyPaxel");
    }
}
