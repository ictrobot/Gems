package ictrobot.gems.magical.item;

import java.util.List;

import cpw.mods.fml.common.FMLCommonHandler;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.server.management.ServerConfigurationManager;
import net.minecraft.world.World;
import ictrobot.core.Core;

public class Warp extends Item {
  
  public Warp(int id) {
    super(id);
    setTextureName(Core.ModID + ":Warp");
    setUnlocalizedName("Warp");
    setCreativeTab(CreativeTabs.tabTools);
    setMaxStackSize(1);
  }

  //Update Tick
  public void onUpdate(ItemStack itemStack, World world, Entity entity, int par4, boolean par5) {
    if( itemStack.getTagCompound() == null ) {
      itemStack.setTagCompound( new NBTTagCompound( ) );
      itemStack.getTagCompound().setInteger("Num", 0);
    }
    if (Core.isClient()) {

    }
    if (Core.isServer()) {
      
    }
  }
  public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player) {
    if( itemStack.getTagCompound() == null ) {
      itemStack.setTagCompound( new NBTTagCompound( ) );
      itemStack.getTagCompound().setInteger("Num", 0);
    }
    NBTTagCompound tag = itemStack.getTagCompound();
    if (Core.isClient()) {
      if (tag.getInteger("Current")>0) {
        int ID = tag.getInteger("Current");
        if (player.dimension == tag.getInteger(ID + "dim")) {
          player.setPositionAndRotation(tag.getDouble(ID + "x"), tag.getDouble(ID + "y"), tag.getDouble(ID + "z"), tag.getFloat(ID + "yaw"), tag.getFloat(ID + "pitch"));
        }
      }
    }
    if (Core.isServer()) {
      int ID = tag.getInteger("Current");
      if (ID>0) {
        EntityPlayerMP playerMP = (EntityPlayerMP)player;
        if (playerMP.dimension != tag.getInteger(ID + "dim")) {
          ServerConfigurationManager server = FMLCommonHandler.instance().getMinecraftServerInstance().getConfigurationManager();
          server.transferPlayerToDimension(playerMP, tag.getInteger(ID + "dim"));
        }
        playerMP.setPositionAndRotation(tag.getDouble(ID + "x"), tag.getDouble(ID + "y"), tag.getDouble(ID + "z"), tag.getFloat(ID + "yaw"), tag.getFloat(ID + "pitch"));

      }
      if (!tag.hasKey("owner")) {
        tag.setString("owner", player.username);
      }
    }
    return itemStack;
  }
  
  @SuppressWarnings({ "rawtypes", "unchecked" })
  public void addInformation(ItemStack itemStack, EntityPlayer player, List par3List, boolean par4) {
    if( itemStack.getTagCompound() != null ) {
      NBTTagCompound tag = itemStack.getTagCompound();
      par3List.add("\u00A77Owner - " + tag.getString("owner"));
      if (tag.getInteger("Current")>0) {
        par3List.add("\u00A77Current Warp - " + tag.getInteger("Current"));
      }
    }
  }
}
