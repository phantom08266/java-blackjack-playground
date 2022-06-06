package nextstep.blackjack.status;

public class Stay extends Finished{

    public Stay(Cards cards) {
        super(cards);
    }

    @Override
    public double earningRate() {
        return 0;
    }
}
