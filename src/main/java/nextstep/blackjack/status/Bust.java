package nextstep.blackjack.status;

public class Bust extends Finished{

    public Bust(Cards cards) {
        super(cards);
    }

    @Override
    public double earningRate() {
        return 0;
    }
}
