package christmas.domain;

public enum Appetizer{

    BUTTON_MUSHROOM_SOUP("양송이 스프", 6000),
    TAPAS("타파스", 5500),
    CAESAR_SALAD("시저샐러드", 8000);

    private String name;
    private Integer price;

    Appetizer(String name, int price) {
        this.name = name;
        this.price = price;
    }

}
