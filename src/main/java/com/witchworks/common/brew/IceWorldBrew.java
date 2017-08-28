package com.witchworks.common.brew;

import com.witchworks.common.block.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;

/**
 * This class was created by Arekkuusu on 11/06/2017.
 * It's distributed as part of Witchworks under
 * the MIT license.
 */
public class IceWorldBrew extends BlockHitBrew {

	private final Map<Block, IBlockState> stateMap = new HashMap<>();

	public IceWorldBrew() {
		stateMap.put(Blocks.GRASS_PATH, Blocks.PACKED_ICE.getDefaultState());
		stateMap.put(Blocks.GRAVEL, Blocks.PACKED_ICE.getDefaultState());
		stateMap.put(Blocks.COBBLESTONE, Blocks.PACKED_ICE.getDefaultState());
		stateMap.put(Blocks.PLANKS, ModBlocks.fake_ice.getDefaultState());
		stateMap.put(Blocks.STONE, ModBlocks.fake_ice.getDefaultState());
		stateMap.put(Blocks.BRICK_BLOCK, ModBlocks.fake_ice.getDefaultState());
		stateMap.put(Blocks.LEAVES, ModBlocks.fake_ice.getDefaultState());
		stateMap.put(Blocks.LEAVES2, ModBlocks.fake_ice.getDefaultState());
		stateMap.put(Blocks.STONEBRICK, ModBlocks.fake_ice.getDefaultState());
		stateMap.put(Blocks.OAK_STAIRS, ModBlocks.fake_ice_stairs.getDefaultState());
		stateMap.put(Blocks.SPRUCE_STAIRS, ModBlocks.fake_ice_stairs.getDefaultState());
		stateMap.put(Blocks.ACACIA_STAIRS, ModBlocks.fake_ice_stairs.getDefaultState());
		stateMap.put(Blocks.JUNGLE_STAIRS, ModBlocks.fake_ice_stairs.getDefaultState());
		stateMap.put(Blocks.DARK_OAK_STAIRS, ModBlocks.fake_ice_stairs.getDefaultState());
		stateMap.put(Blocks.BIRCH_STAIRS, ModBlocks.fake_ice_stairs.getDefaultState());
		stateMap.put(Blocks.RED_SANDSTONE_STAIRS, ModBlocks.fake_ice_stairs.getDefaultState());
		stateMap.put(Blocks.BRICK_STAIRS, ModBlocks.fake_ice_stairs.getDefaultState());
		stateMap.put(Blocks.LOG, Blocks.PACKED_ICE.getDefaultState());
		stateMap.put(Blocks.STONE_STAIRS, ModBlocks.fake_ice_stairs.getDefaultState());
		stateMap.put(Blocks.OAK_FENCE, ModBlocks.fake_ice_fence.getDefaultState());
		stateMap.put(Blocks.SPRUCE_FENCE, ModBlocks.fake_ice_fence.getDefaultState());
		stateMap.put(Blocks.ACACIA_FENCE, ModBlocks.fake_ice_fence.getDefaultState());
		stateMap.put(Blocks.JUNGLE_FENCE, ModBlocks.fake_ice_fence.getDefaultState());
		stateMap.put(Blocks.BIRCH_FENCE, ModBlocks.fake_ice_fence.getDefaultState());
		stateMap.put(Blocks.DARK_OAK_FENCE, ModBlocks.fake_ice_fence.getDefaultState());
		stateMap.put(Blocks.DIRT, Blocks.SNOW.getDefaultState());
		stateMap.put(Blocks.GRASS, Blocks.SNOW.getDefaultState());
		stateMap.put(Blocks.MYCELIUM, Blocks.SNOW.getDefaultState());
		stateMap.put(Blocks.SANDSTONE, ModBlocks.fake_ice.getDefaultState());
		stateMap.put(Blocks.NETHER_BRICK, ModBlocks.fake_ice.getDefaultState());
		stateMap.put(Blocks.RED_NETHER_BRICK, ModBlocks.fake_ice.getDefaultState());
		stateMap.put(Blocks.END_BRICKS, ModBlocks.fake_ice.getDefaultState());
	}

	@Override
	public int getColor() {
		return 0xB0E0E6;
	}

	@Override
	public String getName() {
		return "ice_world";
	}

	@Override
	public void safeImpact(BlockPos pos, @Nullable EnumFacing side, World world, int amplifier) {
		int box = 1 + (int) ((float) amplifier / 2F);

		BlockPos posI = pos.add(box, box, box);
		BlockPos posF = pos.add(-box, -box, -box);

		Iterable<BlockPos> spots = BlockPos.getAllInBox(posI, posF);
		for (BlockPos spot : spots) {
			Block block = world.getBlockState(spot).getBlock();
			boolean place = amplifier > 2 || world.rand.nextBoolean();
			if (place && stateMap.containsKey(block)) {
				world.setBlockState(spot, stateMap.get(block), 11);
			}
		}
	}
}
