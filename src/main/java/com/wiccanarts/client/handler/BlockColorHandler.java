package com.wiccanarts.client.handler;

import com.wiccanarts.api.state.WiccanArtsState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.color.IBlockColor;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;

/**
 * This class was created by Arekkuusu on 11/03/2017.
 * It's distributed as part of Wiccan Arts under
 * the MIT license.
 */
public class BlockColorHandler implements IBlockColor {

	@SideOnly(Side.CLIENT)
	@Override
	public int colorMultiplier(IBlockState state, @Nullable IBlockAccess worldIn, @Nullable BlockPos pos, int tintIndex) {
		int color = 0;
		switch (state.getValue(WiccanArtsState.COLOR).getMetadata()) {
			case 0:
				color = 15987957;
				break;
			case 1:
				color = 16087062;
				break;
			case 2:
				color = 11745961;
				break;
			case 3:
				color = 3847130;
				break;
			case 4:
				color = 16435754;
				break;
			case 5:
				color = 8834086;
				break;
			case 6:
				color = 16030389;
				break;
			case 7:
				color = 4673362;
				break;
			case 8:
				color = 9737358;
				break;
			case 9:
				color = 1413268;
				break;
			case 10:
				color = 8400048;
				break;
			case 11:
				color = 2895503;
				break;
			case 12:
				color = 8606770;
				break;
			case 13:
				color = 6653465;
				break;
			case 14:
				color = 10955043;
				break;
			case 15:
				color = 987157;
				break;
		}
		return color;
	}
}
