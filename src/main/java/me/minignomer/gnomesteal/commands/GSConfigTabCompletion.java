package me.minignomer.gnomesteal.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.*;

public class GSConfigTabCompletion implements TabCompleter {
    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {

        if (args.length == 1) {
            Set<String> set = new HashSet<>();
            boolean b1 = Collections.addAll(set,
                    "HeartItem",
                    "HeartFragmentItem",
                    "LoseHeartsFromNaturalCauses",
                    "EnableGracePeriod",
                    "HeartExchange",
                    "HeartsOnRevive",
                    "HeartMax",
                    "DropHeartFragment",
                    "DropHeart",
                    "Get");
            return new ArrayList<>(set);
        } else if (args.length == 2) {
            Set<String> set = new HashSet<>();
            switch (args[0]) {
                case "LoseHeartsFromNaturalCauses":
                case "EnableGracePeriod":
                case "DropHeartFragment":
                case "DropHeart":
                    boolean b2 = Collections.addAll(set, "True", "False");
                    return new ArrayList<>(set);
                case "HeartExchange":
                case "HeartsOnRevive":
                    boolean b3 = Collections.addAll(set,
                            "1",
                            "2",
                            "3",
                            "4",
                            "5",
                            "6",
                            "7",
                            "8",
                            "9");
                    return new ArrayList<>(set);
                case "HeartMax":
                    boolean b4 = Collections.addAll(set,
                            "10",
                            "20",
                            "30",
                            "40",
                            "50",
                            "60",
                            "100");
                    return new ArrayList<>(set);
                case "Get":
                    boolean b5 = Collections.addAll(set,
                            "Heart",
                            "HeartFragment",
                            "ReviveBeacon");
                    return new ArrayList<>(set);
            }
        } return null;
    }
}
