package me.minignomer.gnomesteal.killdeath;

import me.minignomer.gnomesteal.GnomeSteal;
import me.minignomer.gnomesteal.items.ItemManager;
import org.bukkit.Bukkit;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class GainHeart implements Listener {
    
    @EventHandler
    public void onPlayerKill(PlayerDeathEvent e) {
        Player p = e.getEntity().getPlayer();
        Player k = e.getEntity().getKiller();
        if (GnomeSteal.instance.getConfig().getBoolean("DropHeartFragment") && GnomeSteal.instance.getConfig().getBoolean("DropHeart")) {
            p.getWorld().dropItem(p.getLocation(), ItemManager.heartFragment);
            p.getWorld().dropItem(p.getLocation(), ItemManager.heart);
        } else if (GnomeSteal.instance.getConfig().getBoolean("DropHeartFragment")) {
            p.getWorld().dropItem(p.getLocation(), ItemManager.heartFragment);
        } else if (GnomeSteal.instance.getConfig().getBoolean("DropHeart")) {
            p.getWorld().dropItem(p.getLocation(), ItemManager.heart);
        } if (k != null) {
            if (!GnomeSteal.instance.getConfig().getBoolean("DropHeartFragment") && !GnomeSteal.instance.getConfig().getBoolean("DropHeart")) {
                if (k.getAttribute(Attribute.GENERIC_MAX_HEALTH).getBaseValue() <= GnomeSteal.instance.getConfig().getDouble("HeartMax")) {
                    k.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(k.getAttribute(Attribute.GENERIC_MAX_HEALTH).getBaseValue() + GnomeSteal.instance.getConfig().getDouble("HeartExchange"));
                } else {
                    p.sendMessage("§cYou have the max hearts");
                }
            } else {
                Bukkit.getLogger().warning("ERROR: \"DropHeartFragment\" and \"DropHeart\" must be equal to true or false");
            }
        }
    }

    @EventHandler
    public void onPlayerRightClickHeart(PlayerInteractEvent e) {
        if (e.getItem() != null && e.getItem().getItemMeta().getLore() != null) {
            if (e.getItem().getItemMeta().getLore().equals(ItemManager.heart.getItemMeta().getLore())) {
                if (e.getAction().equals(Action.RIGHT_CLICK_BLOCK) || e.getAction().equals(Action.RIGHT_CLICK_AIR)) {
                    Player p = e.getPlayer();
                    if (p.getAttribute(Attribute.GENERIC_MAX_HEALTH).getBaseValue() == GnomeSteal.instance.getConfig().getDouble("HeartMax")) {
                        p.sendMessage("§cYou have the max hearts");
                    } else {
                        p.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(p.getAttribute(Attribute.GENERIC_MAX_HEALTH).getBaseValue() + GnomeSteal.instance.getConfig().getDouble("HeartExchange"));
                        e.getItem().setAmount(e.getItem().getAmount() - 1);
                    }
                }
            }
        }

    }
}
