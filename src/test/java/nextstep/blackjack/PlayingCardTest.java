package nextstep.blackjack;

import static org.assertj.core.api.Assertions.assertThat;

import nextstep.blackjack.card.CardNumber;
import nextstep.blackjack.card.Suit;
import nextstep.blackjack.status.PlayingCard;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlayingCardTest {

    @Test
    @DisplayName("Ace 하트는 Ace 다이아몬드랑 다른 카드이다.")
    void test1() {
        PlayingCard aceHeart = new PlayingCard(CardNumber.ACE, Suit.HEARTS);
        PlayingCard aceDiamonds = new PlayingCard(CardNumber.ACE, Suit.DIAMONDS);

        assertThat(aceHeart).isNotEqualTo(aceDiamonds);
    }
}
