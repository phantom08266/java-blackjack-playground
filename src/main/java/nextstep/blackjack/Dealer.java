package nextstep.blackjack;

import java.util.List;

public class Dealer {

    private final int BLACK_JACK_NUMBER = 21;
    public final int STANDARD_NUMBER = 16;
    private final PlayingCards cardNumbers;

    public Dealer(PlayingCards cardNumbers) {
        this.cardNumbers = cardNumbers;
    }

    public boolean isOneMoreTakeCard() {
        return cardNumbers.sumCardNumber() <= STANDARD_NUMBER;
    }

    public boolean isBust() {
        return cardNumbers.sumCardNumber() >= BLACK_JACK_NUMBER;
    }
}
