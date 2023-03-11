package me.minignomer.gnomesteal.commands;

import me.minignomer.gnomesteal.GnomeSteal;
import me.minignomer.gnomesteal.items.ItemManager;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GSConfigCommand implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (args.length == 2) {
                switch (args[0]) {
                    case "HeartItem":
                        if (Material.matchMaterial(args[1]) != null) {
                            GnomeSteal.instance.getConfig().set("HeartItem", args[1].toUpperCase());
                            GnomeSteal.instance.getConfig().options().copyDefaults(true);
                            GnomeSteal.instance.saveConfig();
                            GnomeSteal.instance.reloadConfig();
                            p.sendMessage("§aHeartItem has been set to: " + args[1].toUpperCase());
                        } else {
                            p.sendMessage("§cYou must send a proper item see item list here: https://hub.spigotmc.org/javadocs/spigot/org/bukkit/Material.html");
                        }
                        break;
                    case "HeartFragmentItem":
                        if (Material.matchMaterial(args[1]) != null) {
                            GnomeSteal.instance.getConfig().set("HeartFragmentItem", args[1].toUpperCase());
                            GnomeSteal.instance.getConfig().options().copyDefaults(true);
                            GnomeSteal.instance.saveConfig();
                            GnomeSteal.instance.reloadConfig();
                            p.sendMessage("§aHeartFragmentItem has been set to: " + args[1].toUpperCase());
                        } else {
                            p.sendMessage("§cYou must send a proper item see item list here: https://hub.spigotmc.org/javadocs/spigot/org/bukkit/Material.html");
                        }
                        break;
                    case "LoseHeartsFromNaturalCauses":
                        if (args[1].equalsIgnoreCase("false")) {
                            GnomeSteal.instance.getConfig().set("LoseHeartsFromNaturalCauses", false);
                            GnomeSteal.instance.getConfig().options().copyDefaults(true);
                            GnomeSteal.instance.saveConfig();
                            GnomeSteal.instance.reloadConfig();
                            p.sendMessage("§aLoseHeartsFromNaturalCauses has been set to: false");
                        } else if (args[1].equalsIgnoreCase("true")) {
                            GnomeSteal.instance.getConfig().set("LoseHeartsFromNaturalCauses", true);
                            GnomeSteal.instance.getConfig().options().copyDefaults(true);
                            GnomeSteal.instance.saveConfig();
                            GnomeSteal.instance.reloadConfig();
                            p.sendMessage("§aLoseHeartsFromNaturalCauses has been set to: true");
                        } else {
                            p.sendMessage("§cMust be equal to true or false");
                        }
                        break;
                    case "EnableGracePeriod":
                        if (args[1].equalsIgnoreCase("true")) {
                            GnomeSteal.instance.getConfig().set("EnableGracePeriod", true);
                            GnomeSteal.instance.getConfig().options().copyDefaults(true);
                            GnomeSteal.instance.saveConfig();
                            GnomeSteal.instance.reloadConfig();
                            p.sendMessage("§aEnableGracePeriod has been set to: true");
                        } else if (args[1].equalsIgnoreCase("false")) {
                            GnomeSteal.instance.getConfig().set("EnableGracePeriod", false);
                            GnomeSteal.instance.getConfig().options().copyDefaults(true);
                            GnomeSteal.instance.saveConfig();
                            GnomeSteal.instance.reloadConfig();
                            p.sendMessage("§aEnableGracePeriod has been set to: false");
                        } else {
                            p.sendMessage("§cMust be equal to true or false");
                        }
                        break;
                    case "HeartExchange":
                        if (Integer.parseInt(args[1]) > 0) {
                            GnomeSteal.instance.getConfig().set("HeartExchange", (double) Integer.parseInt(args[1]) * 2);
                            GnomeSteal.instance.getConfig().options().copyDefaults(true);
                            GnomeSteal.instance.saveConfig();
                            GnomeSteal.instance.reloadConfig();
                            p.sendMessage("§aHeartExchange has been set to: " + (double) Integer.parseInt(args[1]));
                        } else {
                            p.sendMessage("§cMust be equal to a positive integer");
                        }
                        break;
                    case "HeartsOnRevive":
                        if (Integer.parseInt(args[1]) > 0) {
                            GnomeSteal.instance.getConfig().set("HeartsOnRevive", (double) Integer.parseInt(args[1]) * 2);
                            GnomeSteal.instance.getConfig().options().copyDefaults(true);
                            GnomeSteal.instance.saveConfig();
                            GnomeSteal.instance.reloadConfig();
                            p.sendMessage("§aHeartsOnRevive has been set to: " + (double) Integer.parseInt(args[1]));
                        } else {
                            p.sendMessage("§cMust be equal to a positive integer");
                        }
                        break;
                    case "HeartMax":
                        if (Integer.parseInt(args[1]) > 0) {
                            GnomeSteal.instance.getConfig().set("HeartMax", (double) Integer.parseInt(args[1]) * 2);
                            GnomeSteal.instance.getConfig().options().copyDefaults(true);
                            GnomeSteal.instance.saveConfig();
                            GnomeSteal.instance.reloadConfig();
                            p.sendMessage("§aHeartMax has been set to: " + (double) Integer.parseInt(args[1]));
                        } else {
                            p.sendMessage("§cMust be equal to a positive integer");
                        }
                        break;
                    case "DropHeartFragment":
                        if (args[1].equalsIgnoreCase("true")) {
                            GnomeSteal.instance.getConfig().set("DropHeartFragment", true);
                            GnomeSteal.instance.getConfig().options().copyDefaults(true);
                            GnomeSteal.instance.saveConfig();
                            GnomeSteal.instance.reloadConfig();
                            p.sendMessage("§aDropHeartFragment has been set to: true");
                        } else if (args[1].equalsIgnoreCase("false")) {
                            GnomeSteal.instance.getConfig().set("DropHeartFragment", false);
                            GnomeSteal.instance.getConfig().options().copyDefaults(true);
                            GnomeSteal.instance.saveConfig();
                            GnomeSteal.instance.reloadConfig();
                            p.sendMessage("§aDropHeartFragment has been set to: false");
                        } else {
                            p.sendMessage("§cMust be equal to true or false");
                        }
                        break;
                    case "DropHeart":
                        if (args[1].equalsIgnoreCase("true")) {
                            GnomeSteal.instance.getConfig().set("DropHeart", true);
                            GnomeSteal.instance.getConfig().options().copyDefaults(true);
                            GnomeSteal.instance.saveConfig();
                            GnomeSteal.instance.reloadConfig();
                            p.sendMessage("§aDropHeart has been set to: true");
                        } else if (args[1].equalsIgnoreCase("false")) {
                            GnomeSteal.instance.getConfig().set("DropHeart", false);
                            GnomeSteal.instance.getConfig().options().copyDefaults(true);
                            GnomeSteal.instance.saveConfig();
                            GnomeSteal.instance.reloadConfig();
                            p.sendMessage("§aDropHeart has been set to: false");
                        } else {
                            p.sendMessage("§cMust be equal to true or false");
                        }
                        break;
                    case "Get":
                        if (args[1].equalsIgnoreCase("heart")) {
                            p.getInventory().addItem(ItemManager.heart);
                        } else if (args[1].equalsIgnoreCase("heartFragment")) {
                            p.getInventory().addItem(ItemManager.heartFragment);
                        } else if (args[1].equalsIgnoreCase("reviveBeacon")) {
                            p.getInventory().addItem(ItemManager.reviveBeacon);
                        } else {
                            p.sendMessage("§cMust be equal to \"Heart\", \"HeartFragment\" or \"ReviveBeacon\"");
                        }
                        break;
                    default:
                        p.sendMessage("§cNot enough arguments to use this command");
                }
            }
        } return true;
    }
}
