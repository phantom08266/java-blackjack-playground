package nextstep.blackjack.player;

import java.util.List;
import nextstep.blackjack.player.Player;

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
}
