package nextstep.blackjack;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlayingCardsTest {

    @Test
    @DisplayName("카드합이 21인 경우 블랙잭이다")
    void test1() {
        List<PlayingCard> playingCards = Arrays.asList(new PlayingCard(Number.TEN, Shape.CLOVER),
            new PlayingCard(Number.A, Shape.HEART));

        PlayingCards cardNumbers = new PlayingCards(playingCards);

        assertThat(cardNumbers.isBlackJack()).isTrue();
    }

    @Test
    @DisplayName("Ace 카드만 4개 뽑았다면 총합은 14이다.")
    void test2() {
        List<PlayingCard> playingCards = Arrays.asList(
            new PlayingCard(Number.A, Shape.CLOVER),
            new PlayingCard(Number.A, Shape.DIAMOND),
            new PlayingCard(Number.A, Shape.SPADE),
            new PlayingCard(Number.A, Shape.HEART));

        PlayingCards cardNumbers = new PlayingCards(playingCards);

        assertThat(cardNumbers.sumCardNumber()).isEqualTo(14);
    }
}
