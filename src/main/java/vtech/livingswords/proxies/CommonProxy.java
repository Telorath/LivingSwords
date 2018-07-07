package vtech.livingswords.proxies;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import vtech.livingswords.items.ItemManager;
import vtech.livingswords.mod.LivingSwords;

public class CommonProxy {

	public void init(FMLInitializationEvent event)
	{
		GameRegistry.registerItem(ItemManager.livingSword, LivingSwords.MOD_ID + ItemManager.livingSword.getUnlocalizedName().substring(5));
	}
	
}
