package christmas.domain;

import christmas.domain.menu.GiftMenu;

/**
 * @author 민경수
 * @description sale benefit calculator
 * @since 2023.11.11
 **********************************************************************************************************************/
public class SaleBenefitCalculator {

    public SaleProfit getBenefits(Order order) {
        return SaleProfit.ofVisitDate(
                giftMenu(order),
                weekDay(order),
                weekEnd(order),
                order.calculateChristmasEventBenefit(),
                specialDay(order),
                EventBadge.NONE
        );
    }

    private GiftMenu giftMenu(Order order) {
        if (order.isGiftMenu()) {
            return GiftMenu.CHAMPAGNE;
        }

        return GiftMenu.NONE;
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