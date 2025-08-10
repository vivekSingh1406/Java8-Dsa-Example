package org.DSA_Question.StackQueue;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class PriorityQueue1 {


    // count of each character using priority queue
    public static void countCharacter(String st){

        Map<Character, Integer> map = new HashMap<>();
        for(char ch : st.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }

        PriorityQueue<Map.Entry<Character, Integer>> pq =
                new PriorityQueue<>((a,b) -> b.getValue() - a.getValue());

        pq.addAll(map.entrySet());

        while (!pq.isEmpty()) {
            Map.Entry<Character, Integer> entry = pq.poll();
            System.out.print(entry.getKey() + ":" + entry.getValue() + " ");
        }

    }

    public static void main(String[] args) {

       countCharacter("aabbaaccbbd");
    }
}
