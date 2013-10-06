package ictrobot.gems;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.WrongUsageException;
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
  }

  private void commandHelp(ICommandSender sender, String[] arguments) {
    sender.sendChatToPlayer(ChatMessageComponent.createFromText("Usage"));
    sender.sendChatToPlayer(ChatMessageComponent.createFromText("/Gems version -  Returns Gems version"));
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
}