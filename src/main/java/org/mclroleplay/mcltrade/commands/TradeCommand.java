package org.mclroleplay.mcltrade.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TradeCommand implements CommandExecutor, Listener {
    @Override
    public boolean onCommand(CommandSender cs, Command cmd, String lable, String[] args) {
        if (!(cs instanceof Player)) {
            cs.sendMessage("§4Du must ein Spieler sein");
            return true;
        }
        Player p = (Player) cs;
        Inventory i = Bukkit.getServer().createInventory(null, 6*9, "§4Inventar");
        /*ItemStack s = new ItemStack(Material.APPLE);
        ItemMeta m = s.getItemMeta();
        m.setDisplayName("§cKlick Mich");
        s.setItemMeta(m);
        i.setItem(22, s);*/
        p.openInventory(i);
        return true;
    }
}
