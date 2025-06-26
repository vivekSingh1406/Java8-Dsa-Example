package org.Java8_Java11_Example.ImproveStreamApi;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class RemoveDuplicates  {

    public static void main(String[] args) {

        String input = "aaabbbccccdd";

        String result = input.chars() // convert to IntStream
                .distinct()
                .mapToObj(c -> String.valueOf((char) c))
                .collect(Collectors.joining());

        System.out.println(result);

        //count each character in a string
        Map<Character, Long> countCharacter =  input.chars() // returns an IntStream
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        countCharacter.forEach((character, count) ->
                System.out.println(character + " : " + count)
        );
    }
}
