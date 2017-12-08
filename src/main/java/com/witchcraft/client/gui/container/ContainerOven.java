package com.witchcraft.client.gui.container;

import com.witchcraft.common.item.ModItems;
import com.witchcraft.common.tile.TileOven;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IContainerListener;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraftforge.items.SlotItemHandler;

import javax.annotation.Nonnull;

/**
 * Created by Joseph on 7/17/2017.
 */
public class ContainerOven extends Container {

	private final TileOven oven;

	public ContainerOven(IInventory playerInventory, TileOven te) {
		this.oven = te;
		//input slot
		this.addSlotToContainer(new SlotItemHandler(oven.inventory, 0, 19, 17));
		//fuel slot
		this.addSlotToContainer(new SlotItemHandler(oven.inventory, 1, 19, 53) {
			@Override
			public boolean isItemValid(@Nonnull ItemStack stack) {
				return TileEntityFurnace.isItemFuel(stack);
			}
		});
		//jar slot
		this.addSlotToContainer(new SlotItemHandler(oven.inventory, 2, 69, 53) {
			@Override
			public boolean isItemValid(@Nonnull ItemStack stack) {
				return stack.getItem() == Items.GLASS_BOTTLE || stack.getItem() == ModItems.glass_jar;
			}
		});
		//fume slot
		this.addSlotToContainer(new SlotItemHandler(oven.inventory, 3, 128, 53) {
			@Override
			public boolean isItemValid(@Nonnull ItemStack stack) {
				return false;
			}
		});
		//output slot
		this.addSlotToContainer(new SlotItemHandler(oven.inventory, 4, 124, 21) {
			@Override
			public boolean isItemValid(@Nonnull ItemStack stack) {
				return false;
			}
		});

		for (int i = 0; i < 3; ++i) {
			for (int j = 0; j < 9; ++j) {
				this.addSlotToContainer(new Slot(playerInventory, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
			}
		}

		for (int k = 0; k < 9; ++k) {
			this.addSlotToContainer(new Slot(playerInventory, k, 8 + k * 18, 142));
		}
	}

	@Override
	public void addListener(IContainerListener listener) {
		super.addListener(listener);
		//listener.sendAllWindowProperties(this, (IInventory) this.oven.inventory);
	}

	@Override
	public ItemStack transferStackInSlot(EntityPlayer player, int slotIndex) {
		final Slot slot = inventorySlots.get(slotIndex);
		ItemStack copy = ItemStack.EMPTY;

		if (slot != null && slot.getHasStack()) {
			final ItemStack original = slot.getStack();
			copy = original.copy();

			if (slotIndex == 0) {
				if (!mergeItemStack(original, 5, 41, true)) return ItemStack.EMPTY;
				slot.onSlotChange(original, copy);
			} else if (slotIndex > 5) {
				if (original.getCount() == 1 && !mergeItemStack(original, 0, 5, false)) return ItemStack.EMPTY;
				slot.onSlotChange(original, copy);
			} else {
				if (!mergeItemStack(original, 5, 41, true)) return ItemStack.EMPTY;
				slot.onSlotChange(original, copy);
			}

			if (original.getCount() == 0) {
				slot.putStack(ItemStack.EMPTY);
			} else {
				slot.onSlotChanged();
			}

			if (original.getCount() == copy.getCount()) return ItemStack.EMPTY;

			slot.onTake(player, original);
		}

		return copy;
	}

	@Override
	public boolean canInteractWith(EntityPlayer playerIn) {
		return !playerIn.isSpectator();
	}
}