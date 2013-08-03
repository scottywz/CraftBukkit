package net.minecraft.server;

import java.util.Random;

import org.bukkit.event.block.LockedChestDecayEvent; // CraftBukkit

public class BlockLockedChest extends Block {

    protected BlockLockedChest(int i) {
        super(i, Material.WOOD);
    }

    public boolean canPlace(World world, int i, int j, int k) {
        return true;
    }

    public void a(World world, int i, int j, int k, Random random) {
        // CraftBukkit start
        LockedChestDecayEvent event = new LockedChestDecayEvent(world.getWorld().getBlockAt(i, j, k));
        world.getServer().getPluginManager().callEvent(event);

        if (event.isCancelled()) {
            return;
        }
        // CraftBukkit end

        world.setAir(i, j, k);
    }
}
