package nextstep.blackjack.player;

import java.util.List;

public class Players {

    private List<Player> players;

    public Players(List<Player> players) {
        this.players = players;
    }

    public void showCards() {
        players.forEach(System.out::println);
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void showCardsAndResult() {
        players.forEach(Player::showCardsAndScore);
    }

    public void updateMoney(Dealer dealer) {
        players.forEach(
            player -> {
                if (dealerAndPlayerBlackJack(player, dealer)) {
                    player.moneyClear();
                    return;
                }
                int bettingMoney = player.getBettingMoney();
                int score = player.getScore();
                dealer.updateMoney(bettingMoney, score);
                player.getUpdateMoney(dealer.getScore());
            }
        );
    }

    private boolean dealerAndPlayerBlackJack(Player player, Dealer dealer) {
        return player.isBlackJack() && dealer.isBlackJack();
    }

    public boolean isAllBlackJack() {
        return players.stream()
            .allMatch(Player::isBlackJack);
    }

    public void moneyClear() {
        players.forEach(Player::moneyClear);
    }
}
