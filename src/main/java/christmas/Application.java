package christmas;

import christmas.domain.Order;
import christmas.domain.SaleBenefitCalculator;
import christmas.domain.SaleProfit;
import christmas.printer.EventPlannerPrinter;
import christmas.view.InputVIew;
import christmas.view.ResultView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputVIew inputVIew = new InputVIew();
        ResultView resultView = new ResultView();

        EventPlanner eventPlanner = new EventPlanner(inputVIew, resultView);

        Order order = eventPlanner.takeOrders();

        SaleBenefitCalculator saleBenefitCalculator = new SaleBenefitCalculator();
        SaleProfit saleProfit = saleBenefitCalculator.getProfit(order);

        EventPlannerPrinter eventPlannerPrinter = new EventPlannerPrinter(resultView);
        eventPlannerPrinter.printHeader();
        eventPlannerPrinter.print(order, saleProfit);
    }
}
