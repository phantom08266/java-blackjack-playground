package nextstep.blackjack;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PlayerNames {
    private List<String> names;

    public PlayerNames(String names) {
        String[] playerNames = names.split(",");
        this.names = Arrays.stream(playerNames)
                .collect(Collectors.toList());
    }

    public List<String> getNames() {
        return names;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (String name : names){
            result.append(name).append(", ");
        }
        return result.toString();
    }
}
