package nextstep.blackjack.status;

import java.util.List;
import nextstep.blackjack.player.Name;

public class Cards {

    private final int BLACK_JACK_LIMIT = 21;
    private final int ACE_ELEVEN_NUMBER = 11;
    private final int ACE_SUB_NUMBER = 10;
    private final int BUST_LIMIT_VALUE = 21;
    private List<PlayingCard> playingCards;

    public Cards(List<PlayingCard> playingCards) {
        this.playingCards = playingCards;
    }

    public void add(PlayingCard card) {
        playingCards.add(card);
    }

    public int sumPlayingCardNumber() {
        int result = getSumAceNotCards();
        long aceCardCount = aceCardCount();
        for (int i = 0; i < aceCardCount; i++) {
            result = result + ACE_ELEVEN_NUMBER;
            if (result > BLACK_JACK_LIMIT) {
                result -= ACE_SUB_NUMBER;
            }
        }
        return result;
    }

    private int getSumAceNotCards() {
        return playingCards.stream()
            .filter(card -> !card.isAceCard())
            .mapToInt(PlayingCard::getCardNumber)
            .sum();
    }


    private long aceCardCount() {
        return playingCards.stream()
            .filter(PlayingCard::isAceCard)
            .count();
    }

    public boolean isBust() {
        return sumPlayingCardNumber() > BUST_LIMIT_VALUE;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (PlayingCard card : playingCards) {
            result.append(card).append(", ");
        }
        return result.toString().replaceFirst(". $", "");
    }
}
