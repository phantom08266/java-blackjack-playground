package nextstep.blackjack.status;

public abstract class Running extends Started{

    protected Running(Cards cards) {
        super(cards);
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
