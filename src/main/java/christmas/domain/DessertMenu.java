package christmas.domain;

public enum DessertMenu{

    CHOCOLATE_CAKE("초코케이크", 15000),
    ICE_CREAM("아이스크림", 5000);

    private String name;
    private Integer price;

    DessertMenu(String name, int price) {
        this.name = name;
        this.price = price;
    }

}
