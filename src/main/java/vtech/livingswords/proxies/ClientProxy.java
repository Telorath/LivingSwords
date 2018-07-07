package vtech.livingswords.proxies;

import net.minecraftforge.client.MinecraftForgeClient;
import vtech.livingswords.items.ItemManager;
import vtech.livingswords.mod.LivingSwords;
import vtech.livingswords.visual.renderers.LivingSwordRenderer;

public class ClientProxy extends CommonProxy {

	@Override
	public void registerRenderers()
	{
		super.registerRenderers();
		MinecraftForgeClient.registerItemRenderer(ItemManager.livingSword, new LivingSwordRenderer(LivingSwords.MOD_ID.toLowerCase() + ":AmericaSword.obj", LivingSwords.MOD_ID.toLowerCase() + ":AmericaSword.png"));
	}
	
}
