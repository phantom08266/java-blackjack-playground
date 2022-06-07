package nextstep.blackjack.status;

import java.util.List;

public class Cards {

    public static final int CARD_SIZE = 2;
    private final int UNDER_SCORE_LIMIT = 16;
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

    public int getScore() {
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
        return getScore() > BUST_LIMIT_VALUE;
    }

    public boolean isUnderScoreFromDealer() {
        return getScore() <= UNDER_SCORE_LIMIT;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (PlayingCard card : playingCards) {
            result.append(card).append(", ");
        }
        return result.toString().replaceFirst(". $", "");
    }

    public boolean twoCardBlackJack() {
        return playingCards.size() == CARD_SIZE;
    }
}
