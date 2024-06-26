package com.natamus.keepmysoiltilled.events;

import com.natamus.keepmysoiltilled.util.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FarmBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class StemBlockHarvestEvent {
	public static void onCropBlockBreak(Level level, Player player, BlockPos pos, BlockState state, BlockEntity blockEntity) {
		if (level.isClientSide) {
			return;
		}

		if (Util.isStemGrownBlock(state.getBlock())) {
			BlockState farmBlockState = null;
			boolean foundFarmBlock = false;

			for (BlockPos np : BlockPos.betweenClosed(pos.getX() - 1, pos.getY() - 1, pos.getZ() - 1, pos.getX() + 1, pos.getY() - 1, pos.getZ() + 1)) {
				Block nb = level.getBlockState(np).getBlock();
				if (nb instanceof FarmBlock) {
					foundFarmBlock = true;
					farmBlockState = Blocks.FARMLAND.defaultBlockState();
					break;
				}
			}

			if (foundFarmBlock && farmBlockState != null) {
				BlockPos belowPos = pos.below();
				if (level.getBlockState(belowPos).is(BlockTags.DIRT)) {
					level.setBlock(belowPos, farmBlockState, 3);
				}
			}
		}
	}
}
