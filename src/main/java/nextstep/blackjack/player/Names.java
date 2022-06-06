package nextstep.blackjack.player;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Names {

    private List<Name> names;

    private Names(List<Name> names) {
        this.names = names;
    }

    public static Names createNames(String names) {
        String[] splitedNames = names.split(",");
        return new Names(Arrays.stream(splitedNames)
            .map(Name::new)
            .collect(Collectors.toList()));
    }

    public List<Name> getNames() {
        return names;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Name name : names) {
            result.append(name).append(", ");
        }
        return result.toString().replaceFirst(". $", "");
    }
}
