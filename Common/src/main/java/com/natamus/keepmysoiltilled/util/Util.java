package com.natamus.keepmysoiltilled.util;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.StemGrownBlock;

public class Util {
	public static boolean isStemGrownBlock(Block block) {
		return block instanceof StemGrownBlock;
	}
}
