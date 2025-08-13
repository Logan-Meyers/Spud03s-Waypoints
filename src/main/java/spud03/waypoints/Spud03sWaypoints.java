package spud03.waypoints;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import spud03.waypoints.item.ModItems;

public class Spud03sWaypoints implements ModInitializer {
	public static final String MOD_ID = "spud03s-waypoints";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
        ModItems.registerModItems();  // register mod items on initialization of game

	}
}