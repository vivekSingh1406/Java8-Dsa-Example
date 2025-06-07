package org.DSA_Question.Sliding_Window;

public class MaxSumSubarray {


    /**
     * Returns the maximum sum of a subarray with size k.
     *
     * Time Complexity: O(n) where n is the length of the input array.
     * Space Complexity: O(1)
     *
     * @param arr the input array
     * @param k   the size of the subarray
     * @return the maximum sum of any subarray of size k
     */
    public static int maxSum(int[] arr, int k) {
        if (arr.length < k) {
            throw new IllegalArgumentException("Array length must be at least k");
        }

        int windowSum = 0;
        // Calculate the sum of the first window
        for (int i = 0; i < k; i++) {
            windowSum += arr[i];
        }

        int maxSum = windowSum;

        // Slide the window forward
        for (int i = k; i < arr.length; i++) {
            windowSum += arr[i] - arr[i - k];
            maxSum = Math.max(maxSum, windowSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        int[] arr = {100, 200, 300, 400, -500, 600, 900, 0, 1000, -50, -900, 1200, 300};
        int k = 5;

        int result = maxSum(arr, k);
        System.out.println("Maximum sum "+ result);
    }
}
