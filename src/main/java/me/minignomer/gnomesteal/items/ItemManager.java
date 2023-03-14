package me.minignomer.gnomesteal.items;

import me.minignomer.gnomesteal.GnomeSteal;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class ItemManager {

    public static ItemStack heart;

    public static ItemStack heartFragment;

    public static ItemStack reviveBeacon;

    public static void itemInit() {
        createHeart();
        createHeartFragment();
        createReviveBeacon();
    }

    private static void createHeartFragment() {
        try {
            ItemStack item = new ItemStack(Material.valueOf(GnomeSteal.instance.getConfig().getString("HeartFragmentItem")));
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName("§4§lHeart Fragment");
            List<String> lore = new ArrayList<>();
            lore.add("§cUse Me In A Crafting Recipe To Make A Heart!");
            meta.setLore(lore);
            item.setItemMeta(meta);
            heartFragment = item;
        } catch(IllegalArgumentException exception) {
            Bukkit.getLogger().warning("\"HeartFragmentItem\" must be equal to an item (there may be a spelling mistake)");
        }
    }

    private static void createHeart() {
        try {
        ItemStack item = new ItemStack(Material.valueOf(GnomeSteal.instance.getConfig().getString("HeartItem")));
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§4§lHeart");
        List<String> lore = new ArrayList<>();
        lore.add("§cRight Click Me To Gain A Heart!");
        meta.setLore(lore);
        item.setItemMeta(meta);
        heart = item;
        } catch(IllegalArgumentException exception) {
            Bukkit.getLogger().warning("\"HeartItem\" must be equal to an item (there may be a spelling mistake)");
        }
    }

    private static void createReviveBeacon() {
        ItemStack item = new ItemStack(Material.BEACON);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§3§lRevive Beacon");
        List<String> lore = new ArrayList<>();
        lore.add("§bRight Click Me To Revive A Player!");
        meta.setLore(lore);
        item.setItemMeta(meta);
        reviveBeacon = item;
    }
}
