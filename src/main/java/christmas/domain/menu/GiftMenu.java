package christmas.domain.menu;

public enum GiftMenu {

    CHAMPAGNE("샴페인", 25000);

    private String name;
    private Integer price;

    GiftMenu(String name, Integer price) {
        this.name = name;
        this.price = price;
    }

    public int price() {
        return price;
    }

}