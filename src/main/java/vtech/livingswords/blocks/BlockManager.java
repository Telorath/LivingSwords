package vtech.livingswords.blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockManager {

	public static final Block vTechBlock = new VTechBlock(Material.rock).setBlockName("VortechsBlock");

	public static void registerBlocks() {

		vTechBlock.setCreativeTab(CreativeTabs.tabDecorations);

		GameRegistry.registerBlock(vTechBlock,
				vTechBlock.getUnlocalizedName().substring(vTechBlock.getUnlocalizedName().indexOf('.')));

	}

}
