package christmas.domain;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author 민경수
 * @description order
 * @since 2023.11.10
 **********************************************************************************************************************/
public class Order {

    private final LocalDateTime receivedTime;
    private final Integer visitDate;
    private final List<OrderedMenu> orderedMenus;

    public Order(LocalDateTime receivedTime, Integer visitDate, List<OrderedMenu> orderedMenus) {
        this.receivedTime = receivedTime;
        this.visitDate = visitDate;
        this.orderedMenus = orderedMenus;
    }

    public static Order of(LocalDateTime receivedTime, Integer visitDate, List<OrderedMenu> orderedMenus) {
        return new Order(receivedTime, visitDate, orderedMenus);
    }

    public String toString() {
        StringBuffer sb = new StringBuffer();
        for (OrderedMenu orderedMenu : orderedMenus) {
            sb.append(orderedMenu.toString()).append("\n");
        }

        return sb.toString();
    }

    public int totalPrice() {
        int result = 0;
        for (OrderedMenu orderedMenu : orderedMenus) {
            result += orderedMenu.calculatePrice();
        }

        return result;
    }
}