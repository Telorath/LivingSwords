package vtech.livingswords.items;

import net.minecraft.nbt.NBTTagCompound;

public class NBTHelper {
	
	public static final String LIVING_SWORD_DAMAGE = "livingSwordDamage";
	public static final String LIVING_SWORD_NAME = "livingSwordName";
	public static final String DISPLAY = "display";
	public static final String NAME = "Name";
	
	public static float getLivingSwordDamage(NBTTagCompound tagList)
	{		
		return tagList.getFloat(LIVING_SWORD_DAMAGE);
	}
	
	public static void setLivingSwordDamage(NBTTagCompound tagList, float damage)
	{
		tagList.setFloat(LIVING_SWORD_DAMAGE, damage);
	}
	
	public static String getLivingSwordName(NBTTagCompound tagList)
	{
		return tagList.getString(LIVING_SWORD_NAME);
	}
	
	public static void setLivingSwordName(NBTTagCompound tagList, String name)
	{
		tagList.setString(LIVING_SWORD_NAME, name);
	}
	
	public static void updateLivingSwordInfo(NBTTagCompound tagList)
	{
		NBTTagCompound displayTag = tagList.getCompoundTag("display");
		displayTag.setString("Name", getLivingSwordName(tagList));
	}
	
}
