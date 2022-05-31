package nextstep.blackjack;

public enum Shape {
    HEART("하트"),
    DIAMOND("다이아몬드"),
    CLOVER("클로버"),
    SPADE("스페이드")
    ;
    private final String value;

    Shape(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
