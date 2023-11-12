package christmas.domain;

import christmas.domain.menu.GiftMenu;

/**
 * @author 민경수
 * @description sale benefit calculator
 * @since 2023.11.11
 **********************************************************************************************************************/
public class SaleBenefitCalculator {

    public SaleProfit getBenefits(Order order) {
        int weekDay = weekDay(order);
        int weekEnd = weekEnd(order);
        int christmasDDayEvent = order.calculateChristmasEventBenefit();
        int specialDay = specialDay(order);

        return SaleProfit.of(GiftMenu.CHAMPAGNE, weekDay, weekEnd, christmasDDayEvent, specialDay, EventBadge.NONE);
    }

    private int weekDay(Order order) {
        if (order.isWeekDay()) {
            return order.calculateWeekDayBenefit();
        }

        return 0;
    }

    private int weekEnd(Order order) {
        if (order.isWeekend()) {
            return order.calculateWeekEndBenefit();
        }

        return 0;
    }

    private int specialDay(Order order) {
        if (order.isSpecialSaleDay()) {
            return order.calculateSpecialDayBenefit();
        }

        return 0;
    }

}