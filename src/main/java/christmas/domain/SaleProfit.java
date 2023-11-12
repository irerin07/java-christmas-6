package christmas.domain;

import christmas.domain.menu.GiftMenu;
import java.math.BigDecimal;

/**
 * @author 민경수
 * @description sale profit
 * @since 2023.11.11
 **********************************************************************************************************************/
public class SaleProfit {

    private final GiftMenu giftMenu;
    private final Integer weekdaySaleAmount;
    private final Integer weekendSaleAmount;
    private final Integer christmasDDayEventSaleAmount;
    private final Integer specialDay;
    private final EventBadge eventBadge;


    private SaleProfit(GiftMenu giftMenu, int weekDay, int weekEnd, int christmasDDayEvent, int specialDay,
                      EventBadge eventBadge) {
        this.giftMenu = giftMenu;
        this.weekdaySaleAmount = weekDay;
        this.weekendSaleAmount = weekEnd;
        this.christmasDDayEventSaleAmount = christmasDDayEvent;
        this.specialDay = specialDay;
        this.eventBadge = EventBadge.findByBenefirPrice(weekdaySaleAmount + weekendSaleAmount + christmasDDayEventSaleAmount + specialDay + giftMenu.price());
    }

    public static SaleProfit ofVisitDate(GiftMenu giftMenu, int weekDay, int weekEnd, int christmasDDayEvent, int specialDay,
                                         EventBadge eventBadge) {
        return new SaleProfit(giftMenu, weekDay, weekEnd, christmasDDayEvent, specialDay, eventBadge);
    }

    public BigDecimal totalProfit() {
        return BigDecimal.valueOf(weekdaySaleAmount + weekendSaleAmount + christmasDDayEventSaleAmount + specialDay + giftMenu.price());
    }

    public boolean christmasPeriodSaleApplied() {
        return christmasDDayEventSaleAmount != 0;
    }

    public String getChristmasEventBenefit() {
        return "크리스마스 디데이 할인: -" + christmasDDayEventSaleAmount;
    }

    public boolean weekdaySaleApplied() {
        return weekdaySaleAmount != 0;
    }

    public String getWeekDayBenefit() {
        return "평일 할인: -" + weekdaySaleAmount;
    }

    public boolean weekendSaleApplied() {
        return weekendSaleAmount !=0;
    }

    public String getWeekEndBenefit() {
        return "주말 할인: -" + weekendSaleAmount;
    }

    public boolean specialDaySaleApplied() {
        return specialDay != 0;
    }

    public String getSpecialSaleDayBenefit() {
        return "특별 할인: -" + specialDay;
    }

    public String getGiftMenu(Order order) {
        return GiftMenu.findByOrderPrice(order.totalPrice().intValue());
    }

    public String getGiftMenuBenefit() {
        return "증정 이벤트: -" + giftMenu.price();
    }

    public BigDecimal getGiftMenuIncludedPrice(BigDecimal totalPrice) {
        return totalPrice.add(BigDecimal.valueOf(giftMenu.price()));
    }

    public String getEventBadge() {
        return eventBadge.getName();
    }

}