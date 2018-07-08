package vtech.livingswords.proxies;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.creativetab.CreativeTabs;
import vtech.livingswords.blocks.BlockManager;
import vtech.livingswords.items.ItemManager;
import vtech.livingswords.mod.LivingSwords;
import vtech.livingswords.recipes.RecipeManager;

public abstract class CommonProxy {

	public static final String VTECHTEXTURE = LivingSwords.MOD_ID.toLowerCase() + ":Vortexblock_1";
	public static final String PLASMATEXTURE = LivingSwords.MOD_ID.toLowerCase() + ":Plasma_block";
	
	public void init(FMLInitializationEvent event) {
		GameRegistry.registerItem(ItemManager.livingSword,
				LivingSwords.MOD_ID + ItemManager.livingSword.getUnlocalizedName().substring(5));
		ItemManager.livingSword.setCreativeTab(CreativeTabs.tabTools);
		registerBlockTextures();
		registerBlocks();
		registerRenderers();
		registerRecipes();
	}

	public void registerBlockTextures()
	{
		BlockManager.vTechBlock.setBlockTextureName(VTECHTEXTURE);
		BlockManager.plasmaBlock.setBlockTextureName(PLASMATEXTURE);
	}

	public void registerRenderers() {

	}

	public void registerBlocks() {
		BlockManager.registerBlocks();
	}

	public void registerRecipes() {
		RecipeManager.registerRecipes();
	}

}
