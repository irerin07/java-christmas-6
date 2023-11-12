package christmas.domain.menu;

import java.util.Arrays;

public enum GiftMenu {

    NONE("없음", 0, 0, 119999),
    CHAMPAGNE("샴페인", 25000, 120000, Integer.MAX_VALUE);

    private final String name;
    private final Integer price;
    private final Integer minimumOrderPrice;
    private final Integer maximumOrderPrice;

    GiftMenu(String name, Integer price, Integer minimumOrderPrice, Integer maximumOrderPrice) {
        this.name = name;
        this.price = price;
        this.minimumOrderPrice = minimumOrderPrice;
        this.maximumOrderPrice = maximumOrderPrice;
    }

    public static String findByOrderPrice(int minimumOrderPrice) {
        if (minimumOrderPrice >= CHAMPAGNE.minimumOrderPrice && minimumOrderPrice <= CHAMPAGNE.maximumOrderPrice) {
            return String.format("%s %d개", CHAMPAGNE.name, 1);
        }

        return NONE.name;
    }

    public int price() {
        return price;
    }

}