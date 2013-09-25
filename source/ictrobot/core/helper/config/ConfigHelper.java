package ictrobot.core.helper.config;

import java.io.File;
import ictrobot.gems.Gems;
import net.minecraftforge.common.Configuration;

public class ConfigHelper {
  //Starting BLock + Item IDs
  static int BlockID = 1000;
  static int ItemID = 20000 - 256;
  
  static int BaseBlockID = BlockID;
  static int BaseItemID = ItemID;
  
  static int ItemsRegistered = 0;
  static int BlocksRegistered = 0;
  
  static int ModulesItems = 100;
  static int ModulesBlocks = 10;
  
  static String Module;
  static Configuration config;

  public static void file(String ModuleName) {
    Module = ModuleName;
    Gems.ModulesRegistered = Gems.ModulesRegistered + 1;
    
    File configfile = new File(Gems.configdir, "Gems/" + ModuleName + ".cfg");
    
    config = new Configuration(configfile);
    config.load();
    
    BaseBlockID = BlockID + (Gems.ModulesRegistered * ModulesBlocks);
    BaseItemID = ItemID + (Gems.ModulesRegistered * ModulesItems);
    
    ItemsRegistered = 0;
    BlocksRegistered = 0;
  }
  
  public static void save() {
    config.save();
  }
  
  public static int item(String Name) {
    int id = config.get("Item", Name, BaseItemID+ItemsRegistered).getInt();
    ItemsRegistered = ItemsRegistered + 1;
    return id;
  }
  
  public static int block(String Name) {
    int id = config.get("Block", Name, BaseBlockID + BlocksRegistered).getInt();
    BlocksRegistered = BlocksRegistered + 1;
    return id;
  }
  
  public static String other(String Name, String normal) {
    String str = config.get("Other", Name, normal).getString();
    return str;
  }
  
  public static int other(String Name, int normal) {
    int num = config.get("Other", Name, normal).getInt();
    return num;
  }
  
  public static String other(String Subname, String Name, String normal) {
    String str = config.get(Subname, Name, normal).getString();
    return str;
  }
  
  public static int other(String Subname, String Name, int normal) {
    int num = config.get(Subname, Name, normal).getInt();
    return num;
  }
  
  public static boolean module(String Name, boolean normal) {
    boolean enabled = config.get("Module", Name, normal).getBoolean(normal);
    return enabled;
  }
}
