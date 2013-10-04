package ictrobot.gems.magnetic.tickhandlers;

import ictrobot.core.Core;
import ictrobot.gems.Gems;
import ictrobot.gems.magnetic.armor.JetpackKeybind;
import ictrobot.gems.module.MagneticModule;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.util.EnumSet;

import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.packet.Packet250CustomPayload;
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
        keydown(player);
      } else {
        keyup(player);
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
    Gems.proxy.resetPlayerInAirTime(player);
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
  
  static public void keydown(EntityPlayer player) {
    packet(1, player);
  }
  
  static public void keyup(EntityPlayer player) {
    packet(0, player);
  }
  
  static protected void packet(int state, EntityPlayer tmpplayer) {
    ByteArrayOutputStream bos = new ByteArrayOutputStream(8);
    DataOutputStream outputStream = new DataOutputStream(bos);
    try {
            outputStream.writeInt(1);
            outputStream.writeInt(state);
    } catch (Exception ex) {
            ex.printStackTrace();
    }
    
    Packet250CustomPayload packet = new Packet250CustomPayload();
    packet.channel = "Gems";
    packet.data = bos.toByteArray();
    packet.length = bos.size();
        
    if (Core.isClient()) {
      EntityClientPlayerMP player = (EntityClientPlayerMP) tmpplayer;
      player.sendQueue.addToSendQueue(packet);
    }
  }
}