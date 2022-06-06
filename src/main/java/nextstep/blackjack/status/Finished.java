package nextstep.blackjack.status;

public abstract class Finished extends Started{

    protected Finished(Cards cards) {
        super(cards);
    }

    public abstract double earningRate();

    @Override
    public State draw(PlayingCard playingCard) {
        return null;
    }

    @Override
    public State stay() {
        return null;
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public double profit(double profit) {
        return 0;
    }
}
