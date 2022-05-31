package nextstep.blackjack;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CardNumberTest {

    @Test
    @DisplayName("CardNumber가 ACE일 시 1 또는 11값을 반환한다.")
    void test1() {
        CardNumber cardNumber = new CardNumber(Number.ACE);
        int aceNumber = cardNumber.getAceNumber(10);
        Assertions.assertThat(aceNumber).isEqualTo(11);
    }
}
