package org.DSA_Question.CommanQuestion;

public class MaximumDifferenceBetweenIncreasingElements {

    /**
     * @param nums The input array of integers.
     * @return The maximum difference (nums[j] - nums[i]) where j > i and nums[j] > nums[i],
     *         or -1 if no such pair exists.

     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static int maximumDifference(int[] nums) {
        int minSoFar = nums[0];
        int maxDiff = -1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > minSoFar) {
                maxDiff = Math.max(maxDiff, nums[i] - minSoFar);
            } else {
                minSoFar = nums[i];
            }
        }
        return maxDiff;
    }


    public static void main(String[] args) {

        int []nums =  {1,5,2,10};
        int []nums1 = {7,1,5,4};

        System.out.println(maximumDifference(nums));

        System.out.println(maximumDifference(nums1));

    }
}
