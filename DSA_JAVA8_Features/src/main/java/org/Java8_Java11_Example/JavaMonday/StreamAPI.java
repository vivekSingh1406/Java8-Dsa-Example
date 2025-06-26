package org.Java8_Java11_Example.JavaMonday;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamAPI {

    public static void main(String[] args) {

        List<String> items = Arrays.asList("apple", "banana", "apple", "orange", "banana", "apple");
        Map<String, Long> frequencyMap = items.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        System.out.println(frequencyMap); // Output: {orange=1, banana=2, apple=3}

        List<Integer> numbers = Arrays.asList(5, 3, 9, 1, 7);
        int secondHighest = numbers.stream()
                .sorted(Comparator.reverseOrder())
                .distinct()
                .skip(1)
                .findFirst()
                .orElseThrow();
        System.out.println("Second highest: " + secondHighest);

        int secondLowest = numbers.stream()
                .sorted()
                .distinct()
                .skip(1)
                .findFirst()
                .orElseThrow();
        System.out.println("Second lowest: " + secondLowest);


        List<List<Integer>> nested = Arrays.asList(Arrays.asList(1, 2), Arrays.asList(3, 4), Arrays.asList(5, 9, 8));
        List<Integer> flat = nested.stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
        System.out.println(flat); // Output: [1, 2, 3, 4, 5]

        List<Integer> number = Arrays.asList(123, 145, 256, 198, 543, 1890, 77, 1, 16);

        List<Integer> result = number.stream()
                .filter(n -> String.valueOf(n).startsWith("1")).toList();

        System.out.println("Numbers starting with 1: " + result);

    }
}
