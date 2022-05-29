package nextstep.fp;

import java.util.List;

@FunctionalInterface
public interface AddStrategy {
    int add(List<Integer> numbers);
}
