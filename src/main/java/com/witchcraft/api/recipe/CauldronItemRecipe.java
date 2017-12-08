package com.witchcraft.api.recipe;

import com.witchcraft.common.crafting.cauldron.ItemRitual;

/**
 * This class was created by Arekkuusu on 04/04/2017.
 * It's distributed as part of Witchcraft under
 * the MIT license.
 */
public class CauldronItemRecipe extends FlawlessRecipe {

	private final ItemRitual ritual;

	public CauldronItemRecipe(ItemRitual ritual, Object... inputs) {
		super(ritual.getStack(), inputs);
		this.ritual = ritual;
	}

	public ItemRitual getRitual() {
		return ritual;
	}
}
