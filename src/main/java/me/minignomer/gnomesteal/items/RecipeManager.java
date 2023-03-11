package me.minignomer.gnomesteal.items;

import me.minignomer.gnomesteal.GnomeSteal;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapedRecipe;

public class RecipeManager {
    
    public static void init() {
        createHeartFragmentRecipe();
        createHeartRecipe();
        createReviveBeaconRecipe();
    }

    private static void createHeartFragmentRecipe() {
        try {
            ShapedRecipe recipe = new ShapedRecipe(NamespacedKey.minecraft("heartfragment"), ItemManager.heartFragment);




            recipe.shape("012", "345", "678");

            Object[] heartFragmentRecipe = GnomeSteal.instance.getConfig().getStringList("HeartFragmentRecipe").toArray();

            for (int i = 0; i < 9; i++) {
                String ingredient = (String) heartFragmentRecipe[i];

                char iChar = (char) (i + '0');


                ingredient.toUpperCase();



                switch (ingredient) {
                    case "HEART":
                        try {
                            recipe.setIngredient(iChar, new RecipeChoice.ExactChoice(ItemManager.heart));
                        } catch (IllegalArgumentException ignore) {}
                        break;
                    case "HEART_FRAGMENT":
                        try {
                            recipe.setIngredient(iChar, new RecipeChoice.ExactChoice(ItemManager.heartFragment));
                        } catch (IllegalArgumentException ignore) {}
                        break;
                    case "REVIVE_BEACON":
                        recipe.setIngredient(iChar, new RecipeChoice.ExactChoice(ItemManager.reviveBeacon));
                        break;
                    default:
                        try {
                            recipe.setIngredient(iChar, Material.valueOf(ingredient));
                        } catch(IllegalArgumentException exception) {
                            Bukkit.getLogger().warning("\"HeartFragmentRecipe\" must be equal to an item (there may be a spelling mistake)");
                        }
                        break;
                }
            }
            Bukkit.getServer().addRecipe(recipe);
        } catch(NullPointerException ignored) {}
    }

    private static void createHeartRecipe() {
        try {
            ShapedRecipe recipe = new ShapedRecipe(NamespacedKey.minecraft("heart"), ItemManager.heart);

            recipe.shape("012", "345", "678");

            Object[] heartRecipe = GnomeSteal.instance.getConfig().getStringList("HeartRecipe").toArray();

            for (int i = 0; i < 9; i++) {
                String ingredient = (String) heartRecipe[i];

                char iChar = (char) (i + '0');


                ingredient.toUpperCase();



                switch (ingredient) {
                    case "HEART":
                        try {
                            recipe.setIngredient(iChar, new RecipeChoice.ExactChoice(ItemManager.heart));
                        } catch (IllegalArgumentException ignore) {}
                        break;
                    case "HEART_FRAGMENT":
                        try {
                            recipe.setIngredient(iChar, new RecipeChoice.ExactChoice(ItemManager.heartFragment));
                        } catch (IllegalArgumentException ignore) {}
                        break;
                    case "REVIVE_BEACON":
                        recipe.setIngredient(iChar, new RecipeChoice.ExactChoice(ItemManager.reviveBeacon));
                        break;
                    default:
                        try {
                            recipe.setIngredient(iChar, Material.valueOf(ingredient));
                        } catch(IllegalArgumentException exception) {
                            Bukkit.getLogger().warning("\"HeartRecipe\" must be equal to an item (there may be a spelling mistake)");
                        }
                        break;
                }
            }
            Bukkit.getServer().addRecipe(recipe);
        } catch(NullPointerException ignored) {}
    }

    private static void createReviveBeaconRecipe() {
        ShapedRecipe recipe = new ShapedRecipe(NamespacedKey.minecraft("revivebeacon"), ItemManager.reviveBeacon);

        recipe.shape("012", "345", "678");

        Object[] reviveBeaconRecipe = GnomeSteal.instance.getConfig().getStringList("ReviveBeaconRecipe").toArray();

        for (int i = 0; i < 9; i++) {
            String ingredient = (String) reviveBeaconRecipe[i];

            char iChar = (char) (i + '0');


            ingredient.toUpperCase();



            switch (ingredient) {
                case "HEART":
                    try {
                        recipe.setIngredient(iChar, new RecipeChoice.ExactChoice(ItemManager.heart));
                    } catch (IllegalArgumentException ignore) {}
                    break;
                case "HEART_FRAGMENT":
                    try {
                        recipe.setIngredient(iChar, new RecipeChoice.ExactChoice(ItemManager.heartFragment));
                    } catch (IllegalArgumentException ignore) {}
                    break;
                case "REVIVE_BEACON":
                    recipe.setIngredient(iChar, new RecipeChoice.ExactChoice(ItemManager.reviveBeacon));
                    break;
                default:
                    try {
                        recipe.setIngredient(iChar, Material.valueOf(ingredient));
                    } catch(IllegalArgumentException exception) {
                        Bukkit.getLogger().warning("\"ReviveBeaconRecipe\" must be equal to an item (there may be a spelling mistake)");
                    }
                    break;
            }
        }
        Bukkit.getServer().addRecipe(recipe);
    }
}
