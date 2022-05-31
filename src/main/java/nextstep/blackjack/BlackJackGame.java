package nextstep.blackjack;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BlackJackGame {

    public static void run(Scanner scanner) {
        List<Player> playerList = new ArrayList<>();
        System.out.println("게임에 참여할 사람의 이름을 입력하세요.(쉼표 기준으로 분리)");
        String playerInputs = scanner.nextLine();

        PlayerNames playerNames = new PlayerNames(playerInputs);
        List<String> names = playerNames.getNames();
        for (String name : names) {
            System.out.printf("%s의 배팅 금액은?%n", name);
            int bettingMoney = scanner.nextInt();
            playerList.add(new Player(name, bettingMoney));
        }
        scanner.nextLine();
        CardMachine cardMachine = new CardMachine();

        Players players = new Players(playerList);
        Dealer dealer = new Dealer(cardMachine.getTwoCards());
        players.setPlayingCards(cardMachine);
        System.out.printf("달러와 %s에게 2장의 카드를 나누었습니다.%n", playerNames);

        dealer.showPlayingCards();
        players.showPlayingCards();
        System.out.println();
        players.addCards(scanner, cardMachine);
    }
}
