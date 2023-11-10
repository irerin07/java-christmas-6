package christmas.domain;

import java.util.Arrays;

public enum Dessert implements Menu {

    CHOCOLATE_CAKE("초코케이크", 15000),
    ICE_CREAM("아이스크림", 5000);

    private String name;
    private Integer price;

    Dessert(String name, int price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public Dessert findByName(String userInput) {
        return Arrays.stream(Dessert.values()).filter(desert -> desert.name.equals(userInput)).findFirst().orElse(null);
    }

}
