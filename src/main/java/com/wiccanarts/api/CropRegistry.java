package com.wiccanarts.api;

import com.wiccanarts.api.item.crop.Crop;
import com.wiccanarts.common.block.crop.BlockCrop;
import net.minecraft.item.Item;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * This class was created by Arekkuusu on 14/04/2017.
 * It's distributed as part of Wiccan Arts under
 * the MIT license.
 */
@SuppressWarnings ({"WeakerAccess", "unused"})
public final class CropRegistry {

	private static final Map<Crop, Item> seeds = new LinkedHashMap<>();
	private static final Map<Crop, BlockCrop> crops = new LinkedHashMap<>();
	private static final Map<Crop, Item> foods = new LinkedHashMap<>();

	private CropRegistry() {
	}

	public static Map<Crop, Item> getSeeds() {
		return seeds;
	}

	public static Map<Crop, BlockCrop> getCrops() {
		return crops;
	}

	public static Map<Crop, Item> getFoods() {
		return foods;
	}
}
