package fr.diegomekarcha.buyspawners;

import fr.diegomekarcha.buyspawners.listeners.ListenerPlace;
import org.bukkit.plugin.Plugin;
import org.bukkit.event.Listener;
import fr.diegomekarcha.buyspawners.listeners.ListenerClicks;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import fr.diegomekarcha.buyspawners.commands.CommandSpawner;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.plugin.RegisteredServiceProvider;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class BuySpawners extends JavaPlugin
{
    private FileConfiguration cf;
    public Economy economy;

    public BuySpawners() {
        this.cf = this.getConfig();
    }

    public boolean setupEconomy() {
        final RegisteredServiceProvider<Economy> economyProvider = (RegisteredServiceProvider<Economy>)this.getServer().getServicesManager().getRegistration((Class)Economy.class);
        if (economyProvider != null) {
            this.economy = (Economy)economyProvider.getProvider();
        }
        return this.economy != null;
    }

    public void removeMoney(final Player player, final double amount) {
        this.economy.withdrawPlayer((OfflinePlayer)player, amount);
    }

    public void onEnable() {
        this.saveDefaultConfig();
        System.out.println("[BuySpawners] Le plugin s'allume !");
        this.getCommand("buyspawner").setExecutor((CommandExecutor)new CommandSpawner(this.cf));
        Bukkit.getPluginManager().registerEvents((Listener)new ListenerClicks(this.cf, this), (Plugin)this);
        Bukkit.getPluginManager().registerEvents((Listener)new ListenerPlace(), (Plugin)this);
    }

    public void onDisable() {
        System.out.println("[BuySpawners] Le plugin s'eteint !");
    }
}