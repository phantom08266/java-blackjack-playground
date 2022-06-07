package nextstep.blackjack.player;

import nextstep.blackjack.status.Cards;
import nextstep.blackjack.status.PlayingCard;

public class Dealer {

    private static final int BLACK_JACK_SCORE = 21;
    private Name name;
    private final Cards cards;
    private int money;

    public Dealer(Name name, Cards cards) {
        this.cards = cards;
        this.name = name;
        this.money = 0;
    }

    public String getName() {
        return name.getName();
    }

    public void showCards() {
        System.out.printf("%s: %s \n", name, cards);
    }

    public boolean isUnderScore() {
        return cards.isUnderScoreFromDealer();
    }

    public void addCard(PlayingCard playingCard) {
        cards.add(playingCard);
    }

    public void showCardsAndResult() {
        System.out.printf("%s카드: %s - 결과: %d \n", name, cards, cards.getScore());
    }

    public void updateMoney(int playerMoney, int playerScore) {
        if (isBlackJack() || isWinner(playerScore)) {
            money += playerMoney;
            return;
        }
        money -= playerMoney;
    }

    public boolean isBlackJack() {
        return cards.getScore() == BLACK_JACK_SCORE;
    }

    public boolean isBust() {
        return cards.isBust();
    }

    private boolean isWinner(int playerScore) {
        return playerScore < cards.getScore();
    }

    public int getScore() {
        return cards.getScore();
    }

    public void moneyClear() {
        money = 0;
    }

    public int getMoney() {
        return money;
    }
}
