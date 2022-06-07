package nextstep.blackjack;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import nextstep.blackjack.card.CardFactory;
import nextstep.blackjack.player.Dealer;
import nextstep.blackjack.player.Name;
import nextstep.blackjack.player.Names;
import nextstep.blackjack.player.Player;
import nextstep.blackjack.player.Players;
import nextstep.blackjack.status.Cards;
import nextstep.blackjack.status.PlayingCard;
import nextstep.blackjack.view.InputView;

public class BlackJackGame {

    public void start() {
        String playerNames = InputView.getPlayerNames();
        Names names = Names.createNames(playerNames);

        Players players = getPlayers(names);
        Dealer dealer = new Dealer(new Name("딜러"), createCards());

        InputView.shardTwoCards(dealer.getName(), names.toString());
        dealer.showCards();
        players.showCards();

        playerAddCards(players);
        dealerAddCards(dealer);

        dealer.showCardsAndResult();
        players.showCardsAndResult();

        updatePlayersAndDealerMoney(players, dealer);
        InputView.result();
        System.out.printf("%s: %d \n", dealer.getName(), dealer.getMoney());
        players.getPlayers()
            .forEach(player -> System.out.printf("%s: %d \n", player.getName(), player.getBettingMoney()));
    }

    private void updatePlayersAndDealerMoney(Players players, Dealer dealer) {
        if (dealer.isBust()) {
            players.moneyClear();
            return;
        }

        players.updateMoney(dealer);
    }

    private void dealerAddCards(Dealer dealer) {
       if (dealer.isUnderScore()) {
           dealer.addCard(CardFactory.draw());
           InputView.printDealerOneMoreCard();
       }
    }

    private void playerAddCards(Players players) {
        players.getPlayers()
            .forEach(this::oneMoreCard);
    }

    private void oneMoreCard(Player player) {
        String useYn = InputView.printOneMoreCard(player.getName().getName());
        if (useYn.equals("y")) {
            player.addCard(CardFactory.draw());
            System.out.println(player);
            oneMoreCard(player);
        }
    }

    private Players getPlayers(Names names) {
        return new Players(names.getNames()
            .stream()
            .map(name -> new Player(name, InputView.getBettingMoney(name.getName()), createCards()))
            .collect(Collectors.toList()));
    }

    private Cards createCards() {
        List<PlayingCard> playingCards = new ArrayList<>();
        playingCards.add(CardFactory.draw());
        playingCards.add(CardFactory.draw());
        return new Cards(playingCards);
    }

}


class Main {

    public static void main(String[] args) {
        BlackJackGame blackJackGame = new BlackJackGame();
        blackJackGame.start();
    }
}