package nextstep.blackjack;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import nextstep.blackjack.card.CardNumber;
import nextstep.blackjack.card.Suit;
import nextstep.blackjack.status.Cards;
import nextstep.blackjack.status.PlayingCard;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CardsTest {

    @Test
    @DisplayName("Bust일때 True을 반환한다")
    void test1() {
        PlayingCard queenHeart = new PlayingCard(CardNumber.QUEEN, Suit.HEARTS);
        PlayingCard kingHeart = new PlayingCard(CardNumber.KING, Suit.HEARTS);
        PlayingCard twoDiamonds = new PlayingCard(CardNumber.TWO, Suit.DIAMONDS);

        Cards cards = new Cards(Arrays.asList(queenHeart, kingHeart, twoDiamonds));
        assertThat(cards.isBust()).isTrue();
    }

    @Test
    @DisplayName("Bust가 아니면 false를 반환한다")
    void test2() {
        PlayingCard queenHeart = new PlayingCard(CardNumber.QUEEN, Suit.HEARTS);
        PlayingCard nineHeart = new PlayingCard(CardNumber.NINE, Suit.HEARTS);
        PlayingCard twoDiamonds = new PlayingCard(CardNumber.TWO, Suit.DIAMONDS);

        Cards cards = new Cards(Arrays.asList(queenHeart, nineHeart, twoDiamonds));
        assertThat(cards.isBust()).isFalse();
    }

    @Test
    @DisplayName("Ace가 포함되어 있을 시 21을 넘지않기 위해 1로 계산된다")
    void test3() {
        PlayingCard queenHeart = new PlayingCard(CardNumber.QUEEN, Suit.HEARTS);
        PlayingCard kingHeart = new PlayingCard(CardNumber.KING, Suit.HEARTS);
        PlayingCard aceDiamonds = new PlayingCard(CardNumber.ACE, Suit.DIAMONDS);

        Cards cards = new Cards(Arrays.asList(queenHeart, kingHeart, aceDiamonds));
        assertThat(cards.getScore()).isEqualTo(21);
    }

    @Test
    @DisplayName("Ace가 포함되어 있을 시 21을 넘지않기 위해 11로 계산된다")
    void test4() {
        PlayingCard eightHeart = new PlayingCard(CardNumber.EIGHT, Suit.HEARTS);
        PlayingCard twoHeart = new PlayingCard(CardNumber.TWO, Suit.HEARTS);
        PlayingCard aceDiamonds = new PlayingCard(CardNumber.ACE, Suit.DIAMONDS);

        Cards cards = new Cards(Arrays.asList(eightHeart, twoHeart, aceDiamonds));
        assertThat(cards.getScore()).isEqualTo(21);
    }
}
