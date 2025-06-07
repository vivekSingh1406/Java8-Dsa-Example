package org.DSA_Question;

public class PartitionArrayAccordingToGivenPivot {

    public static int[] pivotArray(int[] nums, int pivot) {
        int[] result = new int[nums.length];
        int left = 0, right = nums.length - 1;

        for (int i = 0, j = nums.length - 1; i < nums.length; i++, j--) {
            if (nums[i] < pivot) {
                result[left] = nums[i];
                left++;
            }
            if (nums[j] > pivot) {
                result[right] = nums[j];
                right--;
            }
        }
        while (left <= right) {
            result[left] = pivot;
            left++;
        }

        return result;
    }

    public static void main(String[] args) {

        int[] arr = {9,12,5,10,14,3,10};
        int pivot = 9;

        int[] ans = pivotArray(arr,pivot);
        for (int i : ans) {
            System.out.print(i+" ");
        }
    }
}
