package nextstep.blackjack.card;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.function.Function;
import java.util.stream.Collectors;
import nextstep.blackjack.status.PlayingCard;

public class CardFactory {

    private static Queue<PlayingCard> playingCards = new LinkedList<>();
   static {
        List<PlayingCard> cards = new ArrayList<>();
        cards.addAll(createHeartCards());
        cards.addAll(createDiamondCards());
        cards.addAll(createSpadeCards());
        cards.addAll(createCloverCards());

        Collections.shuffle(cards);
        playingCards.addAll(cards);
    }

//    public PlayingCards getTwoCards() {
//        List<PlayingCard> playingCards = new ArrayList<>();
//        for (int i = 0; i < 2; i++) {
//            playingCards.add(getOneCard());
//        }
//        return new PlayingCards(playingCards);
//    }

    public static PlayingCard draw() {
        return playingCards.poll();
    }

    private static List<PlayingCard> createHeartCards() {
        return getShapeAllCards(number -> new PlayingCard(number, Suit.HEARTS));
    }

    private static List<PlayingCard> createDiamondCards() {
        return getShapeAllCards(number -> new PlayingCard(number, Suit.DIAMONDS));
    }

    private static List<PlayingCard> createSpadeCards() {
        return getShapeAllCards(number -> new PlayingCard(number, Suit.SPADES));
    }

    private static List<PlayingCard> createCloverCards() {
        return getShapeAllCards(number -> new PlayingCard(number, Suit.CLUBS));
    }

    private static List<PlayingCard> getShapeAllCards(Function<CardNumber, PlayingCard> filter) {
        return Arrays.stream(CardNumber.values())
            .map(filter)
            .collect(Collectors.toList());
    }
}
