package nextstep.blackjack.player;

import nextstep.blackjack.status.Cards;

public class Player {

    private final Name name;
    private final String bettingMoney;
    private final Cards cards;

    public Player(Name name, String bettingMoney, Cards cards) {
        this.name = name;
        this.bettingMoney = bettingMoney;
        this.cards = cards;
    }

    @Override
    public String toString() {
        return name + "카드: " + cards;
    }
}
