package nextstep.blackjack;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class PlayingCards {

    public static final int ACE_MAX_NUMBER = 11;
    public static final int ACE_MIN_NUMBER = 1;
    private final int BLACK_JACK_NUMBER = 21;

    private final List<PlayingCard> playingCards;

    public PlayingCards(List<PlayingCard> playingCards) {
        this.playingCards = playingCards;
    }

    public boolean isBlackJack() {
        return sumCardNumber() == BLACK_JACK_NUMBER;
    }

    public int sumCardNumber() {
        int result = playingCards.stream()
            .filter(playingCard -> !playingCard.isAceCard())
            .map(PlayingCard::cardValue)
            .reduce(0, Integer::sum);

        List<PlayingCard> aceCards = playingCards.stream()
            .filter(PlayingCard::isAceCard)
            .collect(Collectors.toList());

        for (PlayingCard aceCard : aceCards) {
            result += getAceNumber(result);
        }
        return result;
    }

    public void addCard(PlayingCard playingCard) {
        playingCards.add(playingCard);
    }

    private int getAceNumber(int sum) {
        if (sum + ACE_MAX_NUMBER > BLACK_JACK_NUMBER) {
            return ACE_MIN_NUMBER;
        }
        return ACE_MAX_NUMBER;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (PlayingCard playingCard : playingCards) {
            result.append(playingCard).append(", ");
        }
        return result.toString();
    }
}
