package org.Java8_Java11_Example.ImproveStreamApi;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CharacterOperation {

    public static void main(String[] args) {

        List<String> items = Arrays.asList("apple", "banana", "apple", "orange", "banana", "apple");

        Map<String, Long> frequencyMap = items.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        System.out.println(frequencyMap);

        List<Integer> lenString = items.stream()
                .map(String::length).toList();
        System.out.println(lenString);

        List<String> starAndEnd = items.stream().filter(t-> t.startsWith("a")
                && t.endsWith("e")).toList();
        System.out.println(starAndEnd);

        List<String> sortList = items.stream().distinct().sorted().toList();
        System.out.println(sortList);
    }
}
