package org.example.java8.sat_zecdata;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ListOperation {

    public static void main(String[] args) {

//       Integer[] arr = {1, 2, 3, 4, 5, 6, 7};  // This is an array, and the same array reference is used to create a list, which means we can't change the values.
//       List<Integer> list = Arrays.stream(arr).toList();  // We can't change the values; if I try to add a value, it will show an error.

      List<Integer> list = Arrays.asList(10,20,30,35,38,40,45,49,51,71,89,98,98);


      //------------------------- find the second-highest number
        Optional<Integer> secondHighest = list.stream()
                .sorted(Comparator.reverseOrder())
                .skip(1).findFirst();
//        System.out.println(secondHighest.get());

        //----------------------- find duplicate element
        List<Integer> duplicate = list.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .filter(e->e.getValue() > 1)
                .map(Map.Entry::getKey)
                .toList();
//        duplicate.forEach(System.out::println);

        //----------------------- Group number even or odd
        Map<String, Optional<Integer>> maxByGroup = list.stream()
                .collect(Collectors.groupingBy(
                        n -> (n%2==0) ? "even" : "odd",
                        Collectors.maxBy(Comparator.naturalOrder())
                ));
//        System.out.println(maxByGroup);

        //---------------------- find top 3 distinct largest numbers
        List<Integer> top3 = list.stream()
                .distinct()
                .sorted(Comparator.reverseOrder())
                .limit(3)
                .toList();
//        top3.forEach(System.out::println);

        //---------------------- find low 3 distinct lowest numbers
        List<Integer> low3 = list.stream()
                .distinct()
                .sorted()
                .limit(3)
                .toList();
//        low3.forEach(System.out::println);

        //---------------------- check list sorted or not
        boolean isStored  = IntStream.range(0, list.size() - 1 )
                .allMatch((i -> list.get(i) <= list.get(i+1)));
//        System.out.println(isStored);

        // Convert a list to comma-separated String of even numbers

        String result = list.stream()
                .filter(t-> t%2==0)
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
        System.out.println(result);

        // find the frequency of each character
        Map<Integer, Long> frequency = list.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(frequency);
    }
}
