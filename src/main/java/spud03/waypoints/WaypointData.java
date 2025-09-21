package spud03.waypoints;

import net.minecraft.block.Block;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtList;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.PersistentState;

import java.util.ArrayList;
import java.util.List;

public class WaypointData extends PersistentState {
    private static final String KEY = "spud03s-waypoints";

    private final List<BlockPos> waypoints = new ArrayList<>();

    public WaypointData() {
        super();
    }

    public static WaypointData fromNbt(NbtCompound nbt) {
        WaypointData data = new WaypointData();
        NbtList list = nbt.getList("waypoints", 10);  // 10 = compound tag?
        for (int i = 0; i < list.size(); i++) {
            NbtCompound posNbt = list.getCompound(i);
            int x = posNbt.getInt("x");
            int y = posNbt.getInt("y");
            int z = posNbt.getInt("z");
            data.waypoints.add(new BlockPos(x, y, z));
        }
        return data;
    }

    @Override
    public NbtCompound writeNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registries) {
        NbtList list = new NbtList();
        for (BlockPos pos : waypoints) {
            NbtCompound posNbt = new NbtCompound();
            posNbt.putInt("x", pos.getX());
            posNbt.putInt("y", pos.getY());
            posNbt.putInt("z", pos.getZ());
            list.add(posNbt);
        }
        nbt.put("waypoints", list);
        return nbt;
    }

    public void addWaypoint(BlockPos pos) {
        if (!waypoints.contains(pos)) {
            waypoints.add(pos);
            markDirty();
        }
    }

    public List<BlockPos> getWaypoints() {
        return waypoints;
    }
}
