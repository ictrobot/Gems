package ictrobot.gems;

//imports
import ictrobot.gems.armor.lapisgem.LapisGemBoots;
import ictrobot.gems.armor.lapisgem.LapisGemChestplate;
import ictrobot.gems.armor.lapisgem.LapisGemHelmet;
import ictrobot.gems.armor.lapisgem.LapisGemLeggings;
import ictrobot.gems.items.lapisgem.ChargedLapisGem;
import ictrobot.gems.items.lapisgem.LapisGem;
import ictrobot.gems.proxy.CommonProxy;
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

@Mod(modid = "Gems", name = "Gems", version = "Alpha 0.0.1")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class Gems {
  @Instance("Gems")
  public static Gems instance;
  
  //Define IDs
  public static int lapisGemID;
  public static int chargedLapisGemID;
  public static int lapisGemHelmetID;
  public static int lapisGemChestplateID;
  public static int lapisGemLeggingsID;
  public static int lapisGemBootsID;
  
  //Define Items
  public static Item lapisGem;
  public static Item chargedLapisGem;
  public static Item lapisGemHelmet;
  public static Item lapisGemChestplate;
  public static Item lapisGemLeggings;
  public static Item lapisGemBoots;
  
  //Proxy
  @SidedProxy(clientSide = "ictrobot.gems.proxy.ClientProxy", serverSide = "ictrobot.gems.proxy.CommonProxy")
  public static CommonProxy proxy;

  //preInit / Read Config
  @EventHandler
  public void preInit(FMLPreInitializationEvent event) {
    Configuration config = new Configuration(event.getSuggestedConfigurationFile());
    config.load();
    lapisGemID = config.get(Configuration.CATEGORY_ITEM, "LapisGem", 5001).getInt();
    chargedLapisGemID = config.get(Configuration.CATEGORY_ITEM, "ChargedLapisGem", 5002).getInt();
    lapisGemHelmetID = config.get(Configuration.CATEGORY_ITEM, "LapisGemHelmet", 5011).getInt();
    lapisGemChestplateID = config.get(Configuration.CATEGORY_ITEM, "LapisChestplate", 5012).getInt();
    lapisGemLeggingsID = config.get(Configuration.CATEGORY_ITEM, "LapisGemLeggings", 5013).getInt();
    lapisGemBootsID = config.get(Configuration.CATEGORY_ITEM, "LapisGemBoots", 5014).getInt();
    config.save();
  }
  
  //load
  @EventHandler
  public void load(FMLInitializationEvent event) {
    proxy.registerRenderers();
    
    // Settings for Items, Unlocalized Names, Creative Tabs
    lapisGem = (new LapisGem(lapisGemID)).setMaxStackSize(64).setUnlocalizedName("LapisGem").setCreativeTab(CreativeTabs.tabMaterials);
    chargedLapisGem = (new ChargedLapisGem(chargedLapisGemID)).setMaxStackSize(64).setUnlocalizedName("ChargedLapisGem").setCreativeTab(CreativeTabs.tabMaterials);
    
    EnumArmorMaterial lapisGemArmor = EnumHelper.addArmorMaterial("Lapis Gem Armor", 40, new int[]{5, 10, 8, 5}, 50);
    
    lapisGemHelmet = new LapisGemHelmet(lapisGemHelmetID, lapisGemArmor, ModLoader.addArmor("LapisGem"), 0).setUnlocalizedName("LapisGemHelmet").setCreativeTab(CreativeTabs.tabCombat);
    lapisGemChestplate = new LapisGemChestplate(lapisGemChestplateID, lapisGemArmor, ModLoader.addArmor("LapisGem"), 1).setUnlocalizedName("LapisGemChestplate").setCreativeTab(CreativeTabs.tabCombat);
    lapisGemLeggings = new LapisGemLeggings(lapisGemLeggingsID, lapisGemArmor, ModLoader.addArmor("LapisGem"), 2).setUnlocalizedName("LapisGemLeggings").setCreativeTab(CreativeTabs.tabCombat);
    lapisGemBoots = new LapisGemBoots(lapisGemBootsID, lapisGemArmor, ModLoader.addArmor("LapisGem"), 3).setUnlocalizedName("LapisGemBoots").setCreativeTab(CreativeTabs.tabCombat);

    //Register Recipes
    
    GameRegistry.addRecipe(new ItemStack(lapisGem, 1), "lll", "ldl", "lll", 'l',  new ItemStack(Item.dyePowder, 1, 4), 'd', new ItemStack(Item.diamond));
    GameRegistry.addSmelting(lapisGemID+256, new ItemStack(chargedLapisGem), 1);
    GameRegistry.addRecipe(new ItemStack(lapisGemHelmet), "lll", "l l", "   ", 'l',  new ItemStack(chargedLapisGem));
    GameRegistry.addRecipe(new ItemStack(lapisGemChestplate), "l l", "lll", "lll", 'l',  new ItemStack(chargedLapisGem));
    GameRegistry.addRecipe(new ItemStack(lapisGemLeggings), "lll", "l l", "l l", 'l',  new ItemStack(chargedLapisGem));
    GameRegistry.addRecipe(new ItemStack(lapisGemBoots), "   ", "l l", "l l", 'l',  new ItemStack(chargedLapisGem));
  }

  //postInit / Add Names
  @EventHandler
  public void postInit(FMLPostInitializationEvent event) {
    LanguageRegistry.addName(lapisGem, "Lapis Gem");
    LanguageRegistry.addName(chargedLapisGem, "Charged Lapis Gem");
    LanguageRegistry.addName(lapisGemHelmet, "Lapis Gem Helmet");
    LanguageRegistry.addName(lapisGemChestplate, "Lapis Gem Chestplate");
    LanguageRegistry.addName(lapisGemLeggings, "Lapis Gem Leggings");
    LanguageRegistry.addName(lapisGemBoots, "Lapis Gem Boots");
    
    
  }
}
