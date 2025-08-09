package org.DSA_Question.Array$String;

public class MaximumAscendingSubarraySum {

    /**
     * Returns the maximum sum of a strictly ascending subarray in the given array.
     * An ascending subarray is a contiguous sequence where each element is greater than the previous one.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     *
     * @param numb the input array of positive integers
     * @return the maximum sum of any ascending subarray
     */
    public static int maxAscendingSum(int[] numb) {

        int sum = numb[0];
        int maxSum = numb[0];

        for (int i = 1; i < numb.length; i++) {
            if (numb[i] > numb[i - 1]) {
                sum += numb[i];
            } else {
                sum = numb[i];
            }
            maxSum = Math.max(maxSum, sum);
        }

        return maxSum;
    }
    public static void main(String[] args) {

        int []arr = {10,20,30,5,10,50};
        int []arr1 = {12,17,15,13,10,11,12};

        System.out.println(maxAscendingSum(arr));
        System.out.println(maxAscendingSum(arr1));
    }
}
