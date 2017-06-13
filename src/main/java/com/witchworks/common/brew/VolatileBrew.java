package com.witchworks.common.brew;

import com.witchworks.api.brew.IBrew;
import com.witchworks.api.brew.IBrewAttack;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;

/**
 * This class was created by Arekkuusu on 24/04/2017.
 * It's distributed as part of Witchworks under
 * the MIT license.
 */
public class VolatileBrew implements IBrew, IBrewAttack {

	@Override
	public void apply(World world, BlockPos pos, EntityLivingBase entity, int amplifier, int tick) {
		//Todo: Add explosions. Come, now, and walk the path of explosions with me!
		//FIXME: KASUMAAAAAAAAAAAAAAAAAAAAAAAAAAA!!!!
	}

	@Override
	public void onFinish(World world, BlockPos pos, @Nullable EntityLivingBase entity, int amplifier) {
		//NO-OP
	}

	@Override
	public boolean isInstant() {
		return false;
	}

	@Override
	public int getColor() {
		return 0xEE7F2D;
	}

	@Override
	public String getName() {
		return "brew.volatility_brew";
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void renderHUD(int x, int y, Minecraft mc) {
		render(x, y, mc, 7);
	}

	@Override
	public void onAttack(LivingAttackEvent event, DamageSource source, EntityLivingBase affected, int amplifier) {
		affected.world.createExplosion(source.getSourceOfDamage(), affected.posX, affected.posY + 0.5D, affected.posZ, amplifier * 1.5F, true);
	}
}