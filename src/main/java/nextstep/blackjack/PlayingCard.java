package nextstep.blackjack;

import java.util.List;
import java.util.Objects;

public class PlayingCard {

    private final Number number;
    private final Shape shape;

    public PlayingCard(Number number, Shape shape) {
        this.number = number;
        this.shape = shape;
    }

    public boolean isAceCard() {
        return Number.ACE.equals(number);
    }

    public int cardValue() {
        return number.getValue();
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
        return number == that.number && shape == that.shape;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, shape);
    }
}
