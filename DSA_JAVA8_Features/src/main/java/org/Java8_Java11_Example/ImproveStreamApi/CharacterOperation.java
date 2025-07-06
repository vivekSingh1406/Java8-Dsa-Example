package org.Java8_Java11_Example.ImproveStreamApi;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class CharacterOperation {

    public static void main(String[] args) {
/*
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
*/
        /*----------------------------------------------------------------------------------------*/
        List<String> names = Arrays.asList("John", "Jane", "Jack");
        names.stream().filter(n -> n.startsWith("J"))
                .map(String::toUpperCase)
                .forEach(System.out::println);

        //map()
        List<List<String>> mapped = names.stream()
                .map(word -> Arrays.asList(word.split("")))
                .toList();
        System.out.println(mapped);

        //flatMap()
        List<String> flatMapped = names.stream()
                .flatMap(t -> Arrays.stream(t.split(" "))).toList();
        System.out.println(flatMapped);

        // sort in desc
        names.stream().sorted().forEach(System.out::println);

        // sort in asc
        names.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);
    }
}
