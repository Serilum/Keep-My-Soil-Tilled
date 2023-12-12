package com.natamus.keepmysoiltilled;

import com.natamus.collective.check.RegisterMod;
import com.natamus.collective.fabric.callbacks.CollectiveBlockEvents;
import com.natamus.keepmysoiltilled.events.StemBlockHarvestEvent;
import com.natamus.keepmysoiltilled.util.Reference;
import net.fabricmc.api.ModInitializer;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class ModFabric implements ModInitializer {
	
	@Override
	public void onInitialize() {
		setGlobalConstants();
		ModCommon.init();

		loadEvents();

		RegisterMod.register(Reference.NAME, Reference.MOD_ID, Reference.VERSION, Reference.ACCEPTED_VERSIONS);
	}

	private void loadEvents() {
		CollectiveBlockEvents.BLOCK_DESTROY.register((Level world, Player player, BlockPos blockPos, BlockState blockState, BlockEntity blockEntity, ItemStack itemStack) -> {
			StemBlockHarvestEvent.onCropBlockBreak(world, player, blockPos, blockState, blockEntity);
			return true;
		});
	}

	private static void setGlobalConstants() {

	}
}
