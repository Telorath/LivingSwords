package vtech.livingswords.proxies;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.creativetab.CreativeTabs;
import vtech.livingswords.items.ItemManager;
import vtech.livingswords.items.recipes.RecipeManager;
import vtech.livingswords.mod.LivingSwords;

public abstract class CommonProxy {

	public void init(FMLInitializationEvent event)
	{
		GameRegistry.registerItem(ItemManager.livingSword, LivingSwords.MOD_ID + ItemManager.livingSword.getUnlocalizedName().substring(5));
		ItemManager.livingSword.setCreativeTab(CreativeTabs.tabTools);
		registerRenderers();
		registerRecipes();
	}
	
	public void registerRenderers()
	{
		
	}

	public void registerRecipes()
	{
		RecipeManager.registerRecipes();
	}
	
}
