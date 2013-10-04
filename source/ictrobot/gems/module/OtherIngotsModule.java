package ictrobot.gems.module;

import ictrobot.core.block.BasicBlock;
import ictrobot.core.helper.config.ConfigHelper;
import ictrobot.core.helper.register.Register;
import ictrobot.core.helper.tool.ToolMaterials;
import ictrobot.core.item.Ingot;
import ictrobot.core.tool.Paxel;
import ictrobot.core.tool.Sword;
import ictrobot.gems.Gems;
import ictrobot.gems.otheringots.armor.*;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.EnumHelper;
import cpw.mods.fml.common.registry.GameRegistry;

public class OtherIngotsModule {
    
   //Define IDs
   public static int obsidianIngotID;
   public static int refinedObsidianID;
   public static int obsidianPaxelID;
   public static int obsidianSwordID;
   public static int obsidianHelmetID;
   public static int obsidianChestplateID;
   public static int obsidianLegsID;
   public static int obsidianBootsID;

   //Define Blocks
   public static Block refinedObsidian;
   
   //Define Items
   public static Item obsidianIngot;
   public static Item obsidianPaxel;
   public static Item obsidianSword;
   public static Item obsidianHelmet;
   public static Item obsidianChestplate;
   public static Item obsidianLegs;
   public static Item obsidianBoots;
   
   //Define Armor Materials
   public static EnumArmorMaterial Obsidian = EnumHelper.addArmorMaterial("Obsidian", 8192, new int[] { 400, 400, 400, 400 }, 1000);

   
   
   public static void Config(int ID) {
      ConfigHelper.file("OtherIngots", ID);
      //Items
      obsidianIngotID = ConfigHelper.item("obsidianIngot");
      refinedObsidianID = ConfigHelper.block("refinedObsidian");
      obsidianPaxelID = ConfigHelper.item("obsidianPaxel");
      obsidianSwordID = ConfigHelper.item("obsidianSword");
      obsidianHelmetID = ConfigHelper.item("obsidianHelmet");
      obsidianChestplateID = ConfigHelper.item("obsidianChestplate");
      obsidianLegsID = ConfigHelper.item("obsidianLegs");
      obsidianBootsID = ConfigHelper.item("obsidianBoots");

   }
    		  

    public static void Settings() {
      
      //Ingots
      obsidianIngot = (new Ingot(obsidianIngotID, "Obsidian"));
      //Blocks
      refinedObsidian = (new BasicBlock(refinedObsidianID, "refinedObsidian", Material.rock)).setHardness(75.0F).setResistance(6000.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("refinedObsidian").setCreativeTab(CreativeTabs.tabBlock);
      
      //Paxel
      obsidianPaxel = (new Paxel(obsidianPaxelID,  ToolMaterials.Obsidian));
      //Sword
      obsidianSword = (new Sword(obsidianSwordID, ToolMaterials.Obsidian));
      //Armor
      obsidianHelmet = new ObsidianHelmet(obsidianHelmetID, Obsidian, Gems.proxy.addArmor("Obsidian"), 0).setUnlocalizedName("ObsidianHelmet").setCreativeTab(CreativeTabs.tabCombat);
      obsidianChestplate = new ObsidianChestplate(obsidianChestplateID, Obsidian, Gems.proxy.addArmor("Obsidian"), 1).setUnlocalizedName("ObsidianChestplate").setCreativeTab(CreativeTabs.tabCombat);
      obsidianLegs = new ObsidianLeggings(obsidianLegsID, Obsidian, Gems.proxy.addArmor("Obsidian"), 2).setUnlocalizedName("ObsidianLegs").setCreativeTab(CreativeTabs.tabCombat);
      obsidianBoots = new ObsidianBoots(obsidianBootsID, Obsidian, Gems.proxy.addArmor("Obsidian"), 3).setUnlocalizedName("ObsidianBoots").setCreativeTab(CreativeTabs.tabCombat);
      
   }

    
    public static void Register(){
      //Recipies
      GameRegistry.addRecipe(new ItemStack(obsidianPaxel), "lbl", " s ", " s ", 'b', new ItemStack(refinedObsidian), 'l', new ItemStack(obsidianIngot), 's', new ItemStack(Item.stick));
      GameRegistry.addRecipe(new ItemStack(obsidianSword), " g ", " g ", " s ", 'g', new ItemStack(obsidianIngot), 's', new ItemStack(Item.stick));
      GameRegistry.addRecipe(new ItemStack(obsidianChestplate), "odo", "ooo", "ooo", 'o', new ItemStack(refinedObsidian), 'd', new ItemStack(Block.blockDiamond));
      GameRegistry.addRecipe(new ItemStack(obsidianHelmet), "ooo", "odo", "   ", 'o', new ItemStack(refinedObsidian), 'd', new ItemStack(Block.blockDiamond));
      GameRegistry.addRecipe(new ItemStack(obsidianLegs), "ooo", "odo", "o o", 'o', new ItemStack(refinedObsidian), 'd', new ItemStack(Block.blockDiamond));
      GameRegistry.addRecipe(new ItemStack(obsidianBoots), "   ", "o o", "odo", 'o', new ItemStack(refinedObsidian), 'd', new ItemStack(Block.blockDiamond));      GameRegistry.addRecipe(new ItemStack(obsidianBoots), "   ", "o o", "odo", 'o', new ItemStack(refinedObsidian), 'd', new ItemStack(Block.blockDiamond));
      GameRegistry.addRecipe(new ItemStack(refinedObsidian), "ooo", "odo", "ooo", 'o', new ItemStack(obsidianIngot), 'd', new ItemStack(Block.blockDiamond));
      GameRegistry.addShapelessRecipe(new ItemStack(obsidianIngot, 9), new ItemStack(refinedObsidian));
      GameRegistry.addShapelessRecipe(new ItemStack(refinedObsidian, 9), new ItemStack(obsidianIngot, 9));      
      GameRegistry.addSmelting(Block.obsidian.blockID, new ItemStack(obsidianIngot), 10f);
      //Blocks - Coloured Gems
      Register.Block(refinedObsidian, "Refined Obsidian", "pickaxe", 3);
      //Items - Coloured Gems
      Register.Item(obsidianIngot, "Obsidian Ingot");
      
      Register.Item(obsidianPaxel, "Obsidian Paxel");
      Register.Item(obsidianSword, "Obsidian Sword");
      Register.Item(obsidianHelmet, "Obsidian Helmet");
      Register.Item(obsidianChestplate, "Obsidian Chestplate");
      Register.Item(obsidianLegs, "Obsidian Leggings");
      Register.Item(obsidianBoots, "Obsidian Boots");

    }
}
