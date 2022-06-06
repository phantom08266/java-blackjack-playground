package nextstep.blackjack.status;

import java.util.Objects;
import nextstep.blackjack.card.CardNumber;
import nextstep.blackjack.card.Suit;

public class PlayingCard {

    private final CardNumber cardNumber;
    private final Suit suit;

    public PlayingCard(CardNumber cardNumber, Suit suit) {
        this.cardNumber = cardNumber;
        this.suit = suit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PlayingCard that = (PlayingCard) o;
        return cardNumber == that.cardNumber && suit == that.suit;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cardNumber, suit);
    }
}
