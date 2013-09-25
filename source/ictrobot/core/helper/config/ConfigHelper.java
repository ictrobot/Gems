package ictrobot.core.helper.config;

import java.io.File;
import ictrobot.gems.Gems;
import net.minecraftforge.common.Configuration;

public class ConfigHelper {
  
  static int BaseBlockID = 1000;
  static int BaseItemID = 20000 - 256;
  
  static int ItemsRegistered = 0;
  static int BlocksRegistered = 0;
  
  static int ModulesItems = 100;
  static int ModulesBlocks = 10;
  
  static String Module;
  static Configuration config;

  public static void file(File file, String ModuleName) {
    Module = ModuleName;
    Gems.ModulesRegistered = Gems.ModulesRegistered + 1;
    config = new Configuration(file);
    BaseBlockID = BaseBlockID + (Gems.ModulesRegistered * ModulesBlocks);
    BaseItemID = BaseItemID + (Gems.ModulesRegistered * ModulesItems);
    ItemsRegistered = 0;
    BlocksRegistered = 0;
  }
  
  public static int item(String Name) {
    config.load();
    int id = config.get(Module + " - Item", Name, BaseItemID+ItemsRegistered).getInt();
    ItemsRegistered = ItemsRegistered + 1;
    config.save();
    return id;
  }
  
  public static int block(String Name) {
    config.load();
    int id = config.get(Module + " - Block", Name, BaseBlockID + BlocksRegistered).getInt();
    BlocksRegistered = BlocksRegistered + 1;
    config.save();
    return id;
  }
  
  public static String other(String Name, String normal) {
    config.load();
    String str = config.get(Module + " - Other", Name, normal).getString();
    config.save();
    return str;
  }
  
  public static int other(String Name, int normal) {
    config.load();
    int num = config.get(Module + " - Other", Name, normal).getInt();
    config.save();
    return num;
  }
  
  public static String other(String Subname, String Name, String normal) {
    config.load();
    String str = config.get(Module + " - " + Subname, Name, normal).getString();
    config.save();
    return str;
  }
  
  public static int other(String Subname, String Name, int normal) {
    config.load();
    int num = config.get(Module + " - " + Subname, Name, normal).getInt();
    config.save();
    return num;
  }
}
