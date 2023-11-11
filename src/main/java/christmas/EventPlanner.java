package christmas;

import christmas.domain.InputValidationHelper;
import christmas.domain.Order;
import christmas.domain.OrderedMenu;
import christmas.view.InputVIew;
import christmas.view.OutputView;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author 민경수
 * @description event planner
 * @since 2023.11.11
 **********************************************************************************************************************/
public class EventPlanner {

    private final InputVIew inputVIew;
    private final OutputView outputView;

    public EventPlanner(InputVIew inputVIew, OutputView outputView) {
        this.inputVIew = inputVIew;
        this.outputView = outputView;
    }

    public Order takeOrders() {
        LocalDate visitDate = InputValidationHelper.get(() -> inputVIew.getVisitDate());

        List<OrderedMenu> orderedMenus = InputValidationHelper.get(() -> inputVIew.getOrderingMenus());

        return Order.of(LocalDateTime.now(), visitDate, orderedMenus);
    }

}