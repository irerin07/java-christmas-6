package christmas.domain;

import christmas.domain.menu.Dessert;
import christmas.domain.menu.MainMenu;
import java.math.BigDecimal;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

/**
 * @author 민경수
 * @description order
 * @since 2023.11.10
 **********************************************************************************************************************/
public class Order {

    private final LocalDateTime receivedTime;
    private final LocalDate visitDate;
    private final List<OrderedMenu> orderedMenus;

    public Order(LocalDateTime receivedTime, LocalDate visitDate, List<OrderedMenu> orderedMenus) {
        this.receivedTime = receivedTime;

        validateVisitDate(visitDate);
        this.visitDate = visitDate;
        this.orderedMenus = orderedMenus;
    }

    public static Order of(LocalDateTime receivedTime, LocalDate visitDate, List<OrderedMenu> orderedMenus) {
        return new Order(receivedTime, visitDate, orderedMenus);
    }

    public String toString() {
        StringBuffer sb = new StringBuffer();
        for (OrderedMenu orderedMenu : orderedMenus) {
            sb.append(orderedMenu.toString()).append("\n");
        }

        return sb.toString();
    }

    public BigDecimal totalPrice() {
        BigDecimal result = BigDecimal.ZERO;
        for (OrderedMenu orderedMenu : orderedMenus) {
            result = result.add(BigDecimal.valueOf(orderedMenu.calculatePrice()));
        }

        return result;
    }

    public String getVisitDate() {
        return visitDate.getMonthValue() + "월" + visitDate.getDayOfMonth() + "일";
    }

    public boolean isWeekDay() {
        return !(visitDate.getDayOfWeek() == DayOfWeek.FRIDAY || visitDate.getDayOfWeek() == DayOfWeek.SATURDAY);
    }

    public boolean isSpecialSaleDay() {
        // TODO 달력에 별표가 있는지 체크하는 기능
        return false;
    }

    public boolean isGiftMenu() {
        return totalPrice().compareTo(BigDecimal.valueOf(120000)) != -1;
    }

    public boolean isChristmasSalePeriod() {
        return !visitDate.isBefore(LocalDate.of(2023, 12, 1)) && !visitDate.isAfter(LocalDate.of(2023, 12, 25));
    }

    private void validateVisitDate(LocalDate visitDate) {
        if (LocalDate.now().isAfter(visitDate)) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        }
    }

    public long calculateChristmasEventBenefit() {
        long between = ChronoUnit.DAYS.between(LocalDate.of(2023, 12, 1), visitDate);

        return 1000 + (between * 100);
    }

    public boolean isWeekend() {
        return (visitDate.getDayOfWeek() == DayOfWeek.FRIDAY || visitDate.getDayOfWeek() == DayOfWeek.SATURDAY);
    }

    public int calculateWeekDayBenefit() {
        int weekDayBenefit = 0;
        for (OrderedMenu orderedMenu : orderedMenus) {
            if (orderedMenu.isOfType(Dessert.class)) {
                weekDayBenefit += orderedMenu.calculateBenefit();
            }
        }
        return weekDayBenefit;
    }

    public int calculateWeekEndBenefit() {
        int weekDayBenefit = 0;
        for (OrderedMenu orderedMenu : orderedMenus) {
            if (orderedMenu.isOfType(MainMenu.class)) {
                weekDayBenefit += orderedMenu.calculateBenefit();
            }
        }
        return weekDayBenefit;
    }

    public int calculateSpecialDayBenefit() {
        return 1000;
    }
}