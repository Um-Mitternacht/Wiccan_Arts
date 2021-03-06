/**
 * This class was created by <ArekkuusuJerii>. It's distributed as
 * part of the Grimoire Of Alice Mod. Get the Source Code in github:
 * https://github.com/ArekkuusuJerii/Grimore-Of-Alice
 * <p>
 * Grimore Of Alice is Open Source and distributed under the
 * Grimore Of Alice license: https://github.com/ArekkuusuJerii/Grimore-Of-Alice/blob/master/LICENSE.md
 */
package com.witchcraft.common.block;

import com.witchcraft.api.helper.IModelRegister;
import com.witchcraft.client.handler.ModelHandler;
import com.witchcraft.common.core.WitchcraftCreativeTabs;
import com.witchcraft.common.lib.LibMod;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * This class was created by <Arekkuusu> on 26/02/2017.
 * It's distributed as part of Witchcraft under
 * the MIT license.
 */
public class BlockMod extends Block implements IModelRegister {

	public BlockMod(String id, Material material) {
		super(material);
		setUnlocalizedName(id);
		setDefaultState(defaultState());
		setRegistryName(LibMod.MOD_ID, id);
		setCreativeTab(WitchcraftCreativeTabs.BLOCKS_CREATIVE_TAB);
	}

	protected IBlockState defaultState() {
		return blockState.getBaseState();
	}

	public Block setSound(SoundType type) {
		return super.setSoundType(type);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerModel() {
		ModelHandler.registerModel(this, 0);
	}
}
