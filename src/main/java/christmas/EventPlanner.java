package christmas;

import christmas.domain.InputValidationHelper;
import christmas.domain.Order;
import christmas.domain.OrderedMenu;
import christmas.domain.menu.ChristMasMenu;
import christmas.domain.menu.Menu;
import christmas.view.InputVIew;
import christmas.view.ResultView;
import java.time.LocalDate;
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
        LocalDate visitDate = InputValidationHelper.get(() -> inputVIew.getVisitDate());

        List<OrderedMenu> orderedMenus = InputValidationHelper.get(() -> inputVIew.getOrderingMenus());

        return Order.of(LocalDateTime.now(), visitDate, orderedMenus);
    }

}