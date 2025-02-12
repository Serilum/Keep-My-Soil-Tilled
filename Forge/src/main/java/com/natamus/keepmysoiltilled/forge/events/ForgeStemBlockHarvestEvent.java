package com.natamus.keepmysoiltilled.forge.events;

import com.natamus.collective.functions.WorldFunctions;
import com.natamus.keepmysoiltilled.events.StemBlockHarvestEvent;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class ForgeStemBlockHarvestEvent {
	@SubscribeEvent
	public static void onCropBlockBreak(BlockEvent.BreakEvent e) {
		Level level = WorldFunctions.getWorldIfInstanceOfAndNotRemote(e.getLevel());
		if (level == null) {
			return;
		}

		StemBlockHarvestEvent.onCropBlockBreak(level, e.getPlayer(), e.getPos(), e.getState(), null);
	}
}
