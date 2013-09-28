package ictrobot.gems.magnetic.armor;

import java.util.EnumSet;

import net.minecraft.entity.player.EntityPlayer;
import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.TickType;
public class JetpackTickHandler implements ITickHandler {
  private final EnumSet<TickType> ticksToGet;
  
  public static boolean tmp;
  /*
           * This Tick Handler will fire for whatever TickType's you construct and register it with.
           */
  public JetpackTickHandler(EnumSet<TickType> ticksToGet)
  {
           this.ticksToGet = ticksToGet;
  }
  /*
           * I suggest putting all your tick Logic in EITHER of these, but staying in one
           */
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
  }
}