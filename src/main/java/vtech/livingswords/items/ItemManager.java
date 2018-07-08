package vtech.livingswords.items;

import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;

public class ItemManager {
	public static final Item livingSword = new LivingSword(ToolMaterial.IRON).setUnlocalizedName("livingSword");
}