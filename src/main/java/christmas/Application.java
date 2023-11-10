package christmas;

import christmas.manager.EventPlannerManager;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        EventPlannerManager eventPlannerManager = new EventPlannerManager();

        eventPlannerManager.start();
    }
}
