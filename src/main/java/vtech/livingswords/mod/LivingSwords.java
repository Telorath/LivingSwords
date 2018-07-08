package vtech.livingswords.mod;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import vtech.livingswords.proxies.CommonProxy;

@Mod(modid = LivingSwords.MOD_ID, version = LivingSwords.VERSION)
public class LivingSwords {
	public static final String CLIENT_PROXY = "vtech.livingswords.proxies.ClientProxy";
	public static final String SERVER_PROXY = "vtech.livingswords.proxies.ServerProxy";
	public static final String MOD_ID = "LivingSwords";
	public static final String VERSION = "0.1";

	@SidedProxy(clientSide = CLIENT_PROXY, serverSide = SERVER_PROXY)
	public static CommonProxy proxy;

	@EventHandler
	public void init(FMLInitializationEvent event) {
		proxy.init(event);
	}

}