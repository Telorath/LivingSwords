package vtech.livingswords.proxies;

import net.minecraftforge.client.MinecraftForgeClient;
import vtech.livingswords.blocks.BlockManager;
import vtech.livingswords.items.ItemManager;
import vtech.livingswords.mod.LivingSwords;
import vtech.livingswords.visual.renderers.LivingSwordRenderer;

public class ClientProxy extends CommonProxy {

	public static final String VTECHTEXTURE = LivingSwords.MOD_ID + ":Vortexblock_1.png";

	@Override
	public void registerBlockTextures()
	{
		BlockManager.vTechBlock.setBlockTextureName(VTECHTEXTURE);
	}
	
	@Override
	public void registerRenderers()
	{
		super.registerRenderers();
		MinecraftForgeClient.registerItemRenderer(ItemManager.livingSword, new LivingSwordRenderer(LivingSwords.MOD_ID.toLowerCase() + ":AmericaSword.obj", LivingSwords.MOD_ID.toLowerCase() + ":AmericaSword.png"));
	}
	
}
