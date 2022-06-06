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