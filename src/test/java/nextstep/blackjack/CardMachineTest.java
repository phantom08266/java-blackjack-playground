package nextstep.blackjack;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CardMachineTest {

    @Test
    @DisplayName("랜덤으로 카드를 반환한다")
    void test1() {
        CardMachine cardMachine = new CardMachine();
        Assertions.assertThat(cardMachine.getOneCard()).isNotNull();
    }
}
