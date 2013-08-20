package ictrobot.lapisgem;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.Configuration;
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

  @SidedProxy(clientSide = "ictrobot.lapisgem.client.ClientProxy", serverSide = "ictrobot.lapisgem.CommonProxy")
  public static CommonProxy proxy;

  @EventHandler
  public void preInit(FMLPreInitializationEvent event) {
    Configuration config = new Configuration(
        event.getSuggestedConfigurationFile());
    config.load();
    @SuppressWarnings("unused")
    int lapisGemID = config.get(Configuration.CATEGORY_ITEM, "LapisGemItem", 5000).getInt();
    config.save();
  }

  @EventHandler
  public void load(FMLInitializationEvent event) {
    proxy.registerRenderers();

    lapisGemItem = (new LapisGemItem(lapisGemID));
    LanguageRegistry.addName(lapisGemItem, "Lapis Gem");

    ItemStack lapisStack = new ItemStack(Item.dyePowder, 1, 4);
    ItemStack diamondStack = new ItemStack(Item.diamond);
    GameRegistry.addRecipe(new ItemStack(lapisGemItem), "xxx", "xyx", "xxx",
        'x', lapisStack, 'y', diamondStack);
  }

  @EventHandler
  public void postInit(FMLPostInitializationEvent event) {

  }

  public static int lapisGemID;
  public static Item lapisGemItem;
}