package christmas.view;

import christmas.domain.Order;
import christmas.domain.SaleProfit;

/**
 * @author 민경수
 * @description result view
 * @since 2023.11.10
 **********************************************************************************************************************/
public class ResultView {

    public void printEvent(Order order, SaleProfit saleProfit) {
        printOrderedMenus(order);
        printTotalOrderedPrice(order);
        printGiftMenu(saleProfit);
        printBenefits(order, saleProfit);
        printTotalBenefitAmount(saleProfit);
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

    private void printGiftMenu(SaleProfit saleProfit) {
        System.out.println("<증정 메뉴>");
    }

    private void printBenefits(Order order, SaleProfit saleProfit) {
        System.out.println("<혜택 내역>");

//        boolean weekDay = order.isWeekDay();
//        System.out.println("weekDay = " + weekDay);
//        boolean specialSaleDay = order.isSpecialSaleDay();
//        System.out.println("specialSaleDay = " + specialSaleDay);
//        boolean giftMenu = order.isGiftMenu();
//        System.out.println("giftMenu = " + giftMenu);
//        boolean christmasSalePeriod = order.isChristmasSalePeriod();
//        System.out.println("christmasSalePeriod = " + christmasSalePeriod);
    }

    private void printTotalBenefitAmount(SaleProfit saleProfit) {
        System.out.println("<총혜택 금액>");
    }

    private void printEstimatedCheckoutPrice(Order order, SaleProfit saleProfit) {
        System.out.println("<할인 후 예상 결제 금액>");
    }

    private void printEventBadge(SaleProfit saleProfit) {
        System.out.println("<12월 이벤트 배지>");
    }

}