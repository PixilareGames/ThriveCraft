package pixilaregames.thrivecraft.Items.Dracula;

import net.minecraft.block.BlockDispenser;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemElytra;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import pixilaregames.thrivecraft.Lists.ItemList;

public class ItemDraculaElytra extends ItemElytra
{

	public ItemDraculaElytra(Properties builder)
	{
		super(builder);
		this.addPropertyOverride(new ResourceLocation("broken"), (arg1, arg2, arg3) -> { return isUsable(arg1) ? 0.0f : 1.0f;});
		BlockDispenser.registerDispenseBehavior(this, ItemArmor.DISPENSER_BEHAVIOR);
	}
	
	public static boolean isUsanle(ItemStack stack)
	{
		return stack.getDamage() < stack.getMaxDamage() - 1;
	}
	
	public boolean getIsRepairable(ItemStack toRepair, ItemStack repair)
	{
		return repair.getItem() == ItemList.dracula_membrane;
	}
	
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn)
	{
		ItemStack itemstack = playerIn.getHeldItem(handIn);
		EntityEquipmentSlot entityequipmentslot = EntityLiving.getSlotForItemStack(itemstack);
		ItemStack itemstack1 = playerIn.getItemStackFromSlot(entityequipmentslot);
		if (itemstack1.isEmpty())
		{
			playerIn.setItemStackToSlot(entityequipmentslot, itemstack.copy());
			itemstack.setCount(0);
			return new ActionResult<>(EnumActionResult.SUCCESS, itemstack);
		}
		else
		{
			return new ActionResult<>(EnumActionResult.FAIL, itemstack);
		}
	}

}
