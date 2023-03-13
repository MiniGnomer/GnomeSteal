package me.minignomer.gnomesteal.killdeath;

import me.minignomer.gnomesteal.GnomeSteal;
import me.minignomer.gnomesteal.files.BannedPlayersConfig;
import org.bukkit.Bukkit;
import org.bukkit.attribute.Attribute;
import org.bukkit.command.CommandException;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import java.util.List;

public class LoseHeart implements Listener {

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent e) {
        Player p = e.getEntity().getPlayer();
        Player k = e.getEntity().getKiller();
        if (GnomeSteal.instance.getConfig().getBoolean("LoseHeartsFromNaturalCauses")) {
            if (p.getAttribute(Attribute.GENERIC_MAX_HEALTH).getBaseValue() <= GnomeSteal.instance.getConfig().getDouble("HeartExchange")) {
                if (GnomeSteal.instance.getConfig().getString("EliminateCommand").equals("default")) {
                    List<String> list = BannedPlayersConfig.get().getStringList("Banned");
                    list.add(p.getName());
                    BannedPlayersConfig.get().set("Banned", list);
                    BannedPlayersConfig.save();
                    p.getInventory().clear();
                    p.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(GnomeSteal.instance.getConfig().getDouble("HeartsOnRevive"));
                    p.kickPlayer("§c§lYou ran out of hearts!");
                    Bukkit.broadcastMessage("§c§l" + p.getName() + " ran out of hearts!");
                } else {
                    try {
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), GnomeSteal.instance.getConfig().getString("EliminateCommand").replace("{player}", p.getName()));
                    } catch(CommandException exception) {
                        Bukkit.getLogger().warning("ERROR: \"EliminateCommand\" gave an error. Make sure the command is correct");
                    }
                }
            } else {
                p.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(p.getAttribute(Attribute.GENERIC_MAX_HEALTH).getBaseValue() - GnomeSteal.instance.getConfig().getDouble("HeartExchange"));
            }
        } else if (!GnomeSteal.instance.getConfig().getBoolean("LoseHeartsFromNaturalCauses")) {
            if (p.getAttribute(Attribute.GENERIC_MAX_HEALTH).getBaseValue() <= GnomeSteal.instance.getConfig().getDouble("HeartExchange")) {
                if (k != null) {
                    List<String> list = BannedPlayersConfig.get().getStringList("Banned");
                    list.add(p.getName());
                    BannedPlayersConfig.get().set("Banned", list);
                    BannedPlayersConfig.save();
                    p.getInventory().clear();
                    p.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(GnomeSteal.instance.getConfig().getDouble("HeartsOnRevive"));
                    p.kickPlayer("§c§lYou ran out of hearts!");
                    Bukkit.broadcastMessage("§c§l" + p.getName() + " ran out of hearts!");
                }
            } else {
                p.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(p.getAttribute(Attribute.GENERIC_MAX_HEALTH).getBaseValue() - GnomeSteal.instance.getConfig().getDouble("HeartExchange"));
            }
        } else {
            Bukkit.getLogger().warning("ERROR: \"LoseHeartsFromNaturalCauses\" must be equal to true or false");
        }
    }
}
