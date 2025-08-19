package org.Java8_Java11_Example.ImproveStreamApi;

import java.util.Arrays;
import java.util.List;

public class MapAndFlatmap {

    public static void main(String[] args) {

        List<String> listOfStrings = Arrays.asList("1", "2", "3", "4", "5");

        List<Integer> listOfIntegers = listOfStrings.stream()
                .map(Integer::valueOf)
                .toList();

        System.out.println(listOfIntegers);



        List<List<Integer>> listOfLists = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5),
                Arrays.asList(6, 7, 8)
        );
        List<Integer> flattenedList = listOfLists.stream()
                .flatMap(list -> list.stream())
                .toList();
        System.out.println(flattenedList);
    }
}
