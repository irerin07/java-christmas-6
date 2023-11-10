package christmas.printer;

import christmas.domain.Order;
import christmas.view.ResultView;

/**
 * @author 민경수
 * @description event plannerprinter
 * @since 2023.11.10
 **********************************************************************************************************************/
public class EventPlannerPrinter {

    private final ResultView resultView;

    public EventPlannerPrinter(ResultView resultView) {
        this.resultView = resultView;
    }

    public void print(Order order) {
        System.out.println("12월 26일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!");
        System.out.println();
        resultView.printOrderedMenus(order);
        resultView.printTotalOrderedPrice(order);
        resultView.printGiftMenu();
        resultView.printBenefits();
        resultView.printTotalBenefitAmount();
        resultView.printEstimatedCheckoutPrice();
        resultView.printEventBadge();
    }

}