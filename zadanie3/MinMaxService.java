package zadanie3;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class MinMaxService {
    public static <T extends Comparable<T>> MinMax<T> getMinAndMax(List<T> elements) {
        if (elements == null || elements.stream().filter(Objects::nonNull).toList().isEmpty()) {
            throw new IllegalArgumentException("Lista nie może być pusta lub zawierać same nulle");
        }
        T min = Collections.min(elements.stream().filter(Objects::nonNull).toList());
        T max = Collections.max(elements.stream().filter(Objects::nonNull).toList());

        return new MinMax<>(min, max);
    }
}
