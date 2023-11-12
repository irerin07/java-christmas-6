package christmas.view;

import christmas.domain.Order;
import christmas.domain.SaleProfit;
import java.math.BigDecimal;

/**
 * @author 민경수
 * @description result view
 * @since 2023.11.10
 **********************************************************************************************************************/
public class OutputView {

    public void printEvent(Order order, SaleProfit saleProfit) {
        printOrderedMenus(order);
        printTotalOrderedPrice(order);
        printGiftMenu(order, saleProfit);
        printBenefits(order, saleProfit);
        printTotalBenefitAmount(order, saleProfit);
        printEstimatedCheckoutPrice(order, saleProfit);
        printEventBadge(saleProfit);
    }

    private void printOrderedMenus(Order order) {
        System.out.println("<주문 메뉴>");
        System.out.println(order.toString());
    }

    private void printTotalOrderedPrice(Order order) {
        System.out.println("<할인 전 총주문 금액>");
        System.out.println(order.totalPrice());
        System.out.println();
    }

    private void printGiftMenu(Order order, SaleProfit saleProfit) {
        System.out.println("<증정 메뉴>");

        System.out.println(saleProfit.getGiftMenu(order));

        System.out.println();
    }

    private void printBenefits(Order order, SaleProfit saleProfit) {
        // TODO 각각 메서드로 분리하기
        // TODO 혜택 받은 내역이 없으면 "없음" 출력
        System.out.println("<혜택 내역>");

        if(order.isBenefitReceivable()) {
            if (order.isChristmasSalePeriod() && saleProfit.christmasPeriodSaleApplied()) {
                String christmasEventBenefit = saleProfit.getChristmasEventBenefit();
                System.out.println(christmasEventBenefit);
            }

            if (order.isWeekDay() && saleProfit.weekdaySaleApplied()) {
                String weekDayBenefit = saleProfit.getWeekDayBenefit();
                System.out.println(weekDayBenefit);
            }

            if (order.isWeekend() && saleProfit.weekendSaleApplied()) {
                String weekendBenefit = saleProfit.getWeekEndBenefit();
                System.out.println(weekendBenefit);
            }

            if (order.isSpecialSaleDay() && saleProfit.specialDaySaleApplied()) {
                String specialSaleDayBenefit = saleProfit.getSpecialSaleDayBenefit();
                System.out.println(specialSaleDayBenefit);
            }

            if (order.isGiftMenu()) {
                String giftMenuBenefit = saleProfit.getGiftMenuBenefit();
                System.out.println(giftMenuBenefit);
            }
        }

    }

    private void printTotalBenefitAmount(Order order, SaleProfit saleProfit) {
        System.out.println("<총혜택 금액>");

        System.out.println("-" + saleProfit.totalProfit() + "원");
    }

    private void printEstimatedCheckoutPrice(Order order, SaleProfit saleProfit) {
        System.out.println("<할인 후 예상 결제 금액>");
        BigDecimal totalPrice = order.totalPrice();

        if (order.isGiftMenu()) {
            totalPrice = saleProfit.getGiftMenuIncludedPrice(order.totalPrice());
        }

        System.out.println(totalPrice.subtract(saleProfit.totalProfit()));
        System.out.println();
    }

    private void printEventBadge(SaleProfit saleProfit) {
        System.out.println("<12월 이벤트 배지>");
        String eventBadge = saleProfit.getEventBadge();
        System.out.println(eventBadge);
        // TODO 혜택뱔 이벤트 배지 반환하는 메서드 필요
    }

}