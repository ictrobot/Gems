package ictrobot.core.helper.config;

import java.io.File;
import ictrobot.gems.Gems;
import net.minecraftforge.common.Configuration;

public class ConfigHelper {
  
  static int BaseBlockID = 1000;
  static int BaseItemID = 20000;
  
  static String Module;
  static Configuration config;

  public static void file(File file, String ModuleName) {
    Module = ModuleName;
    config = new Configuration(file);
  }
  
  public static int item(String Name) {
    config.load();
    int id = config.get(Module + " - Item", Name, BaseItemID+Gems.ItemsRegistered).getInt();
    Gems.ItemsRegistered = Gems.ItemsRegistered + 1;
    config.save();
    return id;
  }
  
  public static int block(String Name) {
    config.load();
    int id = config.get(Module + " - Block", Name, BaseBlockID+Gems.BlocksRegistered).getInt();
    Gems.BlocksRegistered = Gems.BlocksRegistered + 1;
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
