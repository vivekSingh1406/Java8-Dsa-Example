package org.DSA_Question.Array$String;

import java.util.Arrays;

public class KWithLargestSum {

    public static int[] maxSubsequence(int[] nums, int k) {

        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = nums[nums.length - 1 - i];
        }
        return ans;
    }

    public static void main(String[] args) {

//        int[] nums = {2,1,3,3};
//        int k = 2;

        int []nums ={-1,-2,3,4};
        int k = 3;

        int[] ans = maxSubsequence(nums, k);
        for (int an : ans) {
            System.out.println(an);
        }
    }
}
