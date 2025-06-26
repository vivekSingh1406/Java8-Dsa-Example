package org.DSA_Question.MathProblem;

public class OptimalDivision {

    public static String optimalDivision(int[] nums) {

        if (nums.length == 1) return "" + nums[0];
        if (nums.length == 2) return nums[0] + "/" + nums[1];

        StringBuilder res = new StringBuilder(nums[0] + "/(");
        for (int i = 1; i < nums.length - 1; i++){
            res.append(nums[i]).append("/");
        }

        return res.toString() + nums[nums.length - 1] + ")";
    }
    public static void main(String[] args) {

        int[] arr = {1000,100,10,2};
        System.out.println(optimalDivision(arr));
    }
}
