package ictrobot.core.tool;

import ictrobot.core.Core;
import ictrobot.core.helper.tool.*;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;

public class Shovel extends ItemSpade {
    
    public String ToolType = "shovel";
    private static Material[] materialsEffectiveAgainst = { Material.ground, Material.grass, Material.sand,
      Material.snow, Material.clay, Material.craftedSnow };
    
    private EnumToolMaterial ToolMaterial;
    public String ToolMaterialID;
    
    public Shovel(int itemId, EnumToolMaterial Material) {
        super(itemId, Material);
        ToolMaterial = Material;
        ToolMaterialID = ToolMaterial.name();
        setUnlocalizedName(ToolMaterialID + ToolType);
        setCreativeTab(CreativeTabs.tabTools);
        setTextureName(Core.ModID + ":" + ToolMaterialID + ToolType);
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
                int harvestLevel = MinecraftForge.getBlockHarvestLevel(block, meta, ToolType);
                if (harvestLevel <= toolMaterial.getHarvestLevel()) {
                    return toolMaterial.getEfficiencyOnProperMaterial();
                }
                return 0.5F;
            }
        }
        return super.getStrVsBlock(is, block, meta);
    }
}