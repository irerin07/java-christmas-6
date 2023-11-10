package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author 민경수
 * @description input view
 * @since 2023.11.10
 **********************************************************************************************************************/
public class InputVIew {

    private static final String DELIMITER = ",";
    private static final String MENU_REGEX = "^[가-힣]+-\\d+$";

    public int getVisitDate() {
        System.out.println("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)");
        return validateNumberInput(Console.readLine());
    }

    public Map<String, Integer> getOrderingMenus() {
        System.out.println("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)");

        return getMenus(Console.readLine());
    }

    private Map<String, Integer> getMenus(String input) {
        List<String> strings = Arrays.stream(input.split(DELIMITER)).toList();

        validateMenuInput(strings);

        return validateDuplicateMenu(strings);
    }

    private Map<String, Integer> validateDuplicateMenu(List<String> strings) {
        try {
            return strings.stream()
                    .map(element -> element.split("-"))
                    .collect(Collectors.toMap(parts -> parts[0], parts -> Integer.parseInt(parts[1])));
        } catch (IllegalStateException e) {
            throw new IllegalStateException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }

    private int validateNumberInput(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    private void validateMenuInput(List<String> menus) {
        menus.stream()
                .filter(menu -> !menu.matches(MENU_REGEX))
                .findAny()
                .ifPresent(invalidMenu -> {
                    throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
                });
    }

}