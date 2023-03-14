package me.minignomer.gnomesteal.revive;

import me.minignomer.gnomesteal.files.BannedPlayersConfig;
import me.minignomer.gnomesteal.items.ItemManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryMoveItemEvent;
import org.bukkit.inventory.InventoryView;

import java.util.List;

public class RevivePlayer implements Listener {

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {

        InventoryView inventory = e.getView();

        if (inventory.getTitle().equalsIgnoreCase("§bPick a player to revive!")) {
            if (e.getCurrentItem() != null) {
                e.setCancelled(true);
                Player p = (Player) e.getWhoClicked();
                String name = e.getCurrentItem().getItemMeta().getDisplayName();
                if (BannedPlayersConfig.get().getStringList("Banned").contains(name)) {
                    List<String> list = BannedPlayersConfig.get().getStringList("Banned");
                    list.remove(name);
                    BannedPlayersConfig.get().set("Banned", list);
                    BannedPlayersConfig.save();
                    BannedPlayersConfig.reload();
                    if (p.getInventory().getItemInMainHand().isSimilar(ItemManager.reviveBeacon)) {
                        p.getInventory().getItemInMainHand().setAmount(p.getInventory().getItemInMainHand().getAmount() - 1);
                    } else if (p.getInventory().getItemInOffHand().isSimilar(ItemManager.reviveBeacon)) {
                        p.getInventory().getItemInOffHand().setAmount(p.getInventory().getItemInMainHand().getAmount() - 1);
                    } else {
                        p.sendMessage("§cAn error occurred, try again");
                    }
                    p.closeInventory();
                }
            }
        }
    }

    @EventHandler
    public void onInventoryItemMove(InventoryMoveItemEvent e) {
        InventoryView inventoryView = (InventoryView) e.getDestination();
        if (inventoryView.getTitle().equals("§bPick a player to revive!")) {
            e.setCancelled(true);
        }
    }

}
