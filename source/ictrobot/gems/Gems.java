package ictrobot.gems;

import net.minecraftforge.common.Configuration;
import ictrobot.core.proxy.*;
import ictrobot.gems.module.*;
import ictrobot.gems.module.compat.*;
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
  public boolean MagneticModuleEnable;
  public boolean CompatOreEnable;
  
  //FOR CONFIG HELPER
  public static int ModulesRegistered = -1;
  
  @SidedProxy(clientSide = "ictrobot.core.proxy.ClientProxy", serverSide = "ictrobot.core.proxy.CommonProxy")
  public static CommonProxy proxy;

  @EventHandler
  public void preInit(FMLPreInitializationEvent event) {
    Configuration config = new Configuration(event.getSuggestedConfigurationFile());
    config.load();
    LapisGemEnable = config.get("Modules", "LapisGem", true).getBoolean(true);
    VanillaPaxelEnable = config.get("Modules", "VanillaPaxel", true).getBoolean(true);
    ColouredGemsEnable = config.get("Modules", "ColouredGems", true).getBoolean(true);
    MagneticModuleEnable = config.get("Modules", "MagneticModule", true).getBoolean(true);
    CompatOreEnable = config.get("Modules", "CompatOre", false).getBoolean(false);
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
    if (MagneticModuleEnable==true) {
      MagneticModule.Config(event.getSuggestedConfigurationFile());
    }
    if (CompatOreEnable==true) {
      CompatOreModule.Config(event.getSuggestedConfigurationFile());
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
      ColourGemsModule.WorldGen();
    }
    if (MagneticModuleEnable==true) {
      MagneticModule.Settings();
      MagneticModule.WorldGen();
    }
    if (CompatOreEnable==true) {
      CompatOreModule.Settings();
      CompatOreModule.WorldGen();
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
    if (MagneticModuleEnable==true) {
      MagneticModule.Register();
    }
    if (CompatOreEnable==true) {
      CompatOreModule.Register();
    }
  }
  
}
