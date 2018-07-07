package vtech.livingswords.proxies;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.creativetab.CreativeTabs;
import vtech.livingswords.items.ItemManager;
import vtech.livingswords.mod.LivingSwords;

public abstract class CommonProxy {

	public void init(FMLInitializationEvent event)
	{
		ItemManager.livingSword.setCreativeTab(CreativeTabs.tabTools);
		GameRegistry.registerItem(ItemManager.livingSword, LivingSwords.MOD_ID + ItemManager.livingSword.getUnlocalizedName().substring(5));
		registerRenderers();
	}
	
	public void registerRenderers()
	{
		
	}
	
}
