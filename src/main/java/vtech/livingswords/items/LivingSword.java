package vtech.livingswords.items;

import java.util.List;

import com.google.common.collect.Multimap;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.DamageSource;

public class LivingSword extends ItemSword {

	public LivingSword(ToolMaterial p_i45356_1_) {
		super(p_i45356_1_);
		setContainerItem(Items.iron_sword);
	}
	
	private float getBaseAttackDamage(LivingSwordNBTBundle sword) {
		sword.initialize();
		return sword.getDamage();
	}

	private boolean readyToLevelUp(LivingSwordNBTBundle sword) {
		sword.initialize();
		return sword.getExperience() >= sword.getNeededExperience();
	}

	private void levelSwordUp(LivingSwordNBTBundle sword) {
		sword.setLevel(sword.getLevel() + 1);
		sword.setDamage(sword.getLevelledDamage());
		sword.setNeededExperience(sword.getLevelledExpNeeded());
		if (sword.getLevel() >= 10) {
			sword.updateVisibleName();
		}
	}

	private void applyExperience(LivingSwordNBTBundle sword, Double experience) {
		sword.initialize();
		sword.setExperience(sword.getExperience() + experience);

		if (readyToLevelUp(sword)) {
			levelSwordUp(sword);
		}

	}

	@Override
	public void addInformation(ItemStack itemStack, EntityPlayer entity, List TooltipString, boolean advanced) {

		LivingSwordNBTBundle sword = new LivingSwordNBTBundle(itemStack);

		sword.initialize();

		TooltipString.add(String.format("Level %d (%,.0f/%,.0f)", sword.getLevel(), sword.getExperience(),
				sword.getNeededExperience()));

		TooltipString.add(String.format("+%.1f damage", getBaseAttackDamage(sword)));

		TooltipString.add("This sword is ALIVE!");
	}

	@Override
	public boolean hitEntity(ItemStack stack, EntityLivingBase entityBeingHit, EntityLivingBase entityDoingHitting) {

		if (entityDoingHitting instanceof EntityPlayer) {

			LivingSwordNBTBundle sword = new LivingSwordNBTBundle(stack);

			EntityPlayer player = (EntityPlayer) entityDoingHitting;
			DamageSource damageSource = DamageSource.causePlayerDamage(player);
			float damage = getBaseAttackDamage(sword);
			entityBeingHit.attackEntityFrom(damageSource, damage);
			applyExperience(sword, 1.0);
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