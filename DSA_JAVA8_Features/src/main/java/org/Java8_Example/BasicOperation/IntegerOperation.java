package org.Java8_Example.BasicOperation;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class IntegerOperation {

    public static void main(String[] args) {

      List<Integer> list = Arrays.asList(10,20,30,35,38,40,45,49,51,110,89,98,98);


      //------------------------- find the second-highest number ----------------------
        Optional<Integer> secondHighest = list.stream().distinct()
                .sorted(Comparator.reverseOrder()).skip(1).findFirst();

        secondHighest.ifPresentOrElse(
                System.out::println,
                () -> System.out.println("no second highest number")
        );

        //---------------------- find the second lowest number ------------------------
        Optional<Integer> secondLowest = list.stream().distinct()
                .sorted().skip(1).findFirst();

        secondLowest.ifPresentOrElse(
                System.out::println,
                () -> System.out.println("no second lowest number")
        );

        //----------------------- find duplicate element -------------------------------
        List<Integer> duplicate = list.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .filter(e->e.getValue() > 1)
                .map(Map.Entry::getKey)
                .toList();
        duplicate.forEach(System.out::println);

        //---------------------- find top 3 distinct largest numbers --------------------------
        list.stream().distinct().sorted(Comparator.reverseOrder())
                .limit(3).forEach(System.out::println);


        //---------------------- find low 3 distinct lowest numbers ---------------------------
      list.stream().distinct().sorted()
                .limit(3).forEach(System.out::println);


        //------------------------ Convert a list to comma-separated String of even numbers ----------------
        String result = list.stream()
                .filter(t-> t%2==0)
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
        System.out.println(result);


        //--------------------------- find the frequency of each character ----------------------
        Map<Integer, Long> frequency = list.stream()
                .collect(Collectors.groupingBy(n-> n, Collectors.counting()));
//        System.out.println(frequency);


        // -------------------------- find the min and max number in that list -------------------
        int min = list.stream().min(Integer::compare).get();
        int max = list.stream().max(Integer::compare).get();

//        System.out.println("Min Number : "+ min + "\nMax Number : "+max);

        //-------------------------- find sum() and age() number in that list ---------------------
        int sum = list.stream().mapToInt(Integer::intValue).sum();
        OptionalDouble avg = list.stream().mapToInt(Integer::intValue).average();

//        System.out.println("Sum of list : "+ sum + "\nAverage of list : "+ avg);


        //-------------------------- filter numbers that start with 1 and end with 0 -----------------
        list.stream().filter(n -> String.valueOf(n)
                        .startsWith("1") && String.valueOf(n).endsWith("0"))
                        .forEach(System.out::println);


        // ------------------------- filter data b/w 40 and 80 in the list ------------------------
        list.stream().filter(n-> n>40 && n<80).forEach(System.out::println);

        // ------------------------- filter data last digit exit 0 ---------------------------------

        list.stream().filter(t-> String.valueOf(t).endsWith("0")).forEach(System.out::println);
    }
}
