package ictrobot.gems.magnetic.armor;

import ictrobot.gems.module.MagneticModule;

import java.util.EnumSet;

import net.minecraft.entity.player.EntityPlayer;
import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.TickType;
public class JetpackTickHandler implements ITickHandler {
  private final EnumSet<TickType> ticksToGet;
  
  public static boolean tmp;
  public static boolean goingDown = false;
  public static boolean r1 = false;
  public static boolean r2 = false;

  public JetpackTickHandler(EnumSet<TickType> ticksToGet)
  {
           this.ticksToGet = ticksToGet;
  }

  @Override
  public void tickStart(EnumSet<TickType> type, Object... tickData)
  {
           playerTick((EntityPlayer)tickData[0]);
  }
  @Override
  public void tickEnd(EnumSet<TickType> type, Object... tickData)
  {
  }
  @Override
  public EnumSet<TickType> ticks()
  {
           return ticksToGet;
  }
  @Override
  public String getLabel()
  {
           return "GemsJetpack";
  }
  
  public static void playerTick(EntityPlayer player)
  {
    if(JetpackKeybind.keyPressed!=tmp) {
      tmp = JetpackKeybind.keyPressed;
      if(JetpackKeybind.keyPressed) {
        SendPacket.keydown(player);
      } else {
        SendPacket.keyup(player);
      }
    }
    
    boolean WearingArmor = player.getCurrentArmor(2) != null;
    boolean HasRing = player.inventory.hasItem(MagneticModule.flightRingID + 256);
    
    boolean ShouldFly = false;
    
    if (WearingArmor) {
      if (player.getCurrentArmor(2).itemID == MagneticModule.creativeJetpackID + 256) {
        ShouldFly = true;
      }
    }
    if (HasRing) {
      ShouldFly = true;
    }
    
    if (ShouldFly) {
      allowFlight(player);
    } else {
      disallowFlight(player);
    }
        
    if (goingDown) {
      if (!player.onGround) {
        player.motionY = -2;
      } else {
         goingDown = false;
      }
    }
  }
  
  public static void allowFlight(EntityPlayer player) {
    if (r1) {
      player.capabilities.allowFlying = true;
      player.sendPlayerAbilities();
      goingDown = false;
    }
    r1 = true;
    r2 = false;
  }
  
  public static void disallowFlight(EntityPlayer player) {
    if (!r2) {
      player.capabilities.allowFlying = false;
      player.sendPlayerAbilities();
      goingDown = true;
    }
    r2 = true;
    r1 = false;
  }
}