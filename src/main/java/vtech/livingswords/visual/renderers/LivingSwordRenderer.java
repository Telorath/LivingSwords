package vtech.livingswords.visual.renderers;

import net.minecraft.util.ResourceLocation;
import vtech.livingswords.mod.resources.VisualResourceManager;

public class LivingSwordRenderer extends VTechRenderer {

	public LivingSwordRenderer(String model, String texture)
	{
		this.model = VisualResourceManager.getModel(model);
		this.textureLocation = new ResourceLocation(texture);
	}

}
