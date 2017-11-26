package com.witchworks.common.item.food;

import com.witchworks.common.core.WitchWorksCreativeTabs;
import com.witchworks.common.lib.LibItemName;

/**
 * This class was created by Arekkuusu on 03/07/2017, and modified by Sunconure11 on 03/17/2017.
 * It's distributed as part of Witchworks under
 * the MIT license.
 */
public class ItemGrilledWatermelon extends ItemModFood {

	public ItemGrilledWatermelon() {
		super(LibItemName.GRILLED_WATERMELON, 4, 2.5F, false);
		setCreativeTab(WitchWorksCreativeTabs.ITEMS_CREATIVE_TAB);
	}
}
