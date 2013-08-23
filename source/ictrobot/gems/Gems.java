package ictrobot.gems;

import net.minecraftforge.common.Configuration;
import ictrobot.gems.proxy.*;
import ictrobot.gems.vanillapaxel.VanillaPaxelModule;
import ictrobot.gems.lapisgem.LapisGemModule;
import ictrobot.gems.colourgems.ColourGemsModule;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION_NUMBER)
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class Gems {
  @Instance(Reference.MOD_ID)
  public static Gems instance;

  public boolean LapisGemEnable;
  public boolean VanillaPaxelEnable;
  public boolean ColouredGemsEnable;
  
  @SidedProxy(clientSide = "ictrobot.gems.proxy.ClientProxy", serverSide = "ictrobot.gems.proxy.CommonProxy")
  public static CommonProxy proxy;

  @EventHandler
  public void preInit(FMLPreInitializationEvent event) {
    Configuration config = new Configuration(event.getSuggestedConfigurationFile());
    config.load();
    LapisGemEnable = config.get(Configuration.CATEGORY_GENERAL, "LapisGemEnable", true).getBoolean(true);
    VanillaPaxelEnable = config.get(Configuration.CATEGORY_GENERAL, "VanillaPaxelEnable", true).getBoolean(true);
    ColouredGemsEnable = config.get(Configuration.CATEGORY_GENERAL, "ColouredGemsEnable", true).getBoolean(true);
    config.save();
    
    if (LapisGemEnable==true) {
      LapisGemModule.Config(event.getSuggestedConfigurationFile());
    }
    if (VanillaPaxelEnable==true) {
      VanillaPaxelModule.Config(event.getSuggestedConfigurationFile());
    }
    if (ColouredGemsEnable==true) {
      ColourGemsModule.Config(event.getSuggestedConfigurationFile());
    }
    
    
    
  }

  @EventHandler
  public void load(FMLInitializationEvent event) {
    proxy.registerRenderers();
    
    if (LapisGemEnable==true) {
      LapisGemModule.Settings();
    }
    if (VanillaPaxelEnable==true) {
      VanillaPaxelModule.Settings();
    }
    if (ColouredGemsEnable==true) {
      ColourGemsModule.Settings();
    }
    
    
    
    

  }

  @EventHandler
  public void postInit(FMLPostInitializationEvent event) {

    if (LapisGemEnable==true) {
      LapisGemModule.Register();
    }
    if (VanillaPaxelEnable==true) {
      VanillaPaxelModule.Register();
    }
    if (ColouredGemsEnable==true) {
      ColourGemsModule.Register();
    }
    
    
    
    
    

  }
}
