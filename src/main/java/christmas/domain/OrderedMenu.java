package christmas.domain;

import christmas.domain.menu.Menu;

/**
 * @author 민경수
 * @description ordered menu
 * @since 2023.11.11
 **********************************************************************************************************************/
public class OrderedMenu {

    private final Menu menu;
    private final Integer amount;

    private OrderedMenu(Menu menu, Integer amount) {
        this.menu = menu;
        this.amount = amount;
    }

    public static OrderedMenu of(Menu menu, int amount) {
        return new OrderedMenu(menu, amount);
    }

    public String toString() {
        return menu.toString() + " " + amount + "개";
    }

    public int calculatePrice() {
        return menu.calculateTotalPrice(amount);
    }
}