package com.natamus.keepmysoiltilled.neoforge.events;

import com.natamus.collective.functions.WorldFunctions;
import com.natamus.keepmysoiltilled.events.StemBlockHarvestEvent;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.event.level.BlockEvent;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber
public class NeoForgeStemBlockHarvestEvent {
	@SubscribeEvent
	public static void onCropBlockBreak(BlockEvent.BreakEvent e) {
		Level level = WorldFunctions.getWorldIfInstanceOfAndNotRemote(e.getLevel());
		if (level == null) {
			return;
		}

		StemBlockHarvestEvent.onCropBlockBreak(level, e.getPlayer(), e.getPos(), e.getState(), null);
	}
}
