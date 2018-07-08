package vtech.livingswords.items;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import vtech.livingswords.mod.LivingSwords;

public class LivingSwordNBTBundle {
	public static final String DAMAGE = "livingSwordDamage";
	public static final String LEVEL = "livingSwordLevel";
	public static final String TRUE_NAME = "livingSwordName";
	public static final String EXPERIENCE = "livingSwordExperience";
	public static final String NEEDED_EXPERIENCE = "livingSwordNeededExperience";
	public static final String DISPLAY = "display";
	public static final String NAME = "Name";
	public static final String VERSION = "livingSwordVersion";
	public static final float BASE_DAMAGE = 4.0f;
	public static final double BASE_EXP_NEEDED = 10.0;
	public static final float BONUS_POWER = 2.0f;
	public static final int LEVEL_THRESHOLD = 5;

	ItemStack itemStack;

	public boolean hasTagCompound() {
		return itemStack.hasTagCompound();
	}

	public LivingSwordNBTBundle(ItemStack stack) {
		this.itemStack = stack;
	}

	public NBTTagCompound getTagCompound() {
		return itemStack.getTagCompound();
	}

	public float getLevelledDamage() {
		// The first time three levels are achieved, add bonus power. Each three
		// levels after that, double bonus power.
		return BASE_DAMAGE + BONUS_POWER * ((float) Math.pow(2, getLevel() / (float)LEVEL_THRESHOLD) - 1);
	}

	public double getLevelledExpNeeded() {
		return BASE_EXP_NEEDED * getLevel() * Math.pow(1.35, getLevel() - 1);
	}

	/**
	 * Initializes a sword's values if the sword is from a previous version of the
	 * mod and may lack them.
	 */
	public void initialize() {
		if (!itemStack.hasTagCompound() || !getTagCompound().hasKey(VERSION)
				|| getVersion() < LivingSwords.VERSION_AS_FLOAT()) {
			itemStack.setTagCompound(new NBTTagCompound());
			if (!getTagCompound().hasKey(LEVEL)) {
				setLevel(1);
			}
			if (!getTagCompound().hasKey(EXPERIENCE)) {
				setExperience(0.0);
			}
			if (!getTagCompound().hasKey(NEEDED_EXPERIENCE)) {
				setNeededExperience(getLevelledExpNeeded());
			}
			if (!getTagCompound().hasKey(TRUE_NAME)) {
				setTrueName("Liberty's Fullblade");
			}
			if (!getTagCompound().hasKey(DAMAGE)) {
				setDamage(getLevelledDamage());
			}
			setVersion(LivingSwords.VERSION_AS_FLOAT());
		}
	}

	public float getDamage() {
		return getTagCompound().getFloat(DAMAGE);
	}

	public void setDamage(float damage) {
		getTagCompound().setFloat(DAMAGE, damage);
	}

	public String getTrueName() {
		return getTagCompound().getString(TRUE_NAME);
	}

	public void setTrueName(String name) {
		getTagCompound().setString(TRUE_NAME, name);
	}

	public Double getExperience() {
		return getTagCompound().getDouble(EXPERIENCE);
	}

	public Double getNeededExperience() {
		return getTagCompound().getDouble(NEEDED_EXPERIENCE);
	}

	public void setNeededExperience(Double exp) {
		getTagCompound().setDouble(NEEDED_EXPERIENCE, exp);
	}

	public void setExperience(Double exp) {
		getTagCompound().setDouble(EXPERIENCE, exp);
	}

	public void setLevel(Integer level) {
		getTagCompound().setInteger(LEVEL, level);
	}

	public Integer getLevel() {
		return getTagCompound().getInteger(LEVEL);
	}

	public float getVersion() {
		return getTagCompound().getFloat(VERSION);
	}

	public void setVersion(Float version) {
		getTagCompound().setFloat(VERSION, version);
	}

	public void updateVisibleName() {
		itemStack.setStackDisplayName(getTrueName());
	}

}
