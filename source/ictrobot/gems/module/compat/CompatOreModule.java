package ictrobot.gems.module.compat;

import ictrobot.core.helper.config.*;
import ictrobot.core.item.*;
import ictrobot.core.block.*;
import ictrobot.core.helper.register.Register;
import ictrobot.core.world.*;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;


public class CompatOreModule {
    
   //Define IDs - Colour Gems
   public static int oreCopperID;
   public static int oreTinID;
   public static int oreSilverID;
   public static int oreLeadID;
   
   public static int copperID;
   public static int tinID;
   public static int silverID;
   public static int leadID;

   //Define Blocks - Colour Gems
   public static Block oreCopper;
   public static Block oreTin;
   public static Block oreSilver;
   public static Block oreLead;

   public static Item copper;
   public static Item tin;
   public static Item silver;
   public static Item lead;
   
   public static Dim0WorldGenerator worldCopper;
   public static Dim0WorldGenerator worldTin;
   public static Dim0WorldGenerator worldSilver;
   public static Dim0WorldGenerator worldLead;
   
   public static void Config(int ID) {
      ConfigHelper.file("CompatOre", ID);
      //Items
      oreCopperID = ConfigHelper.block("oreCopperID");
      oreTinID = ConfigHelper.block("oreTinID");
      oreSilverID = ConfigHelper.block("oreSilverID");
      oreLeadID = ConfigHelper.block("oreLeadID");
      
      copperID = ConfigHelper.item("copperID");
      tinID = ConfigHelper.item("tinID");
      silverID = ConfigHelper.item("silverID");
      leadID = ConfigHelper.item("leadID");
      
      int CMaxH = ConfigHelper.other("Copper", "MaxH", 80);
      int CMinH = ConfigHelper.other("Copper", "MinH", 5);
      int CNumberOfVeins = ConfigHelper.other("Copper", "NumberOfVeins", 10);
      int CNumberInVeins = ConfigHelper.other("Copper", "NumberInVeins", 8);
      
      int TMaxH = ConfigHelper.other("Tin", "MaxH", 80);
      int TMinH = ConfigHelper.other("Tin", "MinH", 5);
      int TNumberOfVeins = ConfigHelper.other("Tin", "NumberOfVeins", 10);
      int TNumberInVeins = ConfigHelper.other("Tin", "NumberInVeins", 8);
      
      int SMaxH = ConfigHelper.other("Silver", "MaxH", 40);
      int SMinH = ConfigHelper.other("Silver", "MinH", 5);
      int SNumberOfVeins = ConfigHelper.other("Silver", "NumberOfVeins", 5);
      int SNumberInVeins = ConfigHelper.other("Silver", "NumberInVeins", 8);
      
      int LMaxH = ConfigHelper.other("Silver", "MaxH", 40);
      int LMinH = ConfigHelper.other("Silver", "MinH", 5);
      int LNumberOfVeins = ConfigHelper.other("Silver", "NumberOfVeins", 5);
      int LNumberInVeins = ConfigHelper.other("Silver", "NumberInVeins", 8);
      
      ConfigHelper.save();
      
      //Define World Gen
      worldCopper = new Dim0WorldGenerator(oreCopperID, CMaxH, CMinH, CNumberOfVeins, CNumberInVeins);
      worldTin = new Dim0WorldGenerator(oreTinID, TMaxH, TMinH, TNumberOfVeins, TNumberInVeins);
      worldSilver = new Dim0WorldGenerator(oreTinID, SMaxH, SMinH, SNumberOfVeins, SNumberInVeins);
      worldLead = new Dim0WorldGenerator(oreTinID, LMaxH, LMinH, LNumberOfVeins, LNumberInVeins);
    }

    public static void Settings() {
      //Ore
      oreCopper = (new Ore(oreCopperID, "Copper", oreCopperID));
      oreTin = (new Ore(oreTinID, "Tin", oreTinID));
      oreSilver = (new Ore(oreSilverID, "Silver", oreSilverID));
      oreLead = (new Ore(oreLeadID, "Lead", oreLeadID));
      
      copper = (new Ingot(copperID, "Copper"));
      tin = (new Ingot(tinID, "Tin"));
      silver = (new Ingot(silverID, "Silver"));
      lead = (new Ingot(leadID, "Lead"));
      
      
   }
    
    public static void WorldGen() {
      GameRegistry.registerWorldGenerator(worldCopper);
      GameRegistry.registerWorldGenerator(worldTin);
      GameRegistry.registerWorldGenerator(worldSilver);
      GameRegistry.registerWorldGenerator(worldLead);
    }
    
    public static void Register(){
      GameRegistry.addSmelting(oreCopperID, new ItemStack(copper), 1);
      GameRegistry.addSmelting(oreTinID, new ItemStack(tin), 1);
      GameRegistry.addSmelting(oreSilverID, new ItemStack(silver), 1);
      GameRegistry.addSmelting(oreLeadID, new ItemStack(lead), 1);
      
      Register.Block(oreCopper, "Copper Ore", "pickaxe", 1);
      Register.Block(oreTin, "Tin Ore", "pickaxe", 1);
      Register.Block(oreSilver, "Silver Ore", "pickaxe", 1);
      Register.Block(oreLead, "Lead Ore", "pickaxe", 1);
      
      Register.Item(copper, "Copper Ingot");
      Register.Item(tin, "Tin Ingot");
      Register.Item(silver, "Silver Ingot");
      Register.Item(lead, "Lead Ingot");
      
      Register.Ore("oreCopper", oreCopper);
      Register.Ore("oreTin", oreTin);
      Register.Ore("oreSilver", oreSilver);
      Register.Ore("oreLead", oreLead);
      
      Register.Ore("ingotCopper", copper);
      Register.Ore("ingotTin", tin);
      Register.Ore("ingotSilver", silver);
      Register.Ore("ingotLead", lead);
    }
}