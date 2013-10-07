package ictrobot.gems.module;

import ictrobot.core.block.BasicBlock;
import ictrobot.core.helper.config.ConfigHelper;
import ictrobot.core.helper.register.Register;
import ictrobot.gems.Gems;
import ictrobot.gems.op.armor.OPboots;
import ictrobot.gems.op.armor.OPchestplate;
import ictrobot.gems.op.armor.OPhelmet;
import ictrobot.gems.op.armor.OPlegs;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.EnumHelper;
import cpw.mods.fml.common.registry.GameRegistry;

public class OParmorModule {
    
   //Define IDs
   public static int opHelmetID;
   public static int opChestplateID;
   public static int opLegsID;
   public static int opBootsID;
   public static int bigDiamondblockID;

   //Define Blocks
   public static Block bigDiamondblock;
   
   //Define Items
   public static Item opHelmet;
   public static Item opChestplate;
   public static Item opLegs;
   public static Item opBoots;
   
   //Define Armor Materals
   public static EnumArmorMaterial OP = EnumHelper.addArmorMaterial("OP", 2147483647, new int[] { 2147483647, 2147483647, 2147483647, 2147483647 }, 2147483647);

   
   public static void Config(int ID) {
      ConfigHelper.file("opArmor", ID);
      //Items
      bigDiamondblockID = ConfigHelper.block("bigDiamondblockID");
      opBootsID = ConfigHelper.item("opBootsID");
      opLegsID = ConfigHelper.item("opLegsID");
      opHelmetID = ConfigHelper.item("opHelmetID");
      opChestplateID = ConfigHelper.item("opChestplateID");
      
      ConfigHelper.save();
      }

    public static void Settings() {


      bigDiamondblock = (new BasicBlock(bigDiamondblockID, "bigDiamondblock", Material.iron)).setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("bigDiamondblock").setCreativeTab(CreativeTabs.tabBlock);

      
      opHelmet = (new OPhelmet(opHelmetID, OP, Gems.proxy.addArmor("OP"), 0) ).setUnlocalizedName("opHelmet").setCreativeTab(CreativeTabs.tabCombat);;
      opChestplate = (new OPchestplate(opChestplateID, OP, Gems.proxy.addArmor("OP"), 1) ).setUnlocalizedName("opChestplate").setCreativeTab(CreativeTabs.tabCombat);;
      opLegs = (new OPlegs(opLegsID, OP, Gems.proxy.addArmor("OP"), 2) ).setUnlocalizedName("opLegs").setCreativeTab(CreativeTabs.tabCombat);;
      opBoots = (new OPboots(opBootsID, OP, Gems.proxy.addArmor("OP"), 3) ).setUnlocalizedName("opBoots").setCreativeTab(CreativeTabs.tabCombat);;
   }
    

    public static void Register(){
        GameRegistry.addRecipe(new ItemStack(bigDiamondblock), "bbb", "bbb", "bbb", 'b', (new ItemStack(Block.blockDiamond)) );
    		Register.Item(opHelmet, "OP Helmet");
    		Register.Item(opChestplate, "OP Chestplate");
    		Register.Item(opLegs, "OP Legs");
    		Register.Item(opBoots, "OP Boots");
    		Register.Block(bigDiamondblock, "Big Diamond Block", "Pickaxe", 3);
    		

     
    }
}
