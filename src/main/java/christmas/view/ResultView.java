package christmas.view;

/**
 * @author 민경수
 * @description result view
 * @since 2023.11.10
 **********************************************************************************************************************/
public class ResultView {

    public void printOrderedMenus() {
        System.out.println("<주문 메뉴>");
    }

    public void printTotalOrderedPrice() {
        System.out.println("<할인 전 총주문 금액>");
    }

    public void printGiftMenu() {
        System.out.println("<증정 메뉴>");
    }

    public void printBenefits() {
        System.out.println("<혜택 내역>");
    }

    public void printTotalBenefitAmount() {
        System.out.println("<총혜택 금액>");
    }

    public void printEstimatedCheckoutPrice() {
        System.out.println("<할인 후 예상 결제 금액>");
    }

    public void printEventBadge() {
        System.out.println("<12월 이벤트 배지>");
    }

}