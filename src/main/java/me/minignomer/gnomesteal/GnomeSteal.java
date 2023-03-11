package me.minignomer.gnomesteal;


import me.minignomer.gnomesteal.commands.GSConfigCommand;
import me.minignomer.gnomesteal.commands.GSConfigTabCompletion;
import me.minignomer.gnomesteal.commands.WithdrawCommand;
import me.minignomer.gnomesteal.files.BannedPlayersConfig;
import me.minignomer.gnomesteal.graceperiod.GracePeriod;
import me.minignomer.gnomesteal.items.ItemManager;
import me.minignomer.gnomesteal.items.RecipeManager;
import me.minignomer.gnomesteal.killdeath.GainHeart;
import me.minignomer.gnomesteal.killdeath.KickPlayerOnJoin;
import me.minignomer.gnomesteal.killdeath.LoseHeart;
import me.minignomer.gnomesteal.revive.PlayerPlaceReviveBeacon;
import me.minignomer.gnomesteal.revive.RevivePlayer;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

public final class GnomeSteal extends JavaPlugin {

    public static GnomeSteal instance;

    public static List<String> list;

    @Override
    public void onEnable() {
        Bukkit.getLogger().info("GnomeSteal Enabled");
        instance = this;
        this.getConfig().options().copyDefaults();
        this.saveDefaultConfig();
        list = new ArrayList<>();
        BannedPlayersConfig.setup();
        BannedPlayersConfig.get().addDefault("Banned", list);
        BannedPlayersConfig.get().options().copyDefaults(true);
        BannedPlayersConfig.save();
        BannedPlayersConfig.reload();
        ItemManager.itemInit();
        RecipeManager.init();
        this.getServer().getPluginManager().registerEvents(new LoseHeart(), this);
        this.getServer().getPluginManager().registerEvents(new GainHeart(), this);
        this.getServer().getPluginManager().registerEvents(new KickPlayerOnJoin(), this);
        this.getServer().getPluginManager().registerEvents(new PlayerPlaceReviveBeacon(), this);
        this.getServer().getPluginManager().registerEvents(new RevivePlayer(), this);
        this.getServer().getPluginManager().registerEvents(new GracePeriod(), this);
        this.getCommand("withdraw").setExecutor(new WithdrawCommand());
        this.getCommand("gsconfig").setExecutor(new GSConfigCommand());
        this.getCommand("gsconfig").setTabCompleter(new GSConfigTabCompletion());
    }

    @Override
    public void onDisable() {
        Bukkit.getLogger().info("GnomeSteal Disabled");
    }
}
