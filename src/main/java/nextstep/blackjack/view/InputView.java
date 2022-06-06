package nextstep.blackjack.view;

import java.util.Scanner;

public class InputView {

    public static String getPlayerNames() {
        System.out.println("게임에 참여할 사람의 이름을 입력하세요.(쉼표 기준으로 분리)");
        return new Scanner(System.in).nextLine();
    }

    public static String getBettingMoney(String name) {
        System.out.printf("%s 배팅 금액은 \n", name);
        return new Scanner(System.in).nextLine();
    }

    public static void shardTwoCards(String dealer, String players) {
        System.out.printf("%s와 %s에게 2장의 카드를 나누었습니다. \n", dealer, players);
    }

    public static String printOneMoreCard(String name) {
        System.out.printf("%s는 한장의 카드를 더 받겠습니까?(예는 y, 아니오는 n)\n", name);
        return new Scanner(System.in).nextLine();
    }

    public static void printDealerOneMoreCard() {
        System.out.println("딜러는 16이하라 한장의 카드를 더 받았습니다.\n");
    }
}
