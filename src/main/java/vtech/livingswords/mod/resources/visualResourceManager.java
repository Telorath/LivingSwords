package vtech.livingswords.mod.resources;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

public class visualResourceManager {

	public static IModelCustom getModel(String location)
	{
		return AdvancedModelLoader.loadModel(new ResourceLocation(location));
	}

}
