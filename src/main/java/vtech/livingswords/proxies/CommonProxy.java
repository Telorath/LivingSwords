package vtech.livingswords.proxies;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.creativetab.CreativeTabs;
import vtech.livingswords.blocks.BlockManager;
import vtech.livingswords.items.ItemManager;
import vtech.livingswords.mod.LivingSwords;
import vtech.livingswords.recipes.RecipeManager;

public abstract class CommonProxy {

	public void init(FMLInitializationEvent event) {
		GameRegistry.registerItem(ItemManager.livingSword,
				LivingSwords.MOD_ID + ItemManager.livingSword.getUnlocalizedName().substring(5));
		ItemManager.livingSword.setCreativeTab(CreativeTabs.tabTools);
		registerBlockTextures();
		registerBlocks();
		registerRenderers();
		registerRecipes();
	}

	public void registerBlockTextures() {

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
