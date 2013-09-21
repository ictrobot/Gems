package ictrobot.gems.module;

import java.io.File;

import ictrobot.core.helper.tool.ToolMaterials;
import ictrobot.core.item.*;
import ictrobot.core.tool.*;
import ictrobot.core.block.*;
import ictrobot.gems.Gems;
import ictrobot.gems.lapisgem.armor.*;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.EnumHelper;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.oredict.OreDictionary;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class LapisGemModule {

  // Define IDs - Lapis Gem
  public static int lapisGemID;
  public static int blockLapisGemID;
  public static int chargedLapisGemID;
  public static int lapisGemHelmetID;
  public static int lapisGemChestplateID;
  public static int lapisGemLeggingsID;
  public static int lapisGemBootsID;
  public static int lapisGemPaxelID;
  public static int lapisGemSwordID;
  // Define Items - Lapis Gem
  public static Item lapisGem;
  public static Item chargedLapisGem;
  public static Item lapisGemHelmet;
  public static Item lapisGemChestplate;
  public static Item lapisGemLeggings;
  public static Item lapisGemBoots;
  public static Item lapisGemPaxel;
  public static Item lapisGemSword;
  //Define Blocks - Lapis Gem
  public static Block blockLapisGem;
  //Define Blocks
  public static int lapisGemSwordDamage;
  public static void Config(File file) {
    Configuration config = new Configuration(file);
    config.load();
    lapisGemID = config.get(Configuration.CATEGORY_ITEM, "LapisGem", 5001).getInt();
    chargedLapisGemID = config.get(Configuration.CATEGORY_ITEM, "ChargedLapisGem", 5002).getInt();
    lapisGemHelmetID = config.get(Configuration.CATEGORY_ITEM, "LapisGemHelmet", 5011).getInt();
    lapisGemChestplateID = config.get(Configuration.CATEGORY_ITEM, "LapisChestplate", 5012).getInt();
    lapisGemLeggingsID = config.get(Configuration.CATEGORY_ITEM, "LapisGemLeggings", 5013).getInt();
    lapisGemBootsID = config.get(Configuration.CATEGORY_ITEM, "LapisGemBoots", 5014).getInt();
    lapisGemPaxelID = config.get(Configuration.CATEGORY_ITEM, "lapisGemPaxel", 5021).getInt();
    lapisGemSwordID = config.get(Configuration.CATEGORY_ITEM, "LapisGemSword", 5022).getInt();
    lapisGemSwordDamage = config.get(Configuration.CATEGORY_GENERAL, "lapisGemSwordDamage", 10).getInt();
    blockLapisGemID = config.get(Configuration.CATEGORY_BLOCK, "BlockLapisGem", 1001).getInt();
    config.save();
    
    lapisGemSwordDamage = lapisGemSwordDamage - 4;
  }
  
  public static void Settings() {
    //Items - Lapis Gem
    lapisGem = (new Gem(lapisGemID, "Lapis")).setMaxStackSize(64);
    chargedLapisGem = (new Gem(chargedLapisGemID, "ChargedLapis")).setMaxStackSize(16);
    //Tools - Lapis Gem
    lapisGemPaxel = (new Paxel(lapisGemPaxelID, ToolMaterials.ChargedLapisGem));
    //Swords - Lapis Gem
    lapisGemSword = (new Sword(lapisGemSwordID, ToolMaterials.ChargedLapisGem));
    //Armor - Lapis Gem
    EnumArmorMaterial lapisGemArmorMaterial = EnumHelper.addArmorMaterial("Lapis Gem Armor", 40, new int[] { 4, 9, 7, 4 }, 50);
    lapisGemHelmet = new LapisGemHelmet(lapisGemHelmetID, lapisGemArmorMaterial, Gems.proxy.addArmor("LapisGem"), 0).setUnlocalizedName("LapisGemHelmet").setCreativeTab(CreativeTabs.tabCombat);
    lapisGemChestplate = new LapisGemChestplate(lapisGemChestplateID, lapisGemArmorMaterial, Gems.proxy.addArmor("LapisGem"), 1).setUnlocalizedName("LapisGemChestplate").setCreativeTab(CreativeTabs.tabCombat);
    lapisGemLeggings = new LapisGemLeggings(lapisGemLeggingsID, lapisGemArmorMaterial, Gems.proxy.addArmor("LapisGem"), 2).setUnlocalizedName("LapisGemLeggings").setCreativeTab(CreativeTabs.tabCombat);
    lapisGemBoots = new LapisGemBoots(lapisGemBootsID, lapisGemArmorMaterial, Gems.proxy.addArmor("LapisGem"), 3).setUnlocalizedName("LapisGemBoots").setCreativeTab(CreativeTabs.tabCombat);
    //Blocks - Lapis Gem
    blockLapisGem = new BasicBlock(blockLapisGemID, "LapisGemblock",Material.rock).setHardness(4.0F).setResistance(7.5F).setStepSound(Block.soundMetalFootstep).setUnlocalizedName("BlockLapisGem").setCreativeTab(CreativeTabs.tabBlock);
    // Register Recipes - Lapis Gem
    GameRegistry.addRecipe(new ItemStack(lapisGem, 1), "lll", "ldl", "lll", 'l', new ItemStack(Item.dyePowder, 1, 4), 'd', new ItemStack(Item.diamond));
    GameRegistry.addSmelting(lapisGemID + 256, new ItemStack(chargedLapisGem), 1);
    GameRegistry.addRecipe(new ItemStack(lapisGemHelmet), "lll", "l l", "   ", 'l', new ItemStack(chargedLapisGem));
    GameRegistry.addRecipe(new ItemStack(lapisGemChestplate), "l l", "lll", "lll", 'l', new ItemStack(chargedLapisGem));
    GameRegistry.addRecipe(new ItemStack(lapisGemLeggings), "lll", "l l", "l l", 'l', new ItemStack(chargedLapisGem));
    GameRegistry.addRecipe(new ItemStack(lapisGemBoots), "   ", "l l", "l l", 'l', new ItemStack(chargedLapisGem));
    GameRegistry.addRecipe(new ItemStack(blockLapisGem), "lll", "lll", "lll", 'l', new ItemStack(chargedLapisGem));
    GameRegistry.addShapelessRecipe(new ItemStack(chargedLapisGem, 9), new ItemStack(blockLapisGem));
    GameRegistry.addRecipe(new ItemStack(lapisGemPaxel), "lbl", " s ", " s ", 'b', new ItemStack(blockLapisGem), 'l', new ItemStack(chargedLapisGem), 's', new ItemStack(Item.stick));
    GameRegistry.addRecipe(new ItemStack(lapisGemSword), " b ", " l ", " s ", 'b', new ItemStack(blockLapisGem), 'l', new ItemStack(chargedLapisGem), 's', new ItemStack(Item.stick));    
  }
  
  public static void Register(){
    //Items - Lapis Gem
    LanguageRegistry.addName(lapisGem, "Lapis Gem");
    GameRegistry.registerItem(lapisGem, "lapisGem");
    OreDictionary.registerOre("gemLapis", lapisGem);
    LanguageRegistry.addName(chargedLapisGem, "Lapis Gem");
    GameRegistry.registerItem(chargedLapisGem, "chargedLapisGem");
    OreDictionary.registerOre("gemChargedLapis", chargedLapisGem);
    LanguageRegistry.addName(lapisGemHelmet, "Lapis Gem Helmet");
    GameRegistry.registerItem(lapisGemHelmet, "lapisGemHelmet");
    LanguageRegistry.addName(lapisGemChestplate, "Lapis Gem Chestplate");
    GameRegistry.registerItem(lapisGemChestplate, "lapisGemChestplate");
    LanguageRegistry.addName(lapisGemLeggings, "Lapis Gem Leggings");
    GameRegistry.registerItem(lapisGemLeggings, "lapisGemLeggings");
    LanguageRegistry.addName(lapisGemBoots, "Lapis Gem Boots");
    GameRegistry.registerItem(lapisGemBoots, "lapisGemBoots");
    LanguageRegistry.addName(lapisGemPaxel, "Lapis Gem Paxel");
    GameRegistry.registerItem(lapisGemPaxel, "lapisGemPaxel");
    LanguageRegistry.addName(lapisGemSword, "Lapis Gem Sword");
    GameRegistry.registerItem(lapisGemSword, "lapisGemSword");
    //Blocks - Lapis Gem
    LanguageRegistry.addName(blockLapisGem, "Block of Lapis Gems");
    GameRegistry.registerBlock(blockLapisGem, "blockLapisGem");
    MinecraftForge.setBlockHarvestLevel(blockLapisGem, "pickaxe", 4);
  }
}
