package org.DSA_Question.SortingSearching;


public class BinarySearchLinearSearch {

    /**
     * Performs linear search on the given array to find the target value.
     *
     * @param arr    The array in which to search for the target.
     * @param target The value to search for.
     * @return The index of the target if found; otherwise, -1.
     *
     * Time Complexity: O(n) - In the worst case, all elements are checked.
     * Space Complexity: O(1) - No extra space is used.
     */
    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Performs binary search on a sorted array to find the target value.
     *
     * @param arr    The sorted array in which to search for the target.
     * @param target The value to search for.
     * @return The index of the target if found; otherwise, -1.
     *
     * Time Complexity: O(log n) - The array is halved in each step.
     * Space Complexity: O(1) - Iterative implementation uses constant space.
     *
     * Note: The input array must be sorted in ascending order.
     */
    public static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) return mid;
            else if (arr[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 7, 9};
        int target = 7;

        // Binary search
        System.out.println(binarySearch(arr, target));

        // Linear search
        System.out.println(linearSearch(arr, target));
    }
}
