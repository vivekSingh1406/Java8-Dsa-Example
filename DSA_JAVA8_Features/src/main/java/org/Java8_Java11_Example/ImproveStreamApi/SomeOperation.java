package org.Java8_Java11_Example.ImproveStreamApi;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;


public class SomeOperation {

    public static void main(String[] args) {

        int[] arr = {11, 23, 12, 121, 431, 431, 145, 23, 12, 14, 54};

        /**
         * Filter numbers that start with digit '1'
         * Convert each number to String, check if it starts with "1"
         */
        List<Integer> list = Arrays.stream(arr)
                .filter(t -> String.valueOf(t).startsWith("1"))
                .boxed()
                .toList();
        list.forEach(System.out::println);

        /**
         * Remove duplicate numbers and sort the array in ascending order
         * Then collect as a List of Integers
         */
        List<Integer> uniqueSorted = Arrays.stream(arr)
                .distinct()
                .sorted()
                .boxed()
                .toList();
        System.out.println("Unique & Sorted: " + uniqueSorted);

        /**
         * Count the frequency (occurrences) of each number in the array
         * Collect results into a Map<Integer, Long>
         */
        Map<Integer, Long> frequencyMap = Arrays.stream(arr)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println("Frequency Map: " + frequencyMap);

        /**
         * Filter numbers greater than 100
         */
        List<Integer> greaterValue = Arrays.stream(arr)
                .filter(t -> t > 100)
                .boxed()
                .toList();
        System.out.println("Numbers > 100: " + greaterValue);


        /**
         * Find the maximum number in the array
         * Find the minimum number in the array
         * Calculate the sum of all elements in the array
         * Calculate the average of all elements in the array
         */
        int max = Arrays.stream(arr).max().orElseThrow();
        int min = Arrays.stream(arr).min().orElseThrow();
        int sum = Arrays.stream(arr).sum();
        double average = Arrays.stream(arr).average().orElse(0.0);

        System.out.println("Max: " + max + ", Min: " + min + ", Sum: " + sum + ", Average: " + average);
    }
}
