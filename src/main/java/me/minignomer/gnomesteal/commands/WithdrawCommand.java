package me.minignomer.gnomesteal.commands;

import me.minignomer.gnomesteal.GnomeSteal;
import me.minignomer.gnomesteal.items.ItemManager;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class WithdrawCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (args.length == 1) {
                if (p.getInventory().firstEmpty() >= 0) {
                    try {
                        int heartAmount = Integer.parseInt(args[0]);
                        double doubleHeartAmount = heartAmount * GnomeSteal.instance.getConfig().getDouble("HeartExchange");
                        if (heartAmount < p.getAttribute(Attribute.GENERIC_MAX_HEALTH).getBaseValue() / 2) {
                            if (heartAmount > 0) {
                                ItemManager.heart.setAmount(heartAmount);
                                p.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(p.getAttribute(Attribute.GENERIC_MAX_HEALTH).getBaseValue() - doubleHeartAmount);
                                p.getInventory().addItem(ItemManager.heart);
                            } else {
                                p.sendMessage("§cYou must send a positive integer!");
                            }
                        } else {
                            p.sendMessage("§cYou don't have enough hearts!");
                        }
                    } catch (Exception exception) {
                        p.sendMessage("§cYou must send a positive integer!");
                    }
                } else {
                    p.sendMessage("§cYou don't have any free slots!");
                }
            }
        } return true;
    }
}
