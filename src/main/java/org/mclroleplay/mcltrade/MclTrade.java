package org.mclroleplay.mcltrade;

import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.PluginDescriptionFile;

public final class MclTrade extends JavaPlugin {

    public static PluginDescriptionFile pdf;

    @Override
    public void onEnable() {
        // Plugin startup logic
        pdf = this.getDescription();
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + pdf.getName() + " " + pdf.getVersion() + " has been enabled.");

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getServer().getConsoleSender().sendMessage(ChatColor.RED + pdf.getName() + " " + pdf.getVersion() + " has been diabled.");
    }
}
