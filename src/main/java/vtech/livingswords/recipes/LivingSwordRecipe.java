package vtech.livingswords.recipes;

import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapelessOreRecipe;
import vtech.livingswords.items.LivingSwordNBTBundle;

public class LivingSwordRecipe extends ShapelessOreRecipe {

	public LivingSwordRecipe(ItemStack result, Object[] recipe) {
		super(result, recipe);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Returns an Item that is the result of this recipe
	 */
	@Override
	public ItemStack getCraftingResult(InventoryCrafting var1) {
		ItemStack output = getRecipeOutput().copy();

		LivingSwordNBTBundle sword = new LivingSwordNBTBundle(output);

		sword.initialize();

		return output;
	}

}
