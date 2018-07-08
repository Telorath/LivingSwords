package vtech.livingswords.recipes;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.oredict.ShapelessOreRecipe;
import vtech.livingswords.items.NBTHelper;

public class LivingSwordRecipe extends ShapelessOreRecipe {

	public LivingSwordRecipe(ItemStack result, Object[] recipe) {
		super(result, recipe);
		// TODO Auto-generated constructor stub
	}
	
    /**
     * Returns an Item that is the result of this recipe
     */
    @Override
    public ItemStack getCraftingResult(InventoryCrafting var1){
    	ItemStack output = getRecipeOutput().copy();
    	if (output.getTagCompound() == null)
    	{
    		output.setTagCompound(new NBTTagCompound());
    	}
    	NBTHelper.setLivingSwordDamage(output.getTagCompound(), 9.0f);
    	NBTHelper.setLivingSwordName(output.getTagCompound(), "Sword");
    	NBTHelper.updateLivingSwordInfo(output.getTagCompound());
    	return output;
    	}
    
	
}
