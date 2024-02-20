package ZADANIE3;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        MinMaxService.getMinAndMax(numbers).ifPresent(minMax -> System.out.println("Min:" + minMax.getMin() + ", max: " + minMax.getMax()));

        List<String> strings = Arrays.asList("apple", "zoo", "cherry");
        MinMaxService.getMinAndMax(strings).ifPresent(minMax -> System.out.println("Min:" + minMax.getMin() + ", max: " + minMax.getMax()));


    }
}
