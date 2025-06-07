package org.DSA_Question;

public class TrappingRainWater {

    /**
     * Calculates the total amount of trapped rainwater using the two-pointer technique.
     *
     * Time Complexity: O(n) where n is the length of the input array.<br>
     * Space Complexity: O(1)
     *
     * @param height an array representing the elevation map
     * @return the total amount of trapped rainwater
     *
     */
    public static int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        int trappedWater = 0;

        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    trappedWater += leftMax - height[left];
                }
                left++;
            } else {
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    trappedWater += rightMax - height[right];
                }
                right--;
            }
        }

        return trappedWater;
    }

    /**
     * Calculates the total amount of trapped rainwater using precomputed maximum heights from both sides.
     *
     * Time Complexity: O(n) where n is the length of the input array.<br>
     * Space Complexity: O(n) due to the use of two auxiliary arrays.
     *
     * @param height an array representing the elevation map
     * @return the total amount of trapped rainwater
     *
     */
    public static int trap1(int[] height) {
        int n = height.length;

        int leftmax[] = new int[n];
        int rightmax[] = new int[n];
        int left = Integer.MIN_VALUE;
        int right = Integer.MIN_VALUE;

        for(int i = 0; i < n; i++) {
            leftmax[i] = left = Math.max(height[i], left);
        }

        for(int i = n - 1; i >= 0; i--) {
            rightmax[i] = right = Math.max(height[i], right);
        }

        int count = 0;

        for(int i = 0; i < n; i++) {
            int validMax = Math.min(leftmax[i], rightmax[i]);
            count += (validMax - height[i]);
        }

        return count;
    }

    public static void main(String[] args) {
        int[] height1 = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int[] height2 = {4, 2, 0, 3, 2, 5};

        System.out.println(trap(height1));
        System.out.println(trap1(height2));
    }
}
