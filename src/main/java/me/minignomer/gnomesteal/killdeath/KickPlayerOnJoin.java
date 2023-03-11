package me.minignomer.gnomesteal.killdeath;

import me.minignomer.gnomesteal.GnomeSteal;
import me.minignomer.gnomesteal.files.BannedPlayersConfig;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scheduler.BukkitRunnable;

public class KickPlayerOnJoin implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        if (BannedPlayersConfig.get().getStringList("Banned").contains(p.getName())) {
            new BukkitRunnable() {
                @Override
                public void run() {
                    p.kickPlayer("§c§lYou ran out of hearts!");
                }
            }.runTaskLater(GnomeSteal.instance, 1L);
        }
    }
}
