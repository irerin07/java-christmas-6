package christmas.manager;

import christmas.EventPlanner;
import christmas.printer.EventPlannerPrinter;
import christmas.view.InputVIew;
import christmas.view.ResultView;

/**
 * @author 민경수
 * @description event planner manager
 * @since 2023.11.10
 **********************************************************************************************************************/
public class EventPlannerManager {

    public void start() {
        InputVIew inputVIew = new InputVIew();
        ResultView resultView = new ResultView();

        EventPlanner eventPlanner = new EventPlanner(inputVIew, resultView);
        EventPlannerPrinter plannerPrinter = new EventPlannerPrinter(resultView);

        System.out.println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.");

        plannerPrinter.print(eventPlanner.takeOrders());

    }
}