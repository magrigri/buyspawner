// 
// Decompiled by Procyon v0.5.36
// 

package fr.diegomekarcha.buyspawners.utils;

public class EMsg
{
    public static final String args(final String arg) {
        return "§cErreur ! L'argument ''" + arg + "'' est incorrect. §8[§c\u2717§8]";
    }
    
    public static final String invint(final String arg) {
        return "§cErreur ! L'argument ''" + arg + "'' est invalide. Vous ne pouvez y inscrire qu'un nombre entier. §8[§c\u2717§8]";
    }
    
    public static final String syntax() {
        return "§cErreur ! Veuillez v\u00e9rifier la syntaxe de la commande. §8[§c\u2717§8]";
    }
    
    public static final String invp(final String playername) {
        return "§cErreur ! Le joueur que vous avez sp\u00e9cifi\u00e9 (''" + playername + "'') n'existe pas ou n'est pas connect\u00e9. §8[§c\u2717§8]";
    }
    
    public static final String invw(final String worldname) {
        return "§cErreur ! Le monde que vous avez sp\u00e9cifi\u00e9 (''" + worldname + "'') n'existe pas. §8[§c\u2717§8]";
    }
    
    public static final String perm() {
        return "§cErreur ! §4§l\u2716 §cVous n'avez pas la permission de faire cela. §8[§c\u2717§8]";
    }
    
    public static final String cmdb() {
        return "§cErreur ! Vous ne pouvez pas effectuer cette commande \u00e0 partir d'un bloc de commande. §8[§c\u2717§8]";
    }
    
    public static final String ccs() {
        return "§cErreur ! Vous ne pouvez pas effectuer cette commande \u00e0 partir de la Console. §8[§c\u2717§8]";
    }
    
    public static final String config(final String action) {
        return "§cErreur ! Une erreur dans la configuration du plugin vous emp\u00eache d" + action + ". Veuillez contacter les Administrateurs du serveur au plus vite. §8[§c\u2717§8]";
    }
}
