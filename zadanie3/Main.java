package zadanie3;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, null, 5);
        List<String> words = Arrays.asList("zoo", null, "apple", "banana");

        try {
            System.out.println("Min: " + MinMaxService.getMinAndMax(numbers).getMin() + ", Max: " + MinMaxService.getMinAndMax(numbers).getMax());
            System.out.println("Min: " + MinMaxService.getMinAndMax(words).getMin() + ", Max: " + MinMaxService.getMinAndMax(words).getMax());
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }

    }
}
