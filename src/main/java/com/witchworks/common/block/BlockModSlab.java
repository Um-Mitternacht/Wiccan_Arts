package com.witchworks.common.block;

import java.util.Locale;
import java.util.Random;

import javax.annotation.Nonnull;

import com.witchworks.api.helper.IModelRegister;
import com.witchworks.client.handler.ModelHandler;
import com.witchworks.common.core.WitchWorksCreativeTabs;
import com.witchworks.common.lib.LibMod;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.statemap.StateMap;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

//Original code belongs to Vazkii, and is permitted under her license.

public abstract class BlockModSlab extends BlockSlab implements IModelRegister {

	private final String name;
	private final boolean doubleSlab;
	private static final PropertyEnum<DummyEnum> DUMMY = PropertyEnum.create("dummy", DummyEnum.class);

	public BlockModSlab(boolean full, Material mat, String name) {
		super(mat);
		this.name = name;
		setUnlocalizedName(name);
		setRegistryName(new ResourceLocation(LibMod.MOD_ID, name));
		doubleSlab = full;
		if(!full) {
			setCreativeTab(WitchWorksCreativeTabs.BLOCKS_CREATIVE_TAB);
			useNeighborBrightness = true;
		}
		setDefaultState(blockState.getBaseState().withProperty(HALF, EnumBlockHalf.BOTTOM).withProperty(DUMMY, DummyEnum.SINGLETON));
	}

	@Nonnull
	@Override
	public BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, HALF, getVariantProperty());
	}

	@Nonnull
	@Override
	public IBlockState getStateFromMeta(int meta) {
		if (doubleSlab) {
			return getDefaultState();
		} else {
			return getDefaultState().withProperty(HALF, meta == 8 ? EnumBlockHalf.TOP : EnumBlockHalf.BOTTOM);
		}
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		if (doubleSlab) {
			return 0;
		} else {
			return state.getValue(HALF) == EnumBlockHalf.TOP ? 8 : 0;
		}
	}

	public abstract BlockSlab getFullBlock();

	public abstract BlockSlab getSingleBlock();

	@Nonnull
	@Override
	public ItemStack getPickBlock(@Nonnull IBlockState state, RayTraceResult target, @Nonnull World world, @Nonnull BlockPos pos, EntityPlayer player) {
		return new ItemStack(getSingleBlock());
	}

	@Nonnull
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return Item.getItemFromBlock(getSingleBlock());
	}

	@Nonnull
	@Override
	public ItemStack getSilkTouchDrop(@Nonnull IBlockState par1) {
		return new ItemStack(getSingleBlock());
	}

	@Nonnull
	@Override
	public String getUnlocalizedName(int i) {
		return name;
	}

	@Override
	public final boolean isDouble() {
		return doubleSlab;
	}

	@Nonnull
	@Override
	public final IProperty getVariantProperty() {
		return DUMMY; // Vanilla expects us to store different kinds of slabs into one block ID. Except we don't. We need this dummy property and dummy value to satisfy it.
	}

	@Nonnull
	@Override
	public final Comparable<?> getTypeForItem(@Nonnull ItemStack stack) {
		return DummyEnum.SINGLETON;
	}

	private enum DummyEnum implements IStringSerializable {
		SINGLETON {
			@Nonnull
			@Override
			public String getName() {
				return name().toLowerCase(Locale.ROOT);
			}
		}
	}

}