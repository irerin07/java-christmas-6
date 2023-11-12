package christmas.domain;

import java.util.Arrays;
import java.util.List;

public enum SpecialEventSale {

    STARRED_DATE(Arrays.asList(3, 10, 17, 24, 25, 31));

    private final List<Integer> dates;

    SpecialEventSale(List<Integer> dates) {
        this.dates = dates;
    }

    public static boolean isSpecialEventDate(int date) {
        return Arrays.stream(SpecialEventSale.values()).filter(e -> e.dates.contains(date)).findFirst().isPresent();
    }
}
