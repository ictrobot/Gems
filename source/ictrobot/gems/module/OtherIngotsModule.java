package ictrobot.gems.module;

import ictrobot.core.block.BasicBlock;
import ictrobot.core.helper.config.ConfigHelper;
import ictrobot.core.helper.register.Register;
import ictrobot.core.helper.tool.ToolMaterials;
import ictrobot.core.item.Ingot;
import ictrobot.core.tool.Paxel;
import ictrobot.core.tool.Sword;
import java.io.File;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;

public class OtherIngotsModule {
    
   //Define IDs
   public static int obsidianIngotID;
   public static int refinedObsidianID;
   public static int obsidianPaxelID;
   public static int obsidianSwordID;
   
   //Define Blocks
   public static Block refinedObsidian;
   
   //Define Items
   public static Item obsidianIngot;
   public static Item obsidianPaxel;
   public static Item obsidianSword;
   
   
   public static void Config(File file) {
      ConfigHelper.file("OtherIngots");
      //Items
      obsidianIngotID = ConfigHelper.item("obsidianIngot");
      refinedObsidianID = ConfigHelper.block("refinedObsidian");
      obsidianPaxelID = ConfigHelper.item("obsidianPaxel");
      obsidianSwordID = ConfigHelper.item("obsidianSword");
   }
    		  

    public static void Settings() {
      
      //Ingots
      obsidianIngot = (new Ingot(obsidianIngotID, "Obsidian"));
      //Blocks
      refinedObsidian = (new BasicBlock(refinedObsidianID, "refinedObsidian", Material.rock)).setHardness(100.0F).setResistance(18000000.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("refinedObsidian").setCreativeTab(CreativeTabs.tabBlock);
      
      //Paxel
      obsidianPaxel = (new Paxel(obsidianPaxelID,  ToolMaterials.Obsidian));
      //Sword
      obsidianSword = (new Sword(obsidianSwordID, ToolMaterials.Obsidian));
      
   }

    
    public static void Register(){
      GameRegistry.addRecipe(new ItemStack(obsidianPaxel), "lbl", " s ", " s ", 'b', new ItemStack(refinedObsidian), 'l', new ItemStack(obsidianIngot), 's', new ItemStack(Item.stick));
      GameRegistry.addRecipe(new ItemStack(obsidianSword), " g ", " g ", " s ", 'g', new ItemStack(obsidianIngot), 's', new ItemStack(Item.stick));
      GameRegistry.addRecipe(new ItemStack(refinedObsidian), "ggg", "ggg", "ggg", 'g', new ItemStack(obsidianIngot));
      GameRegistry.addShapelessRecipe(new ItemStack(obsidianIngot, 9), new ItemStack(refinedObsidian));
      GameRegistry.addSmelting(Block.obsidian.blockID, new ItemStack(obsidianIngot), 10f);
      //Blocks - Coloured Gems
      Register.Block(refinedObsidian, "Refined Obsidian", "pickaxe", 3);
     //Items - Coloured Gems
      Register.Item(obsidianIngot, "Obsidian Ingot");
      
      Register.Item(obsidianPaxel, "Obsidian Paxel");
      Register.Item(obsidianSword, "Obsidian Sword");

    }
}
