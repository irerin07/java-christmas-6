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
    private final Long christmasDDayEventSaleAmount;
    private final Integer specialDay;
    private final EventBadge eventBadge;


    public SaleProfit(GiftMenu giftMenu, int weekDay, int weekEnd, long christmasDDayEvent, int specialDay,
                      EventBadge eventBadge) {
        this.giftMenu = giftMenu;
        this.weekdaySaleAmount = weekDay;
        this.weekendSaleAmount = weekEnd;
        this.christmasDDayEventSaleAmount = christmasDDayEvent;
        this.specialDay = specialDay;
        this.eventBadge = eventBadge;
    }

    public static SaleProfit of(GiftMenu giftMenu, int weekDay, int weekEnd, long christmasDDayEvent, int specialDay,
                                EventBadge eventBadge) {
        return new SaleProfit(giftMenu, weekDay, weekEnd, christmasDDayEvent, specialDay, eventBadge);
    }

    public BigDecimal totalProfit() {
        return BigDecimal.valueOf(weekdaySaleAmount + weekendSaleAmount + christmasDDayEventSaleAmount + specialDay);
    }

    public String getChristmasEventBenefit() {
        return "크리스마스 디데이 할인: -" + christmasDDayEventSaleAmount;
    }

    public String getWeekDayBenefit() {
        return "평일 할인: -" + weekdaySaleAmount;
    }

    public String getWeekEndBenefit() {
        return "주말 할인: -" + weekendSaleAmount;
    }

    public String getSpecialSaleDayBenefit() {
        return "특별 할인: -" + specialDay;
    }

    public String getGiftMenuBenefit() {
        return "증정 이벤트: -" + giftMenu.price();
    }

}