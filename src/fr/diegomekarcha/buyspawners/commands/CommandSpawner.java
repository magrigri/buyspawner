// 
// Decompiled by Procyon v0.5.36
// 

package fr.diegomekarcha.buyspawners.commands;

import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.Bukkit;
import java.util.List;
import java.util.Arrays;
import org.bukkit.inventory.ItemStack;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.command.CommandExecutor;

public class CommandSpawner implements CommandExecutor
{
    private FileConfiguration cf;
    
    public CommandSpawner(final FileConfiguration cf) {
        this.cf = cf;
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        if (sender instanceof Player) {
            final Player p = (Player)sender;
            if (cmd.getName().equalsIgnoreCase("buyspawner") && args.length == 0) {
                final ItemStack s1 = new ItemStack(Material.SPAWNER);
                final ItemMeta m1 = s1.getItemMeta();
                m1.setDisplayName("§eSpawner \u00e0 §7Golem");
                m1.setLore((List)Arrays.asList("  §6\u2192 §aPrix : §2" + this.cf.getInt("golemPrice") + " §a" + this.cf.getString("currency")));
                s1.setItemMeta(m1);
                final ItemStack s2 = new ItemStack(Material.SPAWNER);
                final ItemMeta m2 = s2.getItemMeta();
                m2.setDisplayName("§eSpawner \u00e0 §aCreeper");
                m2.setLore((List)Arrays.asList("  §6\u2192 §aPrix : §2" + this.cf.getInt("creeperPrice") + " §a" + this.cf.getString("currency")));
                s2.setItemMeta(m2);
                final Inventory inv = Bukkit.createInventory((InventoryHolder)null, 9, this.cf.getString("GUIName").replace("&", "§"));
                inv.setItem(2, s1);
                inv.setItem(6, s2);
                p.openInventory(inv);
                p.sendMessage("§4\u26a0 Attention ! \u26a0 §6Prenez bien soin de garder au minimum une place de libre dans votre inventaire !");
            }
        }
        return false;
    }
}
