package nextstep.blackjack;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlayingCardTest {

    @Test
    @DisplayName("카드의 번호와 모양이 같다면 같은 카드이다.")
    void test1() {
        // heart, Diamond, clover, spade
        PlayingCard playingCard = new PlayingCard(Number.SIX, Shape.HEART);
        Assertions.assertThat(playingCard).isEqualTo(new PlayingCard(Number.SIX, Shape.HEART));
    }
}
