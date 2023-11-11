package christmas.view;

import christmas.domain.Order;
import christmas.domain.SaleProfit;

/**
 * @author 민경수
 * @description result view
 * @since 2023.11.10
 **********************************************************************************************************************/
public class OutputView {

    public void printEvent(Order order, SaleProfit saleProfit) {
        printOrderedMenus(order);
        printTotalOrderedPrice(order);
        printGiftMenu(order);
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

    private void printGiftMenu(Order order) {
        System.out.println("<증정 메뉴>");

        if (order.isGiftMenu()) {
            // TODO 이것 역시 SaleProfit에서 가져오도록 변경
            System.out.println("샴페인 1개");
        }

        System.out.println();
    }

    private void printBenefits(Order order, SaleProfit saleProfit) {
        // TODO 각각 메서드로 분리하기
        System.out.println("<혜택 내역>");

        if (order.isChristmasSalePeriod()) {
            long l = order.calculateChristmasEventBenefit();
            String christmasEventBenefit = saleProfit.getChristmasEventBenefit();
            System.out.println(christmasEventBenefit);
        }

        if (order.isWeekDay()) {
            int i = order.calculateWeekDayBenefit();
            String weekDayBenefit = saleProfit.getWeekDayBenefit();
            System.out.println(weekDayBenefit);
        }

        if (order.isWeekend()) {
            int i = order.calculateWeekEndBenefit();
            String weekendBenefit = saleProfit.getWeekEndBenefit();
            System.out.println(weekendBenefit);
        }

        if (order.isSpecialSaleDay()) {
            int i = order.calculateSpecialDayBenefit();
            String specialSaleDayBenefit = saleProfit.getSpecialSaleDayBenefit();
            System.out.println(specialSaleDayBenefit);
        }

        if (order.isGiftMenu()) {
            String giftMenuBenefit = saleProfit.getGiftMenuBenefit();
            System.out.println(giftMenuBenefit);
        }

    }

    private void printTotalBenefitAmount(Order order, SaleProfit saleProfit) {
        System.out.println("<총혜택 금액>");

        System.out.println("-" + saleProfit.totalProfit() + "원");
    }

    private void printEstimatedCheckoutPrice(Order order, SaleProfit saleProfit) {
        System.out.println("<할인 후 예상 결제 금액>");
        System.out.println(order.totalPrice().subtract(saleProfit.totalProfit()));
        System.out.println();
    }

    private void printEventBadge(SaleProfit saleProfit) {
        System.out.println("<12월 이벤트 배지>");
        // TODO 혜택뱔 이벤트 배지 반환하는 메서드 필요
    }

}