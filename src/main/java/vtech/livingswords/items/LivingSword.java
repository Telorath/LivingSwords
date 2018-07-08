package vtech.livingswords.items;

import java.util.List;

import com.google.common.collect.Multimap;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.DamageSource;

public class LivingSword extends ItemSword {

	public LivingSword(ToolMaterial p_i45356_1_) {
		super(p_i45356_1_);
	}
	
	private float getBaseAttackDamage(ItemStack stack)
	{		
		return NBTHelper.getLivingSwordDamage(stack.getTagCompound());
	}
	
	@Override
	public void addInformation(ItemStack itemStack, EntityPlayer entity, List TooltipString, boolean advanced) {

		if (itemStack.hasTagCompound())
		{
			TooltipString.add(String.format("+%.1f damage", getBaseAttackDamage(itemStack)));
		}
		
		TooltipString.add("This sword is ALIVE!");
	}

	@Override
	public boolean hitEntity(ItemStack stack, EntityLivingBase entityBeingHit, EntityLivingBase entityDoingHitting) {

		if (entityDoingHitting instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) entityDoingHitting;
			DamageSource damageSource = DamageSource.causePlayerDamage(player);
			float damage = getBaseAttackDamage(stack);
			entityBeingHit.attackEntityFrom(damageSource, damage);
		}
		return super.hitEntity(stack, entityBeingHit, entityDoingHitting);
	}

	/**
	 * Gets a map of item attribute modifiers, used by ItemSword to increase hit
	 * damage.
	 */
	public Multimap getItemAttributeModifiers() {
		Multimap multimap = super.getItemAttributeModifiers();
		multimap.clear();
		return multimap;
	}

}