// 
// Decompiled by Procyon v0.5.36
// 

package fr.diegomekarcha.buyspawners.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.OfflinePlayer;
import java.util.List;
import java.util.Arrays;
import org.bukkit.inventory.ItemStack;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import fr.diegomekarcha.buyspawners.BuySpawners;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.Listener;

public class ListenerClicks implements Listener
{
    private FileConfiguration cf;
    private BuySpawners main;
    
    public ListenerClicks(final FileConfiguration cf, final BuySpawners main) {
        this.cf = cf;
        this.main = main;
    }
    
    @EventHandler
    public void onClick(final InventoryClickEvent e) {
        final ItemStack i = e.getCurrentItem();
        final Player p = (Player)e.getWhoClicked();
        final ItemStack sc = new ItemStack(Material.SPAWNER);
        final ItemMeta sm = sc.getItemMeta();
        sm.setDisplayName("§eSpawner de §aCreeper");
        sm.setLore((List)Arrays.asList("§8§l§m =|===[]===|= ", "§8§l§m =|===[]===|= "));
        sc.setItemMeta(sm);
        final ItemStack sc2 = new ItemStack(Material.SPAWNER);
        final ItemMeta sm2 = sc2.getItemMeta();
        sm2.setDisplayName("§eSpawner de §aCreeper");
        sm2.setLore((List)Arrays.asList("§8§l§m =|===[]===|= ", "§8§l§m =|===[]===|= "));
        sc2.setItemMeta(sm2);
        final ItemStack sg = new ItemStack(Material.SPAWNER);
        final ItemMeta sgm = sg.getItemMeta();
        sgm.setDisplayName("§eSpawner de §7Golem");
        sgm.setLore((List)Arrays.asList("§8§l§m =|===[]===|= ", "§8§l§m =|===[]===|= "));
        sg.setItemMeta(sgm);
        final ItemStack sg2 = new ItemStack(Material.SPAWNER, 64);
        final ItemMeta sm3 = sg2.getItemMeta();
        sm3.setDisplayName("§eSpawner de §aCreeper");
        sm3.setLore((List)Arrays.asList("§8§l§m =|===[]===|= ", "§8§l§m =|===[]===|= "));
        sg2.setItemMeta(sm3);
        if (e.getView().getTitle().equalsIgnoreCase(this.cf.getString("GUIName").replace("&", "§")) && i != null && i.getType() == Material.SPAWNER) {
            if (i.getItemMeta().getDisplayName().contains("Creeper")) {
                e.setCancelled(true);
                if (this.main.setupEconomy()) {
                    if (this.main.economy.getBalance((OfflinePlayer)p) >= this.cf.getInt("creeperPrice")) {
                        if (p.getInventory().firstEmpty() == -1) {
                            p.getWorld().dropItem(p.getLocation(), sc);
                            p.sendMessage("§aVous avez achet\u00e9 un Spawner de Creeper avec succ\u00e8s \u00e0 §2" + this.cf.getInt("creeperPrice") + " §a" + this.cf.getString("currency") + " !");
                            this.main.removeMoney(p, this.cf.getInt("creeperPrice"));
                            p.sendMessage("§4\u26a0 Attention ! \u26a0 §6Votre Spawner est tomb\u00e9 par terre.");
                        }
                        else if (p.getInventory().firstEmpty() >= 0 || p.getInventory().contains(Material.SPAWNER)) {
                            p.getInventory().addItem(new ItemStack[] { sc });
                            p.sendMessage("§aVous avez achet\u00e9 un Spawner de Creeper avec succ\u00e8s \u00e0 §2" + this.cf.getInt("creeperPrice") + " §a" + this.cf.getString("currency") + " !");
                            this.main.removeMoney(p, this.cf.getInt("creeperPrice"));
                        }
                    }
                    else {
                        p.sendMessage("§cErreur ! Vous n'avez pas assez d'argent pour vous acheter un Spawner.");
                    }
                }
            }
            else if (i.getItemMeta().getDisplayName().contains("Golem")) {
                e.setCancelled(true);
                if (this.main.setupEconomy()) {
                    if (this.main.economy.getBalance((OfflinePlayer)p) >= this.cf.getInt("golemPrice")) {
                        if (p.getInventory().firstEmpty() == -1) {
                            p.getWorld().dropItem(p.getLocation(), sg);
                            p.sendMessage("§aVous avez achet\u00e9 un Spawner de §7Golem§a avec succ\u00e8s \u00e0 §2" + this.cf.getInt("golemPrice") + " §a" + this.cf.getString("currency") + " !");
                            this.main.removeMoney(p, this.cf.getInt("golemPrice"));
                            p.sendMessage("§4\u26a0 Attention ! \u26a0 §6Votre Spawner est tomb\u00e9 par terre.");
                        }
                        else if (p.getInventory().firstEmpty() >= 0 || p.getInventory().contains(Material.SPAWNER)) {
                            p.getInventory().addItem(new ItemStack[] { sg });
                            p.sendMessage("§aVous avez achet\u00e9 un Spawner de §7Golem§a avec succ\u00e8s \u00e0 §2" + this.cf.getInt("golemPrice") + " §a" + this.cf.getString("currency") + " !");
                            this.main.removeMoney(p, this.cf.getInt("golemPrice"));
                        }
                    }
                    else {
                        p.sendMessage("§cErreur ! Vous n'avez pas assez d'argent pour vous acheter un Spawner.");
                    }
                }
            }
        }
    }
}
