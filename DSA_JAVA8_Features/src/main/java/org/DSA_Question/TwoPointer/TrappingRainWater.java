package org.DSA_Question.TwoPointer;


public class TrappingRainWater {

    public static int trap(int[] height){

        int n = height.length - 1;
        int[] leftMax = new int[n + 1];
        int[] rightMax = new int[n + 1];
        int trappedWater = 0;

        leftMax[0] = height[0];
        rightMax[n] = height[n];

        for (int i = 1; i <= n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }

        for (int i = n - 1; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }

        for (int i = 0; i <= n; i++) {
            int waterLevel = Math.min(leftMax[i], rightMax[i]);
            trappedWater += waterLevel - height[i];
        }

        return trappedWater;

    }
    public static void main(String[] args) {

        System.out.println(trap(new int[] {0,1,0,2,1,0,1,3,2,1,2,1}));
        System.out.println(trap(new int[] {4,2,0,3,2,5}));
    }
}
