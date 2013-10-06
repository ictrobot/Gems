package ictrobot.gems.magical.command;

import ictrobot.gems.magical.item.Warp;

import java.text.NumberFormat;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.List;

import cpw.mods.fml.common.FMLCommonHandler;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.WrongUsageException;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChatMessageComponent;

public class MagicalWarpCommand implements ICommand
{
  @SuppressWarnings("rawtypes")
  private List aliases;
  @SuppressWarnings({ "rawtypes", "unchecked" })
  public MagicalWarpCommand() {
    this.aliases = new ArrayList();
    this.aliases.add("mw");
    this.aliases.add("warp");
  }

  @Override
  public String getCommandName()
  {
    return "magicalwarp";
  }

  @Override
  public String getCommandUsage(ICommandSender sender) {
    return "/" + this.getCommandName() + " help";
  }

  @SuppressWarnings("rawtypes")
  @Override
  public List getCommandAliases()
  {
    return this.aliases;
  }

  @Override
  public void processCommand(ICommandSender sender, String[] arguments)
  {
    if (arguments.length <= 0) {
      throw new WrongUsageException("Type '" + this.getCommandUsage(sender) + "' for help.");
    }
    if (arguments[0].matches("help")) {
      commandHelp(sender, arguments);
      return;
    }
    if (arguments[0].matches("set")) {
      commandSet(sender, arguments);
      return;
    }
    if (arguments[0].matches("add")) {
      commandAdd(sender, arguments);
      return;
    }
    if (arguments[0].matches("list") || arguments[0].matches("ls")) {
      commandList(sender, arguments);
      return;
    }
    throw new WrongUsageException("Type '" + this.getCommandUsage(sender) + "' for help.");
  }

  private void commandAdd(ICommandSender sender, String[] arguments) {
    EntityPlayerMP player = getPlayerForName(sender.getCommandSenderName());
    if (player!=null) {
      ItemStack held = player.getHeldItem();
      if (held!=null) {
        if (held.getItem() instanceof Warp) {
          NBTTagCompound tag = held.getTagCompound();
          //Interpreter
          String name = "";
          int ID = tag.getInteger("num") + 1;
          if (arguments.length>1) {
            name = arguments[1];
          }
          //Write to NBT
          if (ID>100) {
            sender.sendChatToPlayer(ChatMessageComponent.createFromText("IDs must be smaller than 100"));
            ID = 1;
            tag.setInteger("num", ID);
          }
          if (tag.hasKey(ID + "x")) {
            if (tag.getString(ID + "name")=="") {
              sender.sendChatToPlayer(ChatMessageComponent.createFromText("Overriding ID " + ID + " (" + tag.getDouble(ID + "x") + ", " + tag.getDouble(ID + "y") + ", " + tag.getDouble(ID + "z") +")"));
            } else {
              sender.sendChatToPlayer(ChatMessageComponent.createFromText("Overriding " + tag.getString(ID + "name") + ", previous ID " + ID + " (" + tag.getDouble(ID + "x") + ", " + tag.getDouble(ID + "y") + ", " + tag.getDouble(ID + "z") +")"));
            }
          }
          tag.setString(ID + "name", name);
          tag.setInteger(ID + "dim", player.worldObj.provider.dimensionId);
          tag.setDouble(ID + "x", player.posX);
          tag.setDouble(ID + "y", player.posY);
          tag.setDouble(ID + "z", player.posZ);
          tag.setFloat(ID + "yaw", player.rotationYaw);
          tag.setFloat(ID + "pitch", player.rotationPitch);
          if (tag.getInteger("num")!=ID) {
            tag.setInteger("num", ID);
          }
          sender.sendChatToPlayer(ChatMessageComponent.createFromText("Added warp, ID " + ID + " name " + name));
          
        }
      }
    }
  }
  
  private void commandList(ICommandSender sender, String[] arguments) {
    EntityPlayerMP player = getPlayerForName(sender.getCommandSenderName());
    if (player!=null) {
      ItemStack held = player.getHeldItem();
      if (held!=null) {
        if (held.getItem() instanceof Warp) {
          NBTTagCompound tag = held.getTagCompound();
          sender.sendChatToPlayer(ChatMessageComponent.createFromText("ID NAME ~ X, Y, Z, DIM"));
          for(int i=1; i<=100; i++) {
            if (tag.hasKey(i + "x")) {
              sender.sendChatToPlayer(ChatMessageComponent.createFromText(i + " " + tag.getString(i + "name") + " ~ " + Math.floor(tag.getDouble(i + "x")) + ", " + Math.floor(tag.getDouble(i + "y")) + ", " + Math.floor(tag.getDouble(i + "z")) + ", " + tag.getInteger(i + "dim")));
            }
          }
        }
      }
    }
  }
  
  private void commandSet(ICommandSender sender, String[] arguments) {
    EntityPlayerMP player = getPlayerForName(sender.getCommandSenderName());
    if (player!=null) {
      ItemStack held = player.getHeldItem();
      if (held!=null) {
        if (held.getItem() instanceof Warp) {
          NBTTagCompound tag = held.getTagCompound();
          int ID = 0;
          String name = "";
          if (isNum(arguments[1])) {
            ID = Integer.parseInt(arguments[1]);
            System.out.println("ID - " + ID );
          } else {
            name = arguments[1];
            for(int i=1; i<=100; i++) {
              if (tag.getString(i + "name")==name && ID==0) {
                ID = i;
              }
            }
          }
         tag.setInteger("Current", ID);
        }
      }
    }
  }

  private void commandHelp(ICommandSender sender, String[] arguments) {
    sender.sendChatToPlayer(ChatMessageComponent.createFromText("Usage"));
    sender.sendChatToPlayer(ChatMessageComponent.createFromText("/Gems version -  Returns Gems version"));
    sender.sendChatToPlayer(ChatMessageComponent.createFromText("/Gems ring power [number] -  Sets the held rings power"));
  }

  @Override
  public boolean canCommandSenderUseCommand(ICommandSender icommandsender)
  {
    return true;
  }

  @SuppressWarnings("rawtypes")
  @Override
  public List addTabCompletionOptions(ICommandSender icommandsender,
      String[] astring)
  {
    return null;
  }

  @Override
  public boolean isUsernameIndex(String[] astring, int i)
  {
    return false;
  }

  @Override
  public int compareTo(Object o)
  {
    return 0;
  }
  
  public static EntityPlayerMP getPlayerForName(String name) {
    EntityPlayerMP tempPlayer = FMLCommonHandler.instance().getMinecraftServerInstance().getConfigurationManager().getPlayerForUsername(name);
    return tempPlayer;
  }
  
  public boolean isNum(String str)
  {
    NumberFormat formatter = NumberFormat.getInstance();
    ParsePosition pos = new ParsePosition(0);
    formatter.parse(str, pos);
    return str.length() == pos.getIndex();
  }
}