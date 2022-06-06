package nextstep.blackjack.status;

public abstract class Started implements State {

    protected final Cards cards;

    protected Started(Cards cards) {
        this.cards = cards;
    }

    @Override
    public Cards cards() {
        return null;
    }
}
