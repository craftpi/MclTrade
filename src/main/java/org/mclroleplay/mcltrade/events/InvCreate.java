package org.mclroleplay.mcltrade.events;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.mclroleplay.mcltrade.config.ConfigSave;

import java.util.List;

public class InvCreate implements Listener {

    public static String config (String st){
        return ConfigSave.queryconfig(st);
    }
    public static String invName = config("tradegui-name");
    public static Inventory invCreate() {

        Inventory i = Bukkit.getServer().createInventory(null, 6 * 9, invName);

       // List<String> Items = config.getString("join-message").getSpawns();

        int slot = 9;

        for (int j = 0; j < 8; j++) {

            slot += 1;

            ItemStack tName = new ItemStack(Material.FILLED_MAP);
            ItemMeta me = tName.getItemMeta();
            me.setDisplayName("§c" + spawns.get(j));
            tName.setItemMeta(me);
            i.setItem(slot, tName);

        }

        return i;

    }

    // Klicken sperren
    @EventHandler
    public static void eventCancel(InventoryClickEvent e) {

        // Event set Cancelled
        if (e.getView().getTitle().equals(invName)) {

            if (e.getRawSlot() < e.getInventory().getSize()) {

                e.setCancelled(true);

            }
        }
    }
}
