package com.natamus.keepmysoiltilled.forge.events;

import com.natamus.collective.functions.WorldFunctions;
import com.natamus.keepmysoiltilled.events.StemBlockHarvestEvent;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.eventbus.api.bus.BusGroup;
import net.minecraftforge.eventbus.api.listener.SubscribeEvent;

import java.lang.invoke.MethodHandles;

public class ForgeStemBlockHarvestEvent {
	public static void registerEventsInBus() {
		// BusGroup.DEFAULT.register(MethodHandles.lookup(), ForgeStemBlockHarvestEvent.class);

		BlockEvent.BreakEvent.BUS.addListener(ForgeStemBlockHarvestEvent::onCropBlockBreak);
	}

	@SubscribeEvent
	public static void onCropBlockBreak(BlockEvent.BreakEvent e) {
		Level level = WorldFunctions.getWorldIfInstanceOfAndNotRemote(e.getLevel());
		if (level == null) {
			return;
		}

		StemBlockHarvestEvent.onCropBlockBreak(level, e.getPlayer(), e.getPos(), e.getState(), null);
	}
}
