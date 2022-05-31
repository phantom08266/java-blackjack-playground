package nextstep.blackjack;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PlayerTest {

    @Test
    @DisplayName("Player이름을 받으면 Player를 생성한다.")
    void test1() {
        String name = "june";
        int bettingMoney = 1000;
        Player june = new Player(name, bettingMoney);
        assertThat(june.getName()).isEqualTo(name);
    }
}
