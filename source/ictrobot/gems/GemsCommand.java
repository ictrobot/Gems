package ictrobot.gems;

import ictrobot.gems.magnetic.item.BaseRing;
import java.util.ArrayList;
import java.util.List;
import cpw.mods.fml.common.FMLCommonHandler;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.WrongUsageException;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatMessageComponent;

public class GemsCommand implements ICommand
{
  @SuppressWarnings("rawtypes")
  private List aliases;
  @SuppressWarnings({ "rawtypes", "unchecked" })
  public GemsCommand() {
    this.aliases = new ArrayList();
    this.aliases.add("Gems");
  }

  @Override
  public String getCommandName()
  {
    return "Gems";
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
    if (arguments[0].matches("version")) {
      commandVersion(sender, arguments);
      return;
    }
    if (arguments[0].matches("help")) {
      commandHelp(sender, arguments);
      return;
    }
    if (arguments[0].matches("ring") && arguments[1].matches("power")) {
      commandRingPower(sender, arguments);
      return;
    }
    throw new WrongUsageException("Type '" + this.getCommandUsage(sender) + "' for help.");
  }

  private void commandRingPower(ICommandSender sender, String[] arguments) {
    int Power;
    try {
      Power = Integer.parseInt(arguments[2].toString());
    } catch (NumberFormatException e) {
      sender.sendChatToPlayer(ChatMessageComponent.createFromText("3rd Argument must be a number"));
      return;
    }
    EntityPlayerMP player = getPlayerForName(sender.getCommandSenderName());
    if (player!=null) {
      ItemStack held = player.getHeldItem();
      if (held!=null) {
        if (held.getItem() instanceof BaseRing) {
          if(held.getTagCompound()!=null) {
            held.getTagCompound().setInteger("Power", Power); 
            held.getTagCompound().setInteger("MaxPower", Power);
            held.getTagCompound().setBoolean("Modified", true);
          }
        }
      }
    }
  }

  private void commandHelp(ICommandSender sender, String[] arguments) {
    sender.sendChatToPlayer(ChatMessageComponent.createFromText("Usage"));
    sender.sendChatToPlayer(ChatMessageComponent.createFromText("/Gems version -  Returns Gems version"));
    sender.sendChatToPlayer(ChatMessageComponent.createFromText("/Gems ring power [number] -  Sets the held rings power"));
  }

  private void commandVersion(ICommandSender sender, String[] arguments) {
    sender.sendChatToPlayer(ChatMessageComponent.createFromText(Reference.MOD_NAME + " " + Reference.VERSION_WITHSPACES + " for Minecraft " + Reference.MC_VERSION + " (Forge: " + Reference.FORGE_VERSION + ")"));
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
}