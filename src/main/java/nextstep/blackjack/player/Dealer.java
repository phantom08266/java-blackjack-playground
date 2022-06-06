package nextstep.blackjack.player;

import nextstep.blackjack.status.Cards;

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
}
