package com.natamus.keepmysoiltilled.events;

import com.natamus.keepmysoiltilled.util.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FarmBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class StemBlockHarvestEvent {
	public static void onCropBlockBreak(Level world, Player player, BlockPos pos, BlockState state, BlockEntity blockEntity) {
		if (world.isClientSide) {
			return;
		}

		if (Util.isStemGrownBlock(state.getBlock())) {
			BlockState farmstate = null;
			boolean foundfarmland = false;

			for (BlockPos np : BlockPos.betweenClosed(pos.getX() - 1, pos.getY() - 1, pos.getZ() - 1, pos.getX() + 1, pos.getY() - 1, pos.getZ() + 1)) {
				Block nb = world.getBlockState(np).getBlock();
				if (nb instanceof FarmBlock) {
					foundfarmland = true;
					farmstate = Blocks.FARMLAND.defaultBlockState();
					break;
				}
			}

			if (foundfarmland && farmstate != null) {
				world.setBlock(pos.below(), farmstate, 3);
			}
		}
	}
}
