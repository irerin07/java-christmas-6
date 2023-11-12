package christmas;

import christmas.domain.Order;
import christmas.domain.SaleBenefitCalculator;
import christmas.domain.SaleProfit;
import christmas.printer.EventPlannerPrinter;
import christmas.view.InputVIew;
import christmas.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO 음료수만 있는 경우 예외처리
        // TODO 주문 내역에 샴페인이 있는 경우는 어떻게 처리해야 하나
        // TODO sysout 대신 stringbuffer 사용하도록 변경
        InputVIew inputVIew = new InputVIew();
        OutputView outputView = new OutputView();

        EventPlanner eventPlanner = new EventPlanner(inputVIew, outputView);

        Order order = eventPlanner.takeOrders();

        SaleBenefitCalculator saleBenefitCalculator = new SaleBenefitCalculator();
        SaleProfit saleProfit = saleBenefitCalculator.getBenefits(order);

        EventPlannerPrinter eventPlannerPrinter = new EventPlannerPrinter(outputView);
        eventPlannerPrinter.printHeader();
        eventPlannerPrinter.print(order, saleProfit);
    }
}
