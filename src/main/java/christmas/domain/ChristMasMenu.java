package christmas.domain;

import java.util.Arrays;
import java.util.List;

public enum ChristMasMenu {

    DESSERT(Arrays.asList(DessertMenu.CHOCOLATE_CAKE, DessertMenu.ICE_CREAM)),
    DRINK(Arrays.asList(Drink.ZERO_COKE, Drink.RED_WINE, Drink.CHAMPAGNE)),
    MAIN_MENU(Arrays.asList(MainMenu.T_BONE_STEAK, MainMenu.BARBECUE_RIB, MainMenu.SEAFOOD_PASTA, MainMenu.CHRISTMAS_PASTA)),
    APPETIZER(Arrays.asList(Appetizer.BUTTON_MUSHROOM_SOUP, Appetizer.TAPAS, Appetizer.CAESAR_SALAD));

    List<Enum<?>> items;

    ChristMasMenu(List<Enum<?>> items) {
        this.items = items;
    }

    public static Enum<?> findItemByName(String itemName) {
        for (ChristMasMenu menu : ChristMasMenu.values()) {
            for (Enum<?> item : menu.items) {
                if (item.name().equals(itemName)) {
                    return item;
                }
            }
        }
        return null; // Item not found
    }

}
