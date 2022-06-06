package nextstep.blackjack.card;

public enum CardNumber {
    ACE(1),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8),
    NINE(9),
    TEN(10),
    JACK(10),
    QUEEN(10),
    KING(10);

    private final int score;

    CardNumber(final int score) {
        this.score = score;
    }

    public boolean isAce() {
        return this == ACE;
    }

    public int getScore() {
        return score;
    }

    @Override
    public String toString() {
        if (CardNumber.ACE.equals(this) || CardNumber.JACK.equals(this) ||
            CardNumber.KING.equals(this) || CardNumber.QUEEN.equals(this)) {
            return this.name().substring(0, 1);
        }
        return score + "";
    }
}
