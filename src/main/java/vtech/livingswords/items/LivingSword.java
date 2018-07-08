package vtech.livingswords.items;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.DamageSource;

public class LivingSword extends ItemSword {
	
	public LivingSword(ToolMaterial p_i45356_1_) {
		super(p_i45356_1_);
	}

	@Override
	public boolean hitEntity(ItemStack stack, EntityLivingBase entityBeingHit, EntityLivingBase entityDoingHitting)
	{
		if (entityDoingHitting instanceof EntityPlayer)
		{
			EntityPlayer player = (EntityPlayer) entityDoingHitting;
			DamageSource damageSource = DamageSource.causePlayerDamage(player);
			entityBeingHit.attackEntityFrom(damageSource, 20.0f);
		}
		return true;		
	}
	
}