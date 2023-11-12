package christmas.domain;

import java.util.Arrays;

public enum EventBadge {
    NONE("없음", 0, 4999),
    STAR("별", 5000, 9999),
    TREE("트리", 10000, 19999),
    SANTA("산타", 20000, Integer.MAX_VALUE);

    private final String name;
    private final Integer minimumAmount;
    private final Integer maximumAmount;

    EventBadge(String name, Integer minimumAmount, Integer maximumAmount) {
        this.name = name;
        this.minimumAmount = minimumAmount;
        this.maximumAmount = maximumAmount;
    }

    public static EventBadge findByBenefirPrice(int benefirPrice) {
        return Arrays.stream(EventBadge.values())
                .filter(eventBadge -> eventBadge.minimumAmount <= benefirPrice
                        && eventBadge.maximumAmount >= benefirPrice)
                .findFirst()
                .orElse(NONE);
    }

    public String getName() {
        return name;
    }

}
