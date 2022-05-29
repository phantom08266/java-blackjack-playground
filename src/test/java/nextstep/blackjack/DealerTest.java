package nextstep.blackjack;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DealerTest {

    private PlayingCards cardNumbers;
    private List<PlayingCard> playingCards;

    @BeforeEach
    void setup() {
        playingCards = Arrays.asList(
            new PlayingCard(Number.TEN, Shape.CLOVER),
            new PlayingCard(Number.SIX, Shape.HEART));
        cardNumbers = new PlayingCards(playingCards);
    }

    @Test
    @DisplayName("딜러가 처음에 받은 2장의 합계가 16이하면 True")
    void test1() {
        Dealer dealer = new Dealer(cardNumbers);
        assertThat(dealer.isOneMoreTakeCard()).isTrue();
    }

    @Test
    @DisplayName("딜러가 처음에 받은 2장의 합계가 17이상이면 False")
    void test2() {
        playingCards = Arrays.asList(
            new PlayingCard(Number.TEN, Shape.CLOVER),
            new PlayingCard(Number.TWO, Shape.CLOVER),
            new PlayingCard(Number.SIX, Shape.HEART));
        cardNumbers = new PlayingCards(playingCards);

        Dealer dealer = new Dealer(cardNumbers);
        assertThat(dealer.isOneMoreTakeCard()).isFalse();
    }

    @Test
    @DisplayName("딜러가 21을 초과하면 True를 반환한다.")
    void test3() {
        playingCards = Arrays.asList(
            new PlayingCard(Number.TEN, Shape.CLOVER),
            new PlayingCard(Number.TEN, Shape.CLOVER),
            new PlayingCard(Number.SIX, Shape.HEART));
        cardNumbers = new PlayingCards(playingCards);

        Dealer dealer = new Dealer(cardNumbers);
        assertThat(dealer.isBust()).isTrue();
    }

}
