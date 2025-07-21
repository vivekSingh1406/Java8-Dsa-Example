package org.Java8_Example.BasicOperation;;

import java.util.*;
import java.util.stream.Collectors;

public class StringOperation {

    public static void main(String[] args) {

        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David", "Eva", "bob", "EVA", " ", "", "Zoe");

        //-------------------- Convert all strings uppercase to lowercase ---------------
        names.stream()
                .map(String::toLowerCase)
                .forEach(System.out::println);

        //-------------------- Filter non-empty and non-blank strings --------------------
        names.stream()
                .filter(t->  t!=null && !t.trim().isBlank())
                .forEach(System.out::println);

        //-------------------- Sort alphabetically ---------------------------------------
        names.stream()
                .sorted()
                .forEach(System.out::println);

        //-------------------- Remove duplicates (case-insensitive) -----------------------
        names.stream()
                .map(String::toLowerCase)
                .distinct()
                .forEach(System.out::println);


        //-------------------- Remove duplicates --------------------------------------------
        names.stream()
                .map(String::toUpperCase)
                .distinct()
                .forEach(System.out::println);

        //-------------------- Find longest or shortest string -----------------------------
        Optional<String> longest = names.stream()
                .filter(Objects::nonNull)
                .max(Comparator.comparingInt(String::length));
        longest.ifPresent(System.out::println);

        //-------------------- Count strings that match a condition --------------------------
        long countStartWithA = names.stream()
                .filter(s -> s!=null && s.toLowerCase().startsWith("a"))
                .count();
        System.out.println("Count the string start with A "+ countStartWithA);

        //---------------------- Concatenate all strings with a delimiter ---------------------
        String joined = names.stream()
                .filter(s-> s!=null && !s.isBlank())
                .collect(Collectors.joining(", "));
        System.out.println(joined);

        //---------------------- Map each string to its length ---------------------------------
        List<Integer> lengths = names.stream()
                .map(String::length).toList();
        System.out.println("print all length of string "+ lengths);

        //------------------ Check if any/all strings satisfy a condition ----------------------
        boolean anyStartsWithZ = names.stream()
                .anyMatch(s -> s.toLowerCase().startsWith("z"));

        boolean allNonEmpty = names.stream()
                .allMatch(s -> s != null && !s.isEmpty());

        System.out.println(anyStartsWithZ +" -------- "+ allNonEmpty);

        //--------------------- Group by length or first letter ------------------
        Map<Integer, List<String>> groupByLength = names.stream()
                .collect(Collectors.groupingBy(String::length));
        System.out.println(groupByLength);

        //--------------------- Capitalize first letter of each string ------------
        names.stream().map(s-> s.isBlank() ? s :
                        Character.toUpperCase(s.charAt(0))+s.substring(1).toLowerCase())
                .forEach(System.out::println);

        //-------------------- Reverse each string -----------------------------
        names.stream()
                .map(s-> new StringBuilder(s).reverse().toString())
                .forEach(System.out::println);

        //------------------- Sort by string length ------------------------------
        names.stream()
                .sorted(Comparator.comparingInt(String::length))
                .forEach(System.out::println);

        //------------------- Remove special characters from each string ----------
        names.stream().map(s->s.replaceAll("[^a-zA-Z]", ""))
                .forEach(System.out::println);

        //------------------- Find first string that ends with 'e' -----------------
        Optional<String> firstEndsWithE = names.stream()
                .filter(s -> s.endsWith("e"))
                .findFirst();
        firstEndsWithE.ifPresent(System.out::println);

        //-------------------- Sort by last character ------------------------------
        names.stream()
                .filter(s -> !s.isEmpty())
                .sorted(Comparator.comparing(s -> s.charAt(s.length() - 1)))
                .forEach(System.out::println);

        //-------------------- Find common strings between two lists -----------------
        List<String> otherList = Arrays.asList("Eva", "Zoe", "Tom");
        names.stream()
                .filter(otherList::contains)
                .forEach(System.out::println);

        //----------------- Replace all empty strings with "N/A" ----------------------
        names.stream()
                .map(s -> s.isEmpty() ? "N/A" : s)
                .forEach(System.out::println);

        //---------------- Partition list into two: starting with vowel vs consonant ---------------
        Map<Boolean, List<String>> partitioned = names.stream()
                .filter(s -> !s.isEmpty())
                .collect(Collectors.partitioningBy(
                        s -> "aeiou".indexOf(Character.toLowerCase(s.charAt(0))) >= 0));
        System.out.println(partitioned);

        //---------------------- Remove strings with length < 3 ---------------------------
        names.stream()
                .filter(s -> s.length() >= 3)
                .forEach(System.out::println);

        //----------------------- Convert List<String> to Set<String> ---------------------
        Set<String> uniqueSet = new HashSet<>(names);
        uniqueSet.forEach(System.out::println);
    }
}
