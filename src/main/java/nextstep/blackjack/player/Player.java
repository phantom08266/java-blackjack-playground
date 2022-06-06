package nextstep.blackjack.player;

import nextstep.blackjack.status.Cards;
import nextstep.blackjack.status.PlayingCard;

public class Player {

    private final Name name;
    private final String bettingMoney;
    private final Cards cards;

    public Player(Name name, String bettingMoney, Cards cards) {
        this.name = name;
        this.bettingMoney = bettingMoney;
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
}
