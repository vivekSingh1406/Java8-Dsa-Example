package org.DSA_Question.Sorting$Searching;

public class BubbleSort {

    /**
     * TimeComplexity is: O(n2)
     * SpaceComplexity is: O(1)
     */
    public static void sortArr(int[] arr){

        int i, j, temp;
        int n = arr.length;
        boolean swapped;
        for (i = 0; i < n - 1; i++) {
            swapped = false;
            for (j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }

    public static void main(String[] args) {

        int []arr = {12,14,10,9,5,56,89,0,19,99};
        sortArr(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }
}
