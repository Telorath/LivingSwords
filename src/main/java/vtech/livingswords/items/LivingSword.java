package vtech.livingswords.items;

import com.google.common.collect.Multimap;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.item.ItemSword;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.IModelCustom;
import net.minecraftforge.client.model.IModelCustomLoader;
import net.minecraftforge.client.model.obj.ObjModelLoader;
import vtech.livingswords.mod.LivingSwords;

public class LivingSword extends ItemSword {

	String ModelPath;

	public LivingSword(ToolMaterial p_i45356_1_) {
		super(p_i45356_1_);

		IModelCustomLoader test = new ObjModelLoader();

		ResourceLocation testResource = new ResourceLocation(LivingSwords.MOD_ID, ModelPath);

		IModelCustom model = test.loadInstance(testResource);
		
//		RenderingRegistry.registerEntityRenderingHandler(LivingSword, new Renderer);
		
	}

	@Override
	public Multimap getItemAttributeModifiers() {
		Multimap multimap = super.getItemAttributeModifiers();
		multimap.put(SharedMonsterAttributes.attackDamage.getAttributeUnlocalizedName(),
				new AttributeModifier(field_111210_e, "Weapon modifier", 20.0, 0));
		return multimap;
	}

}