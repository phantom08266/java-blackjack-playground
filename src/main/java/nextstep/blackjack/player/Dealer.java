package nextstep.blackjack.player;

import nextstep.blackjack.status.Cards;
import nextstep.blackjack.status.PlayingCard;

public class Dealer {

    private Name name;

    private final Cards cards;

    public Dealer(Name name, Cards cards) {
        this.cards = cards;
        this.name = name;
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
}
