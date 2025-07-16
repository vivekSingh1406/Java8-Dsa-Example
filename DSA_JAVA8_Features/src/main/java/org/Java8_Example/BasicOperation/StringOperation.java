package org.Java8_Example.BasicOperation;

import com.sun.source.tree.UsesTree;

import java.util.*;
import java.util.stream.Collectors;

public class StringOperation {

    public static void main(String[] args) {

        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David", "Eva", "bob", "EVA", " ", "", "Zoe");

        //  Convert all strings uppercase to lowercase
        names.stream().map(String::toLowerCase).forEach(System.out::println);

        // Filter non-empty and non-blank strings
        List<String> filterString = names.stream().filter(t->  t!=null && !t.trim().isBlank()).toList();
        filterString.forEach(System.out::println);

        // Sort alphabetically
        System.out.println("---------------------");
        List<String> sortAlphabetically = names.stream().sorted().toList();
        sortAlphabetically.forEach(System.out::println);

        //Remove duplicates (case-insensitive)
        List<String> removeDuplicate = names.stream().map(String::toLowerCase)
                .distinct().toList();
        removeDuplicate.forEach(System.out::println);

        //Find longest or shortest string
        Optional<String> longest = names.stream().filter(Objects::nonNull).max(Comparator.comparingInt(String::length));
        longest.ifPresent(System.out::println);

        //Count strings that match a condition
        long countStartWithA = names.stream().filter(s -> s!=null && s.toLowerCase().startsWith("a")).count();
        System.out.println("Count the string start with A "+ countStartWithA);

        //Concatenate all strings with a delimiter
        String joined = names.stream().filter(s-> s!=null && !s.isBlank()).collect(Collectors.joining(", "));
        System.out.println(joined);

        // Map each string to its length
        List<Integer> lengths = names.stream().map(String::length).toList();
        System.out.println("print all length of string "+ lengths);

        //Check if any/all strings satisfy a condition
        boolean anyStartsWithZ = names.stream()
                .anyMatch(s -> s.toLowerCase().startsWith("z"));

        boolean allNonEmpty = names.stream()
                .allMatch(s -> s != null && !s.isEmpty());

        System.out.println(anyStartsWithZ +" -------- "+ allNonEmpty);

        //Group by length or first letter
        Map<Integer, List<String>> groupByLength = names.stream()
                .collect(Collectors.groupingBy(String::length));
        System.out.println(groupByLength);


    }
}
