package com.witchworks.api.brew;

import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

/**
 * This class was created by Arekkuusu on 06/06/2017.
 * It's distributed as part of Witchworks under
 * the MIT license.
 */
public interface IBrewEntityImpact {

	void impact(RayTraceResult trace, World world, int amplifier);
}
