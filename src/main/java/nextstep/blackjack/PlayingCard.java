package nextstep.blackjack;

import java.util.Objects;

public class PlayingCard {

    private final Number number;
    private final Shape shape;

    public PlayingCard(Number number, Shape shape) {
        this.number = number;
        this.shape = shape;
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
