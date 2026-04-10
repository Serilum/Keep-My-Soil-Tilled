package com.natamus.keepmysoiltilled.util;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.PumpkinBlock;

public class Util {
	public static boolean isStemGrownBlock(Block block) {
		return block instanceof PumpkinBlock || block.equals(Blocks.MELON);
	}
}
