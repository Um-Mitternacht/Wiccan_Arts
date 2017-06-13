package com.witchworks.client.render.entity;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

/**
 * This class was created by Arekkuusu on 10/06/2017.
 * It's distributed as part of Witchworks under
 * the MIT license.
 */
public class EmptyRenderer<T extends Entity> extends Render<T> {

	public EmptyRenderer(RenderManager renderManager) {
		super(renderManager);
	}

	@Nullable
	@Override
	protected ResourceLocation getEntityTexture(T entity) {
		return null;
	}
}
