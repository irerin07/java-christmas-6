package christmas;

import christmas.domain.Order;
import christmas.domain.OrderedMenu;
import christmas.domain.menu.ChristMasMenu;
import christmas.domain.menu.Menu;
import christmas.view.InputVIew;
import christmas.view.ResultView;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author 민경수
 * @description event planner
 * @since 2023.11.11
 **********************************************************************************************************************/
public class EventPlanner {

    private final InputVIew inputVIew;
    private final ResultView resultView;

    public EventPlanner(InputVIew inputVIew, ResultView resultView) {
        this.inputVIew = inputVIew;
        this.resultView = resultView;
    }

    public Order takeOrders() {
        int visitDate = inputVIew.getVisitDate();
        List<OrderedMenu> orderedMenus = separateMenus(inputVIew.getOrderingMenus());

        return Order.of(LocalDateTime.now(), visitDate, orderedMenus);
    }

    private List<OrderedMenu> separateMenus(Map<String, Integer> menus) {
        List<OrderedMenu> result = new ArrayList<>();

        for (String menu : menus.keySet()) {
            Menu christmasMenu = ChristMasMenu.findMenu(menu);
            result.add(OrderedMenu.of(christmasMenu, menus.get(menu)));
        }

        return result;
    }

}