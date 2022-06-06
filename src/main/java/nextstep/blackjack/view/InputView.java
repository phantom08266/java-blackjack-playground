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
}
