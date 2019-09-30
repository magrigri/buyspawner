// 
// Decompiled by Procyon v0.5.36
// 

package fr.diegomekarcha.buyspawners.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.block.BlockState;
import org.bukkit.inventory.ItemStack;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.entity.EntityType;
import org.bukkit.Material;
import org.bukkit.block.CreatureSpawner;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.Listener;

public class ListenerPlace implements Listener
{
    @EventHandler
    public void onPlace(final BlockPlaceEvent e) {
        final Player p = e.getPlayer();
        final Block b = e.getBlock();
        final ItemStack pi = p.getInventory().getItemInMainHand();
        final BlockState bs = b.getState();

        if (b.getType() == Material.SPAWNER) {

            final CreatureSpawner cs = (CreatureSpawner)bs;

            if (pi.getItemMeta().getDisplayName().equalsIgnoreCase("§eSpawner de §aCreeper") && pi.getItemMeta().getLore().contains("§8§l§m =|===[]===|= ")) {
                cs.setSpawnedType(EntityType.CREEPER);
                bs.update();
            }
            else if (pi.getItemMeta().getDisplayName().equalsIgnoreCase("§eSpawner de §7Golem") && pi.getItemMeta().getLore().contains("§8§l§m =|===[]===|= ")) {
                cs.setSpawnedType(EntityType.IRON_GOLEM);
                bs.update();
            }
        }
    }
}
