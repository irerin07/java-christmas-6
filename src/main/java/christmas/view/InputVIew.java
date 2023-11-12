package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.domain.InputValidationHelper;
import christmas.domain.OrderedMenu;
import christmas.domain.menu.ChristMasMenu;
import christmas.domain.menu.Drink;
import christmas.domain.menu.Menu;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.ArrayList;
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
    private static final Integer EVENT_MONTH = 12;
    public static final Integer EVENT_YEAR = 2023;

    public LocalDate getVisitDate() {
        System.out.println(EVENT_MONTH + "월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)");

        return validateDate(validateNumberInput(Console.readLine()));
    }

    private LocalDate validateDate(int date) {
        try {
            return LocalDate.of(EVENT_YEAR, EVENT_MONTH, date);
        } catch (DateTimeException e) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        }
    }

    public List<OrderedMenu> getOrderingMenus() {
        System.out.println("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)");

        return separateMenus(getMenus(Console.readLine()));
    }

    private List<OrderedMenu> separateMenus(Map<String, Integer> menus) {
        List<OrderedMenu> result = new ArrayList<>();

        for (String menu : menus.keySet()) {
            Menu christmasMenu = ChristMasMenu.findMenu(menu);
            result.add(OrderedMenu.of(christmasMenu, menus.get(menu)));
        }

        int size = result.stream().filter(e -> !e.isOfType(Drink.class)).toList().size();
        if (size == 0) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }

        return result;
    }

    private Map<String, Integer> getMenus(String input) {
        List<String> strings = Arrays.stream(input.split(DELIMITER)).toList();

        validateMenuInput(strings);
        validateDuplicateMenu(strings);

        Map<String, Integer> stringIntegerMap = validateDuplicateMenu(strings);
        validateOrderAmount(stringIntegerMap);

        return stringIntegerMap;
    }

    private void validateOrderAmount(Map<String, Integer> stringIntegerMap) {
        if (stringIntegerMap.values().stream().reduce(0, Integer::sum) > 20) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }

    private Map<String, Integer> validateDuplicateMenu(List<String> strings) {
        try {
            return strings.stream()
                    .map(element -> element.split("-"))
                    .collect(Collectors.toMap(parts -> parts[0], parts -> Integer.parseInt(parts[1])));
        } catch (IllegalStateException e) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }

    private int validateNumberInput(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
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