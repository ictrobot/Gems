package ictrobot.gems.module;

import ictrobot.core.helper.config.ConfigHelper;
import ictrobot.core.helper.register.Register;
import ictrobot.gems.magical.item.Warp;
import net.minecraft.item.Item;

public class MagicalModule {
    
   //Define IDs - Colour Gems
   public static int warpID;

   public static Item warp;
   
   public static void Config(int ID) {
      ConfigHelper.file("Magical", ID);

      warpID = ConfigHelper.item("warpID");
      
      ConfigHelper.save();
    }

    public static void Settings() {
      warp = (new Warp(warpID));
   }
    
    public static void Register(){
      Register.Item(warp, "Magical Warp");
    }
}
