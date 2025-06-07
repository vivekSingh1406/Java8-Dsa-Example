package org.dsa_question;

public class MergeSortedArray {

    /**
     * Merges two sorted arrays into nums1 in-place.
     *
     * Time Complexity: O(m + n) <br>
     * Space Complexity: O(1) - in-place merge
     *
     * @param nums1 the first sorted array with extra space at the end to accommodate nums2
     * @param m     the number of initialized elements in nums1
     * @param nums2 the second sorted array
     * @param n     the number of elements in nums2
     *
     */

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;

        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }
        // Copy remaining elements from nums2,
        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }
    }

    public static void main(String[] args) {

        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        int m = 3, n = 3;

        merge(nums1, m, nums2, n);

        for (int num : nums1) {
            System.out.print(num + " ");
        }

    }
}
