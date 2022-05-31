package nextstep.blackjack;

public class Dealer {

    private final String name = "딜러";
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

    public void showPlayingCards() {
        System.out.printf("%s카드: %s%n", name, cardNumbers);
    }
}
