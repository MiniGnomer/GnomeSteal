package me.minignomer.gnomesteal.graceperiod;

import me.minignomer.gnomesteal.GnomeSteal;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class GracePeriod implements Listener {

    @EventHandler
    public void onPlayerDamage(EntityDamageByEntityEvent e) {
        if (e.getEntity().getType() == EntityType.PLAYER && e.getDamager().getType() == EntityType.PLAYER) {
            if (GnomeSteal.instance.getConfig().getBoolean("EnableGracePeriod")) {
                e.setCancelled(true);
            }
        }
    }
}
