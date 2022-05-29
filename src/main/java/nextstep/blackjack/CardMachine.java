package nextstep.blackjack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CardMachine {

    private List<PlayingCard> playingCards = new ArrayList<>();
    private List<Integer> cardIndexs;
    private int index;

    public CardMachine() {
        playingCards.addAll(createHeartCards());
        playingCards.addAll(createDiamondCards());
        playingCards.addAll(createSpadeCards());
        playingCards.addAll(createCloverCards());

        cardIndexs = IntStream.range(0, playingCards.size())
            .boxed()
            .collect(Collectors.toList());
        Collections.shuffle(cardIndexs);
        index = 0;
    }

    public PlayingCard getOneCard() {
        if (index == playingCards.size()) {
            throw new IllegalStateException("모든 카드를 다 소진했습니다.");
        }
        return playingCards.get(index++);
    }

    private List<PlayingCard> createHeartCards() {
        return getShapeAllCards(number -> new PlayingCard(number, Shape.HEART));
    }

    private List<PlayingCard> createDiamondCards() {
        return getShapeAllCards(number -> new PlayingCard(number, Shape.DIAMOND));
    }

    private List<PlayingCard> createSpadeCards() {
        return getShapeAllCards(number -> new PlayingCard(number, Shape.SPADE));
    }

    private List<PlayingCard> createCloverCards() {
        return getShapeAllCards(number -> new PlayingCard(number, Shape.CLOVER));
    }

    private List<PlayingCard> getShapeAllCards(Function<Number, PlayingCard> filter) {
        return Arrays.stream(Number.values())
            .map(filter)
            .collect(Collectors.toList());
    }
}
