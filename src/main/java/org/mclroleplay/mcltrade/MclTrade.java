package org.mclroleplay.mcltrade;

import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;
import org.mclroleplay.mcltrade.commands.TradeCommand;
import org.mclroleplay.mcltrade.config.ConfigSave;
import org.mclroleplay.mcltrade.events.InvCreate;

public final class MclTrade extends JavaPlugin {

    private static Economy econ = null;
  //  private static Permission perms = null;
  //  private static Chat chat = null;
    public static PluginDescriptionFile pdf;

    public MclTrade() {
    }

    @Override
    public void onEnable() {
        // Plugin startup logic
        // Enable info
        pdf = this.getDescription();
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + pdf.getName() + " " + pdf.getVersion() + " has been enabled.");

        //config
        new ConfigSave().createconfig(this);
        new ConfigSave().createprice(this);

        //events
        PluginManager pluginManager = Bukkit.getPluginManager();
        pluginManager.registerEvents(new TradeCommand(), this);
        pluginManager.registerEvents(new InvCreate(), this);

        // Commands
        this.getCommand("trade").setExecutor(new TradeCommand());


    /*
        // Create and update the file
        try {
            config = YamlDocument.create(new File(getDataFolder(), "config.yml"), getResource("config.yml"),
                    GeneralSettings.DEFAULT, LoaderSettings.builder().setAutoUpdate(true).build(), DumperSettings.DEFAULT, UpdaterSettings.builder().setVersioning(new BasicVersioning("file-version")).build());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
*/
        //Economy setup
        if (!setupEconomy() ) {
            getLogger().severe(String.format("[%s] - Disabled due to no Vault dependency found!", getDescription().getName()));
            getServer().getPluginManager().disablePlugin(this);
        }
    }

    private boolean setupEconomy() {
        if (getServer().getPluginManager().getPlugin("Vault") == null) {
            return false;
        }
        RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
        if (rsp == null) {
            return false;
        }
        econ = rsp.getProvider();
        return econ != null;
    }
/*
    private boolean setupChat() {
        RegisteredServiceProvider<Chat> rsp = getServer().getServicesManager().getRegistration(Chat.class);
        chat = rsp.getProvider();
        return chat != null;
    }

    private boolean setupPermissions() {
        RegisteredServiceProvider<Permission> rsp = getServer().getServicesManager().getRegistration(Permission.class);
        perms = rsp.getProvider();
        return perms != null;
    }
*/

    public static Economy getEconomy() {
        return econ;
    }
/*
    public static Permission getPermissions() {
        return perms;
    }

    public static Chat getChat() {
        return chat;
    }
*/
    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getServer().getConsoleSender().sendMessage(ChatColor.RED + pdf.getName() + " " + pdf.getVersion() + " has been diabled.");
    }
}
