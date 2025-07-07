package org.DSA_Question.Array$String;

public class LongestStrictlyIncreasing {

    public static int longestMonotonicSubarray(int[] nums) {
        int maxLen = 1;
        int curr = 1;

        for(int i=1; i<nums.length; i++) {
            if(nums[i-1] < nums[i]) curr++;
            else curr = 1;

            maxLen = Math.max(maxLen, curr);
        }

        curr = 1;
        for(int i=1; i<nums.length; i++) {
            if(nums[i-1] > nums[i]) curr++;
            else curr = 1;

            maxLen = Math.max(maxLen, curr);
        }

        return maxLen;
    }
    public static void main(String[] args) {

        int[] arr = {1,4,3,3,2};
        int[] arr1 = {3,2,1};
        System.out.println(longestMonotonicSubarray(arr));
        System.out.println(longestMonotonicSubarray(arr1));
    }
}
