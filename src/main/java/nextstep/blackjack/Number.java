package nextstep.blackjack;

public enum Number {
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8),
    NINE(9),
    TEN(10),
    J(10),
    Q(10),
    K(10),
    A(11);

    private final int value;

    Number(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    @Override
    public String toString() {
        if (Number.A.equals(this) || Number.J.equals(this) || Number.K.equals(this) || Number.Q.equals(this)) {
            return this.name();
        }
        return value + "";
    }
}
