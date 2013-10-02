package ictrobot.core;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.relauncher.Side;
//Reference CLASS
import ictrobot.gems.Reference;

public class Core {

  public static String ModID = Reference.MOD_ID;

  public static boolean isServer() {
    Side side = FMLCommonHandler.instance().getEffectiveSide();
    return side.isServer();
  }
  
  public static boolean isClient() {
    Side side = FMLCommonHandler.instance().getEffectiveSide();
    return side.isClient();
  }
  
  public static void output(String string) {
    System.out.println(string);
  }
}
