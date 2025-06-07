package org.Java8Example.BasicOperation;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;


public class ZecdataQuestionPaper {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(10,15,20,30,11,18,1,10);

        Optional<Integer> secondHighest =  list.stream().distinct()
                .sorted(Comparator.reverseOrder())
                .skip(1).findFirst();

        secondHighest.ifPresentOrElse(
                num -> System.out.println(num),
                () -> System.out.println("no second highest number")
        );

        // find each number how has start in 1
       list.stream().filter(t-> String.valueOf(t)
                        .startsWith("1")).forEach(System.out::println);


        try (BufferedReader br = new BufferedReader(new FileReader("example.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
