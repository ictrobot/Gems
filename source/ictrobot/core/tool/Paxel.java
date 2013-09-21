package ictrobot.core.tool;

import ictrobot.core.Core;
import ictrobot.core.helper.tool.*;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;

public class Paxel extends ItemPickaxe {
    
    public String ToolType = "paxel";
    private Material[] materialsEffectiveAgainst = { Material.wood, Material.circuits, Material.cactus, Material.vine, Material.pumpkin,Material.rock, Material.iron, Material.piston, Material.anvil, Material.circuits, Material.ice, Material.glass, Material.ground, Material.grass, Material.sand, Material.snow, Material.clay, Material.craftedSnow };
    
    private EnumToolMaterial ToolMaterial;
    public String ToolMaterialID;
    
    public Paxel(int itemId, EnumToolMaterial Material) {
        super(itemId, Material);
        ToolMaterial = Material;
        ToolMaterialID = ToolMaterial.name();
        setUnlocalizedName(ToolMaterialID + ToolType);
        setCreativeTab(CreativeTabs.tabTools);
        func_111206_d(Core.ModID + ":" + ToolMaterialID + ToolType);
    }

    @Override
    public boolean getIsRepairable(ItemStack toolIS, ItemStack repairIS) {
        return ToolMaterialsHelper.isRepairable(ToolMaterial, repairIS);
    }

    @Override
    public boolean canHarvestBlock(Block block) {
        if (block.blockMaterial.isToolNotRequired()) {
            return true;
        }
        for (Material mat : materialsEffectiveAgainst) {
            if (mat == block.blockMaterial) {
                return true;
            }
        }
        return false;
    }

    @Override
    public float getStrVsBlock(ItemStack is, Block block, int meta) {
        for (Material mat : materialsEffectiveAgainst) {
            if (mat == block.blockMaterial) {
                boolean harvest = false;
                int toolLevel = toolMaterial.getHarvestLevel();
                int pickaxeLevel = MinecraftForge.getBlockHarvestLevel(block, meta, "pickaxe");
                int axeLevel = MinecraftForge.getBlockHarvestLevel(block, meta, "axe");
                int shovelLevel = MinecraftForge.getBlockHarvestLevel(block, meta, "shovel");
                if (toolLevel >= pickaxeLevel && pickaxeLevel != -1){
                  harvest = true;
                }
                if (toolLevel >= axeLevel && pickaxeLevel != -1){
                  harvest = true;
                }
                if (toolLevel >= shovelLevel && pickaxeLevel != -1){
                  harvest = true;
                }
                if (harvest) {
                    return toolMaterial.getEfficiencyOnProperMaterial();
                }
                return 0.5F;
            }
        }
        return super.getStrVsBlock(is, block, meta);
    }
}