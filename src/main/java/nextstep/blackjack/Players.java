package nextstep.blackjack;

import java.util.List;
import java.util.Scanner;

public class Players {

    private final List<Player> players;

    public Players(List<Player> players) {
        this.players = players;
    }

    public void setPlayingCards(CardMachine cardMachine) {
        players.forEach(player -> player.setPlayingCards(cardMachine.getTwoCards()));
    }

    public void showPlayingCards() {
        players.forEach(Player::showPlayingCards);
    }

    public void addCards(Scanner scanner, CardMachine cardMachine) {
        players.forEach(player -> playerAddCard(player,scanner,cardMachine));
    }

    private void playerAddCard(Player player, Scanner scanner, CardMachine cardMachine) {
        boolean enable = true;
        while (enable) {
            System.out.printf("%s는 한장의 카드를 더 받겠습니까?(예는 y, 아니오는 n) %n", player.getName());
            String useYn = scanner.nextLine();
            if (useYn.equals("y")) {
                player.addCard(cardMachine.getOneCard());
                continue;
            }
            enable = false;
        }
        player.showPlayingCards();
    }
}
