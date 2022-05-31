package nextstep.blackjack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CardMachine {

    private List<PlayingCard> playingCards = new ArrayList<>();
    private int index;

    public CardMachine() {
        playingCards.addAll(createHeartCards());
        playingCards.addAll(createDiamondCards());
        playingCards.addAll(createSpadeCards());
        playingCards.addAll(createCloverCards());

        Collections.shuffle(playingCards);
        index = 0;
    }

    public PlayingCards getTwoCards() {
        List<PlayingCard> playingCards = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            playingCards.add(getOneCard());
        }
        return new PlayingCards(playingCards);
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
