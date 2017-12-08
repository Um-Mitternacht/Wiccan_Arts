package com.witchcraft.client.fx;

import net.minecraft.client.particle.Particle;
import net.minecraft.world.World;

/**
 * This class was created by Arekkuusu on 02/04/2017.
 * It's distributed as part of Witchcraft under
 * the MIT license.
 */
interface IParticleF {

	Particle createParticle(World worldIn, double xCoordIn, double yCoordIn, double zCoordIn, double xSpeedIn, double ySpeedIn, double zSpeedIn, int... args);
}
