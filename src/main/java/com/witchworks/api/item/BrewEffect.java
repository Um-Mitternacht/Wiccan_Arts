package com.witchworks.api.item;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.annotation.Nullable;

/**
 * This class was created by Arekkuusu on 23/04/2017.
 * It's distributed as part of Witchworks under
 * the MIT license.
 */
public class BrewEffect {

	private IBrew brew;
	private int duration;
	private int amplifier;

	public BrewEffect(IBrew brew, int duration, int amplifier) {
		this.brew = brew;
		this.duration = duration;
		this.amplifier = amplifier;
	}

	public void update(World world, BlockPos pos, @Nullable EntityLivingBase entity) {
		brew.apply(world, pos, entity, amplifier, duration--);
	}

	public void end(World world, BlockPos pos, @Nullable EntityLivingBase entity) {
		brew.onFinish(world, pos, entity, amplifier);
	}

	public IBrew getBrew() {
		return brew;
	}

	public int getDuration() {
		return duration;
	}

	public int getAmplifier() {
		return amplifier;
	}

	public boolean isInstant() {
		return brew.isInstant();
	}

	public BrewEffect copy() {
		return new BrewEffect(brew, duration, amplifier);
	}
}
