package com.witchworks.common.crafting.kettle;

import com.witchworks.api.BrewRegistry;
import com.witchworks.api.CauldronRegistry;
import com.witchworks.api.RitualRegistry;
import com.witchworks.api.brew.BrewEffect;
import com.witchworks.api.brew.BrewUtils;
import com.witchworks.api.recipe.BrewModifier;
import com.witchworks.api.recipe.BrewSimpleModifier;
import com.witchworks.api.ritual.IRitual;
import com.witchworks.common.block.ModBlocks;
import com.witchworks.common.block.natural.fluid.Fluids;
import com.witchworks.common.brew.ModBrews;
import com.witchworks.common.item.ModItems;
import com.witchworks.common.lib.LibMod;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;

/**
 * This class was created by Arekkuusu on 21/03/2017.
 * It's distributed as part of Witchworks under
 * the MIT license.
 */
@SuppressWarnings("WeakerAccess")
public final class CauldronCrafting {

	private CauldronCrafting() {
	}

	public static void init() {
		//------------------------------------Processing------------------------------------//
		//Some recipes that return the non-dyed version of an Item
		registerItemProcess(FluidRegistry.WATER, Items.LEATHER_HELMET, Items.LEATHER_HELMET, false);
		registerItemProcess(FluidRegistry.WATER, Items.LEATHER_CHESTPLATE, Items.LEATHER_CHESTPLATE, false);
		registerItemProcess(FluidRegistry.WATER, Items.LEATHER_LEGGINGS, Items.LEATHER_LEGGINGS, false);
		registerItemProcess(FluidRegistry.WATER, Items.LEATHER_BOOTS, Items.LEATHER_BOOTS, false);
		//Cooking with Oil
		registerItemProcess(Fluids.MUNDANE_OIL, Items.PORKCHOP, Items.COOKED_PORKCHOP, true);
		registerItemProcess(Fluids.MUNDANE_OIL, Items.MUTTON, Items.COOKED_MUTTON, true);
		registerItemProcess(Fluids.MUNDANE_OIL, Items.RABBIT, Items.COOKED_RABBIT, true);
		registerItemProcess(Fluids.MUNDANE_OIL, Items.CHICKEN, Items.COOKED_CHICKEN, true);
		registerItemProcess(Fluids.MUNDANE_OIL, Items.BEEF, Items.COOKED_BEEF, true);
		registerItemProcess(Fluids.MUNDANE_OIL, Items.FISH, Items.COOKED_FISH, true);
		registerItemProcess(Fluids.MUNDANE_OIL, Items.POTATO, Items.BAKED_POTATO, true);
		//Coking with Water
		registerItemProcess(FluidRegistry.WATER, ModItems.EMPTY_HONEYCOMB, ModItems.WAX, true);
		registerItemProcess(FluidRegistry.WATER, ModItems.HONEYCOMB, ModItems.HONEY, true);

		//------------------------------------Fluid Creation------------------------------------//
		CauldronRegistry.registerFluidIngredient(ModItems.HONEY, new FluidStack(Fluids.HONEY, 1000));
		CauldronRegistry.registerFluidIngredient(Items.POTATO, new FluidStack(Fluids.MUNDANE_OIL, 1000));

		//------------------------------------Item Rituals------------------------------------//

		//Todo: Better recipe for kelp seeds.
		registerItemRitual("seed_kelp", getStack(ModItems.SEED_KELP), 5
				, getStack(Items.WHEAT_SEEDS, 1), Blocks.WATERLILY);

		registerItemRitual("golden_apple", getStack(Items.GOLDEN_APPLE, 1, 1), 8
				, getStack(Blocks.GOLD_BLOCK, 8), Items.APPLE);

		//------------------------------------Brew Recipes------------------------------------//
		registerBrewRecipe(BrewRegistry.Brew.LINGER, new BrewEffect(ModBrews.MARS_WATER, 500, 0)
				, getStack(Items.field_191525_da, 6), Items.POISONOUS_POTATO, Items.ROTTEN_FLESH, ModItems.SALT, ModItems.JASPER);

		//------------------------------------Custom Brew Creation------------------------------------//
		registerEffect(getStack(ModItems.SALT)
				, new PotionEffect(MobEffects.BLINDNESS, 500), false);
		registerEffect(getStack(Items.ROTTEN_FLESH)
				, new PotionEffect(MobEffects.HUNGER, 500), false);
		registerEffect(getStack(Blocks.END_STONE)
				, new PotionEffect(MobEffects.SLOWNESS, 500), false);
		registerEffect(getStack(Items.SPIDER_EYE)
				, new PotionEffect(MobEffects.POISON, 500), false);
		registerEffect(getStack(Items.GHAST_TEAR)
				, new PotionEffect(MobEffects.REGENERATION, 500), false);
		registerEffect(getStack(Items.GOLDEN_CARROT)
				, new PotionEffect(MobEffects.NIGHT_VISION, 500), false);
		registerEffect(getStack(Items.SUGAR)
				, new PotionEffect(MobEffects.SPEED, 500), false);
		registerEffect(getStack(Items.MAGMA_CREAM)
				, new PotionEffect(MobEffects.FIRE_RESISTANCE, 500), false);
		registerEffect(getStack(Items.BLAZE_POWDER)
				, new PotionEffect(MobEffects.STRENGTH, 500), false);
		registerEffect(getStack(Items.RABBIT_FOOT)
				, new PotionEffect(MobEffects.JUMP_BOOST, 500), false);
		registerEffect(getStack(Items.SPECKLED_MELON)
				, new PotionEffect(MobEffects.INSTANT_HEALTH, 1), false);
		registerEffect(getStack(Items.FISH, 1, 3)
				, new PotionEffect(MobEffects.WATER_BREATHING, 500), false);
		registerEffect(getStack(Blocks.RED_FLOWER, 1, 1)
				, new PotionEffect(MobEffects.LUCK, 500), false);
		registerEffect(getStack(ModItems.WAX)
				, new PotionEffect(MobEffects.SLOWNESS, 500), false);
		registerEffect(getStack(Items.POISONOUS_POTATO)
				, new PotionEffect(MobEffects.NAUSEA, 500), false);
		registerEffect(getStack(ModItems.BELLADONNA)
				, new PotionEffect(MobEffects.WITHER, 500), false);
		registerEffect(getStack(ModItems.ASPHODEL)
				, new PotionEffect(MobEffects.UNLUCK, 500), false);
		registerEffect(getStack(ModItems.LAVENDER)
				, new PotionEffect(MobEffects.HASTE, 500), false);
		registerEffect(getStack(Items.PRISMARINE_CRYSTALS)
				, new PotionEffect(MobEffects.GLOWING, 500), false);
		registerEffect(getStack(ModItems.KELP)
				, new PotionEffect(MobEffects.WATER_BREATHING, 500), false);
		registerEffect(getStack(Items.PRISMARINE_SHARD)
				, new PotionEffect(MobEffects.MINING_FATIGUE, 500), false);
		registerEffect(getStack(Items.SHULKER_SHELL)
				, new PotionEffect(MobEffects.LEVITATION, 500), false);
		registerEffect(getStack(ModBlocks.COQUINA)
				, BrewRegistry.getDefault(ModBrews.SHELL_ARMOR), false);
		registerEffect(getStack(ModItems.MINT)
				, BrewRegistry.getDefault(ModBrews.EXTINGUISH_FIRES), false);
		registerEffect(getStack(ModItems.WHITE_SAGE)
				, BrewRegistry.getDefault(ModBrews.HOLY_WATER), false);
		registerEffect(getStack(Blocks.WEB)
				, BrewRegistry.getDefault(ModBrews.SPIDER_NIGHTMARE), false);
		registerEffect(getStack(Items.SNOWBALL)
				, BrewRegistry.getDefault(ModBrews.FROSTBITE), false);
		registerEffect(getStack(Blocks.TNT)
				, BrewRegistry.getDefault(ModBrews.VOLATILE), false);
		registerEffect(getStack(ModItems.ACONITUM)
				, BrewRegistry.getDefault(ModBrews.WOLFSBANE), false);
		registerEffect(getStack(ModItems.WORMWOOD)
				, BrewRegistry.getDefault(ModBrews.BANE_ARTHROPODS), false);

		registerModifier(getStack(Items.QUARTZ)
				, new BrewSimpleModifier(2400, 0), true);
		registerModifier(getStack(Items.REDSTONE)
				, new BrewSimpleModifier(600, 0), true);
		registerModifier(getStack(Blocks.REDSTONE_BLOCK)
				, new BrewSimpleModifier(1200, 0), true);
		registerModifier(getStack(ModItems.NUUMMITE)
				, new BrewSimpleModifier(0, 3), true);
		registerModifier(getStack(Items.GLOWSTONE_DUST)
				, new BrewSimpleModifier(0, 1), true);
		registerModifier(getStack(Blocks.GLOWSTONE)
				, new BrewSimpleModifier(0, 2), true);
	}

