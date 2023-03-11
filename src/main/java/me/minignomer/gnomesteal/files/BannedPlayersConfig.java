package me.minignomer.gnomesteal.files;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class BannedPlayersConfig {


    public static File file;
    public static FileConfiguration bannedPlayersFile;

    public static void setup() {
        file = new File("plugins/GnomeSteal", "bannedplayers.yml");

        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                Bukkit.getLogger().warning("Couldn't create file");
            }
            bannedPlayersFile = YamlConfiguration.loadConfiguration(file);
        }
        bannedPlayersFile = YamlConfiguration.loadConfiguration(file);
        if (file.exists() && bannedPlayersFile == null) {


            file.delete();

            try {
                file.createNewFile();
            } catch (IOException e) {
                Bukkit.getLogger().warning("Couldn't create file");
            }
            bannedPlayersFile = YamlConfiguration.loadConfiguration(file);
        }
    }
    public static FileConfiguration get() {
        return bannedPlayersFile;
    }

    public static void save() {
        try {
            bannedPlayersFile.save(file);
        } catch (IOException e) {
            Bukkit.getLogger().warning("Couldn't save file");
        }
    }
    public static void reload() {
        bannedPlayersFile = YamlConfiguration.loadConfiguration(file);
    }
}
