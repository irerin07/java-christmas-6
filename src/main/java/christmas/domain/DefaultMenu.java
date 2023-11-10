package christmas.domain;

public enum DefaultMenu implements Menu{
    NONE("없음", 0);

    private String name;
    private Integer price;

    DefaultMenu(String name, int price) {
        
    }

    @Override
    public Menu findByName(String userInput) {
        return null;
    }

}
