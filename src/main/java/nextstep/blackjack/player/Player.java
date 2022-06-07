package nextstep.blackjack.player;

import nextstep.blackjack.status.Cards;
import nextstep.blackjack.status.PlayingCard;

public class Player {

    public static final int BLACK_JACK_SCORE = 21;
    public static final double BLACK_JACK_RATE = 1.5;

    private final Name name;
    private int bettingMoney;
    private final Cards cards;

    public Player(Name name, String bettingMoney, Cards cards) {
        this.name = name;
        this.bettingMoney = Integer.parseInt(bettingMoney);
        this.cards = cards;
    }

    public void addCard(PlayingCard playingCard) {
        cards.add(playingCard);
    }

    public Name getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + "카드: " + cards;
    }

    public void showCardsAndScore() {
        System.out.printf("%s카드: %s - 결과: %d \n", name, cards, cards.getScore());
    }

    public int getBettingMoney() {
        return bettingMoney;
    }

    public void getUpdateMoney(int dealerScore) {
       if (blackJackCalculateMoney()) return;
        if (isWinner(dealerScore) || isSameScore(dealerScore)) return;

        bettingMoney *= -1;
    }

    private boolean blackJackCalculateMoney() {
        if (!isBlackJack()) return false;
        if (cards.twoCardBlackJack()) {
            bettingMoney += (bettingMoney * BLACK_JACK_RATE);
        }
        return true;
    }

    private boolean isSameScore(int dealerScore) {
        return dealerScore == cards.getScore();
    }

    public boolean isBlackJack() {
        return cards.getScore() == BLACK_JACK_SCORE;
    }

    private boolean isWinner(int dealerScore) {
        return dealerScore < cards.getScore();
    }

    public void moneyClear() {
        bettingMoney = 0;
    }

    public int getScore() {
        return cards.getScore();
    }
}
