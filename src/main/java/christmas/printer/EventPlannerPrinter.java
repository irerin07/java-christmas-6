package christmas.printer;

import christmas.domain.Order;
import christmas.domain.SaleProfit;
import christmas.view.ResultView;

/**
 * @author 민경수
 * @description event plannerprinter
 * @since 2023.11.10
 **********************************************************************************************************************/
public class EventPlannerPrinter {

    private final ResultView resultView;

    private static final Integer EVENT_MONTH = 12;

    public EventPlannerPrinter(ResultView resultView) {
        this.resultView = resultView;
    }

    public void printHeader() {
        System.out.println("안녕하세요! 우테코 식당 " + EVENT_MONTH + "월 이벤트 플래너입니다.");
    }

    public void print(Order order, SaleProfit saleProfit) {
        System.out.println(order.getVisitDate() + "에 우테코 식당에서 받을 이벤트 혜택 미리 보기!");
        System.out.println();

        resultView.printEvent(order, saleProfit);
    }

}