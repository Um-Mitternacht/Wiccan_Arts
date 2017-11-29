package com.witchworks.common.item.magic;

import com.witchworks.common.core.WitchWorksCreativeTabs;
import com.witchworks.common.item.ItemMod;
import com.witchworks.common.lib.LibItemName;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IStringSerializable;

/**
 * Created by Joseph on 11/26/2017.
 */
public class ItemFume extends ItemMod {

	public ItemFume() {
		super(LibItemName.FUME);
		setMaxDamage(0);
		setCreativeTab(WitchWorksCreativeTabs.ITEMS_CREATIVE_TAB);
	}

	@Override
	public int getMetadata(int damage) {
		return damage;
	}

	@Override
	public String getUnlocalizedName(ItemStack stack) {
		return super.getUnlocalizedName() + "_" + ItemFume.FumeEnum.values()[stack.getMetadata()].getName();
	}

	public enum FumeEnum implements IStringSerializable {
		FOUL_FUME,
		BREATH_OF_THE_GODDESS,
		EXHALE_OF_THE_HORNED_ONE,
		HINT_OF_REBIRTH,
		ODOR_OF_PURITY,
		REEK_OF_MISFORTUNE,
		WHIFF_OF_MAGIC,
		SCENT_OF_SHADOWS,
		PROTECTIVE_SCENT,
		REEK_OF_DEATH,
		PURE_TRANQUILITY,
		ESSENCE_OF_LIFE,
		OIL_OF_VITRIOL,
		REDSTONE_DISTILLATE,
		TEAR_OF_THE_GODDESS,
		CHAOTIC_SUBSTANCE,
		ENTROPIC_OIL,
		DIAMOND_VAPOR,
		BOTTLED_DRAGONS_ROAR,
		STRANGE_MIASMA,
		ENDER_DEW,
		OUTER_ESSENCE,
		PURE_INFERNO,
		SOLAR_ESSENCE,
		SOLAR_OIL,
		SACRED_ESSENCE,
		INFERNAL_ESSENCE,
		DISTILLATE_OF_ORDER;

		@Override
		public String getName() {
			return name().toLowerCase();
		}
	}
}