	private static void registerItemProcess(Fluid fluid, Item in, Item out, boolean perfectMatch) {
		CauldronRegistry.registerItemProcessing(fluid, in, out, perfectMatch);
	}

	private static void registerItemRitual(String name, ItemStack spawned, int cost, Object... needed) {
		IRitual ritual = RitualRegistry.register(new ResourceLocation(LibMod.MOD_ID, name), new ItemRitual(spawned, cost));
		CauldronRegistry.registerItemRitual((ItemRitual) ritual, needed);
	}

	private static void registerBrewRecipe(BrewRegistry.Brew brew, BrewEffect effect, Object... needed) {
		CauldronRegistry.registerBrewRecipe(BrewUtils.createBrew(brew, effect), needed);
	}

	private static <T> void registerEffect(ItemStack key, T brew, boolean perfectMatch) {
		CauldronRegistry.registerItemEffect(key, brew, perfectMatch);
	}

	private static void registerModifier(ItemStack key, BrewModifier modifier, boolean perfectMatch) {
		CauldronRegistry.registerItemModifier(key, modifier, perfectMatch);
	}

	/**
	 * Who needs to write the whole thing?
	 *
	 * @param item The item to make an ItemStack out of
	 * @return An ItemStack
	 */
	private static ItemStack getStack(Item item) {
		return getStack(item, 1, 0);
	}

