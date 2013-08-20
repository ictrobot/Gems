package ictrobot.lapisgem;

import ictrobot.lapisgem.armor.LapisGemHelmet;
import ictrobot.lapisgem.armor.LapisGemChestplate;
import ictrobot.lapisgem.armor.LapisGemLeggings;
import ictrobot.lapisgem.armor.LapisGemBoots;
import ictrobot.lapisgem.items.LapisGemItem;
import ictrobot.lapisgem.proxy.CommonProxy;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.src.ModLoader;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.EnumHelper;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid = "LapisGem", name = "LapisGem", version = "Alpha 0.0.1")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class LapisGem {
  @Instance("LapisGem")
  public static LapisGem instance;
  
  public static int lapisGemItemID;
  public static int lapisGemHelmetID;
  public static int lapisGemChestplateID;
  public static int lapisGemLeggingsID;
  public static int lapisGemBootsID;
  
  public static Item lapisGemItem;
  public static Item lapisGemHelmet;
  public static Item lapisGemChestplate;
  public static Item lapisGemLeggings;
  public static Item lapisGemBoots;
  
  
  @SidedProxy(clientSide = "ictrobot.lapisgem.client.ClientProxy", serverSide = "ictrobot.lapisgem.CommonProxy")
  public static CommonProxy proxy;

  @EventHandler
  public void preInit(FMLPreInitializationEvent event) {
    Configuration config = new Configuration(
        event.getSuggestedConfigurationFile());
    config.load();
    lapisGemItemID = config.get(Configuration.CATEGORY_ITEM, "LapisGemItem", 5000).getInt();
    lapisGemHelmetID = config.get(Configuration.CATEGORY_ITEM, "LapisGemItem", 5001).getInt();
    lapisGemChestplateID = config.get(Configuration.CATEGORY_ITEM, "LapisGemItem", 5002).getInt();
    lapisGemLeggingsID = config.get(Configuration.CATEGORY_ITEM, "LapisGemItem", 5003).getInt();
    lapisGemBootsID = config.get(Configuration.CATEGORY_ITEM, "LapisGemItem", 5004).getInt();
    config.save();
  }

  @EventHandler
  public void load(FMLInitializationEvent event) {
    proxy.registerRenderers();
    
    lapisGemItem = (new LapisGemItem(lapisGemItemID)).setMaxStackSize(64).setUnlocalizedName("LapisGem").setCreativeTab(CreativeTabs.tabMaterials);
    
    EnumArmorMaterial lapisGemArmor = EnumHelper.addArmorMaterial("Lapis Gem Armor", 40, new int[]{3, 8, 6, 3}, 50);
    
    lapisGemHelmet = new LapisGemHelmet(lapisGemHelmetID, lapisGemArmor, ModLoader.addArmor("LapisGem"), 0).setUnlocalizedName("LapisGemHelmet").setCreativeTab(CreativeTabs.tabCombat);
    lapisGemChestplate = new LapisGemChestplate(lapisGemChestplateID, lapisGemArmor, ModLoader.addArmor("LapisGem"), 1).setUnlocalizedName("LapisGemChestplate").setCreativeTab(CreativeTabs.tabCombat);
    lapisGemLeggings = new LapisGemLeggings(lapisGemLeggingsID, lapisGemArmor, ModLoader.addArmor("LapisGem"), 2).setUnlocalizedName("LapisGemLeggings").setCreativeTab(CreativeTabs.tabCombat);
    lapisGemBoots = new LapisGemBoots(lapisGemBootsID, lapisGemArmor, ModLoader.addArmor("LapisGem"), 3).setUnlocalizedName("LapisGemBoots").setCreativeTab(CreativeTabs.tabCombat);

    ItemStack lapisStack = new ItemStack(Item.dyePowder, 1, 4);
    ItemStack diamondStack = new ItemStack(Item.diamond);
    GameRegistry.addRecipe(new ItemStack(lapisGemItem), "xxx", "xyx", "xxx",
        'x', lapisStack, 'y', diamondStack);
  }

  @EventHandler
  public void postInit(FMLPostInitializationEvent event) {
    LanguageRegistry.addName(lapisGemItem, "Lapis Gem");
    LanguageRegistry.addName(lapisGemHelmet, "Lapis Gem Helmet");
    LanguageRegistry.addName(lapisGemChestplate, "Lapis Gem Chestplate");
    LanguageRegistry.addName(lapisGemLeggings, "Lapis Gem Leggings");
    LanguageRegistry.addName(lapisGemBoots, "Lapis Gem Boots");
    
    
  }
}
