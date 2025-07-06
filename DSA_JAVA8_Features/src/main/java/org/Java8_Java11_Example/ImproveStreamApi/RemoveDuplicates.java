package org.Java8_Java11_Example.ImproveStreamApi;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class RemoveDuplicates  {

    public static void main(String[] args) {

        String input = "aaabbbccccdd";

        // remove duplicate character in a string
        String result = input.chars()
                .distinct()
                .mapToObj(c -> String.valueOf((char) c))
                .collect(Collectors.joining());

        System.out.println(result);

        //count each character in a string
        Map<Character, Long> countCharacter =  input.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        countCharacter.forEach((character, count) ->
                System.out.println(character + " : " + count)
        );
    }
}