	/**
	 * Who needs to write the whole thing?
	 *
	 * @param item The block to make an ItemStack out of
	 * @param size Size of ItemStack
	 * @return An ItemStack
	 */
	private static ItemStack getStack(Item item, int size) {
		return new ItemStack(item, size, 0);
	}

	/**
	 * Who needs to write the whole thing?
	 *
	 * @param item The block to make an ItemStack out of
	 * @param size Size of ItemStack
	 * @param meta Meta of ItemStack
	 * @return An ItemStack
	 */
	private static ItemStack getStack(Item item, int size, int meta) {
		return new ItemStack(item, size, meta);
	}

	/**
	 * Who needs to write the whole thing?
	 *
	 * @param block The block to make an ItemStack out of
	 * @return An ItemStack
	 */
	@SuppressWarnings("ConstantConditions")
	private static ItemStack getStack(Block block) {
		return getStack(Item.getItemFromBlock(block), 1, 0);
	}

	/**
	 * Who needs to write the whole thing?
	 *
	 * @param block The block to make an ItemStack out of
	 * @param size  Size of ItemStack
	 * @return An ItemStack
	 */
	@SuppressWarnings("ConstantConditions")
	private static ItemStack getStack(Block block, int size) {
		return getStack(Item.getItemFromBlock(block), size, 0);
	}

	/**
	 * Who needs to write the whole thing?
	 *
	 * @param block The block to make an ItemStack out of
	 * @param size  Size of ItemStack
	 * @param meta  Meta of ItemStack
	 * @return An ItemStack
	 */
	@SuppressWarnings("ConstantConditions")
	private static ItemStack getStack(Block block, int size, int meta) {
		return getStack(Item.getItemFromBlock(block), size, meta);
	}
}