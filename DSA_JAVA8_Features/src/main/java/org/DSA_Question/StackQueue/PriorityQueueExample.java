package org.DSA_Question.StackQueue;

import java.util.*;

public class PriorityQueueExample {

    /**
     * Counts the frequency of each character in a given string and prints
     * the results in descending order of frequency using a PriorityQueue
     *
     * Input: "aabbaaccbbd"
     * Output: a:4 b:4 c:2 d:1
     */
    public static void countCharacter(String st) {
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : st.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        PriorityQueue<Map.Entry<Character, Integer>> pq =
                new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());

        pq.addAll(map.entrySet());

        while (!pq.isEmpty()) {
            Map.Entry<Character, Integer> entry = pq.poll();
            System.out.print(entry.getKey() + ":" + entry.getValue() + " ");
        }
    }

    /**
     * Finds the K smallest elements in an array using a max-heap implementation of PriorityQueue
     *
     * The max-heap ensures that the largest element in the heap is removed
     * whenever the heap size exceeds k, leaving the K smallest elements.
     */
    public static List<Integer> findKSmallest(int[] arr, int k) {
        if (k <= 0) throw new IllegalArgumentException("k must be greater than 0");

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (int j : arr) {
            maxHeap.add(j);
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        return new ArrayList<>(maxHeap);
    }

    /**
     * Finds the K largest elements in an array using a min-heap implementation of PriorityQueue.
     *
     * The min-heap ensures that the smallest element in the heap is removed
     * whenever the heap size exceeds k, leaving the K largest elements
     */
    public static List<Integer> findKLargest(int[] arr, int k) {
        if (k <= 0) throw new IllegalArgumentException("k must be greater than 0");

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int num : arr) {
            minHeap.add(num);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        return new ArrayList<>(minHeap);
    }

    /**
     * Finds the top K most frequent elements in an array using a PriorityQueue
     *
     * a frequency map is created to store the count of each number.
     * Then, a min-heap is used to keep only the top K elements by frequency.

     * Input: nums = {1, 2, 4, 3, 3, 4, 5, 4, 4, 4, 5, 5, 3, 1, 1, 1, 1}, k = 3
     * Output: [4, 1, 5] (order not guaranteed)
     */
    public static List<Integer> topKFrequent(int[] nums, int k) {
        if (k <= 0) throw new IllegalArgumentException("k must be greater than 0");

        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int n : nums) freqMap.put(n, freqMap.getOrDefault(n, 0) + 1);

        PriorityQueue<Integer> pq = new PriorityQueue<>(
                Comparator.comparingInt(freqMap::get)
        );

        for (int num : freqMap.keySet()) {
            pq.add(num);
            if (pq.size() > k) pq.poll();
        }
        return new ArrayList<>(pq);
    }


    public static void main(String[] args) {

        System.out.println(findKSmallest(new int[]{7, 10, 4, 3, 20, 15}, 3));
        System.out.println(findKLargest(new int[]{7, 10, 4, 3, 20, 15}, 3));
        System.out.println(topKFrequent(new int[]{1, 2, 4, 3, 3, 4, 5, 4, 4, 4, 5, 5, 3, 1, 1, 1, 1}, 3));
    }
}
