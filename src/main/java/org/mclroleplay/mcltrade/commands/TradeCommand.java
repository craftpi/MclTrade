package org.mclroleplay.mcltrade.commands;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.mclroleplay.mcltrade.events.InvCreate;

public class TradeCommand implements CommandExecutor, Listener {
    @Override
    public boolean onCommand(CommandSender cs, Command cmd, String lable, String[] args) {

        Player p = (Player) cs;

        if (!(cs instanceof Player)) {
            cs.sendMessage("§4Du must ein Spieler sein");
        } else {
            p.openInventory(InvCreate.invCreate());
        }
        return true;
    }
}
