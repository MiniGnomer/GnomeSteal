package me.minignomer.gnomesteal.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;
import java.util.List;

public class GSConfigTabCompletion implements TabCompleter {
    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {

        if (args.length == 1) {
            List<String> autocomplete = new ArrayList<>();
            autocomplete.add("HeartItem");
            autocomplete.add("HeartFragmentItem");
            autocomplete.add("LoseHeartsFromNaturalCauses");
            autocomplete.add("EnableGracePeriod");
            autocomplete.add("HeartExchange");
            autocomplete.add("HeartsOnRevive");
            autocomplete.add("HeartMax");
            autocomplete.add("DropHeartFragment");
            autocomplete.add("DropHeart");
            return autocomplete;
        } else if (args.length == 2) {
            List<String> autocomplete = new ArrayList<>();
            switch (args[0]) {
                case "LoseHeartsFromNaturalCauses":
                case "EnableGracePeriod":
                case "DropHeartFragment":
                case "DropHeart":
                    autocomplete.add("True");
                    autocomplete.add("False");
                    return autocomplete;
                case "HeartExchange":
                case "HeartsOnRevive":
                    autocomplete.add("1");
                    autocomplete.add("2");
                    autocomplete.add("3");
                    autocomplete.add("4");
                    autocomplete.add("5");
                    autocomplete.add("6");
                    autocomplete.add("7");
                    autocomplete.add("8");
                    autocomplete.add("9");
                    autocomplete.add("10");
                    return autocomplete;
                case "HeartMax":
                    autocomplete.add("15");
                    autocomplete.add("20");
                    autocomplete.add("25");
                    autocomplete.add("30");
                    autocomplete.add("35");
                    autocomplete.add("40");
                    autocomplete.add("45");
                    autocomplete.add("50");
                    autocomplete.add("60");
                    autocomplete.add("100");
                    return autocomplete;
            }
        }

        return null;
    }
}
