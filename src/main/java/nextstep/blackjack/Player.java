package nextstep.blackjack;

public class Player {
    private final String name;
    private final int bettingMoney;

    private PlayingCards playingCards;

    public Player(String name, int money) {
        this.name = name;
        this.bettingMoney = money;
    }

    public String getName() {
        return name;
    }

    public void setPlayingCards(PlayingCards twoCards) {
        playingCards = twoCards;
    }

    public void showPlayingCards() {
        System.out.printf("%s카드: %s%n", name, playingCards);
    }

    public void addCard(PlayingCard oneCard) {
        playingCards.addCard(oneCard);
    }
}
