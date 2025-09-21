package spud03.waypoints.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class WaypointBlock extends Block {
    public WaypointBlock(Settings settings) {
        super(settings);
    }

    @Override
    public void onPlaced(World world, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack itemStack) {
        if (!world.isClient && placer instanceof ServerPlayerEntity player) {
            player.sendMessage(Text.literal("Waypoint placed at: " + pos.getX() + ", " + pos.getY() + ", " + pos.getZ()), false);
        }
        super.onPlaced(world, pos, state, placer, itemStack);
    }
}
