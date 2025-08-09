package org.DSA_Question.Sorting$Searching;

import java.util.Arrays;

public class QuickSort {


    /**
     * Time Complexity: O(n log n)
     * Space Complexity: O(log n)
     */
    public static void sort(int[] nums, int low, int hi) {

        if (low >= hi) return;

        int s = low;
        int e = hi;
        int m = s + (e - s) / 2;
        int pivot = nums[m];

        while (s <= e) {
            while (nums[s] < pivot) s++;
            while (nums[e] > pivot) e--;

            if (s <= e) {
                int temp = nums[s];
                nums[s] = nums[e];
                nums[e] = temp;
                s++;
                e--;
            }
        }
        sort(nums, low, e);
        sort(nums, s, hi);
    }

    public static void main(String[] args) {

        int[] arr = {2,5,4,8,9,90,32,23,43,55,67,89,22};

        sort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}
