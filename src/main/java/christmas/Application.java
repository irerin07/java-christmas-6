package christmas;

import christmas.domain.Order;
import christmas.domain.SaleBenefitCalculator;
import christmas.domain.SaleProfit;
import christmas.printer.EventPlannerPrinter;
import christmas.view.InputVIew;
import christmas.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputVIew inputVIew = new InputVIew();
        OutputView outputView = new OutputView();

        EventPlanner eventPlanner = new EventPlanner(inputVIew, outputView);

        Order order = eventPlanner.takeOrders();

        SaleBenefitCalculator saleBenefitCalculator = new SaleBenefitCalculator();
        SaleProfit saleProfit = saleBenefitCalculator.test(order);

        EventPlannerPrinter eventPlannerPrinter = new EventPlannerPrinter(outputView);
        eventPlannerPrinter.printHeader();
        eventPlannerPrinter.print(order, saleProfit);
    }
}
