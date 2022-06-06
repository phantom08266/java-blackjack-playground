package nextstep.blackjack.status;

public interface State {

    State draw(PlayingCard playingCard);
    State stay();
    boolean isFinished();
    Cards cards();
    double profit(double profit);
}
