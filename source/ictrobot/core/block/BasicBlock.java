package ictrobot.core.block;

import ictrobot.core.Core;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BasicBlock extends Block {

  public BasicBlock(int id, String texture, Material Material) {
    super(id, Material);
    setTextureName(Core.ModID + ":" + texture);
  }

}
