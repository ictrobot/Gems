package ictrobot.gems.module;

import ictrobot.core.helper.tool.*;
import ictrobot.core.item.*;
import ictrobot.core.tool.*;
import ictrobot.core.block.*;
import ictrobot.core.helper.config.ConfigHelper;
import ictrobot.core.helper.register.Register;
import ictrobot.core.world.*;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

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
   
   public static int sapphirePickaxeID;
   public static int greenSapphirePickaxeID;
   public static int rubyPickaxeID;
   public static int sapphireAxeID;
   public static int greenSapphireAxeID;
   public static int rubyAxeID;
   public static int sapphireShovelID;
   public static int greenSapphireShovelID;
   public static int rubyShovelID;

   public static Item sapphirePickaxe;
   public static Item greenSapphirePickaxe;
   public static Item rubyPickaxe;
   public static Item sapphireAxe;
   public static Item greenSapphireAxe;
   public static Item rubyAxe;
   public static Item sapphireShovel;
   public static Item greenSapphireShovel;
   public static Item rubyShovel;
   
   public static Dim0WorldGenerator worldSapphire;
   public static Dim0WorldGenerator worldGreenSapphire;
   public static Dim0WorldGenerator worldRuby;
   
   public static void Config() {
      ConfigHelper.file("ColourGems");
      //Items
      sapphireID = ConfigHelper.item("sapphireID");
      greenSapphireID = ConfigHelper.item("greenSapphireID");
      rubyID = ConfigHelper.item("rubyID");
      sapphirePaxelID = ConfigHelper.item("sapphirePaxelID");
      greenSapphirePaxelID = ConfigHelper.item("greenSapphirePaxelID");
      rubyPaxelID = ConfigHelper.item("rubyPaxelID");
      sapphireSwordID = ConfigHelper.item("sapphireSwordID");
      greenSapphireSwordID = ConfigHelper.item("greenSapphireSwordID");
      rubySwordID = ConfigHelper.item("rubySwordID");

      sapphirePickaxeID = ConfigHelper.item("sapphirePickaxeID");
      greenSapphirePickaxeID = ConfigHelper.item("greenSapphirePickaxeID");
      rubyPickaxeID = ConfigHelper.item("rubyPickaxeID");
      sapphireAxeID = ConfigHelper.item("sapphireAxeID");
      greenSapphireAxeID = ConfigHelper.item("greenSapphireAxeID");
      rubyAxeID = ConfigHelper.item("rubyAxeID");
      sapphireShovelID = ConfigHelper.item("sapphireShovelID");
      greenSapphireShovelID = ConfigHelper.item("greenSapphireShovelID");
      rubyShovelID = ConfigHelper.item("rubyShovelID");
      //Blocks
      oreSapphireID = ConfigHelper.block("oreSapphireID");
      oreGreenSapphireID = ConfigHelper.block("oreGreenSapphireID");
      oreRubyID = ConfigHelper.block("oreRubyID");
      blockSapphireID = ConfigHelper.block("blockSapphireID");
      blockGreenSapphireID = ConfigHelper.block("blockGreenSapphireID");
      blockRubyID = ConfigHelper.block("blockRubyID");
      
      ConfigHelper.save();
      
      //Define World Gen - Colour Gems
      worldSapphire = new Dim0WorldGenerator(oreSapphireID, 40, 5, 7, 8);
      worldGreenSapphire = new Dim0WorldGenerator(oreGreenSapphireID, 40, 5, 7, 8);
      worldRuby = new Dim0WorldGenerator(oreRubyID, 40, 5, 7, 8);
    }

    public static void Settings() {
      //Ore
      oreSapphire = (new Ore(oreSapphireID, "Sapphire", sapphireID)).setHardness(3.0F);
      oreGreenSapphire = (new Ore(oreGreenSapphireID, "GreenSapphire", greenSapphireID));
      oreRuby = (new Ore(oreRubyID, "Ruby", rubyID)).setHardness(3.0F);
      //Gem Blocks
      blockSapphire = (new BasicBlock(blockSapphireID, "Sapphireblock", Material.iron)).setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("blockSapphire").setCreativeTab(CreativeTabs.tabBlock);
      blockGreenSapphire = (new BasicBlock(blockGreenSapphireID, "GreenSapphireblock", Material.iron)).setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("blockGreenSapphire").setCreativeTab(CreativeTabs.tabBlock);
      blockRuby = (new BasicBlock(blockRubyID, "Rubyblock", Material.iron)).setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("blockRuby").setCreativeTab(CreativeTabs.tabBlock);
      //Gems
      sapphire = (new Gem(sapphireID, "Sapphire"));
      greenSapphire = (new Gem(greenSapphireID, "GreenSapphire"));
      ruby = (new Gem(rubyID, "Ruby"));
      //Paxel
      sapphirePaxel = (new Paxel(sapphirePaxelID, ToolMaterials.Sapphire));
      greenSapphirePaxel = (new Paxel(greenSapphirePaxelID,  ToolMaterials.GreenSapphire));
      rubyPaxel = (new Paxel(rubyPaxelID,  ToolMaterials.Ruby));
      //Sword
      sapphireSword = (new Sword(sapphireSwordID, ToolMaterials.Sapphire));
      greenSapphireSword = (new Sword(greenSapphireSwordID, ToolMaterials.GreenSapphire));
      rubySword = (new Sword(rubySwordID, ToolMaterials.Ruby));
      //Pickaxe
      sapphirePickaxe = (new Pickaxe(sapphirePickaxeID, ToolMaterials.Sapphire));
      greenSapphirePickaxe = (new Pickaxe(greenSapphirePickaxeID, ToolMaterials.GreenSapphire));
      rubyPickaxe = (new Pickaxe(rubyPickaxeID, ToolMaterials.Ruby));
      //Axe
      sapphireAxe = (new Axe(sapphireAxeID, ToolMaterials.Sapphire));
      greenSapphireAxe = (new Axe(greenSapphireAxeID, ToolMaterials.GreenSapphire));
      rubyAxe = (new Axe(rubyAxeID, ToolMaterials.Ruby));
      //Shovel
      sapphireShovel = (new Shovel(sapphireShovelID, ToolMaterials.Sapphire));
      greenSapphireShovel = (new Shovel(greenSapphireShovelID, ToolMaterials.GreenSapphire));
      rubyShovel = (new Shovel(rubyShovelID, ToolMaterials.Ruby));
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
      GameRegistry.addRecipe(new ItemStack(sapphirePickaxe), "ggg", " s ", " s ", 'g', new ItemStack(sapphire), 's', new ItemStack(Item.stick));
      GameRegistry.addRecipe(new ItemStack(greenSapphirePickaxe), "ggg", " s ", " s ", 'g', new ItemStack(greenSapphire), 's', new ItemStack(Item.stick));
      GameRegistry.addRecipe(new ItemStack(rubyPickaxe), "ggg", " s ", " s ", 'g', new ItemStack(ruby), 's', new ItemStack(Item.stick));
      GameRegistry.addRecipe(new ItemStack(sapphireAxe), "gg ", "gs ", " s ", 'g', new ItemStack(sapphire), 's', new ItemStack(Item.stick));
      GameRegistry.addRecipe(new ItemStack(greenSapphireAxe), "gg ", "gs ", " s ", 'g', new ItemStack(greenSapphire), 's', new ItemStack(Item.stick));
      GameRegistry.addRecipe(new ItemStack(rubyAxe), "gg ", "gs ", " s ", 'g', new ItemStack(ruby), 's', new ItemStack(Item.stick));
      GameRegistry.addRecipe(new ItemStack(sapphireShovel), " g ", " s ", " s ", 'g', new ItemStack(sapphire), 's', new ItemStack(Item.stick));
      GameRegistry.addRecipe(new ItemStack(greenSapphireShovel), " g ", " s ", " s ", 'g', new ItemStack(greenSapphire), 's', new ItemStack(Item.stick));
      GameRegistry.addRecipe(new ItemStack(rubyShovel), " g ", " s ", " s ", 'g', new ItemStack(ruby), 's', new ItemStack(Item.stick));
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
      Register.Block(oreSapphire, "Sapphire Ore", "pickaxe", 2);
      Register.Block(oreGreenSapphire, "Green Sapphire Ore", "pickaxe", 2);
      Register.Block(oreRuby, "Ruby Ore", "pickaxe", 2);
      Register.Block(blockSapphire, "Sapphire Block", "pickaxe", 2);
      Register.Block(blockGreenSapphire, "Green Sapphire Block", "pickaxe", 2);
      Register.Block(blockRuby, "Ruby Block", "pickaxe", 2);
      //Items - Coloured Gems
      Register.Item(sapphire, "Sapphire");
      Register.Item(greenSapphire, "Green Sapphire");
      Register.Item(ruby, "Ruby");
      Register.Item(sapphirePaxel, "Sapphire Paxel");
      Register.Item(greenSapphirePaxel, "Green Sapphire Paxel");
      Register.Item(rubyPaxel, "Ruby Paxel");
      Register.Item(sapphireSword, "Sapphire Sword");
      Register.Item(greenSapphireSword, "Green Sapphire Sword");
      Register.Item(rubySword, "Ruby Sword");
      
      Register.Item(sapphirePickaxe, "Sapphire Pickaxe");
      Register.Item(greenSapphirePickaxe, "Green Sapphire Pickaxe");
      Register.Item(rubyPickaxe, "Ruby Pickaxe");
      Register.Item(sapphireAxe, "Sapphire Axe");
      Register.Item(greenSapphireAxe, "Green Sapphire Axe");
      Register.Item(rubyAxe, "Ruby Axe");
      Register.Item(sapphireShovel, "Sapphire Shovel");
      Register.Item(greenSapphireShovel, "Green Sapphire Shovel");
      Register.Item(rubyShovel, "Ruby Shovel");
      
      Register.Ore("gemSapphire", sapphire);
      Register.Ore("gemGreenSapphire", greenSapphire);
      Register.Ore("gemRuby", ruby);
    }
}
