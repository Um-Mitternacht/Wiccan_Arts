package com.witchworks.common.lib;

/**
 * This class was created by <Arekkuusu> on 26/02/2017.
 * It's distributed as part of Witchworks under
 * the MIT license.
 */
public final class LibMod {

	//ID for MOD
	public static final String MOD_ID = "witchworks";

	//Name of MOD
	public static final String MOD_NAME = "WitchWorks";

	//Version of MOD
	public static final String MOD_VER = "@VERSION@";

	//Dependency
	public static final String DEPENDENCIES = "required-after:forge@[14.23.1.2555,];required-after:JEI@[4.8.5.135,];required-after:Waila@[1.8.23-B38_1.12,];required-after:baubles@[1.5.1,];required-after:craftstudioapi@[0.3.0,]";

	//Client proxy location
	public static final String PROXY_CLIENT = "com.witchworks.client.core.ClientProxy";

	//Server proxy location
	public static final String PROXY_COMMON = "com.witchworks.common.core.proxy.ServerProxy";

	private LibMod() {
	}
}
