package vtech.livingswords.recipes;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;
import vtech.livingswords.items.ItemManager;

public class RecipeManager {

	public static void registerRecipes() {
		IRecipe SwordRecipe = new LivingSwordRecipe(new ItemStack(ItemManager.livingSword),
				new Object[] {
						Items.iron_sword, 
						"dyeRed",
						"dyeWhite",
						"dyeBlue"
		});
		GameRegistry.addRecipe(SwordRecipe);
	}

}
