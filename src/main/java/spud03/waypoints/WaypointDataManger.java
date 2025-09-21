package spud03.waypoints;

import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.PersistentStateManager;

public class WaypointDataManger {
    public static WaypointData get(ServerWorld world) {
        PersistentStateManager manager = world.getPersistentStateManager();
        return manager.getOrCreate(WaypointData, "spud03s-waypoints");
    }
}
