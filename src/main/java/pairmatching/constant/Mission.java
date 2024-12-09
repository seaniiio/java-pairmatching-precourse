package pairmatching.constant;

public enum Mission {
    RACING_CAR_GAME("자동차경주", Level.LEVEL1),
    LOTTO("로또", Level.LEVEL1),
    NUMBER_BASEBALL("숫자야구게임", Level.LEVEL1),

    SHOPPING_BASKET("장바구니", Level.LEVEL2),
    PAYMENT("결제", Level.LEVEL2),
    SUBWAY_ROUTE("지하철노선도", Level.LEVEL2),

    PERFORMANCE_IMPROVEMENT("성능개선", Level.LEVEL4),
    DISTRIBUTION("배포", Level.LEVEL4);

    private final String name;
    private final Level level;

    Mission(String name, Level level) {
        this.name = name;
        this.level = level;
    }

    public Level getLevel() {
        return this.level;
    }

    public String getName() {
        return this.name;
    }
}
