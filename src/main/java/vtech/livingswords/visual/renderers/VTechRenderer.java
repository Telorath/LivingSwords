package vtech.livingswords.visual.renderers;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.model.IModelCustom;

public class VTechRenderer implements IItemRenderer{

	protected IModelCustom model;
	protected ResourceLocation textureLocation;
	
	@Override
	public boolean handleRenderType(ItemStack item, ItemRenderType type) {
		return true;
	}

	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {
		return type == ItemRenderType.ENTITY && helper == ItemRendererHelper.ENTITY_ROTATION;
	}

	@Override
	public void renderItem(ItemRenderType type, ItemStack item, Object... data) {

		GL11.glPushMatrix();

		Minecraft.getMinecraft().renderEngine.bindTexture(textureLocation);
		
		GL11.glTranslated(-0.01, 1.11, -0.15);
        GL11.glRotatef(90, 1, 0, 0);
        GL11.glRotatef(140, 0, -1, 0);
        GL11.glScaled(0.7, 0.7, 0.7);

        if (type == IItemRenderer.ItemRenderType.EQUIPPED_FIRST_PERSON) {
            GL11.glRotatef(180, 0, 0, 1);
            GL11.glTranslated(0, -0.4, 0);
        } else if (type == IItemRenderer.ItemRenderType.INVENTORY) {
            GL11.glScalef(8, 8, 8);
            GL11.glRotatef(180, 0, 1, 0);
            GL11.glTranslated(1.9, 0, 0);
        } else if (type == IItemRenderer.ItemRenderType.ENTITY) {
            GL11.glRotatef(-90.5F, 0, 1, 0);
            GL11.glTranslated(-0.8, 0, 0);
        }
		
        model.renderAll();
        
        GL11.glPopMatrix();
        
	}

}
