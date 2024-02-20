package ZADANIE3;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class MinMaxService {
    public static <T extends Comparable<T>> Optional<MinMax<T>> getMinAndMax (List<T> elements) {
        if (elements == null || elements.isEmpty()) {
            return Optional.empty();
        }
        T min = Collections.min(elements);
        T max = Collections.max(elements);

        return Optional.of(new MinMax<>(min, max));
    }
}
