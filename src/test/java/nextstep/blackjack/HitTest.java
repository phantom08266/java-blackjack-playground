package nextstep.blackjack;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import nextstep.blackjack.card.CardNumber;
import nextstep.blackjack.card.Suit;
import nextstep.blackjack.status.Bust;
import nextstep.blackjack.status.Cards;
import nextstep.blackjack.status.Hit;
import nextstep.blackjack.status.PlayingCard;
import nextstep.blackjack.status.State;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class HitTest {

    @Test
    @DisplayName("1장의 카드를 뽑았을 경우 Bust 상태")
    void test1() {
        PlayingCard queenHeart = new PlayingCard(CardNumber.QUEEN, Suit.HEARTS);
        PlayingCard kingHeart = new PlayingCard(CardNumber.KING, Suit.HEARTS);

        List<PlayingCard> playingCards = new ArrayList<>();
        playingCards.add(queenHeart);
        playingCards.add(kingHeart);

        Hit hit = new Hit(new Cards(playingCards));
        State state = hit.draw(new PlayingCard(CardNumber.TWO, Suit.HEARTS));

        assertThat(state).isInstanceOf(Bust.class);
    }

    @Test
    @DisplayName("1장의 카드를 뽑았을 경우 Hit인 상태")
    void test2() {
        PlayingCard queenHeart = new PlayingCard(CardNumber.QUEEN, Suit.HEARTS);
        PlayingCard fiveHeart = new PlayingCard(CardNumber.FIVE, Suit.HEARTS);

        List<PlayingCard> playingCards = new ArrayList<>();
        playingCards.add(queenHeart);
        playingCards.add(fiveHeart);

        Hit hit = new Hit(new Cards(playingCards));
        State state = hit.draw(new PlayingCard(CardNumber.TWO, Suit.HEARTS));

        assertThat(state).isInstanceOf(Hit.class);
    }
}
