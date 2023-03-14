package me.minignomer.gnomesteal.revive;

import me.minignomer.gnomesteal.files.BannedPlayersConfig;
import me.minignomer.gnomesteal.items.ItemManager;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.List;

public class PlayerPlaceReviveBeacon implements Listener {

    @EventHandler
    public void onReviveBeaconRightClick(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        if (e.getAction().equals(Action.RIGHT_CLICK_AIR)) {
            if (p.getInventory().getItemInMainHand().isSimilar(ItemManager.reviveBeacon)) {
                Inventory reviveGui = Bukkit.createInventory(p, 54, "§bPick a player to revive!");
                List<String> list = BannedPlayersConfig.get().getStringList("Banned");
                int length = list.size();
                for (int i = 0; i <= length - 1; i++) {

                    ItemStack head = new ItemStack(Material.PLAYER_HEAD, 1);
                    SkullMeta meta = (SkullMeta) head.getItemMeta();
                    meta.setOwner(list.get(i));
                    meta.setDisplayName("§r" + list.get(i));
                    head.setItemMeta(meta);
                    reviveGui.setItem(i, head);
                }
                p.openInventory(reviveGui);
            }
        }
    }

    @EventHandler
    public void onReviveBeaconPlace(BlockPlaceEvent e) {

        Player p = e.getPlayer();

        ItemStack item = e.getItemInHand();

        if (item.isSimilar(ItemManager.reviveBeacon)) {

            e.setCancelled(true);

            Inventory reviveGui = Bukkit.createInventory(p, 54, "§bPick a player to revive!");
            List<String> list = BannedPlayersConfig.get().getStringList("Banned");
            int length = list.size();
            for (int i = 0; i <= length - 1; i++) {

                ItemStack head = new ItemStack(Material.PLAYER_HEAD, 1);
                SkullMeta meta = (SkullMeta) head.getItemMeta();
                meta.setOwner(list.get(i));
                meta.setDisplayName("§r" + list.get(i));
                head.setItemMeta(meta);


                reviveGui.setItem(i, head);
            }
            p.openInventory(reviveGui);
        }
    }
}
